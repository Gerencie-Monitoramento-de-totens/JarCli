/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package banco;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 *
 * @author Rossi
 */
public class Connection {

    private JdbcTemplate connection;

    // Exemplo de configuração utilizando H2
    // Obs. O código comentado é um exemplo de como se conectar ao mysql
    public Connection() {
        BasicDataSource datasource = new BasicDataSource();

        //datasource.setDriverClassName("org.h2.Driver");
        //datasource.setUrl("jdbc:h2:file:./meu_banco");
        //datasource.setUsername("sa");
        //datasource.setPassword("");
        datasource.setDriverClassName("com.mysql.cj.jdbc.Driver");

        datasource.setUrl("jdbc:mysql://localhost:3306/gerencie");

        datasource.setUsername("root");

//        datasource.setPassword("aluno");
        datasource.setPassword("urubu100");

        this.connection = new JdbcTemplate(datasource);
    }

    public JdbcTemplate getConnection() {
        return connection;
    }
}
