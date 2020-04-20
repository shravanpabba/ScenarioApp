package com.list.app.controller;

import com.list.app.entity.Category;
import com.list.app.entity.Description;
import com.list.app.entity.Keyword;
import com.list.app.repository.CategoryRepository;
import com.list.app.repository.DescriptionRepository;
import com.list.app.repository.KeyWordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value="/api")
@CrossOrigin(origins = "http://localhost:4200")
public class Controller {

	@Autowired
	private CategoryRepository categoryRepository;

	@Autowired
	private KeyWordRepository keyWordRepository;

	@Autowired
	private DescriptionRepository descriptionRepository;

	@GetMapping("categoriesList")
	public List<Category> allCategories() {
		return (List)categoryRepository.findAll();
	}

	@PostMapping("KeyWordsByCategories")
	public List<Keyword> keyWordsByCategories(@RequestBody List<Category> categoryList) {
		List<Integer> catIds = new ArrayList<>();
		categoryList.stream().forEach(category -> {
			catIds.add(category.getId());
		});
		return keyWordRepository.findAllByCatidIn(catIds);
	}

	@PostMapping("descriptionByKeyWords")
	public List<Map<String, String>> descriptionByKeyWords(@RequestBody List<Keyword> keywordList) {
		List<Map<String, String>> responseList = new ArrayList<>();
		keywordList.stream().forEach(keyword -> {
			List<Description> descriptionList = descriptionRepository.findAllByKeyid(keyword.getId());
			descriptionList.stream().forEach(description -> {
				Map<String,String> response = new HashMap<>();
				response.put("keyword",keyword.getItemName());
				response.put("description",description.getName());
				responseList.add(response);
			});
		});
		return responseList;
	}

}
