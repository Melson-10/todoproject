package com.gl.TodosListSpringBoot.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gl.TodosListSpringBoot.Model.TodosList;

public interface TodosListRepository extends JpaRepository<TodosList, Long>{

}
