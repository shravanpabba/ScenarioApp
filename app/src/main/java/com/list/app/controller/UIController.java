package com.list.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class UIController {
	@GetMapping("/")
	public String home() {
		return "index";
	}
}
