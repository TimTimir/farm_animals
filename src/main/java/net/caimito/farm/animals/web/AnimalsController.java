package net.caimito.farm.animals.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import net.caimito.farm.animals.FarmManager;
import springfox.documentation.annotations.ApiIgnore;

@ApiIgnore
@Controller
@RequestMapping("/ui")
public class AnimalsController {
	
	@Autowired
	private FarmManager farmManager ;
	
	@GetMapping
	public String getInventory(Model model) {
		model.addAttribute("animals", farmManager.listAnimalInventory()) ;
		return Views.INVENTORY ;
	}

}
