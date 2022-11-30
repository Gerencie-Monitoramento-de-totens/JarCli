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
public class ConnectionAzu {
        private JdbcTemplate connection; 
    
    // Exemplo de configuração utilizando H2
    // Obs. O código comentado é um exemplo de como se conectar ao mysql
    public ConnectionAzu() {
        BasicDataSource datasource = new BasicDataSource();

        datasource.setDriverClassName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        datasource.setUrl("jdbc:sqlserver://svr-gerencie.database.windows.net:1433;database=gerencie;encryp\n" +
"t=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;");
        datasource.setUsername("admin-gerencie");
        datasource.setPassword("#Gfgrupo10");


        connection = new JdbcTemplate(datasource);
    }

    public JdbcTemplate getConnection() {
        return connection;
    }
}