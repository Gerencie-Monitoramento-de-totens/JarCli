package aplication;

import banco.Consultas;
import banco.Insercao;
import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 *
 * @author stefanini
 */
public class Inovacao {

    static final Runtime run = Runtime.getRuntime();
    static Process pro;
    static BufferedReader read;
    Consultas cs = new Consultas();
    Insercao ins = new Insercao();

    public void desligar(String id, String so) {
        boolean isDesligar = cs.desligarTotem(id);

        if (isDesligar) {
            String[] cmds = {
                "cmd /c start cmd.exe",
                "shutdown /r"
//                "shutdown now"

            };
            
            ins.reiniciarTotem(id);

            try {
                if(so.equals("Windows")){
                    pro = run.exec(String.join("& ", cmds));
                }else{
                    pro = run.exec("shutdown -h -t " + 1); 
                }
               

                read = new BufferedReader(new InputStreamReader(pro.getInputStream()));
                read.readLine();
            } catch (Exception e) {
                System.err.println(e);
            }
        }
    }
}
