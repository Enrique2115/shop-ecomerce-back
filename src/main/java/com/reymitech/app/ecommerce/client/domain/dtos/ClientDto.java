package com.reymitech.app.ecommerce.client.domain.dtos;

import lombok.Data;

@Data
public class ClientDto {
    private String id;
    private String name;
    private String document;
    private String email;
    private String phone;
}
