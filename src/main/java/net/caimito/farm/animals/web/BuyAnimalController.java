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
import net.caimito.farm.animals.FarmManager;
import net.caimito.farm.animals.Seller;
import net.caimito.farm.animals.Species;
import springfox.documentation.annotations.ApiIgnore;

@ApiIgnore
@Controller
@RequestMapping("/ui/buy")
public class BuyAnimalController {
	
	@Autowired
	private FarmManager farmManager ;

	@ModelAttribute("animal")
	public BuyAnimalForm getForm() {
		return new BuyAnimalForm() ;
	}

	@ModelAttribute("knownSpecies")
	public Species[] getKnownSpecies() {
		return Species.values() ;
	}

	@GetMapping
	public String getFormView(Model model) {
		return Views.BUY ;
	}
	
	@PostMapping
    public String submit(@Valid @ModelAttribute("animal") BuyAnimalForm form, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
            return Views.BUY;
        } else {
        	Animal animal = form.readAnimal() ;
        	Seller seller = form.readSeller() ;
        	farmManager.purchaseFrom(animal, seller);
        	return "redirect:/ui" ;
        }
    }

}
