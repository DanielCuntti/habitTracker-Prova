package repository;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import entity.Habit;

public class HabitRepository {
    private List<Habit> habits;

    public HabitRepository() {
        this.habits = new ArrayList<>();
    }

    public void addHabit(Habit habit) {
        habits.add(habit);
    }

    public List<Habit> getAllHabits() {
        return new ArrayList<>(habits);
    }

    public void updateHabit(Habit updatedHabit) {
    
    ListIterator<Habit> iterator = habits.listIterator();
    while (iterator.hasNext()) {
        Habit habit = iterator.next();
        if (habit.getNome().equals(updatedHabit.getNome())) {
            habit.setDescrizione(updatedHabit.getDescrizione());
            habit.setDataInizio(updatedHabit.getDataInizio());
            System.out.println("Habit aggiornata con successo.");
        }
    }

    System.out.println("Habit non trovata.");
}


    public void deleteHabit(String habitName) {
        
        for (Iterator<Habit> iterator = habits.iterator(); iterator.hasNext();) {
            Habit habit = iterator.next();
            if (habit.getNome().equals(habitName)) {
                iterator.remove();
                System.out.println("Habit eliminata con successo.");
                return; 
            }
        }
        System.out.println("Habit non trovata."); 
    }
    
}
