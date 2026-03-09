package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;


@Entity
public class LocationStates 
{
	
	@javax.persistence.Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String state;
	private String country;
	private int latestTotalDeaths;
	private int differFromPrevay;
	private String countrycode;
	
	public LocationStates() {
		// TODO Auto-generated constructor stub
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public int getDifferFromPrevay() {
		return differFromPrevay;
	}
	public void setDifferFromPrevay(int differFromPrevay) {
		this.differFromPrevay = differFromPrevay;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public int getLatestTotalDeaths() {
		return latestTotalDeaths;
	}
	public void setLatestTotalDeaths(int latestTotalDeaths) {
		this.latestTotalDeaths = latestTotalDeaths;
	}
	

	public String getCountrycode() {
		return countrycode;
	}

	public void setCountrycode(String countrycode) {
		this.countrycode = countrycode;
	}

	@Override
	public String toString() {
		return "LocationStates [id=" + id + ", state=" + state + ", country=" + country + ", latestTotalDeaths="
				+ latestTotalDeaths + ", differFromPrevay=" + differFromPrevay + "]";
	}
	
	

	
}
