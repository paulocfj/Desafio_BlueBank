package com.ibm.notfound.bluebank.controller;

import com.ibm.notfound.bluebank.entity.Conta;
import com.ibm.notfound.bluebank.entity.Movimentacao;
import com.ibm.notfound.bluebank.repository.ClienteRepository;
import com.ibm.notfound.bluebank.repository.ContaRepository;
import com.ibm.notfound.bluebank.repository.EnderecoRepository;
import com.ibm.notfound.bluebank.service.MovimentacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/movimentacoes")
public class MovimentacaoController {
    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private EnderecoRepository enderecoRepository;

    @Autowired
    private ContaRepository contaRepository;

    @Autowired
    private MovimentacaoService movimentacaoService;

    @PostMapping("/{numeroContaOrigin}")
    public String fazerTransferenciaParaOutraConta(@PathVariable Long numeroContaOrigin, @RequestBody Movimentacao movimentacao){
        return  movimentacaoService.fazerTransferencia(numeroContaOrigin, movimentacao);
    }

}
