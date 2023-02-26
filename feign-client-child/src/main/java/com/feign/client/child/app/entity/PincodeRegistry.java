package com.feign.client.child.app.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class PincodeRegistry {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long id;
    public String officename;
    public String pincode;
    public String officetype;
    public String deliverystatus;
    public String divisionname;
    public String regionname;
    public String circlename;
    public String taluk;
    public String districtname;
    public String statename;
    public String telephone;
    public String related_suboffice;
    public String related_headoffice;
    public String longitude;
    public String latitude;
    
  /*  
    "officename" : "Achalapur B.O",
    "pincode" : "504273",
    "officetype" : "B.O",
    "deliverystatus" : "Delivery",
    "divisionname" : "Adilabad",
    "regionname" : "Hyderabad",
    "circlename" : "Andhra Pradesh",
    "taluk" : "Asifabad",
    "districtname" : "Adilabad",
    "statename" : "TELANGANA",
    "telephone" : "NA",
    "related_suboffice" : "Rechini S.O",
    "related_headoffice" : "Mancherial H.O",
    "longitude" : "NA",
    "latitude" : "NA"
    */
}
