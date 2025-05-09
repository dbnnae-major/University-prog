package elements;

import interfaces.Validdatable;

import java.io.Serializable;

public class Coordinates implements Validdatable, Serializable {
    private static final long serialVersionUID = 901L;
    private Integer x; //Максимальное значение поля: 550, Поле не может быть null
    private int y;

    public Coordinates(Integer x, int y){
        this.x = x;
        this.y = y;
    }
    public Integer getX() {
        return x;
    }

    public int getY() {
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