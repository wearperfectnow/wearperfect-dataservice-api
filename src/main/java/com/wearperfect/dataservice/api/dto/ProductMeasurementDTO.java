package com.wearperfect.dataservice.api.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
public class ProductMeasurementDTO {
    private Integer id;
    private Long productCategorySizeId;
    private Integer productMeasurementLabelId;
    private Integer productMeasurementUnitId;
    private Float value;
    private Boolean active;
    private Long createdBy;
    private Instant createdOn;
    private Long lastUpdatedBy;
    private Instant lastUpdatedOn;
    private ProductSizeDTO productSize;
    private ProductMeasurementLabelDTO productMeasurementLabel;
}
