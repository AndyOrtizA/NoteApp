package com.exercise.notes.service;

import java.util.List;

import com.exercise.notes.model.Note;
import com.exercise.notes.repository.NoteRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NoteService {
	public final NoteRepository noteRepository;
	
	@Autowired
	public NoteService(NoteRepository noteRepository) {
		this.noteRepository=noteRepository;
	}
	
	public List<Note> getAllNotes(){
		return noteRepository.findAll();
	}//getAllNotes

	public Note getNote(Long id) {	
		return noteRepository.findById(id).orElseThrow(
				()-> new IllegalArgumentException("El producto con el id ["+
		id+ "] no existe")
				);
	}//getNote

	public Note deleteNote(Long id) {
		Note tmpNote= null;
		if(noteRepository.existsById(id)) {
			tmpNote=noteRepository.findById(id).get();
			noteRepository.deleteById(id);;
		}//if
		return tmpNote;
	}

	public Note addNote(Note note) {
		return noteRepository.save(note);
	}

	public void deleteAllNotes() {
		noteRepository.deleteAll();
		return ;
	}
}//NoteService
