package com.ibm.notfound.bluebank.request;

import com.ibm.notfound.bluebank.util.TipoDeMovimentacao;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class MovimentacaoTransferencia {
    private Double valor;
    private Long contaDestino;
    private TipoDeMovimentacao tipoDeMovimentacao = TipoDeMovimentacao.TRANSFERENCIA;

    public MovimentacaoTransferencia(Double valor, Long contaDestino) {
        this.valor = valor;
        this.contaDestino = contaDestino;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public void setContaDestino(Long contaDestino) {
        this.contaDestino = contaDestino;
    }
}
