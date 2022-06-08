package br.com.trabalho.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.trabalho.model.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, Long>{

}
