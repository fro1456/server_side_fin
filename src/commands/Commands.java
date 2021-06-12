package commands;
/**
 * класс хранит в себ комманды
 */

import java.util.ArrayList;

public class Commands {
    int count = 0;
    private ArrayList<String> commandList = new ArrayList<>();
    {
        commandList.add("help : вывести справку по доступным командам");
        commandList.add("info : вывести в стандартный поток вывода информацию о коллекции (тип, дата инициализации, количество элементов и т.д.)");
        commandList.add("show : вывести в стандартный поток вывода все элементы коллекции в строковом представлении");
        commandList.add("insert null {element} : добавить новый элемент с заданным ключом");
        commandList.add("update id {element} : обновить значение элемента коллекции, id которого равен заданному");
        commandList.add("remove_key null : удалить элемент из коллекции по его ключу");
        commandList.add("clear : очистить коллекцию");
        commandList.add("save : сохранить коллекцию в файл");
        commandList.add("execute_script file_name : считать и исполнить скрипт из указанного файла. В скрипте содержатся команды в таком же виде, в котором их вводит пользователь в интерактивном режиме.");
        commandList.add("exit : завершить программу (без сохранения в файл)");
        commandList.add("remove_lower {element} : удалить из коллекции все элементы, меньшие, чем заданный");
        commandList.add("history : вывести последние 12 команд (без их аргументов)");
        commandList.add("replace_if_greater null {element} : заменить значение по ключу, если новое значение больше старого");
        commandList.add("average_of_age : вывести среднее значение поля age для всех элементов коллекции");
        commandList.add("count_less_than_age age : вывести количество элементов, значение поля age которых меньше заданного");
        commandList.add("filter_less_than_age age : вывести элементы, значение поля age которых меньше заданного");

    }
    //public void history(){
    //    count = count+1;


    //}
}
