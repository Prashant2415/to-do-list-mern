package com.todolist.todolist.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.todolist.todolist.model.ToDoData;

@Repository
public interface ToDoDataRepo extends JpaRepository<ToDoData, Integer>{
	@Query(value = "Select * from todolist where todoid=?1", nativeQuery=true)
	public List<ToDoData> getById(int todoid);
}
