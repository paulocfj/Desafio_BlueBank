package com.ibm.notfound.bluebank.response;

import com.ibm.notfound.bluebank.entity.Endereco;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EnderecoResponse {

    private String rua;
    private String bairro;
    private String cep;
    private Integer numero;
    private String complemento;
    private String cidade;
    private String uf;


    public EnderecoResponse(Endereco endereco) {

        this.setRua(endereco.getRua());
        this.setBairro(endereco.getBairro());
        this.setCep(endereco.getCep());
        this.setNumero(endereco.getNumero());
        this.setComplemento(endereco.getComplemento());
        this.setCidade(endereco.getCidade());
        this.setUf(endereco.getUf());
    }
}
