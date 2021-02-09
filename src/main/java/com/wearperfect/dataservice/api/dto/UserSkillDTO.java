package com.wearperfect.dataservice.api.dto;

import lombok.Data;

@Data
public class UserSkillDTO {

	Long id;
	
	Long userId;
	
	Long skillId;
	
	Long createdBy;

	Long createdOn;
	
	Long lastUpdatedBy;

	Long lastUpdatedOn;

	Boolean active;
}