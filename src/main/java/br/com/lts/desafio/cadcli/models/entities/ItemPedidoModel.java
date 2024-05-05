package br.com.lts.desafio.cadcli.models.entities;

import br.com.lts.desafio.cadcli.models.exceptions.PedidoException;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tb_item_pedido")
public class ItemPedidoModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigoItemPedido;
    private Long codigoPedido;
    private Long codigoProduto;
    private int quantidade;

    public void validar() throws PedidoException {
        validarSeProdutoInformado();
        validarSeQuantidadeInformada();
    }

    public void validarSeProdutoInformado() throws PedidoException {
        if(codigoProduto == null || codigoProduto == 0){
            throw new PedidoException("Produto é obrigatório");
        }
    }

    public void validarSeQuantidadeInformada() throws PedidoException {
        if(quantidade == 0){
            throw new PedidoException("Quantidade de produto é obrigatório");
        }
    }

}
