package br.com.lts.desafio.cadcli.models.entities;

import br.com.lts.desafio.cadcli.models.exceptions.ClienteException;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Objects;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tb_cliente")
public class ClienteModel {
    @Id
    private String codigoCliente;
    private String nomeCliente;
    private String emailCliente;
    private String foneCliente;
    private String rgCliente;
    private String cpfCliente;
    private boolean clienteEstaAtivo;

    public void criarCodigoCliente() {
        String novoId = UUID.randomUUID().toString();
        this.codigoCliente = novoId;
    }

    public void validarDadosMinimosParaCadastro() throws ClienteException {
        if(this.nomeCliente == null || Objects.equals(this.nomeCliente, "")){
            throw new ClienteException("Nome do cliente obrigatorio");
        }

        if(this.emailCliente == null || Objects.equals(this.emailCliente, "")){
            throw new ClienteException("Email do cliente obrigatorio");
        }
    }

    public void validarDadosMinimosParaAtualizacao() throws ClienteException {
        if(this.codigoCliente == null || Objects.equals(this.codigoCliente, "")){
            throw new ClienteException("Codigo do cliente obrigatorio");
        }

        if(this.nomeCliente == null || Objects.equals(this.nomeCliente, "")){
            throw new ClienteException("Nome do cliente obrigatorio");
        }
    }

    public static void validarDadosParaExclusao(String codigoCliente) throws ClienteException {
        if(codigoCliente == null || Objects.equals(codigoCliente, "")){
            throw new ClienteException("Codigo do cliente obrigatorio");
        }
    }

    public static void validarDadosParaPesquisa(String codigoCliente) throws ClienteException {
        if(codigoCliente == null || Objects.equals(codigoCliente, "")){
            throw new ClienteException("Codigo do cliente obrigatorio");
        }
    }
}
