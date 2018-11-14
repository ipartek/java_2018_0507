package com.ipartek.formacion.spring;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.ipartek.formacion.pojo.Greeting;

@Controller
public class formController {
	@GetMapping("/formulario")
	public String greetingForm(Model model) {
        model.addAttribute("greeting", new Greeting());
        return "greeting";
    }
	@PostMapping("/formulario")
    public String greetingSubmit(@ModelAttribute Greeting greeting) {
        return "result";
    }
}


