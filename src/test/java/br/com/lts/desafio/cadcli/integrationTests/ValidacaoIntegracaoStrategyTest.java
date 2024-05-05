package br.com.lts.desafio.cadcli.integrationTests;

import br.com.lts.desafio.cadcli.mocks.ClienteResponseDtoMock;
import br.com.lts.desafio.cadcli.models.dtos.requests.ClienteDto;
import br.com.lts.desafio.cadcli.models.dtos.responses.ClienteResponseDto;
import br.com.lts.desafio.cadcli.models.enums.ClienteStrategyEnum;
import br.com.lts.desafio.cadcli.strategies.ClienteStrategy;
import br.com.lts.desafio.cadcli.strategies.cases.cliente.CadastrarClienteCase;
import br.com.lts.desafio.cadcli.strategies.contexts.ClienteContext;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ValidacaoIntegracaoStrategyTest {

    @Mock
    ClienteContext clienteContext;

    @Mock
    CadastrarClienteCase cadastrarClienteCase;

    @InjectMocks
    private ClienteStrategy clienteStrategy;

    @Test
    public void validarCadastroCliente() {

        ClienteResponseDto response = ClienteResponseDtoMock.getClienteResponseDto();
        ClienteDto clienteDto = response.getClientes().get(0);

        ClienteStrategyEnum acao = ClienteStrategyEnum.CADASTRAR_CLIENTE;
        when(clienteContext.executar(any(ClienteDto.class))).thenReturn(response);

        ClienteResponseDto resultado = clienteStrategy.executar(acao, clienteDto);

        verify(clienteContext).setCase(any(CadastrarClienteCase.class));
        verify(clienteContext).executar(any(ClienteDto.class));
        assertThat(resultado.isProcessadoComSucesso()).isEqualTo(true);
    }
}
