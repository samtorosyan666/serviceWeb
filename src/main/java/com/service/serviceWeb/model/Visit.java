package com.service.serviceWeb.model;

import com.service.serviceWeb.en.Car;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class Visit {

    private int id;
    private int employerId;
    private int clientId;
    private Car car;
    private Date createdDate;
    private Employer employer;
    private Client client;
}
