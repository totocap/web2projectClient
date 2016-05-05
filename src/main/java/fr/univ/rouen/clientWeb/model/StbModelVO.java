package fr.univ.rouen.clientWeb.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.validator.constraints.Range;

@XmlRootElement(name = "stb")
@XmlAccessorType(XmlAccessType.NONE)
public class StbModelVO implements Serializable {
	private static final long serialVersionUID = 2L;

	@XmlAttribute
	private Integer id;

	@XmlElement
	private String title;

	@XmlElement
	@Range(min = 1, max = 3)
	private double version;

	@XmlElement
	private String date;

	@XmlElement
	private String description;

	@XmlElement
	@NotNull
	@Valid
	private Client client;

	@XmlElement
	@Valid
	private Team team;

	@XmlElement
	@NotNull
	@Size(min = 1)
	@Valid
	private List<Fonctionnalite> fonctionnalite;

	@XmlElement
	private String commentaire;

	public StbModelVO(Integer id, String title, double version, String date, String description, Client client,
			Team team, List<Fonctionnalite> fonctionnalite, String commentaire) {
		super();
		this.id = id;
		this.title = title;
		this.version = version;
		this.date = date;
		this.description = description;
		this.client = client;
		this.team = team;
		this.fonctionnalite = fonctionnalite;
		this.commentaire = commentaire;
	}

	public Resume getResume() {
		return new Resume(id, title, version, date, description);
	}

	public StbModelVO() {

	}

	public Team getTeam() {
		return team;
	}

	public void setTeam(Team team) {
		this.team = team;
	}

	public List<Fonctionnalite> getFonctionnalite() {
		return fonctionnalite;
	}

	public void setFonctionnalite(ArrayList<Fonctionnalite> fonctionnalite) {
		this.fonctionnalite = fonctionnalite;
	}

	public String getCommentaire() {
		return commentaire;
	}

	public void setCommentaire(String commentaire) {
		this.commentaire = commentaire;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public double getVersion() {
		return version;
	}

	public void setVersion(double version) {
		this.version = version;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		String s = "Stb[id : " + id + ", title : " + title + ", version : " + version + ", date : " + date + ",\n"
				+ "description : " + description + ",\n" + "client : " + client + ",\n" + "team : " + team + ",\n"
				+ "fonctionnalites : \n";

		for (Fonctionnalite f : fonctionnalite) {
			s += "   " + f.toString() + "\n";
		}
		s += "commentaire : " + commentaire + "\n]";

		return s;
	}
}
