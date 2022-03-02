package fr.formation.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "film")
public class Film {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String titre;
	private int annee;
	
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private Realisateur real;
	
	@OneToMany(cascade = CascadeType.ALL, fetch=FetchType.EAGER)
	private List<Acteur> acteurs;

	public Film() {
	}

	public Film(int id, String titre, int annee, Realisateur real, List<Acteur> acteurs) {
		this.id = id;
		this.titre = titre;
		this.annee = annee;
		this.real = real;
		this.acteurs = acteurs;
	}

	public Film(String titre, int annee, Realisateur real, List<Acteur> acteurs) {
		this.titre = titre;
		this.annee = annee;
		this.real = real;
		this.acteurs = acteurs;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public int getAnnee() {
		return annee;
	}

	public void setAnnee(int annee) {
		this.annee = annee;
	}

	public Realisateur getReal() {
		return real;
	}

	public void setReal(Realisateur real) {
		this.real = real;
	}

	public List<Acteur> getActeurs() {
		return acteurs;
	}

	public void setActeurs(List<Acteur> acteurs) {
		this.acteurs = acteurs;
	}

	@Override
	public String toString() {
		return "Film [id=" + id + ", titre=" + titre + ", annee=" + annee + ", real=" + real + ", acteurs=" + getActeurs()
				+ "]";
	}
	

	
	
}
