/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bo;

import Entity.SalaryStatus;
import Entity.Worker;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ADMIN
 */
public class ManageWorker {

    private ArrayList<Worker> ls;

    public ManageWorker() {
        ls = new ArrayList<>();
    }

    private Worker findWorker(String id) {
        for (Worker worker : ls) {
            if (worker.getId().equalsIgnoreCase(id.trim())) {
                return worker;
            }
        }
        return null;
    }

    public boolean addWorker(Worker worker) throws Exception {
        if (findWorker(worker.getId())!= null) {
            throw new Exception("Worker is existed ");
        }
        return ls.add(worker);
    }

    public Worker changeSalary(SalaryStatus status, String code, double amount) throws Exception {
        if (ls.isEmpty()) {
            throw new Exception("List empty");
        }
        Worker worker = findWorker(code);
        if (worker == null) {
            throw new Exception("code can not found");
        }
        if (amount <= 0) {
            throw new Exception("Amount of money must be > 0");
        }
        switch (status) {
            case UP:
                worker.setSalary(worker.getSalary() + amount);
                break;
            case DOWN:
                if (worker.getSalary() < amount) {
                    throw new Exception("Can not down " + amount);
                }
                worker.setSalary(worker.getSalary() - amount);
                break;
        }
        return worker;
    }

    public void saveFile(String file) throws Exception {
        if (ls.isEmpty()) {
            throw new Exception("This list worker is empty!");
        }

        try (FileOutputStream fos = new FileOutputStream(file); ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            for (Worker l : ls) {
                
            oos.writeObject(l);
            }
    
        } catch (IOException ex) {
            ex.printStackTrace();
            throw new Exception("Error to save " + file, ex); // Giữ lại exception gốc
        }
    }

    public void readFile(String file) throws Exception {
        try {
            FileInputStream fis = new FileInputStream(file);
            ObjectInputStream ois = new ObjectInputStream(fis);
        Worker work = (Worker) ois.readObject();
        ls.add(work);
        }catch(EOFException e){//Không có dữ liệu để đọc
        }
        catch (IOException | ClassNotFoundException e) {
            throw new Exception("File " + file + " is empty!");
        }
    }

    @Override
    public String toString() {
        String str = String.format("%7s%10s%10s%10s%10s%15s\n", "Code", "Name", "Age", "Salary", "Status", "Date");
        for (Worker l : ls) {
            
            str += l.toString()+"\n";
        }
 
        
        return str;
    }
    
}
