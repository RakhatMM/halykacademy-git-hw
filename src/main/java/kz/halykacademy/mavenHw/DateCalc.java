package kz.halykacademy.mavenHw;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;
import java.util.Scanner;

public class DateCalc {
    public static void main(String[] args) {
        System.out.println("Please enter the date:");
        Scanner dateScanner = new Scanner(System.in);
        String strDate = dateScanner.next();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate date;
        try {
            date = LocalDate.parse(strDate, formatter);
        } catch (DateTimeException e) {
            System.out.println("Your input cannot be converted to the date or it has wrong date format.\nPlease restart and try again.");
            return;
        }

        LocalDate after30days = date.plusDays(30);
        System.out.println("\nThe date after 30 days:\n" + after30days);

        LocalDate lastSundayInMonth = date.with(TemporalAdjusters.lastInMonth(DayOfWeek.SUNDAY));
        System.out.println("Last sunday in this month:\n" + lastSundayInMonth);

        LocalDate newYear = LocalDate.of(date.getYear(), Month.DECEMBER, 31);
        System.out.println("The amount of days between this date and the 31st of December in this year:\n"
                + ChronoUnit.DAYS.between(date, newYear) + " days");

        System.out.println("\nThanks.");

    }
}
