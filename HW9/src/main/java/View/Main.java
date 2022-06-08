package View;

import Controller.CSVReader;
import Controller.CommandLineParser;
import Controller.EmptyCSVException;
import Controller.ToDoApplicationHandler;
import Controller.ICSVReader;
import Controller.InvalidArgumentsException;
import Controller.UpdateCSV;
import Model.ToDoList;

public class Main {

  public static void main(String[] args) throws InvalidArgumentsException, EmptyCSVException {
    CommandLineParser parser = new CommandLineParser(args);

    String csvFile = parser.getParameters().get(Controller.Commands.CSV_FILE);
    ICSVReader csvProcessor = new CSVReader();
    ToDoList toDoList = csvProcessor.readCSV(csvFile);
    ToDoApplicationHandler f = new ToDoApplicationHandler(parser, toDoList);

    f.makeAction();

    UpdateCSV updateCSV = new UpdateCSV();
    updateCSV.update(csvFile,toDoList);
  }
}
