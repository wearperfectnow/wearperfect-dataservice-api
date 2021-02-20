package com.wearperfect.dataservice.api.entities;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="regions")
public class Region {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer id;
	
	@Column(name = "name")
	String name;
	
	@Column(name = "short_name")
	String shortName;
	
	@Column(name = "desc")
	String desc;
	
	@Column(name = "thumbnail")
	String thumbnail;
	
	@Column(name = "source_link")
	String sourceLink;
	
	@Column(name = "created_by")
	Long createdBy;

	@Column(name = "created_on")
	Date createdOn;

	@Column(name = "last_updated_by")
	Long lastUpdatedBy;

	@Column(name = "last_updated_on")
	Date lastUpdatedOn;
	
	@Column(name = "active")
	Boolean active;
	
	@OneToMany(mappedBy = "region", fetch = FetchType.LAZY, orphanRemoval = true, targetEntity = PreferenceFilterRegion.class)
	List<PreferenceFilterRegion> preferenceFilterRegions;
}