package com.jobint.ingresoJobintApi.Dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class HotelesDto {


    @JsonProperty("results")
    private List<ResponseDto> response;


}
