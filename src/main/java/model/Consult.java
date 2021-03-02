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
    @JoinColumn(name = "vet_id")
    private Vet veterinarian;

    @ManyToOne
    @JoinColumn(name = "pet_id")
    private Pet pet;

    public Consult() {
    }

    public Consult(Long id, String date, String description, Vet veterinarian, Pet pet) {
        this.id = id;
        this.date = date;
        this.description = description;
        this.veterinarian = veterinarian;
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

    public Vet getVeterinarian() {
        return veterinarian;
    }

    public void setVeterinarian(Vet veterinarian) {
        this.veterinarian = veterinarian;
    }

    public Pet getPet() {
        return pet;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }

    @Override
    public String toString() {
        return "Consult{" +
                "id=" + id +
                ", date='" + date + '\'' +
                ", description='" + description + '\'' +
                ", veterinarian=" + veterinarian +
                ", pet=" + pet +
                '}';
    }
}
