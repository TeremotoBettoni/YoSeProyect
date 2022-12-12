package cl.yose.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import cl.yose.web.models.Posteo;
import cl.yose.web.services.PosteoServiceImpl;

@Controller
@RequestMapping("/home")
public class HomeController {
	@Autowired
	PosteoServiceImpl posteoServiceImpl;
	
	@GetMapping("")
	public String home() {
		return "home.jsp";
	}
	
	@PostMapping("/post")
	public String guardarPosteo(@RequestParam("titulo") String titulo, 
			@RequestParam("texto") String texto,
			@RequestParam("url") String url,
			Model model) {
		Posteo posteo= new Posteo();
		posteo.setTitulo(titulo);
		posteo.setTexto(texto);
		posteo.setUrl(url);
		
		posteoServiceImpl.guardarPosteo(posteo);
		
		model.addAttribute(posteo);
		return "home.jsp";
	}
	
}
