package com.ibm.notfound.bluebank.request;

import com.ibm.notfound.bluebank.entity.Cliente;
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


    public Cliente toEntity() {
        Cliente cliente = new Cliente();
        cliente.setNome(this.getNome());
        cliente.setEmail(this.getEmail());
        cliente.setTelefone(this.getTelefone());
        cliente.setIdade(this.getIdade());
        cliente.setDocumento(this.getDocumento());
        cliente.setEndereco(this.endereco.toEntity());

        for (ContaRequest c: this.getContas()) {
            cliente.getContas().add(c.toEntity());
        }

        return cliente;
    }
}
