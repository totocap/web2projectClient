package fr.univ.rouen.clientWeb.model;

import java.io.Serializable;
import java.util.ArrayList;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.validator.constraints.Range;

@XmlRootElement (name="fonctionnalite")
@XmlAccessorType(XmlAccessType.NONE)

public class Fonctionnalite implements Serializable{
	private static final long serialVersionUID = 7L;
	
	@XmlAttribute
	@Range(min=1, max=10)	
	private Integer priorite;
	
	@XmlElement
	private String description;
	
	@XmlElement
	//@NotNull
	//@Size(min = 2)
	private ArrayList<Exigence> exigence;

	public Fonctionnalite(Integer priorite,String description,
			 ArrayList<Exigence> exigence){
		super();
		this.priorite = priorite;
		this.description = description;
		this.exigence = exigence;
		 }
	 
	 public Fonctionnalite(){
			
			 }
	@Override
	 public String toString(){
		 return "Fonctionalite priorite : " + priorite + ",\n description : " + description +
				 ", \n exigence : " + exigence + "\n"; 
	 }
	 
}