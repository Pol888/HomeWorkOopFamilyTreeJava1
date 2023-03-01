package org.example.model.communication;

import java.util.ArrayList;
import java.util.Map;

public interface Service {
    ArrayList<Map<String, String>> getAListPrintHuman();
    void addHuman(String name);
    void setNameHuman(String name, Integer index);
    void  setGenderHuman(String gender, Integer integer);
    void setDateBirth(String date, Integer index);
    void setDateDeath(String date, Integer index);
    void setMother(Integer indexMother, Integer indexChildren);
    void setFather(Integer indexFather, Integer indexChildren);
    void setChildren(Integer indexChildren, Integer indexHuman);
    void setBrothersAndSisters(Integer broAndSis, Integer indexHuman);
    void removeHuman(Integer index);



}
