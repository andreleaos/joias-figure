package br.com.lts.desafio.cadcli.integrationTests;

import br.com.lts.desafio.cadcli.mocks.ClienteDtoMock;
import br.com.lts.desafio.cadcli.models.dtos.requests.ClienteDto;
import br.com.lts.desafio.cadcli.models.entities.ClienteModel;
import br.com.lts.desafio.cadcli.repositories.ClienteRepository;
import br.com.lts.desafio.cadcli.services.ClienteService;
import br.com.lts.desafio.cadcli.utils.ClienteConversor;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.ArgumentMatchers.any;

@ExtendWith(MockitoExtension.class)
public class ValidacaoIntegracaoServiceTest {

    @Mock
    private ClienteRepository clienteRepository;

    @InjectMocks
    private ClienteService clienteService;

    @Test
    public void validarCadastroCliente() {
        var clienteDto = ClienteDtoMock.getClienteDto();
        var cliente = ClienteConversor.converterParaModel(clienteDto);
        cliente.criarCodigoCliente();

        when(clienteRepository.save(any(ClienteModel.class))).thenReturn(cliente);

        ClienteDto clienteCadastrado = clienteService.salvar(clienteDto);

        assertThat(clienteCadastrado).isNotNull();
        assertThat(clienteCadastrado.getCodigoCliente()).isNotNull();
        assertThat(clienteCadastrado.getNomeCliente()).isEqualTo(clienteDto.getNomeCliente());
        verify(clienteRepository).save(any(ClienteModel.class));
    }
}
