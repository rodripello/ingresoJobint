package com.jobint.ingresoJobintApi.Service.Impl;

import com.jobint.ingresoJobintApi.Dto.HotelesDto;
import com.jobint.ingresoJobintApi.Service.HotelesService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
@RequiredArgsConstructor
public class HotelesServiceImpl implements HotelesService {

    @Value("${spring.external.service.hoteles.base-url}")
    private String basepath;

    private final RestTemplate restTemplate;

    @Override
    public List<HotelesDto> getAllHotelesDisponibles(String destino) {
        ResponseEntity<HotelesDto> responseEntity =
             restTemplate.exchange(basepath + destino,
                  HttpMethod.GET, null, new ParameterizedTypeReference<HotelesDto>() {
             });
        HotelesDto response = responseEntity.getBody();
        return Arrays.asList(response);
    }
}
