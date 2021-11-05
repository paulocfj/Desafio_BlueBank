package com.ibm.notfound.bluebank.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

import javax.persistence.*;

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

	@OneToOne()
	@JoinColumn(name = "id")
	@JsonBackReference
	private Cliente cliente;

	//@Column(nullable = false)
	//@OneToMany
    //private List<Movimentacao> movimentacao;
}
