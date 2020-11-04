package com.github.gabrielffguimaraes.rest.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ServicoDTO {
    private String descricao;
    private String valor;
    private String data;
    private Integer idCliente;
}