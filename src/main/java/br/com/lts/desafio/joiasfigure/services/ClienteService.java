package br.com.lts.desafio.joiasfigure.services;

import br.com.lts.desafio.joiasfigure.models.dtos.requests.ClienteDto;
import br.com.lts.desafio.joiasfigure.models.entities.ClienteModel;
import br.com.lts.desafio.joiasfigure.repositories.ClienteRepository;
import br.com.lts.desafio.joiasfigure.services.logs.ConsoleLogService;
import br.com.lts.desafio.joiasfigure.utils.ClienteConversor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public ClienteDto salvar(ClienteDto clienteDto) {

        ClienteModel cliente = ClienteConversor.converterParaModel(clienteDto);
        cliente.criarCodigoCliente();
        clienteRepository.save(cliente);
        var dto = ClienteConversor.converterParaDto(cliente);
        return dto;
    }

    public List<ClienteDto> listar() {
        var clientes = clienteRepository.findAllByOrderByNomeCliente();
        var clientesAtivos = filtrarClientesAtivos(clientes);
        var clientesDto = ClienteConversor.converterParaListDto(clientesAtivos);
        return clientesDto;
    }

    public ClienteDto pesquisarPorId(String codigoCliente) {
        ClienteModel cliente = null;
        try {
            var data = clienteRepository.findById(codigoCliente);
            cliente = data.get();
        }
        catch (NoSuchElementException e) {
            ConsoleLogService.logMessage("[ClienteService][pesquisarPorId] - Cliente: " + codigoCliente + " não localizado");
        }
        catch(Exception e){
            ConsoleLogService.logMessage(e.getMessage());
            e.printStackTrace();
        }

        var result = ClienteConversor.converterParaDto(cliente);
        return result;
    }

    public ClienteDto excluir(String codigoCliente) {
        ClienteModel cliente = clienteRepository
                .findById(codigoCliente)
                .orElseThrow(() -> new IllegalArgumentException("Cliente nao localizado: " + codigoCliente));

        cliente.setClienteEstaAtivo(false);
        clienteRepository.save(cliente);
        var dto = ClienteConversor.converterParaDto(cliente);
        return dto;
    }

    public ClienteDto atualizar(ClienteDto clienteDto) {
        ClienteModel cliente = clienteRepository
                .findById(clienteDto.getCodigoCliente())
                .orElseThrow(() -> new IllegalArgumentException("Cliente nao localizado: " + clienteDto.getCodigoCliente()));

        cliente = new ClienteModel(clienteDto.getCodigoCliente(), clienteDto.getNomeCliente(), clienteDto.getEmailCliente(),
                clienteDto.getFoneCliente(), clienteDto.getRgCliente(), clienteDto.getCpfCliente(),
                clienteDto.isClienteEstaAtivo());

        clienteRepository.save(cliente);

        var dto = ClienteConversor.converterParaDto(cliente);
        return dto;
    }

    private List<ClienteModel> filtrarClientesAtivos(List<ClienteModel> clientes) {
        List<ClienteModel> clientesAtivos = new ArrayList<>();

        for (ClienteModel cliente : clientes) {
            if (cliente.isClienteEstaAtivo()) {
                clientesAtivos.add(cliente);
            }
        }

        return clientesAtivos;
    }
}
