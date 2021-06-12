package сlasses;

import java.io.Serializable;
import java.util.ArrayList;

public class Dragon implements Serializable {
    private long id; //Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
    private String name; //Поле не может быть null, Строка не может быть пустой
    private Coordinates coordinates; //Поле не может быть null
    private java.util.Date creationDate; //Поле не может быть null, Значение этого поля должно генерироваться автоматически
    private int age; //Значение поля должно быть больше 0
    private Color color; //Поле не может быть null
    private DragonType type; //Поле не может быть null
    private DragonCharacter character; //Поле может быть null
    private DragonHead head;
    private ArrayList<String> strings;

    public ArrayList<String> getStrings() {
        return strings;
    }

    public Dragon(long id, String name, Coordinates coordinates, java.util.Date creationDate, int age, Color color, DragonType type, DragonCharacter character, DragonHead head){
        this.id=id;
        this.name=name;
        this.coordinates=coordinates;
        this.creationDate=creationDate;
        this.age=age;
        this.color=color;
        this.type=type;
        this.character=character;
        this.head=head;
    }
    public Dragon(){}

    public long getID(){return id;}
    public String getName(){return name;}
    public Coordinates getCoordinates(){return coordinates;}
    public int getAge(){return age;}
    public Color getColor(){return color;}
    public DragonType getType(){return type;}
    public DragonCharacter getCharacter(){return character;}
    public DragonHead getHead(){return head;}
    public java.util.Date getCreationDate(){
        return creationDate;
    }

    @Override
    public String toString() {
        return "Dragon{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", coordinates=" + coordinates +
                ", creationDate=" + creationDate +
                ", age=" + age +
                ", color=" + color +
                ", type=" + type +
                ", character=" + character +
                ", head=" + head +
                '}';
    }

    public boolean setId(long id){
        if(id>0){
            this.id=id;
            return true;
        }else{
            return false;
        }
    }

    public boolean setName(String name) {
        if(name!=null){
            this.name = name;
            return true;
        }else{
            return false;
        }

    }

    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    public boolean setAge(int age){
        if(age>0){
            this.age=age;
            return true;
        }else{
            return false;
        }
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public void setType(DragonType type) {
        this.type = type;
    }

    public void setCharacter(DragonCharacter character) {
        this.character = character;
    }

    public void setHead(DragonHead head) {
        this.head = head;
    }
    public void setCreationDate(java.util.Date creationDate){
        this.creationDate=creationDate;
    }
}
