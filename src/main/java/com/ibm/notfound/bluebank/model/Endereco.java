package com.ibm.notfound.bluebank.model;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
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
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id")
    @JsonBackReference
    private Cliente cliente;
}
