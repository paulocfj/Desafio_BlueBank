package com.ibm.notfound.bluebank.entity;


import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "CLIENTE")
public class Cliente {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID")
	private Long id;
	
	@Column(nullable = false, name = "NOME")
    private String nome;

	@Column(nullable = false, name = "EMAIL")
    private String email;

	@Column(nullable = false, name = "TELEFONE")
    private String telefone;

	@Column(nullable = false, name = "IDADE")
    private Integer idade;

	@Column(nullable = false, name = "DOCUMENTO", unique = true)
	private String documento;


	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "ENDERECO_ID")
    private Endereco  endereco;


	@OneToMany(fetch = FetchType.LAZY, mappedBy = "cliente")
	private List<Conta> contas;

}
