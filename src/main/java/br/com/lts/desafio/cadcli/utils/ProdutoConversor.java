package br.com.lts.desafio.cadcli.utils;

import br.com.lts.desafio.cadcli.models.dtos.requests.ProdutoDto;
import br.com.lts.desafio.cadcli.models.entities.ProdutoModel;

import java.util.ArrayList;
import java.util.List;

public class ProdutoConversor {

    public static ProdutoDto converterParaDto(ProdutoModel produtoModel){
        var produtoDto = new ProdutoDto();

        if(produtoModel != null){
            produtoDto = new ProdutoDto(produtoModel.getCodigoProduto(), produtoModel.getNomeProduto(), produtoModel.getPrecoProduto());
        }
        else
            produtoDto = null;

        return produtoDto;
    }

    public static List<ProdutoDto> converterParaListDto(List<ProdutoModel> produtosModel){
        List<ProdutoDto> produtosDtos = new ArrayList<>();

        if(produtosModel != null){
            for(ProdutoModel item : produtosModel){
                if(item != null){
                    ProdutoDto produtoDto = converterParaDto(item);
                    produtosDtos.add(produtoDto);
                }
            }
        }
        else
            produtosDtos = null;

        return produtosDtos;
    }

    public static ProdutoModel converterParaModel(ProdutoDto produtoDto){
        var produtoModel = new ProdutoModel();

        if(produtoDto != null){
            produtoModel = new ProdutoModel(produtoDto.getCodigoProduto(), produtoDto.getNomeProduto(), produtoDto.getPrecoProduto());
        }
        else
            produtoDto = null;

        return produtoModel;
    }

    public static List<ProdutoModel> converterParaListModel(List<ProdutoDto> produtosDtos){
        List<ProdutoModel> produtosModel = new ArrayList<>();

        if(produtosDtos != null){
            for(ProdutoDto item : produtosDtos){
                if(item != null){
                    ProdutoModel produtoModel = converterParaModel(item);
                    produtosModel.add(produtoModel);
                }
            }
        }
        else
            produtosModel = null;

        return produtosModel;
    }

}
