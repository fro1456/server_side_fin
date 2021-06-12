package сlasses;

import java.io.Serializable;

public class DragonHead implements Serializable {
    private Float size;
    private Float eyesCount;
    private Double toothCount;

    public DragonHead(float size,float eyesCount, double toothCount){
        this.size=size;
        this.eyesCount=eyesCount;
        this.toothCount=toothCount;
    }
    public float getSize(){
        return size;
    }
    public float getEyesCount(){
        return eyesCount;
    }
    public double getToothCount(){
        return toothCount;
    }

    public void setEyesCount(Float eyesCount) {
        this.eyesCount = eyesCount;
    }

    public void setSize(Float size) {
        this.size = size;
    }

    public void setToothCount(Double toothCount) {
        this.toothCount = toothCount;
    }

    @Override
    public String toString() {
        return "DragonHead{" +
                "size=" + size +
                ", eyesCount=" + eyesCount +
                ", toothCount=" + toothCount +
                '}';
    }

    public DragonHead(){}

}
