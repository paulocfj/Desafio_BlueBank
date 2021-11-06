package com.ibm.notfound.bluebank.repository;

import com.ibm.notfound.bluebank.entity.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public  interface EnderecoRepository extends JpaRepository<Endereco, Long> {
}
