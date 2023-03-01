package org.example.presenter;



import org.example.model.communication.Service;
import org.example.ngui.View;

import java.util.ArrayList;
import java.util.Map;

public class Presenter {
    private final Service service;



    public Presenter(View view, Service sc) {
        this.service = sc;
        view.setPresenter(this);
    }

    public ArrayList<Map<String,String>> getPrintList(){
        return service.getAListPrintHuman();
    }

    public ArrayList<Map<String,String>> setCommandFromView(String command, String text, Integer index){
        switch (command) {
            case "addH" -> service.addHuman(text);
            case "EditingName" -> service.setNameHuman(text, index);
            case "gender" -> service.setGenderHuman(text, index);
            case "dateB" -> service.setDateBirth(text, index);
            case "dateD" -> service.setDateDeath(text, index);
            case "mother" -> service.setMother(Integer.parseInt(text) - 1, index);
            case "father" -> service.setFather(Integer.parseInt(text) - 1, index);
            case "children" -> service.setChildren(Integer.parseInt(text) - 1, index);
            case "brothersAndSisters" -> service.setBrothersAndSisters(Integer.parseInt(text) - 1, index);
            case "remove" -> service.removeHuman(index);
        }
        return null;
    }

}
