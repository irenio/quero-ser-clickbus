package br.com.challenge.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import br.com.challenge.entity.Place;
import br.com.challenge.repository.PlaceRepository;

@Service
public class PlaceService {
	
	@Autowired
	private PlaceRepository placeRepository;
	
	public List<Place> listPlaces(Optional<String> name) {
		if(name.isPresent())
			return this.placeRepository.findByName(name.get().toString());
		
		return this.placeRepository.findAll();
	}
	
	public Optional<Place> getPlaceById(Long id) {		
		return this.placeRepository.findById(id);
	}
	
	public Place createPlace(@RequestBody Place place) {
		place.setCreated_at(new Date());
		return this.placeRepository.save(place);
	}
	
	public Place editPlace(@RequestBody Place place) {
		place.setUpdated_at(new Date());
		return this.placeRepository.save(place);
	}
	
}
