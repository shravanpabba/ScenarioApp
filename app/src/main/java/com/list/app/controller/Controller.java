package com.list.app.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.list.app.entity.Category;
import com.list.app.entity.Keyword;
import com.list.app.entity.ScenarioKeyword;
import com.list.app.entity.Scenarios;
import com.list.app.repository.CategoryRepository;
import com.list.app.repository.KeyWordRepository;
import com.list.app.repository.ScenarioKeyWordRepository;
import com.list.app.repository.ScenarioRepository;

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
	public List<Scenarios> descriptionByKeyWords(@RequestBody List<Keyword> keywordList) {
		List<Scenarios> responseList = new ArrayList<>();
		List<Integer> keywordIdList = keywordList.stream().map(Keyword::getId).collect(Collectors.toList());
		List<ScenarioKeyword> scenarioKeywordList = scenarioKeyWordRepository
				.findByScenarioKeywordIdIn(keywordIdList);
		scenarioKeywordList.stream().forEach(
				scenarioKeyword -> responseList.addAll(scenarioRepository.findAllById(scenarioKeyword.getScenarioId())));
		return responseList;
	}

}
