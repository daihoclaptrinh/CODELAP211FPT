/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author ADMIN
 */
public class Input {

    public int getInt(String messInfo, String messOutOfRange,
            String messInvalidNumber, int min, int max) {
        Scanner SC = new Scanner(System.in);
        do {
            System.out.print(messInfo);
            try {
                int n = Integer.parseInt(SC.nextLine());
                if (n >= min && n <= max) {
                    return n;
                }

                System.out.println(messOutOfRange + " " + min + "-" + max);

            } catch (Exception e) {

                System.out.println("Please enter again an integer number!!!");

            }
        } while (true);
    }

    public double getDouble(String messageInfo, String messsageErrorOutOfRange,
            String messageErrorNumber, double min, double max) {
        Scanner SCANNER = new Scanner(System.in);
        do {
            try {
                System.out.print(messageInfo);
                double number = Double.parseDouble(SCANNER.nextLine());
                if (number >= min && number <= max) {
                    return number;
                } else {
                    System.out.println(messsageErrorOutOfRange);
                }
            } catch (NumberFormatException e) {
                System.out.println(messageErrorNumber);
            }
        } while (true);
    }

    public String getString(String messageInfo, String messageError, final String REGEX) {
        Scanner SCANNER = new Scanner(System.in);
        do {
            System.out.print(messageInfo);
            String str = SCANNER.nextLine().trim();
            if (str.matches(REGEX)) {
                return str;
            }
            System.out.println(messageError);
        } while (true);
    }
    public Date getDate(String messageInfo, String messageErrorDate, final String REGEX) {
        Scanner SCANNER = new Scanner(System.in);
        SimpleDateFormat dateFormat = new SimpleDateFormat(REGEX);
        dateFormat.setLenient(false);
        do{
            System.out.println(messageInfo);
            try {
                Date date = dateFormat.parse(SCANNER.nextLine().trim());
                return date;
            } catch (ParseException ex) {
                System.out.println("Error date");
            }
        } while (true);
    }

//    public double getDouble(String mess, double min, double max) {
//        Scanner SC = new Scanner(System.in);
//
//        String s1;
//        double n;
//        do {
//            s1 = SC.nextLine().trim();
//            if (s1.matches("\"^(-?)(0|([1-9][0-9]*))(\\\\.[0-9]+)?$\"")) {
//                n = Double.parseDouble(s1);
//                if (n >= min && n <= max) {
//                    break;
//                } else {
//                    System.out.println("Please enter number " + min + "-" + max);
//                }
//            } else {
//                System.out.println("Invalid number!!!");
//            }
//        } while (true);
//        return n;
//    }
//
//    public String getString(String messageInfo, String messageError, final String Regex) {
//        Scanner SC = new Scanner(System.in);
//
//        do {
//            System.out.println(messageInfo);
//            String str = SC.nextLine();
//            if (str.matches(Regex)) {
//                return str;
//            }
//            System.out.println(messageError);
//        } while (true);
//        // ex . SExxxxxx --> regex:"SE\\d{6}" giải thích\\d đại diện cho số {6} là 6 số duy nhất
//    }
}
