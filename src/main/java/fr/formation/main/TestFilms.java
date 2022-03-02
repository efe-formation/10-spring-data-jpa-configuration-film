package fr.formation.main;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import fr.formation.conf.ApplicationConfiguration;
import fr.formation.controller.FilmController;
import fr.formation.entity.Acteur;
import fr.formation.entity.Film;
import fr.formation.entity.Realisateur;

public class TestFilms {
	public static void main(String[] args) {
		

		ApplicationContext ac = new AnnotationConfigApplicationContext(ApplicationConfiguration.class);
		
		
		FilmController fc = ac.getBean(FilmController.class);
		
		List<Acteur> acteursFilm1 = new ArrayList<Acteur>();
		acteursFilm1.add(new Acteur("Chabrol", "Claude", "La Truffe"));
		acteursFilm1.add(new Acteur("Blain", "Gérard", "Serge"));
		acteursFilm1.add(new Acteur("Brialy", "Jean-Claude", "Baillou"));
		acteursFilm1.add(new Acteur("Lafont", "Bernadette", "Marie"));
		
		Film film1 = new Film("Le Beau Serge", 1959, new Realisateur("Chabrol", "Claude"), acteursFilm1);
		
		List<Acteur> acteursFilm2 = new ArrayList<Acteur>();
		acteursFilm2.add(new Acteur("Audran", "Stéphane", "Helene"));
		acteursFilm2.add(new Acteur("Yanne", "Jean", "Paul"));
	
		Film film2 = new Film("Le Boucher", 1970, new Realisateur("Chabrol", "Claude"), acteursFilm2);
		
		List<Acteur> acteursFilm3 = new ArrayList<Acteur>();
		acteursFilm3.add(new Acteur("Belmondo", "Jean-Paul", "Sam Lion"));
		acteursFilm3.add(new Acteur("Richard", "Anconina", "Albert"));
		acteursFilm3.add(new Acteur("L.", "Marie-Sophie", "Victoria"));
		
		Film film3 = new Film("Itinéraire d'un enfant gâté", 1988, new Realisateur("Lelouch", "Claude"), acteursFilm3);

		
		List<Acteur> acteursFilm4 = new ArrayList<Acteur>();
		acteursFilm4.add(new Acteur("Bruel", "Patrick", "Mozart"));
		acteursFilm4.add(new Acteur("Yanne", "Jean", "L'expert"));
		acteursFilm4.add(new Acteur("Gerard", "Charles", "Tonton"));
		
		Film film4 = new Film("Attention bandits !", 1986, new Realisateur("Lelouch", "Claude"), acteursFilm4);

		fc.ajouterFilm(film1);
		fc.ajouterFilm(film2);
		fc.ajouterFilm(film3);
		fc.ajouterFilm(film4);
		
		
		fc.afficherListeFilms();
		
		
		((AnnotationConfigApplicationContext)ac).close();
	}
}
