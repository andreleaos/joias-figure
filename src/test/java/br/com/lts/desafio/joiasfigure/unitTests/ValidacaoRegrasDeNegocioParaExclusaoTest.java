package br.com.lts.desafio.joiasfigure.unitTests;

import br.com.lts.desafio.joiasfigure.mocks.ClienteDtoMock;
import br.com.lts.desafio.joiasfigure.models.entities.ClienteModel;
import br.com.lts.desafio.joiasfigure.models.exceptions.ClienteException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ValidacaoRegrasDeNegocioParaExclusaoTest {

    @Test
    public void validarDadosParaExclusao(){
        var clienteDto = ClienteDtoMock.getClienteDtoComId();
        var resultadoEsperado = "";
        var resultadoObtido = "";

        try {
            ClienteModel.validarDadosParaExclusao(clienteDto.getCodigoCliente());
        }
        catch (ClienteException e) {
            resultadoObtido = e.getMessage();
        }

        assertEquals(resultadoEsperado, resultadoObtido);
    }

    @Test
    public void validarDadosParaExclusaoSemid(){
        var clienteDto = ClienteDtoMock.getClienteDto();
        var resultadoEsperado = "Codigo do cliente obrigatorio";
        var resultadoObtido = "";

        try {
            ClienteModel.validarDadosParaExclusao(clienteDto.getCodigoCliente());
        }
        catch (ClienteException e) {
            resultadoObtido = e.getMessage();
        }

        assertEquals(resultadoEsperado, resultadoObtido);
    }

}
