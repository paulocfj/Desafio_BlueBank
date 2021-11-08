package com.ibm.notfound.bluebank.response;

import com.ibm.notfound.bluebank.entity.Cliente;
import com.ibm.notfound.bluebank.entity.Conta;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClienteResponse {

    private Long id;
    private String nome;
    private String email;
    private String telefone;
    private Integer idade;
    private String documento;
    private EnderecoResponse endereco;
    private List<ContaResponse> contas = new ArrayList<>();


    public ClienteResponse(Cliente cliente) {

        this.setId(cliente.getId());
        this.setNome(cliente.getNome());
        this.setEmail(cliente.getEmail());
        this.setTelefone(cliente.getTelefone());
        this.setIdade(cliente.getIdade());
        this.setDocumento(cliente.getDocumento());
        EnderecoResponse enderecoResponse = new EnderecoResponse(cliente.getEndereco());
        this.setEndereco(enderecoResponse);

        for (Conta c: cliente.getContas()) {
            ContaResponse contaResponse = new ContaResponse(c);
            this.getContas().add(contaResponse);
        }
    }

}
