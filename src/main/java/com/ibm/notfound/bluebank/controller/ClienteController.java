package com.ibm.notfound.bluebank.controller;

import java.util.List;
import java.util.Optional;
import com.ibm.notfound.bluebank.entity.Conta;
import com.ibm.notfound.bluebank.repository.ContaRepository;
import com.ibm.notfound.bluebank.repository.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import com.ibm.notfound.bluebank.entity.Cliente;
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
	public List<Cliente> listarClientes(){
		return clienteRepository.findAll();
	}

	@GetMapping("/{id}")
	public Optional<Cliente> listarCliente(@PathVariable Long id) {
		return clienteRepository.findById(id);
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public void adicionar(@RequestBody Cliente cliente) {

		Conta conta = cliente.getContas().get(0);
		System.out.println(conta);
		cliente.setContas(null);
		Cliente novoCliente = clienteRepository.save(cliente);
		System.out.println(novoCliente);
		conta.setCliente(novoCliente);
		Conta novaConta = contaRepository.save(conta);
		System.out.println(novaConta);
	}
}



