package br.com.lts.desafio.cadcli.unitTests;

import br.com.lts.desafio.cadcli.mocks.ClienteDtoMock;
import br.com.lts.desafio.cadcli.models.entities.ClienteModel;
import br.com.lts.desafio.cadcli.models.exceptions.ClienteException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ValidacaoRegrasDeNegocioParaPesquisaTest {
    @Test
    public void validarDadosParaPesquisa(){
        var clienteDto = ClienteDtoMock.getClienteDtoComId();
        var resultadoEsperado = "";
        var resultadoObtido = "";

        try {
            ClienteModel.validarDadosParaPesquisa(clienteDto.getCodigoCliente());
        }
        catch (ClienteException e) {
            resultadoObtido = e.getMessage();
        }

        assertEquals(resultadoEsperado, resultadoObtido);
    }

    @Test
    public void validarDadosParaPesquisaSemid(){
        var clienteDto = ClienteDtoMock.getClienteDto();
        var resultadoEsperado = "Codigo do cliente obrigatorio";
        var resultadoObtido = "";

        try {
            ClienteModel.validarDadosParaPesquisa(clienteDto.getCodigoCliente());
        }
        catch (ClienteException e) {
            resultadoObtido = e.getMessage();
        }

        assertEquals(resultadoEsperado, resultadoObtido);
    }

}
