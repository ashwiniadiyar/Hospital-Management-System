package com.jsp.hospital_app.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.GeneratorType;

@Entity
public class Observation 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int oid;
	private String dname;
	private String robservattion;
	@ManyToOne
	@JoinColumn
	private Encounter encounter;
	
	
	public int getOid() {
		return oid;
	}
	public void setOid(int oid) {
		this.oid = oid;
	}
	public String getDname() {
		return dname;
	}
	public void setDname(String dname) {
		this.dname = dname;
	}
	public String getRobservattion() {
		return robservattion;
	}
	public void setRobservattion(String robservattion) {
		this.robservattion = robservattion;
	}
	public Encounter getEncounter() {
		return encounter;
	}
	public void setEncounter(Encounter encounter) {
		this.encounter = encounter;
	}
	

}
