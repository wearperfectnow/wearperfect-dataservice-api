package com.wearperfect.dataservice.api.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="user_contacts")
public class UserContact implements Serializable{

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer id;

	@Column(name = "user_id")
	Long userId;

	@Column(name = "contact_user_id")
	Long contactUserId;
	
	@Column(name = "first_contacted_on")
	Date firstContactedOn;
	
	@Column(name = "last_contacted_on")
	Date lastContactedOn;

	@Column(name = "active")
	Boolean active;
	
	@ManyToOne(fetch = FetchType.LAZY, targetEntity = User.class)
	@JoinColumn(name = "user_id", referencedColumnName = "id", insertable = false, updatable = false)
	User userDetails;

	@ManyToOne(fetch = FetchType.LAZY, targetEntity = User.class)
	@JoinColumn(name = "contact_user_id", referencedColumnName = "id", insertable = false, updatable = false)
	User contactUserDetails;
}