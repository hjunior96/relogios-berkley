/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package relogioservidor;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 *
 * @author Hamilton
 */
public class RelogioServidor {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try{
            //ativa o servidor e avisa quando estiver esperando por solicitações
            IRelogioServidor iRelogio = new IRelogioServidorImpl();
            IRelogioServidor iRelogioEscravo = new IRelogioServidorImpl();
            IRelogioServidor iRelogioEscravo2 = new IRelogioServidorImpl();
            IRelogioServidor iRelogioEscravo3 = new IRelogioServidorImpl();
            Registry reg = LocateRegistry.createRegistry(9999);
           // Registry reg2 = LocateRegistry.createRegistry(8080);
            reg.rebind("IRelogioServidorImpl", iRelogio);
            reg.rebind("IRelogioServidorImpl2", iRelogioEscravo);
            reg.rebind("IRelogioServidorImpl3", iRelogioEscravo2);
            reg.rebind("IRelogioServidorImpl4", iRelogioEscravo3);
            System.out.println("Servidor Relogio: " + iRelogio + "pronto.");
            
        }catch(Exception ex){
            System.out.println("Erro: " + ex.getMessage());
        }
    }
}
