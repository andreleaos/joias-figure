package br.com.lts.desafio.cadcli.unitTests;

import br.com.lts.desafio.cadcli.mocks.ClienteDtoMock;
import br.com.lts.desafio.cadcli.models.exceptions.ClienteException;
import br.com.lts.desafio.cadcli.utils.ClienteConversor;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ValidacaoRegrasDeNegociosParaCadastroTest {

    @Test
    public void validarDadosMinimosParaCadastroPreenchidos(){
        var clienteDto = ClienteDtoMock.getClienteDto();
        var cliente = ClienteConversor.converterParaModel(clienteDto);
        var resultadoEsperado = "";
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
    public void validarDadosMinimosParaCadastroSemNome(){
        var clienteDto = ClienteDtoMock.getClienteDtoSemNome();
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
    public void validarDadosMinimosParaCadastroSemEmail(){
        var clienteDto = ClienteDtoMock.getClienteDtoSemEmail();
        var cliente = ClienteConversor.converterParaModel(clienteDto);
        var resultadoEsperado = "Email do cliente obrigatorio";
        var resultadoObtido = "";

        try {
            cliente.validarDadosMinimosParaCadastro();
        }
        catch (ClienteException e) {
            resultadoObtido = e.getMessage();
        }

        assertEquals(resultadoEsperado, resultadoObtido);
    }
}
