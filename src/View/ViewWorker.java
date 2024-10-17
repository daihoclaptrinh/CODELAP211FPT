/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;

/**
 *
 * @author ADMIN
 */
public class ViewWorker {

    public void printMenu() {
        System.out.println("======== Worker Management ========");
        System.out.println("1. Add a Worker\n"
                + "2. Increase salary for worker\n"
                + "3. Decrease for worker\n"
                + "4. Show adjusted salary worker information\n"
                + "5. Exit");
    }
    
    public void displayMess(String mess){
        System.out.println(mess);
    }
}
