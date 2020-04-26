package com.list.app.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.list.app.model.ScenarioModel;
import com.list.app.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.list.app.entity.Category;
import com.list.app.entity.Keyword;

@RestController
@RequestMapping(value = "/api")
@CrossOrigin(origins = "http://localhost:4200")
public class Controller {

	@Autowired
	private CategoryRepository categoryRepository;

	@Autowired
	private KeyWordRepository keyWordRepository;

	@Autowired
	private ScenarioRepository scenarioRepository;

	@Autowired
	private ScenarioKeyWordRepository scenarioKeyWordRepository;

	@Autowired
	private JdbcRepository jdbcRepository;

	@GetMapping("categoriesList")
	public List<Category> allCategories() {
		return categoryRepository.findAll();
	}

	@PostMapping("KeyWordsByCategories")
	public List<Keyword> keyWordsByCategories(@RequestBody List<Category> categoryList) {
		List<Integer> catIds = new ArrayList<>();
		categoryList.stream().forEach(category -> {
			catIds.add(category.getId());
		});
		return keyWordRepository.findAllByCatidIn(catIds);
	}

	@PostMapping("scenarious")
	public List<ScenarioModel> descriptionByKeyWords(@RequestBody List<Keyword> keywordList) {
		List<Integer> keywordIdList = keywordList.stream().map(Keyword::getId).collect(Collectors.toList());
		return jdbcRepository.getAllScenarios(keywordIdList);

	}


}
