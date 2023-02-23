package com.dev.fab.projenum.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dev.fab.projenum.entities.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long>{

}
