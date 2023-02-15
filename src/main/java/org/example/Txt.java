package org.example;

public class Txt extends DB{
    @Override
    public void write(Tree tree) {



        System.out.println("запись...");
    }

    @Override
    public Tree read(String nameFile) {
        System.out.println("чтение");
        return new Tree();
    }
}
