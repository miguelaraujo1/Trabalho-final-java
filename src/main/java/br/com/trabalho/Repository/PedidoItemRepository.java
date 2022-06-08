package br.com.trabalho.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.trabalho.model.PedidoItem;

public interface PedidoItemRepository extends JpaRepository<PedidoItem, Long> {

}
