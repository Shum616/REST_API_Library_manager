package com.restapi.rest_api_lab2.service.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class RegisterBookSubscriptionDTO {
    private long subscriptionId;
    private long BookId;
}
