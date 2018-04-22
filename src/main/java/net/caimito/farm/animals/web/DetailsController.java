package net.caimito.farm.animals.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import net.caimito.farm.animals.Animal;
import net.caimito.farm.animals.db.AnimalInventory;
import springfox.documentation.annotations.ApiIgnore;

@ApiIgnore
@Controller
@RequestMapping("/ui/details")
public class DetailsController {

	@Autowired
	private AnimalInventory inventory ;
	
	@GetMapping("/{eid}")
	public String getDetails(@PathVariable("eid") String eid, Model model) {
		Animal animal = inventory.searchByEid(eid) ;
		
		model.addAttribute("animal", animal) ;
		return Views.DETAILS ;
	}
}
