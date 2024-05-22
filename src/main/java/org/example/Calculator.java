package org.example;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Calculator extends Remote {
    public int add(int x, int y) throws RemoteException;
    public int sub(int x, int y) throws RemoteException;
    public float divide(float x, float y) throws  RemoteException;
    public int multiply(int x, int y) throws RemoteException;

}
