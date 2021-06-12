package сlasses;

import java.io.Serializable;
import java.util.Arrays;

public class RequestedClass implements Serializable {
    private String commandName;
    private Long argument;
    private String[] command;
    private Dragon dragon;

    public Long getArgument() {
        return argument;
    }

    public String getCommandName() {
        return commandName;
    }

    public String[] getCommand() {
        return command;
    }

    public RequestedClass(String[] command){
        this.command = command;
    }
    public RequestedClass(String commandName){
        this.commandName = commandName;
    }

    public RequestedClass(String commandName,Long argument) {
        this.commandName = commandName;
        this.argument = argument;
    }
    public RequestedClass() {
    }
    public RequestedClass(String command,Long argument, Dragon dragon) {
        this.commandName =command;
        this.argument = argument;
        this.dragon=dragon;
    }
    @Override
    public String toString() {
        return "RequestedClass{" +
                "commandName='" + commandName + '\'' +
                ", argument=" + argument +
                ", command=" + Arrays.toString(command) +
                ", dragon=" + dragon +
                '}';
    }

    public void setCommand(String[] command) {
        this.command = command;
    }

    public void setArgument(Long argument) {
        this.argument = argument;
    }

    public void setCommandName(String commandName) {
        this.commandName = commandName;
    }

    public void setDragon(Dragon dragon) {
        this.dragon = dragon;
    }

    public Dragon getDragon() {
        return dragon;
    }
}
