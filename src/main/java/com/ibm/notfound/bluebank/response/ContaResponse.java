package com.ibm.notfound.bluebank.response;

import com.ibm.notfound.bluebank.entity.Conta;
import com.ibm.notfound.bluebank.util.TipoDeConta;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ContaResponse {

    private Long id;
    private Double saldo;
    private Long numeroConta;
    private TipoDeConta tipoDeConta;


    public ContaResponse(Conta conta) {

        this.setId(conta.getId());
        this.setNumeroConta(conta.getNumeroConta());
        this.setSaldo(conta.getSaldo());
        this.setTipoDeConta(conta.getTipoDeConta());
    }

}
