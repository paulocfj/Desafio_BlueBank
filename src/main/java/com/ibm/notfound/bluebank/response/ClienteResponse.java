package com.ibm.notfound.bluebank.response;

import com.ibm.notfound.bluebank.request.ContaRequest;
import com.ibm.notfound.bluebank.request.EnderecoRequest;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClienteResponse {
    private String nome;
    private String email;
    private String telefone;
    private Integer idade;
    private String documento;
    private EnderecoResponse endereco;
    private List<ContaResponse> contas;
}
