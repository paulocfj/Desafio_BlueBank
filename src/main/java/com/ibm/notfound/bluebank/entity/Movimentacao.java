package com.ibm.notfound.bluebank.entity;

import com.ibm.notfound.bluebank.util.TipoDeMovimentacao;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Table(name = "MOVIMENTACAO")
public class Movimentacao {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Long id;

	@Column(name = "DATA")
    private Date data = new Date();

	@Column(nullable = false, name = "TIPO_DE_MOVIMENTACAO")
    private TipoDeMovimentacao tipoDeMovimentacao;

	@Column(nullable = false, name = "VALOR")
    private Double valor = 0D;

	@Column(name = "CONTA_DESTINO")
	private Long contaDestino;


	@ManyToOne
	@JoinColumn
	private Conta conta;
}
