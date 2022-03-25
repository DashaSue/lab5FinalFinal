package data;

import program.*;

import java.util.Objects;
import java.util.Scanner;

public class Coordinates {
    public double x; //Поле не может быть null
    public long y; //Максимальное значение поля: 494

    public Coordinates(double x, long y) {
        this.x = x;
        this.y = y;
    }

    public Double getX() {
        return x;
    }
    public Long getY() {
        return y;
    }

    public void setX(Double x) {
        this.x = x;
    }
    public void setY(Long y) {
        this.y = y;
    }

    public static Coordinates create() {
        Coordinates coordinates = null;

        if(Main.script) {
            double xcoord = Double.parseDouble(Objects.requireNonNull(Main.scriptLines.poll()));
            long ycoord = Long.parseLong(Objects.requireNonNull(Main.scriptLines.poll()));
            coordinates = new Coordinates(xcoord, ycoord);
        }
        else {
            boolean check = false;

            System.out.println("\nВведите координату X:");
            Scanner coordIn = new Scanner(System.in);
            Double xcoord = null;
            while(!check) {
                try {
                    xcoord = Double.parseDouble(coordIn.nextLine());
                    check = true;
                } catch(Exception e) {
                    System.out.println("\nДанные введены неверно");
                    System.out.println("Введите координату X:");
                }
            }

            check = false;
            System.out.println("\nВведите координату Y:");
            Long ycoord = null;
            while(!check) {
                try {
                    ycoord = Long.parseLong(coordIn.nextLine());
                    if(ycoord <= 494) check = true;
                    else {
                        System.out.println("Поле должно быть не более 494");
                        System.out.println("Введите координату Y:");
                    }
                } catch(Exception e) {
                    System.out.println("\nДанные введены неверно");
                    System.out.println("Введите координату Y:");
                }
            }

            coordinates = new Coordinates(xcoord, ycoord);
        }
        return coordinates;
    }
}