/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bo;

import Entity.HistorySalary;
import Entity.Worker;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author ADMIN
 */
public class ManagerSalaryHistory {

    private List<HistorySalary> list;

    public ManagerSalaryHistory() {
        list = new ArrayList<>();
    }

    public List<HistorySalary> getLs() {
        return list;
    }

    public void setLs(List<HistorySalary> ls) {
        this.list = ls;
    }

    public boolean addSalaryHistory(HistorySalary historySalary) {
        return list.add(historySalary);
    }

    private void sortById() {
        Collections.sort(list);
    }

    @Override
    public String toString() {
        if (list.isEmpty()) {
            return null;
        }
        sortById();
        String str = String.format("%7s%10s%10s%10s%10s%15s\n", "Code", "Name", "Age", "Salary", "Status", "Date");
        for (HistorySalary l : list) {
            str += l.toString()+"\n";
        }
        return str;
    }

    public void saveFile(String file) throws Exception {
        if (list.isEmpty()) {
            throw new Exception("This list history is empty!");
        }
        try {
            FileOutputStream fos = new FileOutputStream(file);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            for (HistorySalary historySalary : list) {
                oos.writeObject(historySalary);

            }
        } catch (IOException ex) {
            ex.printStackTrace();
            throw new Exception("Error to save " + file, ex); // Giữ lại exception gốc
        }

    }

    public void readFile(String file) throws Exception {
        try {
            FileInputStream fos = new FileInputStream(file);
            ObjectInputStream oos = new ObjectInputStream(fos);
            while (true) {
                try {
                    HistorySalary history = (HistorySalary) oos.readObject();
                    list.add(history);
                } catch (Exception e) {
                    break;
                }
            }
        } catch (Exception e) {
            throw new Exception("File " + file + " is empty!");
        }
    }
}
