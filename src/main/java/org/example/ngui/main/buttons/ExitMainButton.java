package org.example.ngui.main.buttons;

import org.example.ngui.ConsoleUI;
import org.example.ngui.SButton;

public class ExitMainButton extends SButton {
    private final String text;
    {
        text = "Выход";
    }
    private final ConsoleUI consoleUI;

    public ExitMainButton(ConsoleUI consoleUI) {
        this.consoleUI = consoleUI;
    }

    @Override
    public void action() {
        consoleUI.setFlag(true);
    }
    @Override
    public String toString() {
        return text;
    }
}
