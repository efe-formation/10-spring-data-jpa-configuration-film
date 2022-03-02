package fr.formation.service;

import java.util.List;

import fr.formation.entity.Film;

public interface FilmService {

	void ajouterFilm(Film f) throws ServiceException;
	void modifierFilm(Film f) throws ServiceException;
	void supprimerFilm(Film f);
	
	List<Film> listerFilms();
	List<Film> listerFilmsTrieParTitre();
	List<Film> listerFilmsTrieParTitreInvers();
	List<Film> listerFilmsTrieParAnneeCroissant();
	List<Film> listerFilmsTrieParAnneeDecroissant();
	
	List<Film> listerFilmsParRealisateur(String nom);
	List<Film> listerFilmsParActeur(String nom);
	List<Film> listerFilmsParTitre(String titre);
}
