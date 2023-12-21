package entity;


import java.time.LocalDate;

public class Habit {
    private String nome;
    private String descrizione;
    private LocalDate dataInizio;

    
    public Habit(String name, String description, LocalDate startDate) {
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getDescrizione() {
        return descrizione;
    }
    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }
    public LocalDate getDataInizio() {
        return dataInizio;
    }
    public void setDataInizio(LocalDate dataInizio) {
        this.dataInizio = dataInizio;
    }


    
}
