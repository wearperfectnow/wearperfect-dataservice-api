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
@Table(name="follows")
public class Follow {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;
	
	@Column(name = "user_id")
	Long userId;

	@Column(name = "following_by")
	Long followingBy;

	@Column(name = "active")
	Boolean active;

	@Column(name = "created_on")
	Date createdOn;

	@Column(name = "last_updated_on")
	Date lastUpdatedOn;
	
//	@ManyToOne(fetch = FetchType.LAZY, optional = false, targetEntity = User.class)
//	@JoinColumn(name = "user_id", referencedColumnName = "id", insertable = false, updatable = false)
//	User userDetails;
//	
//	@ManyToOne(fetch = FetchType.LAZY, optional = false, targetEntity = User.class)
//	@JoinColumn(name = "followed_by", referencedColumnName = "id", insertable = false, updatable = false)
//	User followingByUserDetails;
}
