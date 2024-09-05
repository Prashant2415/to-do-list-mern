package com.todolist.todolist.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.todolist.todolist.model.ToDoData;
import com.todolist.todolist.repo.ToDoDataRepo;
@Service
public class ToDoDataServiceImpl implements ToDoDataService{
	@Autowired
	private ToDoDataRepo listRepo;
	@Override
	public ToDoData saveListData(ToDoData listData) {
		// TODO Auto-generated method stub
		return listRepo.save(listData);
	}

	@Override
	public List<ToDoData> getAllListData() {
		// TODO Auto-generated method stub
		return listRepo.findAll();
	}

	@Override
	public List<ToDoData> getById(int todoid) {
		// TODO Auto-generated method stub
		return listRepo.getById(todoid);
	}

	@Override
	public void updateListData(ToDoData listData) {
		// TODO Auto-generated method stub
		listRepo.save(listData);
	}

	@Override
	public void deleteDataById(int todoid) {
		// TODO Auto-generated method stub
		listRepo.deleteById(todoid);
	}

}
