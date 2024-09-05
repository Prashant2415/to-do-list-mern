package com.todolist.todolist.service;

import java.util.List;

import com.todolist.todolist.model.ToDoData;

public interface ToDoDataService {

	public ToDoData saveListData(ToDoData listData);
	public List<ToDoData> getAllListData();
	public List<ToDoData> getById(int todoid);
	public void updateListData(ToDoData listData);
	public void deleteDataById(int todoid);
}
