package com.ibm.notfound.bluebank;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ibm.notfound.bluebank.entity.Cliente;
import com.ibm.notfound.bluebank.entity.Conta;
import com.ibm.notfound.bluebank.entity.Endereco;

import com.ibm.notfound.bluebank.response.ClienteResponse;
import com.ibm.notfound.bluebank.service.ClienteService;
import com.ibm.notfound.bluebank.util.TipoDeConta;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@SpringBootTest
@AutoConfigureMockMvc
class ClienteTests {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private ClienteService clienteService;

//    @Test
//    void listarCliente_deveria_retornar_status_200() throws  Exception{
//        Endereco e = new Endereco();
//        e.setId(1L);
//        e.setRua("Rua armando marti");
//        e.setBairro("Centro");
//        e.setCep("2555666");
//        e.setNumero(555);
//        e.setCidade("Petro");
//        e.setUf("RJ");
//
//        Conta conta = new Conta();
//        conta.setId(2L);
//        conta.setNumeroConta(545123688L);
//        conta.setSaldo(10500D);
//        conta.setTipoDeConta(TipoDeConta.POUPANCA);
//
//        Cliente cliente = new Cliente();
//        cliente.setId(1L);
//        cliente.setNome("Mateus");
//        cliente.setEmail("mm@gmail.com");
//        cliente.setTelefone("24955664488");
//        cliente.setIdade(20);
//        cliente.setDocumento("256984656");
//        cliente.setEndereco(e);
//
//        cliente.getContas().add(conta);
//
//        //ClienteResponse response = clienteService.criarCliente(CLcliente);
//
//        mockMvc.perform(get("/clientes/1")
//                .contentType("application/json"))
//                .andExpect(status().isOk());
//    }

    @Test
    void adicionar_deveria_retornar_status_200() throws Exception {
        Endereco e = new Endereco();
        e.setId(1L);
        e.setRua("Rua armando marti");
        e.setBairro("Centro");
        e.setCep("2555666");
        e.setNumero(555);
        e.setCidade("Petro");
        e.setUf("RJ");

        Conta conta = new Conta();
        conta.setId(2L);
        conta.setNumeroConta(5451236188L);
        conta.setSaldo(10500D);
        conta.setTipoDeConta(TipoDeConta.POUPANCA);

        Cliente cliente = new Cliente();
        cliente.setId(2L);
        cliente.setNome("Mateus");
        cliente.setEmail("mm@gmail.com");
        cliente.setTelefone("24955664488");
        cliente.setIdade(20);
        cliente.setDocumento("256984562");
        cliente.setEndereco(e);

        cliente.getContas().add(conta);

        mockMvc.perform(post("/clientes")
                        .contentType("application/json")
                        .content(objectMapper.writeValueAsString(cliente)))
                .andExpect(status().isCreated());
    }

    @Test
    void adicionar_sem_body_de_requisicao_deveria_retornar_status_400() throws Exception{
        mockMvc.perform(post("/clientes")
                        .contentType("application/json")
                        .content(objectMapper.writeValueAsString(null)))
                .andExpect(status().isBadRequest());
    }

}
