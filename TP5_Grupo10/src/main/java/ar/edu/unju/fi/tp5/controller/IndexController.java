package ar.edu.unju.fi.tp5.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {
	@GetMapping("/inicio")
	public String getIndex(Model model) {
		return "index";
	}
}
