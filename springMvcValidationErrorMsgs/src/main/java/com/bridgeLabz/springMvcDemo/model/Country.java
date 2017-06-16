package com.bridgeLabz.springMvcDemo.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table
public class Country implements Serializable {
	@Id
	@GenericGenerator(name = "abc", strategy = "increment")
	@GeneratedValue(generator = "abc")
	private int id;

	@NotNull
	@Size(min=3,max=15)
	private String name;

	@NotEmpty
	@Pattern(regexp="[^0-9]*")
	private String speciality;

	@NotEmpty
	private String corrency;

	@NotEmpty
	private String population;

	public Country(int id, String name, String speciality, String corrency, String population) {
		this.id = id;
		this.name = name;
		this.speciality = speciality;
		this.corrency = corrency;
		this.population = population;
	}

	public Country() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSpeciality() {
		return speciality;
	}

	public void setSpeciality(String speciality) {
		this.speciality = speciality;
	}

	public String getCorrency() {
		return corrency;
	}

	public void setCorrency(String corrency) {
		this.corrency = corrency;
	}

	public String getPopulation() {
		return population;
	}

	public void setPopulation(String population) {
		this.population = population;
	}

	@Override
	public String toString() {
		return "Country [id=" + id + ", name=" + name + ", speciality=" + speciality + ", corrency=" + corrency
				+ ", population=" + population + "]";
	}
}
