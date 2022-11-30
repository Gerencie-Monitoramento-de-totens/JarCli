/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package aplication;

import banco.Consultas;
import banco.CriacaoBanco;
import com.github.britooo.looca.api.core.Looca;
import com.github.britooo.looca.api.group.processador.Processador;
import com.github.britooo.looca.api.util.Conversor;
import java.io.IOException;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;
import looca.LoocaInital;

/**
 *
 * @author Rossi
 */
public class App {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Consultas consulta = new Consultas();
        CriacaoBanco banc = new CriacaoBanco();
        LoocaInital lc = new LoocaInital();
        Inovacao innovation = new Inovacao();
        Looca looca = new Looca();
        Processador processador = looca.getProcessador();
        String idTotemVar;

        idTotemVar = processador.getId();
        boolean isLogado = false;

        do {
            System.out.println("id do Totem: " + idTotemVar);

            System.out.print("Digite o User:");
            String user = sc.nextLine();

            System.out.print("Digite a senha:");
            String senha = sc.nextLine();

            isLogado = consulta.logarTotem(user, senha, idTotemVar);

        } while (!isLogado);
        banc.criarBanco();

        lc.pegarDados();
        new Timer().scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                
                try {
                    lc.loopPegarDados();
                } catch (IOException ex) {
                    Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
                } catch (InterruptedException ex) {
                    Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                System.out.println();

//                System.out.println("Uso Processador: " + Conversor.formatarBytes(lc.getUsoProcessador().longValue()));
//                System.out.println("Uso Ram: " + Conversor.formatarBytes(lc.getEmUsoRAM()));
//                System.out.println("Ram total: " + Conversor.formatarBytes(lc.getMemoriaRAMTotal()));
//                System.out.println("DisponivelRam: " + Conversor.formatarBytes(lc.getDisponivelRAM()));
//                System.out.println("Temperatura: " + Double.toString(lc.getTemperatura()));

                innovation.desligar(lc.getIdTotem(), lc.getSistemaOperacional());
            }

        }, 0, 1000);
    }
}
