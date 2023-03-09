package com.jobint.ingresoJobintApi.Dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class ResponseDto {

    private String name;

    @JsonProperty("location")
    private LocacionesDto locacion;

    @JsonProperty("categories")
    private List<CategoriasDto> categorias;

}
