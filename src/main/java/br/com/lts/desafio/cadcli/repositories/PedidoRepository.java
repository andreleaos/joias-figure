package br.com.lts.desafio.cadcli.repositories;

import br.com.lts.desafio.cadcli.models.entities.PedidoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PedidoRepository extends JpaRepository<PedidoModel, Long> {
}
