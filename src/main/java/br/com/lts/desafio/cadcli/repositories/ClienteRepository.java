package br.com.lts.desafio.cadcli.repositories;

import br.com.lts.desafio.cadcli.models.entities.ClienteModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClienteRepository extends JpaRepository<ClienteModel, String> {
    List<ClienteModel> findAllByOrderByNomeCliente();
}