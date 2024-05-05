package br.com.lts.desafio.cadcli.repositories;

import br.com.lts.desafio.cadcli.models.entities.ProdutoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoRepository extends JpaRepository<ProdutoModel, Long> {
}
