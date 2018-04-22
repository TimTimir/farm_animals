package net.caimito.farm.animals.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import net.caimito.farm.animals.Animal;
import net.caimito.farm.animals.FarmManager;
import net.caimito.farm.animals.db.AnimalRepository;
import springfox.documentation.annotations.ApiIgnore;

@ApiIgnore
@Controller
@RequestMapping("/ui/details")
public class DetailsController {

	@Autowired
	private AnimalRepository inventory ;
	
	@Autowired
	private FarmManager farmManager ;
	
	@GetMapping("/{eid}")
	public String getDetails(@PathVariable("eid") String eid, Model model) {
		Animal animal = inventory.findByEid(eid).convertToAnimal() ;
		
		model.addAttribute("animal", animal) ;
		return Views.DETAILS ;
	}
	
	@PostMapping(path="/{eid}", params={"reportDead"})
	public String addRow(@PathVariable("eid") String eid) {
		Animal animal = inventory.findByEid(eid).convertToAnimal() ;
		farmManager.reportDead(animal) ;
		return "redirect:/ui" ;
	}

}
