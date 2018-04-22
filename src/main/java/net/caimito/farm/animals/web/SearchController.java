package net.caimito.farm.animals.web;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import net.caimito.farm.animals.Animal;
import net.caimito.farm.animals.db.AnimalRepository;
import springfox.documentation.annotations.ApiIgnore;

@ApiIgnore
@Controller
@RequestMapping("/ui/search")
public class SearchController {
	
	@Autowired
	private AnimalRepository inventory ;

	@ModelAttribute("searchForm")
	public SearchForm getForm() {
		return new SearchForm() ;
	}
	
	@GetMapping
	public String getFormView(Model model) {
		return Views.SEARCH ;
	}

	@PostMapping
    public String submit(@Valid @ModelAttribute("searchForm") SearchForm form, BindingResult bindingResult) {
		if (bindingResult.hasErrors())
			return Views.SEARCH ;
		else {
			Animal animal = inventory.findByEid(form.getEid()).convertToAnimal() ;
			return String.format("redirect:/ui/details/%s", animal.getEid()) ;
		}
	}
}
