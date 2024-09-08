package com.todolist.todolist.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.todolist.todolist.model.ToDoData;
import com.todolist.todolist.service.ToDoDataService;

@RestController
@CrossOrigin(origins="http://localhost:3000")
@RequestMapping("/todo")
public class ToDoDataController {
	@Autowired
	private ToDoDataService listService;
	@PostMapping("/save")
	public String saveListData(@RequestBody ToDoData listData) {
		listService.saveListData(listData);
		return "Data saved";
	}
	
	@GetMapping("/getAllList")
	public List<ToDoData> getAllListData()
	{
		return listService.getAllListData();
	}
	
	@GetMapping("/getListById/{todoid}")
	public List<ToDoData> getListById(@PathVariable int todoid)
	{
		return listService.getById(todoid);
	}
	
	@PutMapping("/updateList")
	public void updateListData(@RequestBody ToDoData listData)
	{
		listService.updateListData(listData);
	}
	
	@DeleteMapping("/deleteById/{todoid}")
	public void deleteListDataById(@PathVariable int todoid)
	{
		listService.deleteDataById(todoid);
	}
	
	
	
}
