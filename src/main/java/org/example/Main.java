package org.example;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.util.Scanner;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;


public class Main {

    private static final Scanner scanner = new Scanner(System.in);

    private static Calculator getStub() throws MalformedURLException {
        Calculator result;
        String bindName = "calculator";
        try {
            result = (Calculator) Naming.lookup(bindName);
        } catch (NotBoundException | RemoteException e) {
            throw new RuntimeException(e);
        }
        return result;
    }

    public static void main(String[] args) throws RemoteException {

        try {
            Calculator stub = getStub();
            char letter;

            do {
                System.out.println("\nWelcome to you in simple Calculation application");

                System.out.println("\nEnter First Number: ");
                float number1 = scanner.nextFloat();

                System.out.println("\nEnter second Number: ");
                float number2 = scanner.nextFloat();

                System.out.println("\n-----------------\nChoose which operation to perform on numbers (/, +, -, *): ");
                char operation = scanner.next().charAt(0);

                switch (operation) {
                    case '/':
                        float result_divide = stub.divide(number1, number2);

                        if(result_divide != -1){
                            System.out.println("The Result of divide is " + result_divide);
                        }else{
                            System.out.println("Can't divide on zero");
                        }
                        break;
                    case '*':
                        int result_multiply = stub.multiply((int)number1, (int)number2);
                        System.out.println("The Result of multiplication is " + result_multiply);
                        break;
                    case '+':
                        int result_add = stub.add((int)number1, (int)number2);
                        System.out.println("The Result of addition is " + result_add);
                        break;
                    case '-':
                        int result_sub = stub.sub((int)number1, (int)number2);
                        System.out.println("The Result of Subtraction is " + result_sub);
                        break;
                    default:
                        System.out.println("Invalid operation, must be (/, +, -, *):");
                }
                System.out.println("Do you want to perform any operation? (Y,N)");
                letter = scanner.next().charAt(0);
            } while (letter == 'Y' || letter == 'y');
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }
}