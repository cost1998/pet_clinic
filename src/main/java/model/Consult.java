package model;

import javax.persistence.*;

@Entity
@Table(name="consult")

public class Consult {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "consult_id")
    private Long id;

    @Column(name = "date")
    private String date;

    @Column(name = "description")
    private String description;

    @ManyToOne
    @JoinColumn(name = "pet_id")
    private Pet pet;

    @ManyToOne
    @JoinColumn(name = "vet_id")
    private Vet vet;

    public Consult() {
    }

    public Consult( String date, String description, Vet vet, Pet pet) {
        this.date = date;
        this.description = description;
        this.vet = vet;
        this.pet = pet;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Vet getVet() {
        return vet;
    }

    public void setVet(Vet vet) {
        this.vet = vet;
    }

    public Pet getPet() {
        return pet;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }

    @Override
    public String toString() {
        return "Consult info: " +
                "ID: " + id +
                ", Date: " + date +
                ", Description: " + description +"\n"
                + vet + "\n"+
                  pet ;
    }
}
