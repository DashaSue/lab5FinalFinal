package data;

import program.*;

import java.util.Objects;
import java.util.Scanner;
import java.util.Arrays;
import java.util.Comparator;
import java.time.LocalDate;

public class SpaceMarine implements Comparable {
    public int id; //Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
    public String name; //Поле не может быть null, Строка не может быть пустой
    public Coordinates coordinates;//Поле не может быть null
    public static LocalDate creationDate; //Поле не может быть null, Значение этого поля должно генерироваться автоматически
    public Long health; //Поле не может быть null, Значение поля должно быть больше 0
    public String achievements; //Поле не может быть null
    public AstartesCategory category; //Поле может быть null
    public Weapon weaponType; //Поле не может быть null
    public Chapter chapter; //Поле не может быть null

    public SpaceMarine(String name, Coordinates coordinates, Long health, String achievements, AstartesCategory category, Weapon weapon, Chapter chapter) {
        this.creationDate = LocalDate.now();
        this.id = generateId();
        this.name = name;
        this.coordinates = coordinates;
        this.health = health;
        this.achievements = achievements;
        this.category = category;
        this.weaponType = weapon;
        this.chapter = chapter;
    }

    public static LocalDate getCreationDate() {
        return creationDate;
    }
    public long getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public Coordinates getCoordinates() {
        return coordinates;
    }
    public long getHealth() {
        return health;
    }
    public String getAchievements() {
        return achievements;
    }
    public AstartesCategory getCategory() {
        return category;
    }
    public Weapon getWeaponType() {
        return weaponType;
    }
    public Chapter getChapter() {
        return chapter;
    }

    public void setName(String name) throws NullPointerException {
        if (name != null && !name.isEmpty())
            this.name = name;
        else throw new NullPointerException();
    }
    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }
    public void setHealth(long health) throws NullPointerException {
        throw new NullPointerException();
    }
    public void setAchievements(String achievements) throws NullPointerException {
        if (achievements != null && !achievements.isEmpty())
            this.achievements = name;
        else throw new NullPointerException();
    }
    public void setCategory(AstartesCategory category) throws NullPointerException {
        if (category != null)
            this.category = category;
        else throw new NullPointerException();
    }
    public void setWeaponType(Weapon weaponType) throws NullPointerException {
        if (weaponType != null)
            this.weaponType = weaponType;
        else throw new NullPointerException();
    }
    public void setChapter(Chapter chapter) throws NullPointerException {
        if (chapter != null)
            this.chapter = chapter;
        else throw new NullPointerException();
    }

    public static int generateId() {
        int count = 0;
        int id = 1;
        while(count != Main.collection.size()) {
            for(SpaceMarine spaceMarine : Main.collection) {
                count++;
                if(spaceMarine.getId() == id) {
                    id++;
                    count = 0;
                    break;
                }
            }
        }
        return id;
    }
    public static SpaceMarine create() {
        SpaceMarine spaceMarine = null;

        if(Main.script) {
            String name = Main.scriptLines.poll();
            Coordinates coordinates = Coordinates.create();
            Long health = Long.parseLong(Objects.requireNonNull(Main.scriptLines.poll()));
            String achievements = Main.scriptLines.poll();
            AstartesCategory category = null;
            try {
                category = AstartesCategory.valueOf(Main.scriptLines.poll());
            } catch (Exception ignored) {}
            Weapon weapon = Weapon.valueOf(Main.scriptLines.poll());
            Chapter chapter = Chapter.create();
            spaceMarine = new SpaceMarine(name, coordinates, health, achievements, category, weapon, chapter);
        }
        else {
            System.out.println("\nВведите название корабля:");
            Scanner nameIn = new Scanner(System.in);
            String name = nameIn.nextLine();
            while(name.equals("")) {
                System.out.println("\nПоле не может быть пустым");
                System.out.println("Введите название корабля:");
                name = nameIn.nextLine();
            }

            Coordinates coordinates = Coordinates.create();

            boolean check = false;
            System.out.println("\nВведите здоровье:");
            Scanner healthIn = new Scanner(System.in);
            Long health = null;
            while(!check) {
                try {
                    health = Long.parseLong(healthIn.nextLine());
                    if(health > 0) check = true;
                    else {
                        System.out.println("Поле должно быть больше 0");
                        System.out.println("Введите здоровье:");
                    }
                } catch(Exception e) {
                    System.out.println("\nДанные введены неверно");
                    System.out.println("Введите здоровье:");
                }
            }

            System.out.println("\nВведите достижения:");
            Scanner achievementsIn = new Scanner(System.in);
            String achievements = nameIn.nextLine();
            while(achievements.equals("")) {
                System.out.println("\nПоле не может быть пустым");
                System.out.println("Введите достижения:");
                name = nameIn.nextLine();
            }

            check = false;
            System.out.println("\nВведите категорию " + Arrays.toString(AstartesCategory.values()) + ":");
            AstartesCategory category = null;
            while(!check) {
                try {
                    Scanner categoryIn = new Scanner(System.in);
                    String categoryInput = categoryIn.nextLine();
                    if(categoryInput.equals("")) {
                        check = true;
                        break;
                    }
                    else category = AstartesCategory.valueOf(categoryInput);
                    check = true;
                } catch(Exception e) {
                    System.out.println("\nДанные введены неверно");
                    System.out.println("Введите категорию " + Arrays.toString(AstartesCategory.values()) + ":");
                }
            }

            check = false;
            System.out.println("\nВведите оружие " + Arrays.toString(Weapon.values()) + ":");
            Weapon weapon = null;
            while(!check) {
                try {
                    Scanner weaponIn = new Scanner(System.in);
                    String weaponInput = weaponIn.nextLine();
                    if(weaponInput.equals("")) {
                        System.out.println("\nПоле не может быть пустым");
                        System.out.println("Введите оружие " + Arrays.toString(Weapon.values()) + ":");
                        continue;
                    }
                    else weapon = Weapon.valueOf(weaponInput);
                    check = true;
                } catch(Exception e) {
                    System.out.println("\nДанные введены неверно");
                    System.out.println("Введите оружие " + Arrays.toString(Weapon.values()) + ":");
                }
            }

            Chapter chapter = Chapter.create();

            spaceMarine = new SpaceMarine(name, coordinates, health, achievements, category, weapon, chapter);

        }
        return spaceMarine;
    }

    public static class healthComparator implements Comparator<SpaceMarine> {
        @Override
        public int compare(SpaceMarine sm1, SpaceMarine sm2) {
            int ret = 0;
            if(sm1.health - sm2.health > 0) ret = 1;
            if(sm1.health - sm2.health == 0) ret = 0;
            if(sm1.health - sm2.health < 0) ret = -1;
            return ret;
        }
    }

    @Override
    public String toString() {
        return "Космический корабль{ " +
                "id: " + id +
                ", имя: '" + name + '\'' +
                ", " + "коодинаты: x = "+coordinates.getX() + ", y = "+coordinates.getY()+
                ", дата создания: " + creationDate +
                ", здоровье: " + health +
                ", достижения: " + achievements +
                ", категория: " + category +
                ", тип оружия: " + weaponType +
                ", " + chapter + "}";
    }

    @Override
    public int compareTo(Object spaceMarine) {
        SpaceMarine sm = (SpaceMarine) spaceMarine;
        int ret = 0;
        if(this.health - sm.health > 0) ret = 1;
        if(this.health - sm.health == 0) ret = 0;
        if(this.health - sm.health < 0) ret = -1;
        return ret;
    }
}