package entity;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

import repository.HabitRepository;

public class Interfaccia {
    private HabitRepository habitRepository;
    private Scanner scanner;

    public Interfaccia(HabitRepository habitRepository) {
        this.habitRepository = habitRepository;
        this.scanner = new Scanner(System.in);
    }

    public void start() {
        int choice;
        do {
            System.out.println("Menu:");
            System.out.println("1. Visualizza abitudini");
            System.out.println("2. Aggiungi abitudine");
            System.out.println("3. Aggiorna abitudine");
            System.out.println("4. Elimina abitudine");
            System.out.println("0. Esci");
            System.out.print("Scelta: ");

            choice = scanner.nextInt();
            scanner.nextLine(); // Consuma la nuova riga dopo l'input numerico

            switch (choice) {
                case 1:
                    displayHabits();
                    break;
                case 2:
                    addHabit();
                    break;
                case 3:
                    updateHabit();
                    break;
                case 4:
                    deleteHabit();
                    break;
                case 0:
                    System.out.println("Arrivederci!");
                    break;
                default:
                    System.out.println("Scelta non valida. Riprova.");
            }
        } while (choice != 0);
    }

    private void displayHabits() {
        List<Habit> habits = habitRepository.getAllHabits();
        if (habits.isEmpty()) {
            System.out.println("Nessuna abitudine presente.");
        } else {
            System.out.println("Abitudini:");
            for (Habit habit : habits) {
                System.out.println(habit.getNome() + " - " + habit.getDescrizione() + " (Inizio: " + habit.getDataInizio() + ")");
            }
        }
    }

    private void addHabit() {
        System.out.print("Inserisci il nome dell'abitudine: ");
        String name = scanner.nextLine();

        System.out.print("Inserisci la descrizione dell'abitudine: ");
        String description = scanner.nextLine();

        System.out.print("Inserisci la data di inizio (YYYY-MM-DD): ");
        LocalDate startDate = LocalDate.parse(scanner.nextLine());

        Habit newHabit = new Habit(name, description, startDate);
        habitRepository.addHabit(newHabit);

        System.out.println("Abitudine aggiunta con successo.");
    }

    private void updateHabit() {
        System.out.print("Inserisci il nome dell'abitudine da aggiornare: ");
        String habitName = scanner.nextLine();

        // Verifica se l'abitudine esiste prima di richiedere l'aggiornamento
        if (habitRepository.getAllHabits().stream().anyMatch(habit -> habit.getNome().equals(habitName))) {
            System.out.print("Inserisci la nuova descrizione dell'abitudine: ");
            String newDescription = scanner.nextLine();

            System.out.print("Inserisci la nuova data di inizio (YYYY-MM-DD): ");
            LocalDate newStartDate = LocalDate.parse(scanner.nextLine());

            Habit updatedHabit = new Habit(habitName, newDescription, newStartDate);
            habitRepository.updateHabit(updatedHabit);

            System.out.println("Abitudine aggiornata con successo.");
        } else {
            System.out.println("Abitudine non trovata.");
        }
    }

    private void deleteHabit() {
        System.out.print("Inserisci il nome dell'abitudine da eliminare: ");
        String habitName = scanner.nextLine();

        habitRepository.deleteHabit(habitName);
    }

    public static void main(String[] args) {
        HabitRepository habitRepository = new HabitRepository();
        Interfaccia cli = new Interfaccia(habitRepository);
        cli.start();
    }
}
