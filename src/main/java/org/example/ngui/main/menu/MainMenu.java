package org.example.ngui.main.menu;

import org.example.ngui.ConsoleUI;
import org.example.ngui.SButton;
import org.example.ngui.SMenu;
import org.example.ngui.main.buttons.*;

import java.util.ArrayList;

public class MainMenu extends SMenu {

    private ConsoleUI consoleUI;
    private final ArrayList <SButton> buttons = new ArrayList <>();

    public MainMenu(ConsoleUI consoleUI) {
       this.consoleUI = consoleUI;
       addButton();
    }



    public ArrayList<SButton> getButtons() {
        return buttons;
    }

    @Override
    public void addButton() {
        buttons.add(new PrintListMainButton(consoleUI));
        buttons.add(new AddHumanMainButton(consoleUI));
        buttons.add(new AddEditDataMainButton(consoleUI));
        buttons.add(new RemoveHumanMainButton(consoleUI));
        buttons.add(new ExitMainButton(consoleUI));
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < buttons.size(); i++) {
            res.append(String.format("%d - %s\n", i + 1, buttons.get(i).toString()));
        }
    return res.toString();
    }
}
