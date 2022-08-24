package com.restapi.rest_api_lab2.service.dto;

import com.restapi.rest_api_lab2.persistance.entities.Subscription;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
public class SubscriptionDTO {
    private long id;
    private long readerId;
    private long librarianId;
    private LocalDate wasGiven;
    private LocalDate willBeTaken;

    public SubscriptionDTO(Subscription subscription) {
        this.id = subscription.getId();
        this.readerId = subscription.getReader().getId();
        this.librarianId = subscription.getLibrarian().getId();
        this.wasGiven = subscription.getWasGiven();
        this.willBeTaken = subscription.getWillBeTaken();
    }
}
