package сlasses;

import java.io.Serializable;

public class Coordinates implements Serializable {
    private long x; //Значение поля должно быть больше -248
    private Double y; //Поле не может быть null
    public Coordinates(long x, double y){
        this.x=x;
        this.y=y;
    }
    public Coordinates(){}

    public void setY(double y){
        this.y = y;
    }
    public void setX(long x){
        this.x=x;
    }

    public String toString(){
        return "{"+x+":"+y+"}";
    }
    public boolean checkX(long x) {
        if (x>-248) {
            this.x = x;
            return true;
        }
        else{
            return false;
        }
    }

}
