package com.ibm.notfound.bluebank.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Conta {

    private Double saldo = 0D;
    private Integer numeroConta;
    private List<Movimentacao> movimentacao;
}
