package com.ibm.notfound.bluebank.request;

import com.ibm.notfound.bluebank.util.TipoDeMovimentacao;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class MovimentacaoSaque {
    private Double valor;
    private TipoDeMovimentacao tipoDeMovimentacao = TipoDeMovimentacao.SAQUE;

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public MovimentacaoSaque(Double valor) {
        this.valor = valor;
    }
}
