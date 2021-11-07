package com.ibm.notfound.bluebank.repository;

import com.ibm.notfound.bluebank.entity.Movimentacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MovimentacaoRepository extends JpaRepository<Movimentacao, Long> {
    @Query(value = "SELECT * FROM MOVIMENTACAO WHERE CONTA_ORIGEM = ?1", nativeQuery = true)
    List<Movimentacao> findAllMovimentacaoPeloNumeroConta(Long numeroConta);
}