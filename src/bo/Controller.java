/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bo;

import Entity.HistorySalary;
import Entity.SalaryStatus;
import Entity.Worker;
import View.Input;
import View.ViewWorker;
import bo.ManageWorker;

import bo.ManagerSalaryHistory;
import java.io.File;
import java.util.Date;

/**
 *
 * @author ADMIN
 */
public class Controller {
    ManagerSalaryHistory historySalary = new ManagerSalaryHistory();
    ManageWorker workers = new ManageWorker();
    Input inp = new Input();
    View.ViewWorker view = new ViewWorker();


    public Worker addWorker() throws Exception {
        String id = inp.getString("Enter Id: ","Please format (W|w) [\\d]+ ex: w 3","^(W|w) [\\d]+$");
        String name = inp.getString("Enter Name: ","Please ","^[a-z\\sA-z]+$");
        int age = inp.getInt("Enter age: ","Please age","Invalid", 18, 50);
        double salary = inp.getDouble("Enter salary: ","Salary must be >0","Invalid",Double.MIN_VALUE,Double.MAX_VALUE);
        String workLocation = inp.getString("Enter work-location: ","Please ","[a-zA-Z-\\s\\d]+");
        
        if (workers.addWorker(new Worker(id, name, age, salary, workLocation))) {
            return new Worker(id, name, age, salary, workLocation);
        }
        throw new Exception("Can not add worker!");
    }

    public HistorySalary upSalary() throws Exception {
        String code = inp.getString("Enter id: ", "Invalid!", "[Ww] \\d+").toUpperCase();
        double amount = inp.getDouble("Enter Salary: ",
                "Amount must be > 0","invalid",Double.MIN_VALUE, Double.MAX_VALUE);
        Worker worker = workers.changeSalary(SalaryStatus.UP, code, amount);
        HistorySalary history = new HistorySalary(SalaryStatus.UP,worker, worker.getSalary(),  new Date());
        if (historySalary.addSalaryHistory(history)) {
            return history;
        }
        throw new Exception("Can not up salary!");
    }

    public HistorySalary downSalary() throws Exception {
        String code = inp.getString("Enter id: ", "Invalid!", "[Ww]\\d+").toUpperCase();
        double amount = inp.getDouble("Enter Salary: ",
                "Must be >0","Invalid",
                Double.MIN_VALUE, Double.MAX_VALUE);
        Worker worker = workers.changeSalary(SalaryStatus.DOWN, code, amount);
        HistorySalary history = new HistorySalary(SalaryStatus.DOWN,worker, worker.getSalary(),  new Date());
        if (historySalary.addSalaryHistory(history)) {
            return history;
        }
        throw new Exception("Can not down salary!");
    }

    public void showHistory() throws Exception {
        String result = historySalary.toString();
        if (result == null) {
            throw new Exception("History Salary is empty!!");
        } else {
            System.out.println(result);
        }
    }

    public void saveWorkersToFile() {
        try {
            workers.saveFile("worker.dat");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void saveHistoryToFile() {
        try {
            
            historySalary.saveFile("history.dat");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void readFile() {
        try {
            workers.readFile("worker.dat");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        try {
            historySalary.readFile("history.dat");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    public void showW(){
         view.displayMess(workers.toString());
    }
}
