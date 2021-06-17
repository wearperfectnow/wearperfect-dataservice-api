package com.wearperfect.dataservice.api.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import com.wearperfect.dataservice.api.dto.HashTagDTO;
import com.wearperfect.dataservice.api.dto.HashTagSearchDTO;
import com.wearperfect.dataservice.api.entities.HashTag;

@Mapper(uses = {UtilityMapper.class}, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface HashTagMapper {

	HashTagDTO mapHashTagToHashTagDto(HashTag hashTag);

	HashTag mapHashTagDtoToHashTag	(HashTagDTO hashTagDto);
	
	HashTagSearchDTO mapHashTagToHashTagSearchDto(HashTag hashTag);	
}