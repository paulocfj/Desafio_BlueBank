package com.ibm.notfound.bluebank.request;

import com.ibm.notfound.bluebank.util.TipoDeMovimentacao;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class MovimentacaoDeposito {
    private Double valor;
    private TipoDeMovimentacao tipoDeMovimentacao = TipoDeMovimentacao.DEPOSITO;

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public MovimentacaoDeposito(Double valor) {
        this.valor = valor;
    }

}
