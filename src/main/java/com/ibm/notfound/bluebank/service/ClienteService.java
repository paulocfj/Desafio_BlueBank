package com.ibm.notfound.bluebank.service;

import com.ibm.notfound.bluebank.repository.ClienteRepository;
import com.ibm.notfound.bluebank.repository.ContaRepository;
import com.ibm.notfound.bluebank.repository.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private ContaRepository contaRepository;

    @Autowired
    private EnderecoRepository enderecoRepository;



}
