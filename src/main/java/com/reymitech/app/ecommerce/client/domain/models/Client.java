package com.reymitech.app.ecommerce.client.domain.models;

import com.reymitech.app.ecommerce.utils.entity.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.*;

@Entity(name = "client")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Client extends BaseEntity {
    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "document", nullable = false)
    private String document;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "phone", nullable = false)
    private String phone;
}
