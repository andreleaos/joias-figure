package br.com.lts.desafio.joiasfigure.models.entities;

import br.com.lts.desafio.joiasfigure.models.dtos.requests.ItemPedidoProdutoDto;
import br.com.lts.desafio.joiasfigure.models.exceptions.PedidoException;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tb_pedido")
public class PedidoModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigoPedido;
    private String codigoCliente;
    @Column(nullable = true)
    private LocalDate dataCadastro;
    @Column(nullable = true)
    private LocalDate dataAtualizacao;
    private int codigoStatusPedido;
    private double valorTotalPedido;

    public void calcularValorTotal(List<ItemPedidoProdutoDto> itens) {

        double total = 0;

        for (ItemPedidoProdutoDto item : itens) {
            double totalItem = item.getValor() * item.getQuantidade();
            total += totalItem;
        }

        valorTotalPedido = total;
    }

    public void validarDadosParaCadastro() throws PedidoException {
        if(this.codigoCliente ==null || this.codigoCliente.isEmpty()){
            throw new PedidoException("Cliente é obrigatorio");
        }

        if(this.valorTotalPedido <=0){
            throw new PedidoException("valorTotal de pedido é obrigatorio");
        }
    }

    public void validarDadosParaAtualizacao() throws PedidoException {
        if(this.codigoPedido ==null || this.codigoPedido ==0){
            throw new PedidoException("Cliente é obrigatorio");
        }

        if(this.codigoCliente ==null || this.codigoCliente.isEmpty()){
            throw new PedidoException("Cliente é obrigatorio");
        }

        if(this.codigoStatusPedido ==0){
            throw new PedidoException("Status é obrigatorio");
        }
    }

    public static void validarDadosParaPesquisa(Long codigoPedido) throws PedidoException {
        if(codigoPedido ==null || codigoPedido <= 0){
            throw new PedidoException("codigo pedido é obrigatorio");
        }
    }

}
