package com.ibm.notfound.bluebank.service;

import com.ibm.notfound.bluebank.entity.Cliente;
import com.ibm.notfound.bluebank.repository.ClienteRepository;
import com.ibm.notfound.bluebank.repository.ContaRepository;
import com.ibm.notfound.bluebank.repository.EnderecoRepository;
import com.ibm.notfound.bluebank.request.ClienteRequest;
import com.ibm.notfound.bluebank.response.ClienteResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private ContaRepository contaRepository;

    @Autowired
    private EnderecoRepository enderecoRepository;

    public List<ClienteResponse> buscarClientes() {
        List<Cliente> cliente = clienteRepository.findAll();
        List<ClienteResponse> clienteResponses = new ArrayList<>();
        for (Cliente c: cliente) {
            ClienteResponse clienteResponse = new ClienteResponse(c);
            clienteResponses.add(clienteResponse);
        }
        return  clienteResponses;
    }

    public ClienteResponse buscarClientePorId(Long id) {
        Optional<Cliente> cliente =  clienteRepository.findById(id);
        if (!cliente.isEmpty()) {
            ClienteResponse clienteResponse = new ClienteResponse(cliente.get());
            return clienteResponse;
        }

        return null;
    }

    public ClienteResponse criarCliente(ClienteRequest clienteRequest) {
        Cliente cliente = clienteRequest.toEntity();
        Cliente novoCliente = clienteRepository.save(cliente);
        ClienteResponse clienteResponse = new ClienteResponse(novoCliente);
        return  clienteResponse;
    }

}
