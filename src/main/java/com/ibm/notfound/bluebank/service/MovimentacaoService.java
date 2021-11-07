package com.ibm.notfound.bluebank.service;

import com.ibm.notfound.bluebank.entity.Conta;
import com.ibm.notfound.bluebank.entity.Movimentacao;
import com.ibm.notfound.bluebank.repository.ContaRepository;
import com.ibm.notfound.bluebank.repository.MovimentacaoRepository;
import com.ibm.notfound.bluebank.request.MovimentacaoDeposito;
import com.ibm.notfound.bluebank.request.MovimentacaoSaque;
import com.ibm.notfound.bluebank.request.MovimentacaoTransferencia;
import com.ibm.notfound.bluebank.response.MovimentacaoReponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class MovimentacaoService {
    @Autowired
    private ContaRepository contaRepository;

    @Autowired
    private MovimentacaoRepository movimentacaoRepository;

    public String fazerDeposito(Long contaCliente, MovimentacaoDeposito movimentacao) {
        Conta contaClienteOrigin = contaRepository.findByNumeroConta(contaCliente);

        Double saldo = contaClienteOrigin.getSaldo();
        Double valorSaque = movimentacao.getValor();


        contaClienteOrigin.setSaldo(saldo + valorSaque);
        Movimentacao m = new Movimentacao();
        m.setTipoDeMovimentacao(movimentacao.getTipoDeMovimentacao());
        m.setValor(movimentacao.getValor());
        m.setContaOrigem(contaCliente);
        movimentacaoRepository.save(m);
        contaClienteOrigin.getMovimentacao().add(m);

        contaRepository.save(contaClienteOrigin);
        return "Depósito realizado com sucesso!";
    }

    public String fazerTransferencia(Long contaCliente, MovimentacaoTransferencia movimentacao) {
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
            m.setValor(movimentacao.getValor());
            m.setContaOrigem(contaCliente);

            movimentacaoRepository.save(m);

            contaClienteOrigin.getMovimentacao().add(m);
        } else {
            return "Saldo inválido!";
        }

        contaRepository.save(contaClienteOrigin);
        contaRepository.save(contaClienteDestino);

        return "Transferência realizada com sucesso!";
    }

    public String fazerSaque(Long contaCliente, MovimentacaoSaque movimentacao) {
        Conta contaClienteOrigin = contaRepository.findByNumeroConta(contaCliente);

        Double saldo = contaClienteOrigin.getSaldo();
        Double valorSaque = movimentacao.getValor();

        if (saldo >= valorSaque) {
            contaClienteOrigin.setSaldo(saldo - valorSaque);
            Movimentacao m = new Movimentacao();
            m.setTipoDeMovimentacao(movimentacao.getTipoDeMovimentacao());
            m.setValor(movimentacao.getValor());
            m.setContaOrigem(contaCliente);
            movimentacaoRepository.save(m);
            contaClienteOrigin.getMovimentacao().add(m);
        } else {
            return "Saldo inválido!";
        }

        contaRepository.save(contaClienteOrigin);
        return "Saque realizado com sucesso!";
    }

    public MovimentacaoReponse listarMovimentacoesPeloNumeroConta(Long numeroConta) {
        List<Movimentacao> movimentacoes = movimentacaoRepository.findAllMovimentacaoPeloNumeroConta(numeroConta);
        Conta conta = contaRepository.findByNumeroConta(numeroConta);

        MovimentacaoReponse movimentacaoReponse = new MovimentacaoReponse();
        movimentacaoReponse.extrato(movimentacoes, conta);

        return movimentacaoReponse;
    }

}
