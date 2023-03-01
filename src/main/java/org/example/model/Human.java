package org.example.model;

import org.example.model.id.IdHuman;

import java.time.LocalDate;
import java.util.ArrayList;


public class Human {
    private final String id;
    private String name;
    private Gender gender;
    private LocalDate dateOfBirth;
    private LocalDate dateOfDeath;
    private Human mother;
    private Human father;
    private final ArrayList<Human> children;
    {
        children = new ArrayList<>();
    }
    private final ArrayList<Human> brothersAndSisters;
    {
        brothersAndSisters = new ArrayList<>();
    }
    // ==============================================================================================================
    public Human(String name, Gender gender, LocalDate dateOfBirth, LocalDate dateOfDeath, String id, Tree<Human> tree) {
        this.name = name;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
        this.dateOfDeath = dateOfDeath;
        this.id = new IdHuman(tree, id).creatorId();
    }
    public Human(String name, Tree<Human> tree){
        this(name, null, LocalDate.now(), null, "", tree);
    }
    //-----------------------------------------------------------------------------------------------------------
    public String getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Gender getGender() {return gender;}
    public void setGender(Gender gender) {
        this.gender = gender;
    }
    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }
    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
    public LocalDate getDateOfDeath() {
        return dateOfDeath;
    }
    public void setDateOfDeath(LocalDate dateOfDeath) {
        this.dateOfDeath = dateOfDeath;
    }
    public Human getMother() {
        return mother;
    }
    public void setMother(Human mother) {
        this.mother = mother;
    }
    public Human getFather() {
        return father;
    }
    public void setFather(Human father) {
        this.father = father;
    }
    public ArrayList<Human> getChildren() {
        return children;
    }
    public void setChildren(Human children) {
        this.children.add(children);
    }
    public ArrayList<Human> getBrothersAndSisters() {
        return brothersAndSisters;
    }
    public void setBrothersAndSisters(Human children) {
        this.brothersAndSisters.add(children);
    }
}
