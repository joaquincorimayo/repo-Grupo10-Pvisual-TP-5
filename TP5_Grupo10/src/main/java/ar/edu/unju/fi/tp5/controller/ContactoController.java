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
 */

@Controller
public class ContactoController {
	private static final Log logs = LogFactory.getLog(ContactoController.class);
	@GetMapping("/contacto")
	public String getContactoPage(Model model) {
		return "contacto";
	}
}
