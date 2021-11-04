package com.ibm.notfound.bluebank.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Cliente {

    private String nome;
    private String email;
    private String telefone;
    private Integer idade;
    private Endereco  endereco;
    private Conta conta;

}
