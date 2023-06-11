package com.example.todolist.dao;

import com.example.todolist.entity.Task;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskDAO extends JpaRepository<Task, Long> {
    @Override
    <S extends Task> S save(S entity);

    @Override
    void deleteById(Long aLong);

    @Override
    Page<Task> findAll(Pageable pageable);
}
