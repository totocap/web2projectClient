package fr.univ.rouen.clientWeb.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "team")
@XmlAccessorType(XmlAccessType.NONE)
public class Team implements Serializable {
	private static final long serialVersionUID = 6L;

	@XmlElement
	@NotNull
	@Size(min = 1, max = 7)
	private List<Membre> membre;

	public Team() {
		super();
		membre = new ArrayList<Membre>();
	}

	public void addMember(Membre membre) {
		this.membre.add(membre);
	}

	public List<Membre> getMembre() {
		return membre;
	}

	public void setMembres(ArrayList<Membre> membre) {
		this.membre = membre;
	}

	@Override
	public String toString() {
		String s = "Team[membres : \n";
		for (Membre m : membre) {
			s += "   " + m.toString() + "\n";
		}
		s += "]";
		return s;
	}

}
