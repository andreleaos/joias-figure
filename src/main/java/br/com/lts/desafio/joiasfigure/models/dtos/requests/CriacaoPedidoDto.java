package br.com.lts.desafio.joiasfigure.models.dtos.requests;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CriacaoPedidoDto {
    private PedidoDto pedido;
    private List<ItemPedidoDto> itensPedido;

    public void adicionarItens(List<ItemPedidoDto> itens){
        if(this.itensPedido == null){ this.itensPedido = new ArrayList<ItemPedidoDto>(); }
        this.itensPedido.addAll(itens);
    }

    public void adicionarItem(ItemPedidoDto item){
        if(this.itensPedido == null){ this.itensPedido = new ArrayList<ItemPedidoDto>(); }
        this.itensPedido.add(item);
    }
}
