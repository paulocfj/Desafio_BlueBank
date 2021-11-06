package com.ibm.notfound.bluebank.controller;

import java.util.List;
import com.ibm.notfound.bluebank.request.ClienteRequest;
import com.ibm.notfound.bluebank.response.ClienteResponse;
import com.ibm.notfound.bluebank.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/clientes")
public class ClienteController {
	
	@Autowired
	private ClienteService clienteService;

	@GetMapping
	public List<ClienteResponse> listarClientes() {
		return clienteService.buscarClientes();
	}

	@GetMapping("/{id}")
	public ResponseEntity<ClienteResponse> listarCliente(@PathVariable Long id) {

		ClienteResponse cliente =  clienteService.buscarClientePorId(id);
		if (cliente == null) {
			return ResponseEntity.notFound().build();
		}
		return  ResponseEntity.ok().body(cliente);
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ClienteResponse adicionar(@RequestBody ClienteRequest cliente) {
			return clienteService.criarCliente(cliente);
	}
}



