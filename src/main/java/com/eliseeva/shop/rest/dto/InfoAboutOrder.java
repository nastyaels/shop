package com.eliseeva.shop.rest.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@Schema(description = "Information about adding order")
@Validated
public class InfoAboutOrder {

    @NotNull
    @Schema(description = "user", required = true)
    @JsonProperty("user")
    private User user;

    @NotNull
    @Schema(description = "order", required = true)
    @JsonProperty("order")
    private Order order;

    @NotNull
    @Schema(description = "purchase", required = true)
    @JsonProperty("purchase")
    private List<Purchase> purchases;

}
