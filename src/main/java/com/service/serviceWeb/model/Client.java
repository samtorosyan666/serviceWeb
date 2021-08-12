package com.service.serviceWeb.model;

import com.service.serviceWeb.en.Type;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class Client {

    private int id;
    private String name;
    private String surname;
    private String email;
    private String password;
    private int number;
    private Type type;

}
