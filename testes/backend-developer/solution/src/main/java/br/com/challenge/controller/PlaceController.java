package br.com.challenge.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.challenge.entity.Place;
import br.com.challenge.service.PlaceService;

@RestController
public class PlaceController {
	
	@Autowired
	private PlaceService placeService;
	
	@RequestMapping (value="/place", method=RequestMethod.GET, produces="application/json")
	public List<Place> listPlaces(@RequestParam("name") Optional<String> name) {
		return this.placeService.listPlaces(name);
	}
	
	@RequestMapping (value="/place/{id}", method=RequestMethod.GET, produces="application/json")
	public Optional<Place> getPlaceById(@PathVariable("id") Long id) {		
		return this.placeService.getPlaceById(id);
	}
	
	@RequestMapping (value="/place", method=RequestMethod.POST, produces="application/json")
	public Place createPlace(@RequestBody Place place) {
		return this.placeService.createPlace(place);
	}
	
	@RequestMapping (value="/place", method=RequestMethod.PUT, produces="application/json")
	public Place editPlace(@RequestBody Place place) {		
		return this.placeService.editPlace(place);
	}
	
}
