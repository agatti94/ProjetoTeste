package com.d4i.sample.movie.delivery.responses;

import com.d4i.sample.movie.delivery.rest.CategoryRest;
import org.junit.jupiter.api.Test;

import static com.d4i.sample.movie.shared.constants.CommonConstants.OK;
import static com.d4i.sample.movie.shared.constants.CommonConstants.SUCCESS;
import static org.junit.jupiter.api.Assertions.*;

class NetflixResponseTest {
    private final NetflixResponse<CategoryRest> netflixResponse = new NetflixResponse<CategoryRest>();

    @Test
    void should_set_new_values_to_response() {
        assertNull(netflixResponse.getStatus());
        assertNull(netflixResponse.getCode());
        assertNull(netflixResponse.getMessage());
        assertNull(netflixResponse.getData());
        String status = SUCCESS;
        String codigoRetorno = "200 Ok";
        String mensagem = OK;
        CategoryRest Categoria = new CategoryRest("Romance", true);
        netflixResponse.setStatus(status);
        netflixResponse.setCode(codigoRetorno);
        netflixResponse.setMessage(mensagem);
        netflixResponse.setData(Categoria);
        assertEquals(status, netflixResponse.getStatus());
        assertEquals(codigoRetorno, netflixResponse.getCode());
        assertEquals(mensagem, netflixResponse.getMessage());
        assertEquals(Categoria, netflixResponse.getData());
    }
}