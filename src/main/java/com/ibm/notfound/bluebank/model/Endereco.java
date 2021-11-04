package com.ibm.notfound.bluebank.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Endereco {

    private String rua;
    private String bairro;
    private String cep;
    private Integer numero;
    private String complemento;
    private String cidade;
    private String uf;
}
