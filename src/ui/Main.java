/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ui;

import bo.Controller;
import Entity.HistorySalary;
import Entity.Worker;
import View.Input;
import View.ViewWorker;

/**
 *
 * @author ADMIN
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Controller control = new Controller();
        Input inp = new Input();
        ViewWorker view = new ViewWorker();
        
        control.readFile();
        do {
            view.printMenu();
            int choice = inp.getInt("Enter your choice: ","Please choice from",
                    "Invalid",
                     1, 5);
            switch (choice) {
                case 1:
                    try {
                        Worker worker = control.addWorker();
                        view.displayMess("Add success: " + worker.toString());
                    } catch (Exception ex) {
                        view.displayMess(ex.getMessage());
                    }
                    control.saveWorkersToFile();
                    
                    break;
                case 2:
                    try {
                        HistorySalary history = control.upSalary();
                        view.displayMess("Up success: \n" + history.toString());
                    } catch (Exception ex) {
                        view.displayMess(ex.getMessage());
                    }
                    control.saveHistoryToFile();
                    control.saveWorkersToFile();
                    break;
                case 3:
                    try {
                        HistorySalary history = control.downSalary();
                        view.displayMess("Add success: \n" + history.toString());
                    } catch (Exception ex) {
                        view.displayMess(ex.getMessage());
                    }
                    control.saveHistoryToFile();
                    control.saveWorkersToFile();
                    break;
                case 4:
                    try {
                        control.showHistory();
                    } catch (Exception ex) {
                        view.displayMess(ex.getMessage());
                    }
                    break;
                case 5:
control.showW();break;
//                    System.exit(0);
            }
        } while (true);
    }
    
}
