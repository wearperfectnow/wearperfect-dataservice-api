package com.wearperfect.dataservice.api.dto;

import com.wearperfect.dataservice.api.entity.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
public class ProductDTO {
    Long id;
    String name;
    String description;
    String features;
    Long manufacturerId;
    Integer productCategoryId;
    Integer genderCategoryId;
    Integer colorId;
    Boolean availableForSale;
    Float price;
    Integer discount;
    Integer discountTypeId;
    Integer currencyId;
    Long createdBy;
    Date createdOn;
    Long lastUpdatedBy;
    Date lastUpdatedOn;
    Boolean active;
    UserBasicDetailsDTO manufacturer;
    ProductCategoryDTO productCategory;
    GenderCategoryBasicDetailsDTO genderCategory;
    ColorBasicDetailsDTO color;
    List<ProductMediaDTO> productMediaList;
    List<ProductStyleDTO> productStyleList;
    ProductCategorySizeChartDTO productCategorySizeChart;
}
