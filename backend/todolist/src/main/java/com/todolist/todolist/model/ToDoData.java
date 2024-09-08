package com.todolist.todolist.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
@Table(name ="Todo")
@Entity
public class ToDoData {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name ="todoid")
	private int todoid;
	@Column(name ="message")
	private String message;
	@Column(name ="dateTime")
	private LocalDateTime dateTime;
	@Column(name ="check")
	private boolean check;
	public ToDoData() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ToDoData(int todoid, String message, LocalDateTime dateTime, boolean check) {
		super();
		this.todoid = todoid;
		this.message = message;
		this.dateTime = dateTime;
		this.check = check;
	}
	public int getTodoid() {
		return todoid;
	}
	public void setTodoid(int todoid) {
		this.todoid = todoid;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public LocalDateTime getDateTime() {
		return dateTime;
	}
	public void setDateTime(LocalDateTime dateTime) {
		this.dateTime = dateTime;
	}
	public boolean isCheck() {
		return check;
	}
	public void setCheck(boolean check) {
		this.check = check;
	}
	
	
	
}
