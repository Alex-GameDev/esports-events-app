package es.urjc.dad.leaguesports.control;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Controlador {
	
	@GetMapping("/")
	public String loadMain(){
		return "main";
	}
	@GetMapping("/mustache")
	public String saludarMustache() {
		return "plantilla";
	}
	
	@GetMapping("/saludo")
	public String pruebaSaludar() {
		return "plantilla";
	}

}
