package br.com.lts.desafio.cadcli.utils;

import br.com.lts.desafio.cadcli.models.dtos.requests.ItemPedidoDto;
import br.com.lts.desafio.cadcli.models.entities.ItemPedidoModel;

import java.util.ArrayList;
import java.util.List;

public class ItemPedidoConversor {

    public static ItemPedidoDto converterParaDto(ItemPedidoModel itemPedidoModel) {
        ItemPedidoDto itemPedidoDto = new ItemPedidoDto();

        if(itemPedidoModel != null) {
            itemPedidoDto = new ItemPedidoDto(itemPedidoModel.getCodigoItemPedido(), itemPedidoModel.getCodigoPedido(),
                    itemPedidoModel.getCodigoProduto(), itemPedidoModel.getQuantidade());
        }
        else
            itemPedidoDto = null;

        return itemPedidoDto;
    }

    public static ItemPedidoModel converterParaModel(ItemPedidoDto itemPedidoDto) {
        ItemPedidoModel itemPedidoModel = new ItemPedidoModel();

        if(itemPedidoDto != null) {
            itemPedidoModel = new ItemPedidoModel(itemPedidoDto.getCodigoItemPedido(), itemPedidoDto.getCodigoPedido(),
                    itemPedidoDto.getCodigoProduto(), itemPedidoDto.getQuantidade());
        }
        else
            itemPedidoModel = null;

        return itemPedidoModel;
    }

    public static List<ItemPedidoDto> converterParaListDto(List<ItemPedidoModel> itemPedidoModels) {
        List<ItemPedidoDto> itensPedidoDto = new ArrayList<>();

        if(itemPedidoModels != null) {
            for(ItemPedidoModel item : itemPedidoModels) {
                var dto = converterParaDto(item);
                itensPedidoDto.add(dto);
            }
        }
        else
            itensPedidoDto = null;

        return itensPedidoDto;
    }

    public static List<ItemPedidoModel> converterParaListModel(List<ItemPedidoDto> itensPedidoDto) {
        List<ItemPedidoModel> itensPedidoModel = new ArrayList<>();

        if(itensPedidoDto != null) {
            for(ItemPedidoDto item : itensPedidoDto) {
                var model = converterParaModel(item);
                itensPedidoModel.add(model);
            }
        }
        else
            itensPedidoModel = null;

        return itensPedidoModel;
    }
}
