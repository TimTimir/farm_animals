package net.caimito;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/cookingJob")
public class CookingJobController {

	private Logger logger = LoggerFactory.getLogger(CookingJobController.class) ;
	
	@Autowired
	private FakeHolder fakeHolder ;
	
	@PostMapping
	public ResponseEntity<CookingJob> createMealPlan(@RequestBody CookingJob cookingJob) {
		logger.info(cookingJob.toString());
		new CookingJobWorker().assignJobToMealPlan(fakeHolder.getMealPlan(), cookingJob);
		return new ResponseEntity<CookingJob>(cookingJob, HttpStatus.OK) ;
	}

	@GetMapping
	public ResponseEntity<List<CookingJob>> getCookingJobs() {
		logger.info("Getting all cooking jobs");
		List<CookingJob> jobs = new ArrayList<>() ;
		
		CookingJob job = new CookingJob() ;
		job.setRecipeID("some ID");
		job.setMonday(new String[] { "breakfast" } );
		
		jobs.add(job) ;
		
		return new ResponseEntity<List<CookingJob>>(jobs, HttpStatus.OK) ;
	}
}
