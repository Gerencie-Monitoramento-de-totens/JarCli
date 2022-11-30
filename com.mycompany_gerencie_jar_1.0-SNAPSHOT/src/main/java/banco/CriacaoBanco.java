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
public class CriacaoBanco {

    Connection connection = new Connection();
    JdbcTemplate con = connection.getConnection();

    public void criarBanco() {

        

        con.execute(
                "create table if not exists  metrica("
                + "idMetrica int primary key auto_increment,"
                + "dtInicializado datetime,"
                + "UsoRAM  double,"
                + "disponivelRAM double,"
                + "usoProcessador int,"
                + "disponivelProcessador int,"
                + "temperatura int"
                + ");"
        );

    }

}
