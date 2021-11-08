package com.ibm.notfound.bluebank.controller;

import com.ibm.notfound.bluebank.request.ClienteRequest;
import com.ibm.notfound.bluebank.response.ClienteResponse;
import com.ibm.notfound.bluebank.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/clientes")
public class ClienteController {
	@Autowired
	private ClienteService clienteService;

	@GetMapping
	public ResponseEntity<?> listarClientes() {
		try {
			return ResponseEntity.ok().body(clienteService.buscarClientes());
		} catch (Exception e) {
			System.out.println("Error: "+e.getMessage());
			return ResponseEntity.internalServerError().body("Não foi possível realizar está operação!");
		}
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> listarCliente(@PathVariable Long id) {
		try {
			ClienteResponse cliente =  clienteService.buscarClientePorId(id);
			if (cliente == null) {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cliente não encontrado!");
			}
			return  ResponseEntity.ok().body(cliente);
		} catch (Exception e) {
			System.out.println("Error: "+e.getMessage());
			return ResponseEntity.internalServerError().body("Não foi possível realizar está operação!");
		}
	}
	
	@PostMapping
	public ResponseEntity<?> adicionar(@RequestBody ClienteRequest cliente) {
		try {
			ClienteResponse response = clienteService.criarCliente(cliente);
			if(response == null) {
				return ResponseEntity.badRequest().body("Erro ao cadastrar, verifique os campos");
			}
			return ResponseEntity.status(HttpStatus.CREATED).body(response);
		} catch (Exception e) {
			System.out.println("Error: "+e.getMessage());
			return ResponseEntity.internalServerError().body("Não foi possível realizar está operação!");
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> deletar(@PathVariable Long id) {
		try {
			int response = clienteService.deletarCliente(id);
			if (response == 404)
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cliente não encontrado!");
			return ResponseEntity.noContent().build();
		} catch (Exception e) {
			System.out.println("Error: "+e.getMessage());
			return ResponseEntity.internalServerError().body("Não foi possível realizar está operação!");
		}
	}

}



