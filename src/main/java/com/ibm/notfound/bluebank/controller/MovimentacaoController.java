package com.ibm.notfound.bluebank.controller;

import com.ibm.notfound.bluebank.response.MovimentacaoReponse;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.notfound.bluebank.entity.Conta;
import com.ibm.notfound.bluebank.request.MovimentacaoDeposito;
import com.ibm.notfound.bluebank.request.MovimentacaoSaque;
import com.ibm.notfound.bluebank.request.MovimentacaoTransferencia;
import com.ibm.notfound.bluebank.service.ContaService;
import com.ibm.notfound.bluebank.service.MovimentacaoService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;


@Api(value = "Movimentacao")
@RestController
@RequestMapping("/movimentacoes")
public class MovimentacaoController {

    @Autowired
    private MovimentacaoService movimentacaoService;

    @Autowired
    private ContaService contaService;

    @ApiOperation(value = "Mostra lista de movimentação")
    @GetMapping("/{numeroConta}")
    @ApiResponses(value =  {@ApiResponse(response = MovimentacaoReponse.class, code = 200, message = "Extrato bancário!"),
            @ApiResponse(code = 404, message = "Conta não encontrada!"),
            @ApiResponse(code = 500, message = "Não foi possível realizar está operação!")
    })
    public ResponseEntity<?> listarHistoricoTransacoes(@PathVariable Long numeroConta) {
        try {
            Conta conta = contaService.buscarConta(numeroConta);
            if (conta == null) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Conta não encotrada!");
            }
            return ResponseEntity.ok().body(movimentacaoService.listarMovimentacoesPeloNumeroConta(numeroConta));
        } catch (Exception e) {
            System.out.println("Error: "+e.getMessage());
            return ResponseEntity.internalServerError().body("Não foi possível realizar está operação!");
        }
    }

    @ApiOperation(value = "Realizar deposito")
    @PostMapping("/deposito/{numeroContaOrigem}")
    @ApiResponses(value =  {@ApiResponse(code = 200, message = "Depósito realizado com sucesso!"),
            @ApiResponse(code = 404, message = "Conta não encontrada!"),
            @ApiResponse(code = 500, message = "Não foi possível realizar está operação!")
    })
    public ResponseEntity<?>  realizarDeposito(@PathVariable Long numeroContaOrigem, @RequestBody MovimentacaoDeposito movimentacao){
        try {
            Conta conta = contaService.buscarConta(numeroContaOrigem);
            if (conta == null) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Conta não encotrada!");
            }
            return  ResponseEntity.ok().body(movimentacaoService.fazerDeposito(numeroContaOrigem, movimentacao));
        } catch (Exception e) {
            System.out.println("Error: "+e.getMessage());
            return ResponseEntity.internalServerError().body("Não foi possível realizar está operação!");
        }
    }

    @ApiOperation(value = "Realizar saque")
    @PostMapping("/saque/{numeroContaOrigem}")
    @ApiResponses(value =  {@ApiResponse(code = 200, message = "Saque realizado com sucesso!"),
            @ApiResponse(code = 404, message = "Conta não encontrada!"),
            @ApiResponse(code = 500, message = "Não foi possível realizar está operação!")
    })
    public ResponseEntity<?> realizarSaque(@PathVariable Long numeroContaOrigem, @RequestBody MovimentacaoSaque movimentacao){
        try {
            Conta conta = contaService.buscarConta(numeroContaOrigem);
            if (conta == null) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Conta não encotrada!");
            }
            return ResponseEntity.ok().body(movimentacaoService.fazerSaque(numeroContaOrigem, movimentacao));
        } catch (Exception e) {
            System.out.println("Error: "+e.getMessage());
            return ResponseEntity.internalServerError().body("Não foi possível realizar está operação!");
        }

    }

    @ApiOperation(value = "Realizar transferência")
    @PostMapping("/transferencia/{numeroContaOrigem}")
    @ApiResponses(value =  {@ApiResponse(code = 200, message = "Transferência realizada com sucesso!"),
            @ApiResponse(code = 404, message = "Conta não encontrada! ou Conta de destino não encontrada!"),
            @ApiResponse(code = 500, message = "Não foi possível realizar está operação!")
    })
    public ResponseEntity<?> realizarTransferencia(@PathVariable Long numeroContaOrigem, @RequestBody MovimentacaoTransferencia movimentacao){
        try {
            Conta contaOrigem = contaService.buscarConta(numeroContaOrigem);
            if (contaOrigem == null) {
               return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Conta não encotrada!");
            }
            Conta contaDestino = contaService.buscarConta(numeroContaOrigem);
            if (contaDestino== null) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Conta de destino não encontrada!");
            }

            return  ResponseEntity.ok().body(movimentacaoService.fazerTransferencia(movimentacao, contaOrigem, contaDestino));
        } catch (Exception e) {
            System.out.println("Error: "+e.getMessage());
            return ResponseEntity.internalServerError().body("Não foi possível realizar está operação!");
        }
    }

}
