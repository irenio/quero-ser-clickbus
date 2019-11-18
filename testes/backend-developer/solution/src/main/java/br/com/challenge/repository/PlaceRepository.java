package br.com.challenge.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.challenge.entity.Place;

public interface PlaceRepository extends JpaRepository<Place, Long> {

	Optional<Place> findById(Long id);
	
	@Query("FROM Place WHERE name like :name")
	List<Place> findByName(@Param("name") String name);

}
