package fr.formation.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.formation.entity.Film;


public interface FilmDao extends JpaRepository<Film, Integer> {

	List<Film> findByOrderByTitreAsc();
	List<Film> findByOrderByTitreDesc();
	List<Film> findByOrderByAnneeAsc();
	List<Film> findByOrderByAnneeDesc();
	
	List<Film> findByRealNomContaining(String nom);
	List<Film> findByActeursNomContaining(String nom);
	List<Film> findByTitreContainingIgnoreCase(String nom);
}
