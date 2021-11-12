package com.eliseeva.shop.rest.dto;

import com.eliseeva.shop.orders.Deliveries;
import com.eliseeva.shop.orders.OrderStatuses;
import com.eliseeva.shop.orders.Payment;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import java.time.LocalDateTime;

@Data
@Schema(description = "Information about purchase")
@Validated
public class Order {
    @Null
    @Schema(description = "id",required = false)
    @JsonProperty("id")
    private Long id;

    @NotNull
    @Schema(description = "userId",required = true)
    @JsonProperty("userId")
    private Long userId;

    @NotNull
    @Schema(description = " delivery need",required = true)
    @JsonProperty("delivery")
    private Deliveries delivery;

    @NotNull
    @Schema(description = "status of order",required = true)
    @JsonProperty("orderStatus")
    private OrderStatuses orderStatus;

    @NotNull
    @Schema(description = "kind of payment",required = true)
    @JsonProperty("payment")
    private Payment payment;

    @NotNull
    @Schema(description = "address of delivery",required = true)
    @JsonProperty("deliveryAddress")
    private String deliveryAddress;

    @NotNull
    @Schema(description = "time of delivery",required = true)
    @JsonProperty("deliveryTime")
    private LocalDateTime deliveryDate;
}
