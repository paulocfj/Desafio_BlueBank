package com.ibm.notfound.bluebank.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Endereco {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false)
    private String rua;
	@Column(nullable = false)
    private String bairro;
	@Column(nullable = false)
    private String cep;
	@Column(nullable = false)
    private Integer numero;
    private String complemento;
    @Column(nullable = false)
    private String cidade;
    @Column(nullable = false)
    private String uf;
}
