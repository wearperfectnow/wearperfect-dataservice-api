package com.wearperfect.dataservice.api.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
public class DiscountTypeDTO {
    private Byte id;
    private String name;
    private String desc;
    private Boolean active = false;
    private Long createdBy;
    private Instant createdOn;
    private Long lastUpdatedBy;
    private Instant lastUpdatedOn;
}