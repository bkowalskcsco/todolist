package com.example.fullstackapp.infrastructure.repository;

import java.util.Collection;
import java.util.Optional;

import org.springframework.stereotype.Component;

import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;

import com.example.fullstackapp.domain.todo.Item;
import com.example.fullstackapp.domain.todo.ItemRepository;

@Component
@RequiredArgsConstructor
class ItemRepositoryImpl implements ItemRepository {

    private final ItemJpaRepository dao;

    @Override
    public Optional<Item> findById(Long id) {
        return dao.findById(id);
    }

    @Override
    public Collection<Item> listAll() {
        return dao.findAll();
    }

    @Override
    public Item save(@NotNull Item item) {
        return dao.save(item);
    }

    @Override
    public void delete(Long id) {
        dao.deleteById(id);
    }

}
