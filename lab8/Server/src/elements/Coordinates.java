package elements;

import interfaces.Validdatable;

import java.io.Serializable;

public class Coordinates implements Validdatable, Serializable {
    private static final long serialVersionUID = 901L;
    private double x; //Максимальное значение поля: 550, Поле не может быть null
    private double y;

    public Coordinates(double x, double y){
        this.x = x;
        this.y = y;
    }
    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    @Override
    public String toString() {
        return "("+ x + ";" + y + ")";
    }

    @Override
    public boolean validate() {
        if (x > 550) return false;
        return true;
    }
}