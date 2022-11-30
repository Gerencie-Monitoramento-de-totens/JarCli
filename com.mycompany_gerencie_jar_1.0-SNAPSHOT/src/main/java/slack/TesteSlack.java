package slack;

import banco.Consultas;
import banco.Insercao;
import com.github.britooo.looca.api.util.Conversor;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.json.JSONObject;


/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author jvsdi
 */
public class TesteSlack {

    Timer timer = new Timer();
    JSONObject json = new JSONObject();
    Insercao dados = new Insercao();
    Log logs = new Log();
    Consultas consulta = new Consultas();

    public void mensagemSlack(Double usoCPU, Long emUsoRAM, Long disponivelRAM, String fkTotem) throws IOException, InterruptedException {
        Map<String, Object> limites = consulta.limitesTotem(fkTotem);

        Double limiteP = new Double(limites.get("limiteProcessador").toString());

        Double limiteR = new Double(limites.get("limiteRam").toString());
        LocalDateTime ultimoAlerta = LocalDateTime.now();
        LocalDateTime proximoAlerta = ultimoAlerta.plusMinutes(2);

        int delay = 5000;   // tempo de espera antes da 1ª execução da tarefa.
        int interval = 10000;  // intervalo no qual a tarefa será executada.
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            public void run() {

                if (usoCPU > limiteP) {

                    json.put("text", "Seu uso de CPU ultrapassou o limite!");

                    try {
                        Slack.sendMessage(json);
                    } catch (IOException ex) {
                        Logger.getLogger(TesteSlack.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(TesteSlack.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    logs.logCPU(logs.getLista());
                    //  dados.novoAlerta(fkTotem);
                    //  ultimoAlerta = LocalDateTime.now();
                }
                if (emUsoRAM > limiteR) {

                    json.put("text", "Seu uso de RAM ultrapassou o limite!");

                    try {
                        Slack.sendMessage(json);
                    } catch (IOException ex) {
                        Logger.getLogger(TesteSlack.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(TesteSlack.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    logs.logRAM(logs.getLista());
                    // dados.novoAlerta(fkTotem);
                    //  ultimoAlerta = LocalDateTime.now();
                }
                //   }

                json.put("text", "Tudo está indo bem");

                try {
                    Slack.sendMessage(json);
                } catch (IOException ex) {
                    Logger.getLogger(TesteSlack.class.getName()).log(Level.SEVERE, null, ex);
                } catch (InterruptedException ex) {
                    Logger.getLogger(TesteSlack.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        }, delay, interval);

        //if (Duration.between(ultimoAlerta, proximoAlerta).toMinutes() <= 0) {
    }
}
