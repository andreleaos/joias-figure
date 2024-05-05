package br.com.lts.desafio.cadcli.models.entities;

import br.com.lts.desafio.cadcli.models.exceptions.ProdutoException;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Objects;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tb_produto")
public class ProdutoModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigoProduto;
    private String nomeProduto;
    private double precoProduto;

    public void validarDadosParaCadastro() throws ProdutoException {
        if(this.nomeProduto == null || Objects.equals(this.nomeProduto, "")){
            throw new ProdutoException("Nome do produto obrigatorio");
        }

        if(this.precoProduto <= 0.0){
            throw new ProdutoException("Preco do produto obrigatorio e deve ser maior do que zero");
        }
    }

    public void validarDadosParaAtuaizacao() throws ProdutoException {
        if(this.codigoProduto <= 0){
            throw new ProdutoException("codigo do produto obrigatorio");
        }

        if(this.nomeProduto == null || Objects.equals(this.nomeProduto, "")){
            throw new ProdutoException("Nome do produto obrigatorio");
        }

        if(this.precoProduto <= 0.0){
            throw new ProdutoException("Preco do produto obrigatorio e deve ser maior do que zero");
        }
    }

    public static void validarDadosParaExclusao(Long id) throws ProdutoException {
        if(id <= 0){
            throw new ProdutoException("codigo do produto obrigatorio");
        }
    }

    public static void validarDadosParaPesquisa(Long id) throws ProdutoException {
        if(id <= 0){
            throw new ProdutoException("codigo do produto obrigatorio");
        }
    }

}
