package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.model.LocationStates;
import com.example.demo.services.CoronaVirusDataServices;
import com.example.demo.services.CoronavirusDataServicerRepository;

@Controller

public class HomeController 
{
	
	CoronaVirusDataServices crnService;
	@Autowired
	CoronavirusDataServicerRepository repository;
	
	@Autowired
	public void setCrnService(CoronaVirusDataServices crnService) {
		this.crnService = crnService;
	}


	@GetMapping("/")
	public String home(Model model)
	{
		List<LocationStates> allstates=crnService.getAllstates();
		int totalDeathsReported=allstates.stream().mapToInt(stat->stat.getLatestTotalDeaths()).sum();
		model.addAttribute("LocationStates",allstates);
		model.addAttribute("totalDeathsReported",totalDeathsReported);
		repository.saveAll(allstates);
		return "home";
	}
	 @GetMapping(path="/countries/top/{count}", produces={"application/json"})
	 @ResponseBody
	    public List<LocationStates> getTopCountries(@PathVariable("count") int count) {
	        return crnService.getTopCountriesByDeaths(count);
	    }
	 
	 @GetMapping(path="/country/name/{country}",produces={"application/json"})
	 @ResponseBody
	 public List<LocationStates> getCountryData(@PathVariable String country) {
	        return crnService.findByCountryIgnoreCase(country);
	        		
	    }
	 @GetMapping(path="/country/id/{id}",produces={"application/json"})
	 @ResponseBody
	    public Optional<LocationStates> getLocationById(@PathVariable Long id) {
		 return crnService.getLocationById(id);
	        
	    }
	 
	 @GetMapping("/viewChart")
	    public String viewChart(Model model) {

	        List<LocationStates> list = repository.findAll();
	        model.addAttribute("data", list);

	        return "chart";
	    }
	 @GetMapping(path="/viewChart/top/{count}")
	
	    public String getTopCountries(@PathVariable("count") int count,Model model) {
		 List<LocationStates> list=crnService.getTopCountriesByDeaths(count);
		 model.addAttribute("data", list);

	        return "chart";

	    }
	 
}
