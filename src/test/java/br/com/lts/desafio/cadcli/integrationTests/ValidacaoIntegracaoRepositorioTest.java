package br.com.lts.desafio.cadcli.integrationTests;

import br.com.lts.desafio.cadcli.mocks.ClienteDtoMock;
import br.com.lts.desafio.cadcli.repositories.ClienteRepository;
import br.com.lts.desafio.cadcli.utils.ClienteConversor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ActiveProfiles;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@ActiveProfiles("test")
public class ValidacaoIntegracaoRepositorioTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    ClienteRepository clienteRepository;

    @Test
    public void validarCadastroDeCliente(){
        var clienteDto = ClienteDtoMock.getClienteDto();
        var cliente = ClienteConversor.converterParaModel(clienteDto);
        cliente.criarCodigoCliente();

        var codigoCliente = cliente.getCodigoCliente();
        var clienteCadastrado = entityManager.persistAndFlush(cliente);

        assertThat(clienteCadastrado).isNotNull();
        assertThat(clienteCadastrado.getCodigoCliente()).isEqualTo(codigoCliente);
    }

    @Test
    public void validarCadastroDeClienteComPesquisa(){
        var clienteDto = ClienteDtoMock.getClienteDto();
        var cliente = ClienteConversor.converterParaModel(clienteDto);
        cliente.criarCodigoCliente();

        var codigoCliente = cliente.getCodigoCliente();
        var clienteCadastrado = entityManager.persistAndFlush(cliente);

        var clientePesquisado = clienteRepository.findById(codigoCliente).orElse(null);
        assertThat(clientePesquisado).isNotNull();
        assertThat(clientePesquisado.getCodigoCliente()).isEqualTo(codigoCliente);
    }

}
