package com.ibm.notfound.bluebank.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ContaRequest {

    private Double saldo = 0D;
    private Long numeroConta;
}
