package com.calendar;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Calendar {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    System.out.print("Podaj numer dnia(1-31): ");
    int dayOfMonth = 0;
    try {
      dayOfMonth = scanner.nextInt();
      if (dayOfMonth < 1 | dayOfMonth > 31) {
        System.out.println("Podałeś nieprawidłowe dane");
        System.exit(0);
      }
    } catch (InputMismatchException e) {
      System.out.println("Wrong format! " + e);
    }

    System.out.print("Podaj numer miesiąca(1-12): ");
    int numberOfMonth = 0;
    try {
      numberOfMonth = scanner.nextInt();
      if (numberOfMonth < 1 | numberOfMonth > 12) {
        System.out.println("Podałeś nieprawidłowe dane");
        System.exit(0);
      }
    } catch (InputMismatchException e) {
      System.out.println("Wrong format! " + e);
    }

    scanner.close();
    countDayOfMonth(dayOfMonth, numberOfMonth);
  }

  private static void countDayOfMonth(int dayNumber, int monthNumber) {
    // Handling month
    String[] monthOfTheYear =
        new String[] {
          "styczeń",
          "luty",
          "marzec",
          "kwiecień",
          "maj",
          "czerwiec",
          "lipiec",
          "sierpień",
          "wrzesień",
                "październik",
                "listopad",
                "grudzień"
        };

    int monthNumberInArray = monthNumber - 1;
    String monthName = monthOfTheYear[monthNumberInArray];
    System.out.println("Miesiąc to: " + monthName);

    // Handling day of week
    String dayOfWeek = switch (dayNumber) {
      case 1, 8, 15, 22, 29 -> "poniedziałek";
      case 2, 9, 16, 23, 30 -> "wtorek";
      case 3, 10, 17, 24, 31 -> "środa";
      case 4, 11, 18, 25 -> "czwartek";
      case 5, 12, 19, 26 -> "piątek";
      case 6, 13, 20, 27 -> "sobota";
      case 7, 14, 21, 28 -> "niedziela";
      default -> "Unknown";
    };

    if ((monthNumber == 4 || monthNumber == 6 || monthNumber == 9 || monthNumber == 11)
            & dayNumber > 30) {
      System.out.println(
              "Miesiąc " + monthName + " ma tylko 30 dni w miesiącu. Podano za dużo dni!");
    } else if (monthNumber == 2 & dayNumber > 28) {
      System.out.println(
              "Miesiąc " + monthName + " ma tylko 28 dni w miesiącu. Podano za dużo dni!");
    } else {
      System.out.println("monthNumber: " + monthNumber + ", dayNumber: " + dayNumber);
      System.out.println(
          "W miesiącu " + monthName + " dzień " + dayNumber + " to był " + dayOfWeek);
    }
  }
}
