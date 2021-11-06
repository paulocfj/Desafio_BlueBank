package com.ibm.notfound.bluebank.entity;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "ENDERECO")
public class Endereco {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
	private Long id;
	
	@Column(nullable = false, name = "RUA")
    private String rua;

	@Column(nullable = false, name = "BAIRRO")
    private String bairro;

	@Column(nullable = false, name = "CEP")
    private String cep;

	@Column(nullable = false, name = "NUMERO")
    private Integer numero;

    @Column( name = "COMPLEMENTO")
    private String complemento;

    @Column(nullable = false, name = "CIDADE")
    private String cidade;

    @Column(nullable = false, name = "UF")
    private String uf;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "CLIENTE_ID")
    @JsonIgnore
    private Cliente cliente;
}
