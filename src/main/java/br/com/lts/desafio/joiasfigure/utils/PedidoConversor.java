package br.com.lts.desafio.joiasfigure.utils;

import br.com.lts.desafio.joiasfigure.models.dtos.requests.PedidoDto;
import br.com.lts.desafio.joiasfigure.models.entities.PedidoModel;

import java.util.ArrayList;
import java.util.List;

public class PedidoConversor {

    public static PedidoDto converterParaDto(PedidoModel pedidoModel) {
        PedidoDto pedidoDto = new PedidoDto();
        if(pedidoModel != null) {
            pedidoDto = new PedidoDto(pedidoModel.getCodigoPedido(), pedidoModel.getCodigoCliente(),
                    pedidoModel.getDataCadastro(), pedidoModel.getDataAtualizacao(),
                    pedidoModel.getCodigoStatusPedido(), pedidoModel.getValorTotalPedido());
        }
        return pedidoDto;
    }

    public static PedidoModel converterParaModel(PedidoDto pedidoDto) {
        PedidoModel pedidoModel = new PedidoModel();
        if(pedidoDto != null) {
            pedidoModel = new PedidoModel(pedidoDto.getCodigoPedido(), pedidoDto.getCodigoCliente(),
                    pedidoDto.getDataCadastro(), pedidoDto.getDataAtualizacao(),
                    pedidoDto.getCodigoStatusPedido(),pedidoDto.getValorTotalPedido());
        }
        return pedidoModel;
    }

    public static List<PedidoDto> converterParaListDto(List<PedidoModel> pedidosModel) {
        List<PedidoDto> pedidosDto = new ArrayList<>();

        if(pedidosModel != null) {
            for(PedidoModel item : pedidosModel) {
                PedidoDto dto = converterParaDto(item);
                pedidosDto.add(dto);
            }
        }else
            pedidosDto = null;

        return pedidosDto;
    }

    public static List<PedidoModel> converterParaListModel(List<PedidoDto> pedidosDto) {
        List<PedidoModel> pedidosModel = new ArrayList<>();

        if(pedidosDto != null) {
            for(PedidoDto item : pedidosDto) {
                PedidoModel model = converterParaModel(item);
                pedidosModel.add(model);
            }
        }

        return pedidosModel;
    }
}
