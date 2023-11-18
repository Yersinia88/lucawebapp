package hu.akakademia.lucawebapp.entity.dog;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;

import java.time.LocalDate;

/**
 * chip szám :A passzív RFID rendszert használó parányi kapszula csak egy 15 számjegyből álló egyedi kódot (számsort) tárol, mást nem.
 */
@AllArgsConstructor
@Entity
@Table(name="dog")
public class Dog {
    @Column(name="name")
    private final String name;
    @Column(name="sex")
    private final Sex sex;
    @Column(name="chip_number")
    private final String chipNumber;
    @Column(name="birthday")
    private final LocalDate birthDay;
    @Column(name="birth_place")
    private final String birthPlace;
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    //TODO - Controller-ben is kell ezt kezelni? Beállítom a breed_id-t ehhez?
    @OneToOne (cascade = CascadeType.DETACH)
    @JoinColumn(name="dog_breed_id")
    private Breed breed;
    @Column(name="active")
    private boolean active;

    public Dog(String name, Sex sex, String chipNumber, LocalDate birthDay, String birthPlace) {
        validate(chipNumber); //TODO move it to a factory class
        this.name = name;
        this.sex = sex;
        this.chipNumber = chipNumber;
        this.birthDay = birthDay;
        this.birthPlace = birthPlace;
    }

    private void validate(String chipNumber) {
        if (!(chipNumber.matches("[0-9]+") && chipNumber.length() == 15)) {
            throw new RuntimeException("Wrong chip-number format");
        }
    }

    public String getName() {
        return name;
    }
    public String getSex() {
        return sex.getLabel();
    }
    public String getChipNumber() {
        return chipNumber;
    }
    public LocalDate getBirthDay() {
        return birthDay;
    }
    public String getBirthPlace() {
        return birthPlace;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public boolean isActive() {
        return active;
    }
    public void setActive(boolean active) {
        this.active = active;
    }

    @Override
    public String toString() {
        return name;
    }
}