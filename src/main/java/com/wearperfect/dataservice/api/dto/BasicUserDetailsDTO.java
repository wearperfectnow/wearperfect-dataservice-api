package com.wearperfect.dataservice.api.dto;

import lombok.Data;

@Data
public class BasicUserDetailsDTO {
	private Long id;
	private String username;
	private String fullname;
	private String profilePicture;
	private Boolean active;
}