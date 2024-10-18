package com.exercise.notes.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

// POJO - Plain Old Java Object
@Entity
@Table(name="Notes")
public class Note {
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id", unique=true, nullable=false)
	private long id;
	@Column(nullable=false)
	private String title;
	@Column(nullable=false)
	private String content; 
	
	
	//Constructor 
	public Note(String title, String content) {
		this.title = title;
		this.content = content;
	}
	
	//Constructor vacío
	 public Note() {}

	// Getter and Setter
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	
	public Long getId() {
		return id;
	}
	
	//To String
	@Override
	public String toString() {
		return "Note [title=" + title + ", content=" + content + ", id=" + id + "]";
	}

	
	
	
	
	
	

	
}//Class Note
