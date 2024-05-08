package br.com.lts.desafio.joiasfigure.repositories;

import br.com.lts.desafio.joiasfigure.models.entities.PedidoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PedidoRepository extends JpaRepository<PedidoModel, Long> {
}
