package br.com.lts.desafio.cadcli.unitTests;

import br.com.lts.desafio.cadcli.mocks.ClienteDtoMock;
import br.com.lts.desafio.cadcli.models.exceptions.ClienteException;
import br.com.lts.desafio.cadcli.utils.ClienteConversor;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ValidacaoRegrasDeNegocioParaAtualizacaoTest {

    @Test
    public void validarDadosMinimosParaAtualizacaPreenchidos(){
        var clienteDto = ClienteDtoMock.getClienteDtoComId();
        var cliente = ClienteConversor.converterParaModel(clienteDto);
        var resultadoEsperado = "";
        var resultadoObtido = "";

        try {
            cliente.validarDadosMinimosParaAtualizacao();
        }
        catch (ClienteException e) {
            resultadoObtido = e.getMessage();
        }

        assertEquals(resultadoEsperado, resultadoObtido);
    }

    @Test
    public void validarDadosMinimosParaAtualizacaoSemNome(){
        var clienteDto = ClienteDtoMock.getClienteDtoComIdESemNome();
        var cliente = ClienteConversor.converterParaModel(clienteDto);
        var resultadoEsperado = "Nome do cliente obrigatorio";
        var resultadoObtido = "";

        try {
            cliente.validarDadosMinimosParaCadastro();
        }
        catch (ClienteException e) {
            resultadoObtido = e.getMessage();
        }

        assertEquals(resultadoEsperado, resultadoObtido);
    }

    @Test
    public void validarDadosMinimosParaAtualizacaoSemId(){
        var clienteDto = ClienteDtoMock.getClienteDto();
        var cliente = ClienteConversor.converterParaModel(clienteDto);
        var resultadoEsperado = "Codigo do cliente obrigatorio";
        var resultadoObtido = "";

        try {
            cliente.validarDadosMinimosParaAtualizacao();
        }
        catch (ClienteException e) {
            resultadoObtido = e.getMessage();
        }

        assertEquals(resultadoEsperado, resultadoObtido);
    }

}
