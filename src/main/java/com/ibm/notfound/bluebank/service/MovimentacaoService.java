package com.ibm.notfound.bluebank.service;

import com.ibm.notfound.bluebank.entity.Conta;
import com.ibm.notfound.bluebank.entity.Movimentacao;
import com.ibm.notfound.bluebank.repository.ContaRepository;
import com.ibm.notfound.bluebank.repository.MovimentacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class MovimentacaoService {
    @Autowired
    private ContaRepository contaRepository;

    @Autowired
    private MovimentacaoRepository movimentacaoRepository;

    public String fazerTransferencia(Long contaCliente, Movimentacao movimentacao) {
        Conta contaClienteOrigin = contaRepository.findByNumeroConta(contaCliente);
        Conta contaClienteDestino = contaRepository.findByNumeroConta(movimentacao.getContaDestino());

        Double saldo = contaClienteOrigin.getSaldo();
        Double valorTransferencia = movimentacao.getValor();

        if (saldo >= valorTransferencia) {
            contaClienteOrigin.setSaldo(saldo - valorTransferencia);
            contaClienteDestino.setSaldo(contaClienteDestino.getSaldo() + valorTransferencia);

            Movimentacao m = new Movimentacao();
            m.setContaDestino(movimentacao.getContaDestino());
            m.setTipoDeMovimentacao(movimentacao.getTipoDeMovimentacao());
            m.setData(movimentacao.getData());
            m.setValor(movimentacao.getValor());
            m.setContaOrigem(contaCliente);

            movimentacaoRepository.save(m);

            contaClienteOrigin.getMovimentacao().add(m);
        } else {
            return "Saldo inválido";
        }

        contaRepository.save(contaClienteOrigin);
        contaRepository.save(contaClienteDestino);

        return "Transferência realizada com sucesso";
    }

    public List<Movimentacao> listarMovimentacoesPeloNumeroConta(Long numeroConta) {
        return movimentacaoRepository.findAllMovimentacaoPeloNumeroConta(numeroConta);
    }
}
