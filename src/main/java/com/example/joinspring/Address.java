package com.example.joinspring;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity(name="address")
public class Address {
@Id
@GeneratedValue(strategy=GenerationType.AUTO)
int id;
String city;
String country;

@OneToOne(cascade=CascadeType.ALL)
@JsonBackReference
Man man;

public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}

public String getCity() {
	return city;
}

public void setCity(String city) {
	this.city = city;
}

public String getCountry() {
	return country;
}

public void setCountry(String country) {
	this.country = country;
}

public Man getMan() {
	return man;
}

public void setMan(Man man) {
	this.man = man;
}

}
