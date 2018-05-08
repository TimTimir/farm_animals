package net.caimito.farm.animals.web;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import springfox.documentation.annotations.ApiIgnore;

@ApiIgnore
@Controller
@RequestMapping("/ui/about")
public class AboutController {

	@Value("${caimito.version}")
	public String versionNumber ;
	
	@GetMapping
	public String getAbout(Model model) {
		model.addAttribute("versionNumber", versionNumber) ;
		return Views.ABOUT ;
	}
}
