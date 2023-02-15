package org.example;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.*;

public class App
{
    public static void main( String[] args )
    {
        Tree treeFamDem = new Tree();   // База данных Human +++++++++++++++++++++++++++++++
        treeFamDem.setNameFamily("Демидовичи");

        treeFamDem.setBigFamily(new ArrayList<>());
        //--------------------------------------------------------------------------------------------------------------
        treeFamDem.addHuman(new Human("Демидович Павел Анатольевич", Gender.male, LocalDate.of(1988, 8, 23)));
        treeFamDem.addHuman(new Human("Демидович Агата Павловна", Gender.female, LocalDate.of(2013, 9, 16)));
        treeFamDem.addHuman(new Human("Демидович Анатолий Афанасьевич", Gender.male, LocalDate.of(1955, 9, 28)));
        treeFamDem.addHuman(new Human("Демидович Галина Ивановна", Gender.female, LocalDate.of(1950, 9, 24)));
        treeFamDem.addHuman(new Human("Мордвинцева Александра Павловна", Gender.female, LocalDate.of(1925, 5, 1), LocalDate.of(1959, 3, 3)));
        treeFamDem.addHuman(new Human("Гулак Иван Васильевич", Gender.male));
        treeFamDem.addHuman(new Human("Демидович Анастасия Герасимовна", Gender.female));
        treeFamDem.addHuman(new Human("Демидович Афанасий Гаврилович", Gender.male));
        treeFamDem.addHuman(new Human("Балашенко Феодосия Ивановна"));
        // Кнопки:
        Menu mainM = new Menu();
        mainM.setButtons(new HashMap<>(Map.of(
                1, "Вывод на экран",
                2, "Добавить человека",
                3, "Добавить/изменить данные",
                4, "Выход")));
        Menu mainM1 = new Menu();
        mainM1.setButtons(new HashMap<>(Map.of(
                1, "Печать выбранного человека",
                2, "Печать всего списка людей")));
        Menu mainM31 = new Menu();
        mainM31.setButtons(new HashMap<>(Map.of(
                1, "Ф.И.О.",
                2, "ПОЛ",
                3, "ДАТУ РОЖДЕНИЯ",
                4, "ДОБАВИТЬ/РЕДАКТИРОВАТЬ ДАТУ СМЕРТИ",
                5, "mother",
                6, "father",
                7, "children",
                8, "brothersAndSisters",
                9, "Вернуться в предыдущее меню")));
        //====================================================
        Menu messages = new Menu();
        messages.setButtons(new HashMap<>(Map.of(
                1, "*******ВЫБЕРЕТЕ ЧЕЛОВЕКА ИЗ СПИСКА*******\n",
                2, "*******ЧТО ВЫ ХОТИТЕ ДОБАВИТЬ/ИЗМЕНИТЬ ?*******\n",
                3, "***Введите Ф.И.О***",
                5, "Ведите дату формате -день%месяц%год-")));
        //------------------------------------------------------------------------------------
        Scanner scanner = new Scanner(System.in);
        boolean flag = false;
        while (!flag) {
            mainM.outputOfMenuButtons(mainM.getButtons()); // выводит меню в консоль
            String input = scanner.nextLine();
            switch (input) {
                case "1" -> {           // Печать
                    messages.outputOfMessages(messages.getButtons(), new ArrayList<>(List.of(1)));
                    Human.printNamesHuman(treeFamDem);
                    input = scanner.nextLine();
                    Human.superPrintHumanHC(treeFamDem, Integer.parseInt(input) - 1);
                }
                case "2" ->  {
                    messages.outputOfMessages(messages.getButtons(), new ArrayList<>(List.of(3)));
                    String name = scanner.nextLine();                      // Добавить человека
                    treeFamDem.addHuman(new Human(name));
                }
                case "3" -> {    // Изменить данные человека
                    messages.outputOfMessages(messages.getButtons(), new ArrayList<>(List.of(1)));
                    Human.printNamesHuman(treeFamDem); // вывод списка Human по именам
                    input = scanner.nextLine();
                    boolean flag3 = false;
                    while (!flag3) {
                        messages.outputOfMessages(messages.getButtons(), new ArrayList<>(List.of(2)));
                        Human.printHuman(treeFamDem, Integer.parseInt(input) - 1);
                        mainM31.outputOfMenuButtons(mainM31.getButtons());
                        switch (Integer.parseInt(scanner.nextLine())) {
                            case 1 -> {
                                messages.outputOfMessages(messages.getButtons(), new ArrayList<>(List.of(3)));
                                treeFamDem.getBigFamily().get(Integer.parseInt(input) - 1).setName(scanner.nextLine());
                            }
                            case 2 -> {
                                System.out.println("1 - Мужчина");
                                System.out.println("2 - Женщина");
                                String input2 = scanner.nextLine();
                                if (input2.equals("1")){
                                    treeFamDem.getBigFamily().get(Integer.parseInt(input) - 1).setGender(Gender.male);
                                } else{
                                    treeFamDem.getBigFamily().get(Integer.parseInt(input) - 1).setGender(Gender.female);
                                }
                            }
                            case 3 -> {
                                messages.outputOfMessages(messages.getButtons(), new ArrayList<>(List.of(5)));
                                String input2 = scanner.nextLine();
                                treeFamDem.getBigFamily().get(Integer.parseInt(input) - 1).setDateOfBirth(Human.creatingADate(input2));
                            }
                            case 4 -> {
                                messages.outputOfMessages(messages.getButtons(), new ArrayList<>(List.of(5)));
                                String input2 = scanner.nextLine();
                                treeFamDem.getBigFamily().get(Integer.parseInt(input) - 1).setDateOfDeath(Human.creatingADate(input2));
                            }
                            case 5 -> {
                                messages.outputOfMessages(messages.getButtons(), new ArrayList<>(List.of(1)));
                                Human.printNamesHuman(treeFamDem);
                                String input2 = scanner.nextLine();
                                Human mother = treeFamDem.getBigFamily().get(Integer.parseInt(input2) - 1);
                                treeFamDem.getBigFamily().get(Integer.parseInt(input) - 1).setMother(mother);
           // Делаеш ребенку мать автомотически ренку присваивается мать так же и отцу далее
                                Human children = treeFamDem.getBigFamily().get(Integer.parseInt(input) - 1);
                                mother.setChildren(children);
                            }
                             case 6 -> {
                                 messages.outputOfMessages(messages.getButtons(), new ArrayList<>(List.of(1)));
                                 Human.printNamesHuman(treeFamDem);
                                 String input2 = scanner.nextLine();
                                 Human father = treeFamDem.getBigFamily().get(Integer.parseInt(input2) - 1);
                                 treeFamDem.getBigFamily().get(Integer.parseInt(input) - 1).setFather(father);
                                 Human children = treeFamDem.getBigFamily().get(Integer.parseInt(input) - 1);
                                 father.setChildren(children);

                            }
                            case 7 ->{
                                messages.outputOfMessages(messages.getButtons(), new ArrayList<>(List.of(1)));
                                Human.printNamesHuman(treeFamDem);
                                String input2 = scanner.nextLine();
                                Human children = treeFamDem.getBigFamily().get(Integer.parseInt(input2) - 1);
                                treeFamDem.getBigFamily().get(Integer.parseInt(input) - 1).setChildren(children);

                            }
                            case 8 -> {
                                messages.outputOfMessages(messages.getButtons(), new ArrayList<>(List.of(1)));
                                Human.printNamesHuman(treeFamDem);
                                String input2 = scanner.nextLine();
                                Human brothersAndSisters = treeFamDem.getBigFamily().get(Integer.parseInt(input2) - 1);
                                treeFamDem.getBigFamily().get(Integer.parseInt(input) - 1).setBrothersAndSisters(brothersAndSisters);
                            }
                            case 9 -> flag3 = true;
                        }
                    }
                }
            case "4" -> flag = true;
            }
        }
        scanner.close();
    }
}
