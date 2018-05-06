/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package relogioservidor;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author Hamilton
 */
public interface IRelogioServidor extends Remote{
    public int getTempo() throws RemoteException;
    public void setTempo(int tempo) throws RemoteException;
    public void setDiferenca(int diferenca) throws RemoteException;
    public int getDiferenca() throws RemoteException;
    public void aleatorio() throws RemoteException;
}
