package com.ibm.notfound.bluebank.model;

import com.ibm.notfound.bluebank.util.TipoDeMovimentacao;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Movimentacao {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	//@Column(nullable = false)
	//@ManyToOne
	//private Conta conta;
	@Column(nullable = false)
    private Date data;
	@Column(nullable = false)
    private TipoDeMovimentacao tipoDeMovimentacao;
	@Column(nullable = false)
    private Double valor = 0D;
}
