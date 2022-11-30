/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package banco;

import org.springframework.jdbc.core.JdbcTemplate;

/**
 *
 * @author Rossi
 */
public class Insercao {

    Connection connection = new Connection();
    JdbcTemplate con = connection.getConnection();
    
    ConnectionAzu connectionAzu = new ConnectionAzu();
    JdbcTemplate conAzu = connectionAzu.getConnection();
    
   
    
    public void inserirMetrica( Long emUsoRAM, Long disponivelRAM, Double usoProcessador,Double temperatura, String idTotem) {
        // Ou passar diretamente dentro do método
        // exemplo:
        con.update("INSERT INTO metrica ( dtInicializado, usoRAM, disponivelRAM,usoProcessador, temperatura) VALUES ( NOW(), ?, ?, ?,?);",
                  emUsoRAM, disponivelRAM, usoProcessador, temperatura);
        
        conAzu.update("INSERT INTO metrica ( dtInicializado, usoRAM, disponivelRAM,usoProcessador, temperatura, fkTotem) VALUES ( CURRENT_TIMESTAMP, ?, ?, ?,?,?);",
                  emUsoRAM, disponivelRAM, usoProcessador, temperatura, idTotem);
    }


    public void alterarTotem( String so,Long memoriaRAMTotal, String IdTotem) {
        
        conAzu.update("UPDATE totem set sistemaOperacional = ?, memoriaRAMTotal = ? WHERE idTotem = ?;"
            , so, memoriaRAMTotal, IdTotem);
    }
    
    public void reiniciarTotem( String IdTotem) {
        
     
        
        conAzu.update("UPDATE totem set isAtivoTotem = 't' WHERE idTotem = ?;"
            ,  IdTotem);
    }
    
    public void novoAlerta( String IdTotem) {
   
        conAzu.update("UPDATE totem set ultimoAlerta = CURRENT_TIMESTAMP WHERE idTotem = ?;"
            ,  IdTotem);
    }

}
