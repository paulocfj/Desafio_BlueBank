package com.ibm.notfound.bluebank.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ContaResponse {
    private Double saldo = 0D;
    private Long numeroConta;
}
