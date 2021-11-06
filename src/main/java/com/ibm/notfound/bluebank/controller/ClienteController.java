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
			return ResponseEntity.noContent().build();
		}
		return  ResponseEntity.ok().body(cliente);
	}
	
	@PostMapping
	public ResponseEntity <?> adicionar(@RequestBody ClienteRequest cliente) {
		ClienteResponse response = clienteService.criarCliente(cliente);
		if(response == null) {
			return ResponseEntity.badRequest().body("Erro ao cadastrar, verifique os campos");
		}
		return ResponseEntity.ok().body(response);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Integer> deletar(@PathVariable Long id) {
		int response = clienteService.deletarCliente(id);
		if (response == 404)
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(404);
		return ResponseEntity.ok().body(200);
	}

	/* modificar depois
	@PutMapping(value = "/{id}")
	public ClienteResponse atualizarCliente(@RequestBody ClienteRequest cliente, @PathVariable Long id) {
		return clienteService.atualizarCliente(cliente, id);
	}*/
}



