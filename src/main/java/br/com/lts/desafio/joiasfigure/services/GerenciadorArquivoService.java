package br.com.lts.desafio.joiasfigure.services;

import br.com.lts.desafio.joiasfigure.models.dtos.requests.ClienteDto;
import br.com.lts.desafio.joiasfigure.models.dtos.requests.ProdutoDto;
import br.com.lts.desafio.joiasfigure.services.logs.ConsoleLogService;
import br.com.lts.desafio.joiasfigure.utils.GerenciadorArquivoFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Service
public class GerenciadorArquivoService {

    @Autowired
    private GerenciadorArquivoFactory gerenciadorArquivoFactory;

    @Value("${arquivos.diretorio.relatorio_cliente}")
    private String nomeArquivoCliente;

    @Value("${arquivos.diretorio.relatorio_produto}")
    private String nomeArquivoProduto;

    DateTimeFormatter formatoData = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

    public void gravarClienteAtualizado(ClienteDto cliente){

        var linha = String.format("codigo_cliente: %s, nome: %s, email: %s, fone: %s, rg: %s, cpf: %s, estaAtivo: %s, dataAtualizacao: %s",
                cliente.getCodigoCliente(), cliente.getNomeCliente(), cliente.getEmailCliente(),
                cliente.getFoneCliente(), cliente.getRgCliente(), cliente.getCpfCliente(), cliente.isClienteEstaAtivo(),
                LocalDate.now().toString());

        gravarDadosEmArquivo(nomeArquivoCliente, linha);
    }

    public void gravarProdutoAtualizado(ProdutoDto produto){

        var linha = String.format("id: %s, nome: %s, preco: %s, dataAtualizacao: %s",
                produto.getCodigoProduto(), produto.getNomeProduto(), produto.getPrecoProduto(),
                LocalDate.now().toString());

        gravarDadosEmArquivo(nomeArquivoProduto, linha);
    }

    private void gravarDadosEmArquivo(String nomeArquivo, String linha){
        try {
            PrintWriter writer = gerenciadorArquivoFactory.criarArquivo(nomeArquivo);
            writer.println(linha);
            writer.close();
        }
        catch (FileNotFoundException e) {
            var mensagem = "Arquivo nao localizado: " + e.getMessage();
            ConsoleLogService.logMessage(mensagem);
            throw new RuntimeException(mensagem);
        }
        catch(Exception e){
            var mensagem = "Erro ao gravar dado: " + e.getMessage();
            ConsoleLogService.logMessage(mensagem);
            throw new RuntimeException(mensagem);
        }
    }
}
