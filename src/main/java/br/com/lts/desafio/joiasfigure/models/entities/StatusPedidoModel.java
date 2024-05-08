package br.com.lts.desafio.joiasfigure.models.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tb_status_pedido")
public class StatusPedidoModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int codigoStatusPedido;
    private String descricaoStatusPedido;
}
