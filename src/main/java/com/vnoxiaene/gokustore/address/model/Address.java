package com.vnoxiaene.gokustore.address.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.UUID;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Data
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    @NotNull
    @Size(min = 8, max = 8, message = "Only 8 chars are allowed")
    private String cep;
    @NotNull
    private String logradouro;
    private Integer numero;
    private String bairro;
    @NotNull
    @Size(min = 2, max = 200, message = "Cidade must be between 2 and 200 characters")
    private String cidade;
    @NotNull
    @Size(min = 2, max = 200, message = "Estado must be between 2 and 200 characters")
    private String estado;


}
