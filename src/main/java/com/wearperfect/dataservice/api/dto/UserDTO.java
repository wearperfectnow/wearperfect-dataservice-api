package com.wearperfect.dataservice.api.dto;

import java.util.Date;

import lombok.Data;

@Data
public class UserDTO {
	
	private Long id;
	private String username;
	private String password;
	private String roleId;
	private String fullname;
	private String email;
	private String phone;
	private String profilePicture;
	private String bio;
	private Integer genderId;
	private Long homeAddressId;
	private Long DeliveryAddressId;
	private Long businessAddressId;
	private Date createdOn;
	private Date lastUpdatedOn;
	private Boolean active;
}

