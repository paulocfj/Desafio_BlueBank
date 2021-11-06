package com.ibm.notfound.bluebank.request;

import com.ibm.notfound.bluebank.entity.Endereco;
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

    public Endereco toEntity() {
        Endereco endereco = new Endereco();

        endereco.setRua(this.getRua());
        endereco.setBairro(this.getBairro());
        endereco.setCep(this.getCep());
        endereco.setNumero(this.getNumero());
        endereco.setComplemento(this.getComplemento());
        endereco.setCidade(this.getCidade());
        endereco.setUf(this.getUf());

        return endereco;
    }
}
