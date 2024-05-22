package org.example;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

public class Server {
    public static void main(String[] args) {
        try{
            String bindName = "calculator";
            Calculator stub = new CalculatorImp();
            LocateRegistry.createRegistry(1099);
            Naming.rebind(bindName, stub);
        }catch(Exception e) {
            System.out.println(e.getMessage());
        }


    }
}
