package br.com.lts.desafio.cadcli.utils;

import br.com.lts.desafio.cadcli.models.dtos.requests.ClienteDto;
import br.com.lts.desafio.cadcli.models.entities.ClienteModel;

import java.util.ArrayList;
import java.util.List;

public class ClienteConversor {

    public static ClienteDto converterParaDto(ClienteModel clienteModel){
        ClienteDto clienteDto = new ClienteDto();
        if(clienteModel != null) {
            if (clienteModel.getCodigoCliente() != null) {
                clienteDto.setCodigoCliente(clienteModel.getCodigoCliente());
            }

            if (clienteModel.getNomeCliente() != null) {
                clienteDto.setNomeCliente(clienteModel.getNomeCliente());
            }

            if (clienteModel.getEmailCliente() != null) {
                clienteDto.setEmailCliente(clienteModel.getEmailCliente());
            }

            if (clienteModel.getFoneCliente() != null) {
                clienteDto.setFoneCliente(clienteModel.getFoneCliente());
            }

            if (clienteModel.getRgCliente() != null) {
                clienteDto.setRgCliente(clienteModel.getRgCliente());
            }

            if (clienteModel.getCpfCliente() != null) {
                clienteDto.setCpfCliente(clienteModel.getCpfCliente());
            }

            clienteDto.setClienteEstaAtivo(clienteModel.isClienteEstaAtivo());
        }
        else
            clienteDto = null;

        return clienteDto;
    }
    public static List<ClienteDto> converterParaListDto(List<ClienteModel> clientesModel) {

        List<ClienteDto> result = new ArrayList<>();

        if(clientesModel != null) {
            for (var item : clientesModel) {
                result.add(converterParaDto(item));
            }
        }
        else
            result = null;

        return result;
    }
    public static ClienteModel converterParaModel(ClienteDto clienteDto){
        ClienteModel cliente = new ClienteModel();
        if(clienteDto != null) {
            if (clienteDto.getCodigoCliente() != null) {
                cliente.setCodigoCliente(clienteDto.getCodigoCliente());
            }

            if (clienteDto.getNomeCliente() != null) {
                cliente.setNomeCliente(clienteDto.getNomeCliente());
            }

            if (clienteDto.getEmailCliente() != null) {
                cliente.setEmailCliente(clienteDto.getEmailCliente());
            }

            if (clienteDto.getFoneCliente() != null) {
                cliente.setFoneCliente(clienteDto.getFoneCliente());
            }

            if (clienteDto.getRgCliente() != null) {
                cliente.setRgCliente(clienteDto.getRgCliente());
            }

            if (clienteDto.getCpfCliente() != null) {
                cliente.setCpfCliente(clienteDto.getCpfCliente());
            }

            cliente.setClienteEstaAtivo(clienteDto.isClienteEstaAtivo());
        }

        return cliente;
    }
    public static List<ClienteModel> converterParaListModel(List<ClienteDto> clientesDto) {

        List<ClienteModel> result = new ArrayList<>();

        if(clientesDto != null) {
            for (var item : clientesDto) {
                result.add(converterParaModel(item));
            }
        }
        else
            result = null;

        return result;
    }
}
