package com.ibm.notfound.bluebank.response;

import com.ibm.notfound.bluebank.entity.Conta;
import com.ibm.notfound.bluebank.entity.Movimentacao;
import com.ibm.notfound.bluebank.util.TipoDeMovimentacao;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
public class MovimentacaoReponse {
    private List<StringBuffer> extrato = new ArrayList<>();
    private String info;
    public void extrato(List<Movimentacao> movimentacao, Conta conta) {
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");
        String contaInfo  = new String();
        Date hoje = new Date();


        contaInfo = "Conta: "+conta.getNumeroConta()+" | valor atual R$ "+conta.getSaldo()+" | tipo da conta: "+conta.getTipoDeConta()+" | data atual: "+formato.format(hoje);
        this.setInfo(contaInfo);

        for (Movimentacao m: movimentacao) {

                StringBuffer menssagem = new StringBuffer();

                if (m.getTipoDeMovimentacao().equals(TipoDeMovimentacao.TRANSFERENCIA)) {

                    if(m.getContaOrigem().equals(conta.getNumeroConta())) {
                        menssagem.append("Realizou a transferência no valor de R$ "+ m.getValor()+" para a conta: "+m.getContaDestino()+" data: "+ formato.format(m.getData()));
                    }
                    else {
                        menssagem.append("Recebeu uma transfêrencia no valor de R$ "+ m.getValor()+ " pela conta: "+ m.getContaOrigem()+" data: "+ formato.format(m.getData()));
                    }

                } else if (m.getTipoDeMovimentacao().equals(TipoDeMovimentacao.SAQUE)) {
                    menssagem.append("Foi realizado um saque no valor de R$ "+m.getValor()+" data: "+ formato.format(m.getData()));
                } else if (m.getTipoDeMovimentacao().equals(TipoDeMovimentacao.DEPOSITO)) {
                    menssagem.append("Foi realizado um depósito no valor de R$ "+m.getValor()+" data: "+ formato.format(m.getData()));
                }

                this.getExtrato().add(menssagem);
            }
    }
}
