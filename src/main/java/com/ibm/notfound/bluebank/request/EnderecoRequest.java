package com.ibm.notfound.bluebank.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EnderecoRequest {

    private String rua;
    private String bairro;
    private String cep;
    private Integer numero;
    private String complemento;
    private String cidade;
    private String uf;
}
