package model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="pet")

public class Pet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pet_id")
    private Long id;

    @Column(name = "race")
    private String race;

    @Column(name = "isVaccinated")
    private boolean isVaccinated;

    @Column(name = "birthdate")
    private String birthdate;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy="pet")
    private List<Consult> consult;

    public Pet() {
    }

    public Pet(Long id, String race, boolean isVaccinated, String birthdate, String name) {
        this.id = id;
        this.race = race;
        this.isVaccinated = isVaccinated;
        this.birthdate = birthdate;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRace() {
        return race;
    }

    public void setRace(String race) {
        this.race = race;
    }

    public boolean isVaccinated() {
        return isVaccinated;
    }

    public void setVaccinated(boolean vaccinated) {
        isVaccinated = vaccinated;
    }

    public String getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }

    public String getOwnerName() {
        return name;
    }

    public void setOwnerName(String ownerName) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Pet{" +
                "id=" + id +
                ", race='" + race + '\'' +
                ", isVaccinated=" + isVaccinated +
                ", birthdate='" + birthdate + '\'' +
                ", ownerName='" + name + '\'' +
                '}';
    }
}
