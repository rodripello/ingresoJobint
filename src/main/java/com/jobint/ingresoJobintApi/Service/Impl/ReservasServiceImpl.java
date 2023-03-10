package com.jobint.ingresoJobintApi.Service.Impl;

import com.jobint.ingresoJobintApi.Dto.HotelesDto;
import com.jobint.ingresoJobintApi.Dto.ReservasDto;
import com.jobint.ingresoJobintApi.Dto.ResponseReservasDto;
import com.jobint.ingresoJobintApi.Service.ReservasService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ReservasServiceImpl implements ReservasService {

    @Value("${spring.external.service.reservas.base-url}")
    private String basepath;

    private final RestTemplate restTemplate;

    @Override
    public List<ResponseReservasDto> getallReservas(String destino) {
        restTemplate.getInterceptors().add((request, body, execution) -> {
            ClientHttpResponse response = execution.execute(request,body);
            response.getHeaders().setContentType(MediaType.APPLICATION_JSON);
            return response;
        });
        ResponseEntity<ResponseReservasDto> responseEntity =
                restTemplate.exchange(basepath  ,
                        HttpMethod.GET, null, new ParameterizedTypeReference<ResponseReservasDto>() {
                        });
        ResponseReservasDto response = responseEntity.getBody();
        ResponseReservasDto responseDestino= new ResponseReservasDto();
        List<ReservasDto>listaReservaDestino=new ArrayList<>();
        for(ResponseReservasDto resp:Arrays.asList(response)){
            for (ReservasDto reserva:resp.getResponse()){
                if (reserva.getVuelo().getAereopuertoDestino().equals(destino)){
                    listaReservaDestino.add(reserva);
                }
            }
        }
        responseDestino.setResponse(listaReservaDestino);
        return Arrays.asList(responseDestino);
    }


}
