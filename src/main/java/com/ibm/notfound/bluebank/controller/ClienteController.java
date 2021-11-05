package com.ibm.notfound.bluebank.controller;

import java.util.List;

import com.ibm.notfound.bluebank.model.Conta;
import com.ibm.notfound.bluebank.model.Endereco;
import com.ibm.notfound.bluebank.repository.ContaRepository;
import com.ibm.notfound.bluebank.repository.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.notfound.bluebank.model.Cliente;
import com.ibm.notfound.bluebank.repository.ClienteRepository;

@RestController
@RequestMapping("/clientes")
public class ClienteController {
	
	@Autowired
	private ClienteRepository clienteRepository;

	@Autowired
	private EnderecoRepository enderecoRepository;

	@Autowired
	private ContaRepository contaRepository;

	@GetMapping
	public List<Cliente> listar(){
		return clienteRepository.findAll();
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Cliente adicionar(@RequestBody Cliente cliente) {
		Endereco endereco = enderecoRepository.save(cliente.getEndereco());
		Conta conta = contaRepository.save(cliente.getConta());
		cliente.setEndereco(endereco);
		cliente.setConta(conta);
		return clienteRepository.save(cliente);
	}
}
