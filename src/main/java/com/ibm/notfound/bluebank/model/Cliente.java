package com.ibm.notfound.bluebank.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Cliente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false)
    private String nome;
	@Column(nullable = false)
    private String email;
	@Column(nullable = false)
    private String telefone;
	@Column(nullable = false)
    private Integer idade;
	//@Column(nullable = false)
    //private Endereco  endereco;
	//@Column(nullable = false)
    //private Conta conta;

}
