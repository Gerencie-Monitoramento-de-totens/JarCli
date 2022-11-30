/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package slack;

import banco.Insercao;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Francisco
 */
public class Log {

    File arquivo = new File("arquivo.txt");
    Insercao dados = new Insercao();

   List<String> lista = new ArrayList<>();

    public List<String> getLista() {
        return lista;
    }

    public void logCPU(List<String> lista) {

        Date dataHoraAtual = new Date();
        String hora = new SimpleDateFormat("HH:mm:ss").format(dataHoraAtual);

        if (!arquivo.exists()) {
            try {
                arquivo.createNewFile();
            } catch (IOException ex) {
                Logger.getLogger(Log.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        lista.add("Você excedeu o limite de CPU " + LocalDateTime.now().format(DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL))
                + " às " + (DateTimeFormatter.ofPattern("HH:mm:ss").format(LocalDateTime.now())));
        

        try {
            // + " às " + dataHoraAtual);
            Files.write(Paths.get(arquivo.getPath()), lista, StandardOpenOption.APPEND);
        } catch (IOException ex) {
            Logger.getLogger(Log.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

     public void logRAM(List<String> lista) {

        Date dataHoraAtual = new Date();
        String hora = new SimpleDateFormat("HH:mm:ss").format(dataHoraAtual);

        if (!arquivo.exists()) {
            try {
                arquivo.createNewFile();
            } catch (IOException ex) {
                Logger.getLogger(Log.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        lista.add("Você excedeu o limite de RAM " + LocalDateTime.now().format(DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL))
                + " às " + (DateTimeFormatter.ofPattern("HH:mm:ss").format(LocalDateTime.now())));
        

        try {
            // + " às " + dataHoraAtual);
            Files.write(Paths.get(arquivo.getPath()), lista, StandardOpenOption.APPEND);
        } catch (IOException ex) {
            Logger.getLogger(Log.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
