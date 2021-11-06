package com.ibm.notfound.bluebank.repository;

import com.ibm.notfound.bluebank.entity.Conta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ContaRepository extends JpaRepository<Conta, Long> {
    @Query(value = "SELECT * FROM CONTA WHERE NUMERO_CONTA = ?1", nativeQuery = true)
    Conta findByNumeroConta(Long numeroConta);
}
