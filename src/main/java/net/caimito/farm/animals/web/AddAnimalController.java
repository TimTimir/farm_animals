package net.caimito.farm.animals.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.RedirectView;

import springfox.documentation.annotations.ApiIgnore;

@ApiIgnore
@Controller
@RequestMapping("/ui/add")
public class AddAnimalController {

	@GetMapping
	public String getForm(Model model) {
		model.addAttribute("animal", new AnimalForm()) ;
		return Views.ADD ;
	}
	
	@PostMapping
    public RedirectView submit(@ModelAttribute AnimalForm form) {
		return new RedirectView("/ui", true);
    }

}
