package commands;

import java.io.Serializable;

public class CommandData implements Serializable {
    private static final long serialVersionUID = 5824144243465154839L;
    private int key;
    private Float distance;
    private String name;
    private int breakpoint;
    public void setBreakpoint(int breakpoint) {this.breakpoint = breakpoint; }
    public int getBreakpoint() {return breakpoint;}
    public Float getDistance() {
        return distance;
    }

    public void setDistance(Float distance) {
        this.distance = distance;
    }

    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return name;
    }
    public void setKey(int key) {
        this.key = key;
    }

    public int getKey() {
        return key;
    }
}
