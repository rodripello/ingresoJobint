package com.jobint.ingresoJobintApi.restHoteles;

import com.jobint.ingresoJobintApi.Dto.HotelesDto;
import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.test.context.junit4.SpringRunner;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment= SpringBootTest.WebEnvironment.RANDOM_PORT)
public class testRestTemplateHoteles {

    @Autowired
    private TestRestTemplate testRestTemplate;

    @LocalServerPort
    int randomServerPort;

    //Test donde me trae todos los hoteles disponibles ingresando como parametro el destino
    @Test
    public void testGetHotelesDisponiblesSuccess() throws URISyntaxException
    {
        //destinos Paris,Rome,
        String destino="Rome";
        ResponseEntity<HotelesDto[]> respuesta = testRestTemplate.getForEntity("http://localhost:"+randomServerPort+"/api/ingresoJobint/hoteles/"+destino,HotelesDto[].class);
        List<HotelesDto> hotelesDestino = Arrays.asList(respuesta.getBody());
        assertEquals("Rome",hotelesDestino.get(0).getResponse().get(0).getLocacion().getLocality());
        assertEquals("Hotel",hotelesDestino.get(0).getResponse().get(1).getCategorias().get(0).getName());
        assertEquals(HttpStatus.OK,respuesta.getStatusCode());
    }
}
