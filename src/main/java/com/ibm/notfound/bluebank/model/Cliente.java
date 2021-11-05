package com.ibm.notfound.bluebank.model;


import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


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
	@Column(nullable = false)
	private String documento;


	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "id")
	@JsonManagedReference
    private Endereco  endereco;


	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "id")
	@JsonManagedReference
	private Conta conta;

}
