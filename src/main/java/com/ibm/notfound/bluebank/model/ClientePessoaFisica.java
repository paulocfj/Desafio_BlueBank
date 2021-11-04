package com.ibm.notfound.bluebank.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClientePessoaFisica extends Cliente {

    private String cpf;
    private String rg;
}
