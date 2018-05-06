/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package relogioservidor;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 *
 * @author Hamilton
 */
public class IRelogioServidorImpl extends UnicastRemoteObject implements IRelogioServidor{
    
   //Hora do sistema
   private int horas;
   //Diferenca entre a hora do servidor com a do coordenador
   private int diferenca;
   
   public IRelogioServidorImpl() throws RemoteException {
       //Necessário randomizar para impedir que os relógios já iniciem ajustados.
       int i = (int) (Math.random() * 23);
       int j = (int) (Math.random() * 59);
       
       this.horas = (i*60) + j;
   }
   
   @Override
   public int getTempo() throws RemoteException {
       return this.horas;
   }

    @Override
    public void setTempo(int tempo) throws RemoteException {
        this.horas += tempo;
    }

    @Override
    public void setDiferenca(int diferenca) throws RemoteException {
        this.diferenca = diferenca;
    }

    @Override
    public int getDiferenca() throws RemoteException {
        return this.diferenca;
    }

    @Override
    public void aleatorio() throws RemoteException {
       int i = (int) (Math.random() * 23);
       int j = (int) (Math.random() * 59);
       
       this.horas = (i*60) + j;
    }
}
