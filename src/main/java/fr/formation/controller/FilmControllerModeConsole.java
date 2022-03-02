package fr.formation.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import fr.formation.entity.Acteur;
import fr.formation.entity.Film;
import fr.formation.service.FilmService;
import fr.formation.service.ServiceException;


@Controller
public class FilmControllerModeConsole implements FilmController {

	@Autowired
	private FilmService fs;
	
	

	@Override
	public void afficherListeFilms() {
		
		System.out.println("\nListe des films :");
		fs.listerFilms().forEach(f -> System.out.println(f));
		
		System.out.println("\nListe des films triés par titre :");
		fs.listerFilmsTrieParTitre().forEach(f -> System.out.println(f));

		System.out.println("\nListe des films triés par titre inv :");
		fs.listerFilmsTrieParTitreInvers().forEach(f -> System.out.println(f));
	
		System.out.println("\nListe des films triés par ordre chrono :");
		fs.listerFilmsTrieParAnneeCroissant().forEach(f -> System.out.println(f));
		
		System.out.println("\nListe des films triés par ordre chrono inv :");
		fs.listerFilmsTrieParAnneeDecroissant().forEach(f -> System.out.println(f));
		
		System.out.println("\nListe des films de Chabrol :");
		fs.listerFilmsParRealisateur("Chabrol").forEach(f -> System.out.println(f));
		
		System.out.println("\nListe des films de Lelouch :");
		fs.listerFilmsParRealisateur("Lelouch").forEach(f -> System.out.println(f));
		
		System.out.println("\nListe des films avec Jean Yanne :");
		fs.listerFilmsParActeur("Yanne").forEach(f -> System.out.println(f));
		

		System.out.println("\nListe des films avec titre 'attention' :");
		fs.listerFilmsParTitre("attention").forEach(f -> {
			System.out.println(f);
			System.out.println("Liste des acteurs du film :");
			List<Acteur> acteurs = f.getActeurs();
			acteurs.forEach(a -> System.out.println(a));
		});

	}



	@Override
	public void ajouterFilm(Film f) {
		try {
			fs.ajouterFilm(f);
		} catch (ServiceException e) {
			System.out.println(e.getMessage());
		}
		
	}

}
