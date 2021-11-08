package com.ibm.notfound.bluebank;

import com.ibm.notfound.bluebank.controller.MovimentacaoController;
import com.ibm.notfound.bluebank.entity.Conta;
import com.ibm.notfound.bluebank.request.MovimentacaoDeposito;
import com.ibm.notfound.bluebank.request.MovimentacaoSaque;
import com.ibm.notfound.bluebank.request.MovimentacaoTransferencia;
import com.ibm.notfound.bluebank.service.ContaService;
import com.ibm.notfound.bluebank.service.MovimentacaoService;
import com.ibm.notfound.bluebank.util.TipoDeConta;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.List;
import static  io.restassured.module.mockmvc.RestAssuredMockMvc.*;

@SpringBootTest
public class MovimentacaoTests {
    @Autowired
    private MovimentacaoController movimentacaoController;

    @MockBean
    private MovimentacaoService movimentacaoService;

    @MockBean
    private ContaService contaService;

    private List<Conta> listaConta;
    private MovimentacaoTransferencia movimentacaoTransferencia;
    private MovimentacaoSaque movimentacaoSaque;
    private MovimentacaoDeposito movimentacaoDeposito;



    @BeforeEach
    public void inicializacao() {
        standaloneSetup(this.movimentacaoController);

        listaConta = new ArrayList<>();
        System.out.println("Inicializando os testes de movimentação.");
        System.out.println("Populando os dados iniciais.");

        System.out.println("Populando a primeira conta.");
        Conta conta1 = new Conta();
        conta1.setId(2L);
        conta1.setNumeroConta(545123688L);
        conta1.setSaldo(10500D);
        conta1.setTipoDeConta(TipoDeConta.POUPANCA);
        listaConta.add(conta1);

        System.out.println("Populando a segunda conta.");
        Conta conta2 = new Conta();
        conta2.setId(10L);
        conta2.setNumeroConta(100200300L);
        conta2.setSaldo(20000D);
        conta2.setTipoDeConta(TipoDeConta.CORRENTE);
        listaConta.add(conta2);

        System.out.println("Populando a terceira conta.");
        Conta conta3 = new Conta();
        conta3.setId(30L);
        conta3.setNumeroConta(5001000900L);
        conta3.setSaldo(15000D);
        conta3.setTipoDeConta(TipoDeConta.CORRENTE);
        listaConta.add(conta3);

        System.out.println("Populando movimentação do tipo saque para a primeira conta.");
        movimentacaoSaque = new MovimentacaoSaque();
        movimentacaoSaque.setValor(1000D);


        System.out.println("Populando movimentação do tipo depósito para a segunda conta.");
        movimentacaoDeposito = new MovimentacaoDeposito();
        movimentacaoDeposito.setValor(500D);


        System.out.println("Populando movimentação do tipo transferência da a segunda conta para a terceira conta.");
        movimentacaoTransferencia  = new MovimentacaoTransferencia();
        movimentacaoTransferencia.setContaDestino(conta3.getNumeroConta());
        movimentacaoTransferencia.setValor(100D);

    }

    @Test
    public void deveRetornarSucesso_QuandoRealizadoSaque() {
        when(this.movimentacaoService.fazerSaque(listaConta.get(0).getNumeroConta(),movimentacaoSaque))
                .thenReturn("Saque realizado com sucesso!");
        when(this.contaService.buscarConta(listaConta.get(0).getNumeroConta()))
                .thenReturn(listaConta.get(0));

        given()
                //.accept(ContentType.JSON)
                .contentType("application/json")
                .body("{\"valor\":"+movimentacaoSaque.getValor()+", \"tipeDeMovimentacao\": \""+movimentacaoSaque.getTipoDeMovimentacao()+"\"}")
        .when()
                .post("/movimentacoes/saque/{numeroConta}",listaConta.get(0).getNumeroConta() )
        .then()
                .statusCode(HttpStatus.OK.value());
    }


    @AfterEach
    public void encerrando() {
        System.out.println("Encerrando os testes de movimentação.");
        System.out.println("Limpando os dados iniciais.");
        listaConta.clear();
    }
}
