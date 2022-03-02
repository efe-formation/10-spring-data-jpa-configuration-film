package fr.formation.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.formation.entity.Film;
import fr.formation.repository.FilmDao;


@Service
public class FilmServiceImpl implements FilmService {

	@Autowired
	private FilmDao dao;
	
	@Override
	public void ajouterFilm(Film f) throws ServiceException {
		// regles métier
		dao.save(f);
	}

	@Override
	public void modifierFilm(Film f) throws ServiceException {
		dao.save(f);
	}

	@Override
	public void supprimerFilm(Film f) {
		dao.delete(f);
	}

	@Override
	public List<Film> listerFilms() {
		return dao.findAll();
	}

	@Override
	public List<Film> listerFilmsTrieParTitre() {
		return dao.findByOrderByTitreAsc();
	}

	@Override
	public List<Film> listerFilmsTrieParTitreInvers() {
		return dao.findByOrderByTitreDesc();
	}

	@Override
	public List<Film> listerFilmsTrieParAnneeCroissant() {
		return dao.findByOrderByAnneeAsc();
	}

	@Override
	public List<Film> listerFilmsTrieParAnneeDecroissant() {
		return dao.findByOrderByAnneeDesc();
	}

	@Override
	public List<Film> listerFilmsParRealisateur(String nom) {
		return dao.findByRealNomContaining(nom);
	}

	@Override
	public List<Film> listerFilmsParActeur(String nom) {
		return dao.findByActeursNomContaining(nom);

	}

	@Override
	public List<Film> listerFilmsParTitre(String titre) {
		return dao.findByTitreContainingIgnoreCase(titre);
	}


}
