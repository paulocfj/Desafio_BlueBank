package com.ibm.notfound.bluebank.controller;

import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.notfound.bluebank.request.ClienteRequest;
import com.ibm.notfound.bluebank.response.ClienteResponse;
import com.ibm.notfound.bluebank.service.ClienteService;

@RestController
@RequestMapping("/clientes")
@Api(value="Cliente")
public class ClienteController {

	@Autowired
	private ClienteService clienteService;

	@ApiOperation(value = "Cadastrar cliente")
	@ApiResponses(value =  {@ApiResponse(response = ClienteResponse.class, code = 201, message = "Criado com Sucesso!"),
			@ApiResponse(code = 400, message = "Erro ao cadastrar, verifique os campos!"),
			@ApiResponse(code = 500, message = "Não foi possível realizar está operação!")
	})
	@PostMapping
	public ResponseEntity<?> adicionar(@RequestBody ClienteRequest cliente) {
		try {
			ClienteResponse response = clienteService.criarCliente(cliente);
			if(response == null) {
				return ResponseEntity.badRequest().body("Erro ao cadastrar, verifique os campos!");
			}
			return ResponseEntity.status(HttpStatus.CREATED).body(response);
		} catch (Exception e) {
			System.out.println("Error: "+e.getMessage());
			return ResponseEntity.internalServerError().body("Não foi possível realizar está operação!");
		}
	}

	@ApiOperation(value = "Excluir cliente")
	@DeleteMapping("/{id}")
	@ApiResponses(value =  {@ApiResponse(code = 204, message = "Excluído com Sucesso!"),
			@ApiResponse(code = 404, message = "Cliente não encontrado!"),
			@ApiResponse(code = 500, message = "Não foi possível realizar está operação!")
	})
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

	@ApiOperation(value = "Mostra cliente pelo Id")
	@ApiResponses(value =  {@ApiResponse(response = ClienteResponse.class, code = 200, message = "Listado com Sucesso!"),
			@ApiResponse(code = 404, message = "Cliente não encontrado!"),
			@ApiResponse(code = 500, message = "Não foi possível realizar está operação!")
	})
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

	@GetMapping
	@ApiResponses(value =  {@ApiResponse(response = ClienteResponse.class, code = 200, message = "Listados com Sucesso!", responseContainer = "List"),
			@ApiResponse(code = 500, message = "Não foi possível realizar está operação!")
	})
	@ApiOperation(value = "Mostra lista de clientes")
	public ResponseEntity<?> listarClientes() {
		try {
			return ResponseEntity.ok().body(clienteService.buscarClientes());
		} catch (Exception e) {
			System.out.println("Error: "+e.getMessage());
			return ResponseEntity.internalServerError().body("Não foi possível realizar está operação!");
		}
	}

}



