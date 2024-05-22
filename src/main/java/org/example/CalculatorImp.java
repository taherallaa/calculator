package org.example;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class CalculatorImp extends UnicastRemoteObject implements Calculator {
    CalculatorImp() throws RemoteException {
        super();
    }

    @Override
    public int add(int x, int y) throws RemoteException {
        return x + y;
    }

    @Override
    public int sub(int x, int y) throws RemoteException {
        return x - y;
    }

    @Override
    public float divide(float x, float y) throws RemoteException {
        if (y != 0)
            return (float) x /y;
        return -1;
    }

    @Override
    public int multiply(int x, int y) throws RemoteException {
        return x * y;
    }
}
