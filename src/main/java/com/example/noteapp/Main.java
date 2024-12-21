package com.example.noteapp;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        NoteApp noteApp = new NoteApp();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nМеню:");
            System.out.println("1. Добавить заметку");
            System.out.println("2. Удалить заметку");
            System.out.println("3. Очистить заметки за день");
            System.out.println("4. Показать заметки на день");
            System.out.println("5. Выход");
            System.out.print("Выберите опцию: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Введите дату (yyyy-MM-dd): ");
                    String date = scanner.nextLine();
                    System.out.print("Введите заметку: ");
                    String content = scanner.nextLine();
                    noteApp.addNoteForDate(date, content);
                    break;

                case 2:
                    System.out.print("Введите дату (yyyy-MM-dd): ");
                    date = scanner.nextLine();
                    System.out.print("Введите ID заметки: ");
                    String noteId = scanner.nextLine();
                    noteApp.removeNoteById(date, noteId);
                    break;

                case 3:
                    System.out.print("Введите дату (yyyy-MM-dd): ");
                    date = scanner.nextLine();
                    noteApp.clearNotesForDate(date);
                    break;

                case 4:
                    System.out.print("Введите дату (yyyy-MM-dd): ");
                    date = scanner.nextLine();
                    noteApp.displayNotesForDate(date);
                    break;

                case 5:
                    System.out.println("Выход...");
                    return;

                default:
                    System.out.println("Неверная опция!");
            }
        }
    }
}