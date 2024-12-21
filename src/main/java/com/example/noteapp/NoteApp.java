package com.example.noteapp;

import java.util.*;

public class NoteApp {
    private final Map<String, List<Note>> notes = new HashMap<>();
    private final HolidayService holidayService = new HolidayService();

    public void addNoteForDate(String date, String content) {
        notes.putIfAbsent(date, new ArrayList<>());
        Note newNote = new Note(UUID.randomUUID().toString(), content);
        notes.get(date).add(newNote);
        System.out.println("Заметка добавлена!");
    }

    public void removeNoteById(String date, String noteId) {
        List<Note> dayNotes = notes.get(date);
        if (dayNotes != null && dayNotes.removeIf(note -> note.getId().equals(noteId))) {
            System.out.println("Заметка удалена!");
        } else {
            System.out.println("Заметка не найдена!");
        }
    }

    public void clearNotesForDate(String date) {
        if (notes.remove(date) != null) {
            System.out.println("Все заметки за " + date + " удалены!");
        } else {
            System.out.println("Заметки за " + date + " не найдены!");
        }
    }

    public void displayNotesForDate(String date) {
        boolean isHoliday = holidayService.isHoliday(date);
        System.out.println("Дата: " + date + (isHoliday ? " (Праздничный день)" : " (Рабочий день)"));

        List<Note> dayNotes = notes.get(date);
        if (dayNotes == null || dayNotes.isEmpty()) {
            System.out.println("Нет заметок на эту дату.");
        } else {
            System.out.println("Заметки:");
            for (int i = 0; i < dayNotes.size(); i++) {
                Note note = dayNotes.get(i);
                System.out.println((i + 1) + ". ID: " + note.getId() + " Содержание: " + note.getContent());
            }
        }
    }

    static class Note {
        private final String id;
        private final String content;

        public Note(String id, String content) {
            this.id = id;
            this.content = content;
        }

        public String getId() {
            return id;
        }

        public String getContent() {
            return content;
        }
    }
}