package com.example.todolist.dao;

import com.example.todolist.entity.Task;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface TaskDAO extends JpaRepository<Task, Long> {
    @Override
    <S extends Task> S save(S entity);

    @Override
    Optional<Task> findById(Long aLong);

    @Override
    void deleteById(Long aLong);

    @Override
    void delete(Task entity);

    @Override
    Page<Task> findAll(Pageable pageable);

    @Override
    List<Task> findAll();

    @Override
    <S extends Task> Optional<S> findOne(Example<S> example);
}
