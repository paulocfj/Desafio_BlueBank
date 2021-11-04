package com.ibm.notfound.bluebank.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClientePessoaJuridica extends Cliente {
    private String cnpj;
}
