package com.example.fullstackapp.infrastructure.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.fullstackapp.domain.todo.Item;

@Repository
public interface ItemJpaRepository extends JpaRepository<Item, Long> {

}
