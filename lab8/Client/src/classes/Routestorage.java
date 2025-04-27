package classes;

import elements.Route;

import java.io.Serializable;
import java.util.Date;
import java.util.LinkedHashMap;

public class Routestorage implements Serializable {

    private static final long serialVersionUID = 4123123L;

    public LinkedHashMap<Integer, Route> getMap() {
        return map;
    }

    private LinkedHashMap<Integer, Route> map;

    public Routestorage() {
        map = new LinkedHashMap<Integer, Route>();
    }
}
