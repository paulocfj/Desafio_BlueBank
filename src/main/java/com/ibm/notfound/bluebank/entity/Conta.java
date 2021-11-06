package com.ibm.notfound.bluebank.entity;

import com.ibm.notfound.bluebank.util.TipoDeConta;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "CONTA")
public class Conta {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID")
	private Long id;

	@Column(nullable = false, name = "SALDO")
    private Double saldo = 0D;

	@Column(nullable = false, unique = true, name = "NUMERO_CONTA")
    private Long numeroConta;

	@Column(name = "ATIVA")
	private  Boolean ativa = true;

	@Column(name = "TIPO_DE_CONTA")
	private TipoDeConta tipoDeConta;
}
