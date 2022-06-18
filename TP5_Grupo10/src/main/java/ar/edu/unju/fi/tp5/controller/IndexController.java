package ar.edu.unju.fi.tp5.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * 
 * @author JoaquinCorimayo
 *
 * @author LuisQuispe
 */

@Controller
public class IndexController {
	private static final Log logs = LogFactory.getLog(IndexController.class);
	@GetMapping("/inicio")
	public String getIndex(Model model) {
		return "index";
	}
}
