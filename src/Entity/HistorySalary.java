/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author ADMIN
 */
public class HistorySalary implements Comparable<HistorySalary>,Serializable{
    private SalaryStatus salaryStatus;
    private Worker worker;
    private double salaryUpdate ;
    private Date date;

    public HistorySalary() {
    }

    public HistorySalary(SalaryStatus salaryStatus, Worker worker, double salaryUpdate, Date date) {
        this.salaryStatus = salaryStatus;
        this.worker = worker;
        this.salaryUpdate = salaryUpdate;
        this.date = date;
    }

    public SalaryStatus getSalaryStatus() {
        return salaryStatus;
    }

    public void setSalaryStatus(SalaryStatus salaryStatus) {
        this.salaryStatus = salaryStatus;
    }

    public Worker getWorker() {
        return worker;
    }

    public void setWorker(Worker worker) {
        this.worker = worker;
    }

    public double getSalaryUpdate() {
        return salaryUpdate;
    }

    public void setSalaryUpdate(double salaryUpdate) {
        this.salaryUpdate = salaryUpdate;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    
    @Override
    public String toString() {
        SimpleDateFormat SimpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        return String.format("%7s%10s%10d%10.0f%10s%15s",
                worker.getId(),worker.getName(),worker.getAge(),
                this.salaryUpdate,getSalaryStatus(),SimpleDateFormat.format(this.date));
    }

    @Override
    public int compareTo(HistorySalary o) {
        return worker.getId().compareTo(o.getWorker().getId());
    }
    
}
