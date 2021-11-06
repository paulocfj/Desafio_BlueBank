package com.ibm.notfound.bluebank.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClienteRequest {

    private String nome;
    private String email;
    private String telefone;
    private Integer idade;
    private String documento;
    private EnderecoRequest endereco;
    private List<ContaRequest> contas;
}
