package commands;

import elements.Route;

import java.io.Serializable;

/**
 * Класс для передачи между командами флагов, переменных, которые нужны для правильной работы.
 */
public class CommandData implements Serializable {
    private static final long serialVersionUID = 5824144243465154839L;
    private Route route = null;
    private int key = 0;
    private Float distance = 0F;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String name = "";

    public void setObject(Object object) {
        if (object.getClass().toString().equals("class elements.Route")) {
            route = (Route) object;
        }
        else if (object.getClass().toString().equals("class java.lang.Integer")) {
            key = (int) object;
        }
        else if (object.getClass().toString().equals("class java.lang.Float")) {
            distance = (Float) object;
        }
        else if (object.getClass().toString().equals("class java.lang.String")) {
            name = (String) object;
        }
    }
    public Float getDistance(){
        return distance;
    }
    public void setDistance(Float distance){
        this.distance = distance;
    }
    public Route getRoute() {
        return route;
    }

    public void setRoute(Route route) {
        this.route = route;
    }

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }
}