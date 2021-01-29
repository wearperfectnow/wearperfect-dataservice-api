package com.wearperfect.dataservice.api.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "gender_categories")
public class GenderCategory {

	@Column(name="id")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer id;
	
	@Column(name="name")
	String name;
	
	@Column(name="short_name")
	String shortName;
	
	@Column(name="genderId")
	Integer genderId;
	
	@Column(name="created_by")
	Long createdBy;
	
	@Column(name="created_on")
	Date createdOn;
	
	@Column(name="last_updated_by")
	Long lastUpdatedBy;
	
	@Column(name="last_updated_on")
	Date lastUpdatedOn;
	
	@Column(name="active")
	Boolean active;
}
