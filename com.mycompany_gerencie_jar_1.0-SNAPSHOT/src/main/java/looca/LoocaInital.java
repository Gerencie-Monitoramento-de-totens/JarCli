/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package looca;

import banco.Insercao;
import com.github.britooo.looca.api.core.Looca;
import com.github.britooo.looca.api.group.memoria.Memoria;
import com.github.britooo.looca.api.group.processador.Processador;
import com.github.britooo.looca.api.group.sistema.Sistema;
import com.github.britooo.looca.api.group.temperatura.Temperatura;
import java.io.IOException;
import slack.TesteSlack;

/**
 *
 * @author aluno
 */
public class LoocaInital {

    Double usoProcessador = 0.0;
    Long emUsoRAM = 00000000000L;//
    Long disponivelRAM = 00000000000L;//
    String idTotem = "";//
    Long memoriaRAMTotal = 0000000000L;//
    Double temperatura = 0.0;
    String sistemaOperacional = "";

    public Long getMemoriaRAMTotal() {
        return memoriaRAMTotal;
    }

    public String getIdTotem() {
        return idTotem;
    }

    public Double getUsoProcessador() {
        return usoProcessador;
    }

    public Long getEmUsoRAM() {
        return emUsoRAM;
    }

    public Long getDisponivelRAM() {
        return disponivelRAM;
    }

    public String getSistemaOperacional() {
        return sistemaOperacional;
    }

    public Double getTemperatura() {
        return temperatura;
    }
    
    
    
    // https://github.com/Britooo/looca-api/blob/main/README.md
    Looca looca = new Looca();

    //sistema
    Sistema sistema = looca.getSistema();
    Sistema loopSistema = looca.getSistema();
    Memoria memoria = looca.getMemoria();
    Memoria loopMemoria = looca.getMemoria();
    Processador processador = looca.getProcessador();
    Processador loopProcessador = looca.getProcessador();
    Temperatura loopTemperatura = looca.getTemperatura();

    Insercao insert = new Insercao();
    TesteSlack mensagem = new TesteSlack();

    void dadosSistema() {
        sistemaOperacional = sistema.getSistemaOperacional();
    }

    void loopDadosSistema() {
        loopSistema.getInicializado();
    }

    //memoria
    void dadosMemoria() {
        memoriaRAMTotal = memoria.getTotal();
    }

    void loopDadosMemoria() {
        emUsoRAM = loopMemoria.getEmUso();
        disponivelRAM = loopMemoria.getDisponivel();
    }

    //Processador
    void dadosProcessador() {
        idTotem = processador.getId();
    }

    void loopDadosProcessador() {
        usoProcessador = loopProcessador.getUso();
    }

    //Temperatura
    void loopDadosTemperatura() {
        temperatura = loopTemperatura.getTemperatura();
    }

   

    public void pegarDados() {
        dadosSistema();
        dadosMemoria();
        dadosProcessador();

        insert.alterarTotem(sistemaOperacional ,memoriaRAMTotal, idTotem);
    }

    public void loopPegarDados() throws IOException, InterruptedException {
        loopDadosSistema();
        loopDadosMemoria();
        loopDadosProcessador();
        loopDadosTemperatura();
        
        Long utilizadoRAM = emUsoRAM / 1000000000;
        Long ramDisponivel = disponivelRAM / 1000000000;

        insert.inserirMetrica( utilizadoRAM, ramDisponivel, usoProcessador, temperatura, idTotem);
        mensagem.mensagemSlack(usoProcessador,emUsoRAM,disponivelRAM,idTotem);
    }
}
