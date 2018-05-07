/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package relogiocliente;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import relogioservidor.IRelogioServidor;

/**
 *
 * @author Hamilton
 */
public class RelogioCliente {

    public static void main(String[] args) throws RemoteException {
        //Limite que pode ser aceito de diferença entre os relógios
        int limiteDiferenca = 10;

        while (true) {
            
            int total = 0;
            int media = 0;

            //Lista de Servidores
            List<IRelogioServidor> servidores = new ArrayList<IRelogioServidor>();

            try {
                
                Registry registry = LocateRegistry.getRegistry(9999);
                IRelogioServidor c = (IRelogioServidor) registry.lookup("IRelogioServidorImpl");
                System.out.println("Servidor encontrado com sucesso: " + c);
                System.out.println("Hora do servidor coordenador: " + c.getTempo()/60 + ":" + ((c.getTempo()%60) + Integer.parseInt("00")));
                servidores.add(c);

                
                //Colocar outro servidor para testar
                registry = LocateRegistry.getRegistry(9999);
                IRelogioServidor  e1 = (IRelogioServidor) registry.lookup("IRelogioServidorImpl2");
                e1.aleatorio();
                servidores.add(e1);
                System.out.println("Hora do nó escravo 1: " + e1.getTempo()/60 + ":" + e1.getTempo()%60);
                
                registry = LocateRegistry.getRegistry(9999);
                IRelogioServidor  e2 = (IRelogioServidor) registry.lookup("IRelogioServidorImpl3");
                e2.aleatorio();
                servidores.add(e2);
                System.out.println("Hora do nó escravo 2: " + e2.getTempo()/60 + ":" + e2.getTempo()%60);
                
                registry = LocateRegistry.getRegistry(9999);
                IRelogioServidor  e3 = (IRelogioServidor) registry.lookup("IRelogioServidorImpl4");
                e3.aleatorio();
                servidores.add(e3);
                System.out.println("Hora do nó escravo 3: " + e3.getTempo()/60 + ":" + e3.getTempo()%60);
            } catch (Exception ex) {
                System.out.println("Erro: " + ex.getMessage());
            }
            
            //número de relógios com diferença maior que o limite
            int relogiosForaDaCurva= 0;
            
            //Percorre os servidores para calcular a diferença de horário entre eles
            for (IRelogioServidor servidor : servidores) {
                servidor.setDiferenca(servidor.getTempo() - servidores.get(0).getTempo());
                if(servidor.getDiferenca() >= limiteDiferenca)
                    //se for acima do limite, adiciona 1 no contador de relógios que passam do limite
                    relogiosForaDaCurva++;
                else
                    //se não, adiciona a diferença no total para ser calculada a média
                    total += servidor.getDiferenca();
            }
            
            //Calcula a média usando o total e desconsiderando os relógios com diferenca maior que a permitida
            media = total / (servidores.size()-relogiosForaDaCurva);
            
            //ajusta os relógios usando a média e a diferença do servidor e coordenador
            for (IRelogioServidor servidor : servidores) {
                servidor.setTempo(media + (-1 * servidor.getDiferenca()));
            }

            //Mostra no console o horário ajustado dos relógios
            int i=0;
            for (IRelogioServidor servidor : servidores) {
                
                int parteInteira = servidor.getTempo() / 60;
                int resto = servidor.getTempo() % 60;

                System.out.println("Horario ajustado do servidor "+ i++ + ": " + parteInteira + ":" + resto);
            }
            //Randomiza os horários novamente para próxima execução
            for (IRelogioServidor servidor : servidores) {
                servidor.aleatorio();
            }
            
            try {
                //Executa a cada 10 minutos
                Thread.sleep(10*60*1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(RelogioCliente.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
