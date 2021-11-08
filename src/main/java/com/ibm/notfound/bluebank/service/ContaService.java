package com.ibm.notfound.bluebank.service;

import com.ibm.notfound.bluebank.entity.Conta;
import com.ibm.notfound.bluebank.repository.ContaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContaService {
    @Autowired
    private ContaRepository contaRepository;

    public Conta buscarConta(Long numeroConta) {
        return contaRepository.findByNumeroConta(numeroConta);
    }
}
