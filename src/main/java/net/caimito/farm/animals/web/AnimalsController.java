package net.caimito.farm.animals.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import springfox.documentation.annotations.ApiIgnore;

@ApiIgnore
@Controller
@RequestMapping("/ui")
public class AnimalsController {
	
	@GetMapping
	public String getInventory() {
		return Views.INVENTORY ;
	}

}
