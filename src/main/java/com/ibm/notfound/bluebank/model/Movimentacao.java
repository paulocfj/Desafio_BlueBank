package com.ibm.notfound.bluebank.model;

import com.ibm.notfound.bluebank.util.TipoDeMovimentacao;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Movimentacao {

    private Date data;
    private TipoDeMovimentacao tipoDeMovimentacao;
    private Double valor = 0D;
}
