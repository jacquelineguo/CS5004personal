package Controller;

import Model.Row;
import Model.Seat;
import Model.Theater;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Interaction class which represents the interaction between customer input from terminal and the
 * backend theater reservation service.
 */
public class Interaction {
  private Theater theater;
  private static final String SHOW = "show";
  private static final String DONE = "done";
  private static final String YES = "yes";

  /**
   * Constructor for Interaction class.
   * @param theater - a theater for customer to reservation tickets.
   */
  public Interaction(Theater theater) {
    this.theater = theater;
  }

  /**
   * Ask customers' action which can be as following:
   * 'show': show the theater's seat situation.
   * 'reserve x': x is the number of seats the customer what to reserve.
   * 'done': end the system.
   * Then according to customer's instruction make action.
   */
  public void makeAction() {
    Boolean finished = false;
    Scanner scanner = new Scanner(System.in);
    while (!finished) {
      System.out.println("What would like to do?");
      String input = scanner.nextLine();
      switch (input) {
        case SHOW:
          DisplayTheater.displayTheater(this.theater);
          break;
        case DONE:
          finished = true;
          break;
        default:
          Pattern p = Pattern.compile("\\d+");
          Matcher matcher = p.matcher(input);
          if (!matcher.find()) { // no number in user input
            System.out.println("Please contain the number of seats you want to reserve.");
          } else {
            Integer reserveNum = Integer.parseInt(matcher.group());
            System.out.println("What is your name?");
            String name = scanner.nextLine();
            System.out.println("Do you need wheelchair accessible seats?");
            String wheelchairAccess = scanner.nextLine();
            Boolean needWheelChair;
            if (wheelchairAccess.equalsIgnoreCase(YES)){
              needWheelChair = true;
            }else{
              needWheelChair = false;
            }

            boolean result = ReservationsService.reserveSeats(
                theater, reserveNum, name, needWheelChair);

            if (result) {
              System.out.println(
                  "I've reserved " + reserveNum + " seats for you at the " +
                      theater.getTheaterName() + " in row, " + this.findRow(name) + ", " +
                      name + ".");
            }else {
              System.out.println(
                  "Sorry, we do not have that many seats for you at " + theater.getTheaterName() +
                      ", " + name + ".");
            }
            break;
          }
      }
    }
    System.out.println("Have a nice day!");
    scanner.close();
  }

  /**
   * Help method which helps get the row number the customer reserved.
   * @param name - customer name.
   * @return the row number the customer reserved.
   */
  private Integer findRow(String name) {
    Integer result = 0;
    for (Row row: this.theater.getRowList()) {
      if (row.get(0) == null)
        continue;
      else {
        for (Seat seat: row) {
          if (seat.getCustomerName() != null && seat.getCustomerName() == name)
            return row.getRowNum();
          continue;
        }
      }
    }
    return result;
  }

}
