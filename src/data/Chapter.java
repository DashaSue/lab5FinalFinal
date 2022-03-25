package data;

import program.*;

import java.util.Objects;
import java.util.Scanner;

public class Chapter {
    private String name; //Поле не может быть null, Строка не может быть пустой
    private String parentLegion;
    private long marinesCount; //Значение поля должно быть больше 0, Максимальное значение поля: 1000

    public Chapter(String name, String parentLegion, long marinesCount) {
        this.name = name;
        this.parentLegion = parentLegion;
        this.marinesCount = marinesCount;
    }

    @Override
    public String toString() {
        return "часть{" +
                "имя: '" + name + '\'' +
                ", легион: '" + parentLegion + '\'' + ",количество кораблей в части: " + marinesCount+
                '}';
    }

    public String getName() {
        return name;
    }
    public String getParentLegion() {
        return parentLegion;
    }
    public long getMarinesCount() {
        return marinesCount;
    }

    public void setName(String name) {
        if (name != null)
            this.name = name;
    }
    public void setParentLegion(String parentLegion) {
        if (parentLegion != null)
            this.parentLegion = parentLegion;
    }
    public void setMarinesCount(Long marinesCount){
        this.marinesCount = marinesCount;
    }

    public static Chapter create() {
        Chapter chapter = null;

        if(Main.script) {
            String name = Main.scriptLines.poll();
            String parentLegion = Main.scriptLines.poll();
            Long marinesCount = Long.parseLong(Objects.requireNonNull(Main.scriptLines.poll()));
            chapter = new Chapter(name, parentLegion, marinesCount);
        }
        else {
            System.out.println("\nВведите имя части:");
            Scanner nameIn = new Scanner(System.in);
            String name = nameIn.nextLine();
            System.out.println("\nВведите название легиона:");
            Scanner legionIn = new Scanner(System.in);
            String parentLegion = legionIn.nextLine();

            boolean check = false;
            System.out.println("\nВведите количество кораблей:");
            Scanner countIn = new Scanner(System.in);
            Long marineCount = null;
            while(!check) {
                try {
                    marineCount = Long.parseLong(countIn.nextLine());
                    if(marineCount > 0 && marineCount <= 1000) check = true;
                    else {
                        System.out.println("Поле должно быть от 0 до 1000");
                        System.out.println("Введите количество кораблей:");
                    }
                } catch(Exception e) {
                    System.out.println("\nДанные введены неверно");
                    System.out.println("Введите количество кораблей:");
                }
            }

            chapter = new Chapter(name, parentLegion, marineCount);
        }
        return chapter;
    }
}