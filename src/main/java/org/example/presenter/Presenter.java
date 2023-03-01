package org.example.presenter;



import org.example.model.communication.Service;
import org.example.ngui.View;

import java.util.ArrayList;
import java.util.Map;

public class Presenter {
    private final View view;
    private final Service service;



    public Presenter(View view, Service sc) {
        this.service = sc;
        this.view = view;
        this.view.setPresenter(this);
    }

    public ArrayList<Map<String,String>> getPrintList(){
        return service.getAListPrintHuman();
    }

    public ArrayList<Map<String,String>> setCommandFromView(String command, String text, Integer index){
        if (command.equals("addH")) {
            service.addHuman(text);
        } else if (command.equals("EditingName")) {
            service.setNameHuman(text, index);
        } else if (command.equals("gender")){
            service.setGenderHuman(text, index);
        } else if (command.equals("dateB")) {
            service.setDateBirth(text, index);
        } else if (command.equals("dateD")) {
            service.setDateDeath(text, index);
        } else if (command.equals("mother")){
            service.setMother(Integer.parseInt(text) - 1, index);
        } else if (command.equals("father")){
            service.setFather(Integer.parseInt(text) - 1, index);
        } else if (command.equals("children")){
            service.setChildren(Integer.parseInt(text) - 1, index);
        } else if (command.equals("brothersAndSisters")){
            service.setBrothersAndSisters(Integer.parseInt(text) - 1, index);
        } else if (command.equals("remove")) {
            service.removeHuman(index);
        }
        return null;
    }

}
