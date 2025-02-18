package com.psoft.SpringProject1.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;


@Entity
public class Country {

	
	@Id
     // Country Code (Primary Key)
    private String CountryName;
	private String CountryCode;
	private String region;// Country Name

    public Country() {}

    public Country( String CountryName, String CountryCode,String region) {
    	
        this.CountryName =CountryName;
        this.CountryCode = CountryCode;
        this.region=region;
        
    }

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public String getCountryCode() {
		return CountryCode;
	}

	public void setCountryCode(String countryCode) {
		CountryCode = countryCode;
	}

	public String getCountryName() {
		return CountryName;
	}

	public void setCountryName(String countryName) {
		CountryName = countryName;
	}
   

   
}
