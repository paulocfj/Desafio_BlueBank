package com.ibm.notfound.bluebank.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.ibm.notfound.bluebank.entity.Cliente;
import com.ibm.notfound.bluebank.entity.Conta;
import com.ibm.notfound.bluebank.entity.Endereco;
import com.ibm.notfound.bluebank.repository.ClienteRepository;
import com.ibm.notfound.bluebank.util.TipoDeConta;

@Component
@Order(1)
public class InicializacaoComDadosIniciais implements CommandLineRunner {
    private ClienteRepository clienteRepository;

    @Autowired
    public void DataLoader(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Conta conta = new Conta();
        conta.setAtiva(true);
        conta.setNumeroConta((long) 12345983);
        conta.setSaldo((double) 5000);
        conta.setTipoDeConta(TipoDeConta.CORRENTE);
        conta.setMovimentacao(null);
        List<Conta> contas =new ArrayList<Conta>();
        contas.add(conta);
        Endereco endereco = new Endereco();
        endereco.setRua("Fulano");
        endereco.setNumero(100);
        endereco.setBairro("Sicrano");
        endereco.setCep("60000000");
        endereco.setComplemento(null);
        endereco.setCidade("Minas");
        endereco.setUf("CE");
        Cliente cliente = new Cliente();
        cliente.setNome("Matheus");
        cliente.setEmail("mathes@email.com");
        cliente.setIdade(20);
        cliente.setDocumento("documento4");
        cliente.setTelefone("11999999999");
        cliente.setEndereco(endereco);
        cliente.setContas(contas);


        clienteRepository.save(cliente);
    }
}

@Component
@Order(2)
class Clientes2 implements CommandLineRunner {
    private ClienteRepository clienteRepository;

    @Autowired
    public void DataLoader(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Conta conta = new Conta();
        conta.setAtiva(true);
        conta.setNumeroConta((long) 12345675);
        conta.setSaldo((double) 3000);
        conta.setTipoDeConta(TipoDeConta.CORRENTE);
        conta.setMovimentacao(null);
        List<Conta> contas =new ArrayList<Conta>();
        contas.add(conta);
        Endereco endereco = new Endereco();
        endereco.setRua("Fulano2");
        endereco.setNumero(100);
        endereco.setBairro("Sicrano2");
        endereco.setCep("60000002");
        endereco.setComplemento(null);
        endereco.setCidade("Fortaleza");
        endereco.setUf("CE");
        Cliente cliente = new Cliente();
        cliente.setNome("Anderson");
        cliente.setEmail("andersons@email.com");
        cliente.setIdade(20);
        cliente.setDocumento("documento3");
        cliente.setTelefone("11999999992");
        cliente.setEndereco(endereco);
        cliente.setContas(contas);

        clienteRepository.save(cliente);
    }
}