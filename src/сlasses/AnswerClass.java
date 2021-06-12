package сlasses;

import java.io.Serializable;

public class AnswerClass implements Serializable {
    private String message;

    public AnswerClass(String command) {
        this.message = command;
    }
    public AnswerClass(){

    }

    public void setMessage(String message){
        this.message=message;
    }
    public String getMessage(){
        return message;
    }
}
