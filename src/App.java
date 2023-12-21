import entity.Interfaccia;
import repository.HabitRepository;

public class App {
    public static void main(String[] args) {
    HabitRepository habitRepository = new HabitRepository();
    Interfaccia cli = new Interfaccia(habitRepository);
    cli.start();
}

}
