package elements;

import interfaces.Validdatable;

import java.io.Serializable;
import java.util.Date;

public class Route implements Validdatable, Comparable<Route>, Serializable {
    private static final long serialVersionUID = 901L;
    private String owner;
    private int id; //Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
    private String name; //Поле не может быть null, Строка не может быть пустой
    private Coordinates coordinates; //Поле не может быть null
    private java.util.Date creationDate; //Поле не может быть null, Значение этого поля должно генерироваться автоматически
    private Location1 from; //Поле не может быть null
    private Location2 to; //Поле не может быть null
    private Float distance; //Поле может быть null, Значение поля должно быть больше 1

    public Route(int id, String name, Coordinates coordinates, Location1 from, Location2 to, Float distance) {
        this.id = id;
        this.name = name;
        this.coordinates = coordinates;
        this.creationDate = new Date();
        this.from = from;
        this.to = to;
        this.distance = distance;
    }

    public String getOwner() {
        return owner;
    }

    public Route(int id, String name, Date date, Coordinates coordinates, Location1 from, Location2 to, Float distance, String owner) {
        this.id = id;
        this.name = name;
        this.coordinates = coordinates;
        this.creationDate = date;
        this.from = from;
        this.to = to;
        this.distance = distance;
        this.owner = owner;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Float getDistance() {
        return distance;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public Location1 getFrom() {
        return from;
    }

    public Location2 getTo() {
        return to;
    }


    @Override
    public String toString() {
        return "\n Owner: " + owner + "\n id: " + id + "\n name: " + name + "\n coordinates: " + coordinates +
                "\n creationDate: " + creationDate + "\n from: \t" + from + "\n to: \t" + to + "\n distance: " + distance + "\n";
    }

    @Override
    public boolean validate() {
        if (id <= 0) return false;
        if (name == null) return false;
        if (coordinates == null) return false;
        if (from == null) return false;
        if (to == null) return false;
        if (distance == null || distance < 1.0) return false;
        return true;
    }

    @Override
    public int compareTo(Route other) {
        return Float.compare(this.distance, other.distance);
    }

}
