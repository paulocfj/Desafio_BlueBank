package com.ibm.notfound.bluebank.request;

import com.ibm.notfound.bluebank.entity.Conta;
import com.ibm.notfound.bluebank.util.TipoDeConta;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ContaRequest {

    private Double saldo = 0D;
    private Long numeroConta;
    private TipoDeConta tipoDeConta;

    public Conta toEntity() {
        Conta conta = new Conta();

        conta.setNumeroConta(this.getNumeroConta());
        conta.setSaldo(this.getSaldo());
        conta.setTipoDeConta(this.getTipoDeConta());

        return conta;
    }
}
