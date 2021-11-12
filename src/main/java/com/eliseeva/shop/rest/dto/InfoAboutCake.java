package com.eliseeva.shop.rest.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import java.math.BigDecimal;


@Data
@Validated
@Schema(description = "dop info")
public class InfoAboutCake {
    @Null
    @Schema(description = "id",required = false)
    @JsonProperty("id")
    private Long id;

    @Schema(description = "Name", required = true)
    @JsonProperty("name")
    private String name;

    @Schema(description = "Calories of cake", required = true)
    @JsonProperty("calories")
    private BigDecimal calories;

    @Schema(description = "Relative url of cake image", required = true)
    @JsonProperty("image")
    private String image;

    @Schema(description = "Price of cake", required = true)
    @JsonProperty("price")
    private BigDecimal price;

    @Schema(description = "Cake weight", required = true)
    @JsonProperty("weight")
    private BigDecimal weight;

    @Schema(description = "Cake's ingredients", required = false)
    @JsonProperty("ingredients")
    private String ingredients;
}
