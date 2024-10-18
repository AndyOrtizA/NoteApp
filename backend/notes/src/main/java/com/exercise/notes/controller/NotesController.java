package com.exercise.notes.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.exercise.notes.model.Note;
import com.exercise.notes.service.NoteService;

@RestController
//@CrossOrigin(origins="http://localhost:5500")
@RequestMapping(path="api/notes/")
public class NotesController {
	private final NoteService noteService;
	
	@Autowired
	public NotesController(NoteService noteService) {
		this.noteService = noteService;
	}//Constructor

	@GetMapping
	public List<Note> getNotes(){
		return noteService.getAllNotes();
	}//getNotes
	
	@GetMapping(path="{prodId}")
	public Note getNote (@PathVariable("prodId") Long id) {
		return noteService.getNote(id);
	}
	
	@DeleteMapping(path="{prodId}")
	public Note deleteNote (@PathVariable("prodId") Long id) {
		return noteService.deleteNote(id);
	}
	
	@PostMapping //http://localhost:8088/api/notes/
	public Note addNote(@RequestBody Note note) {
		return noteService.addNote(note);
	}
	
	@DeleteMapping
	public void deleteNotes(){
		noteService.deleteAllNotes();
		return ;
	}//getNotes
}
