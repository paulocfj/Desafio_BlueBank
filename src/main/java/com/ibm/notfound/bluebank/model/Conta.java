package com.ibm.notfound.bluebank.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Conta {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	//@Column(nullable = false)
	//@ManyToOne
	//private Cliente cliente;
	@Column(nullable = false)
    private Double saldo = 0D;
	@Column(nullable = false)
    private Integer numeroConta;
	//@Column(nullable = false)
	//@OneToMany
    //private List<Movimentacao> movimentacao;
}
