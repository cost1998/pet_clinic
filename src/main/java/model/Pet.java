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

    @Column(name = "birthdate")
    private String birthdate;

    @Column(name = "isVaccinated")
    private boolean isVaccinated;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "pet")
    private List<Consult> consults;

    public Pet() {
    }

    public Pet(String race,boolean isVaccinated, String birthdate, String name) {
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Consult> getConsults() {
        return consults;
    }

    public void setConsultations(List<Consult> consults) {
        this.consults = consults;
    }

    @Override
    public String toString() {
        return "Pet info :" +
                "ID:" + id +
                ", Name: " + name +
                ", Race: " + race +
                ", IsVaccinated=" + isVaccinated +
                ", Birthdate: " + birthdate;
    }
}
