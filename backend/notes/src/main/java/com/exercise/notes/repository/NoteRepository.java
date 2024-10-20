package com.exercise.notes.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.exercise.notes.model.Note;

@Repository
public interface NoteRepository extends JpaRepository<Note, Long> {
	
}//interface NoteRepository
