/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package banco;

import java.util.Map;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 *
 * @author stefanini
 */
public class Consultas {

    ConnectionAzu connectionAzu = new ConnectionAzu();
    JdbcTemplate conAzu = connectionAzu.getConnection();

    public boolean logarTotem(String usuario, String senha, String idTotem) {
        try {
            Map<String, Object> registro = conAzu.queryForMap(
                    "select * from totem where usuarioTotem = ? and senhaTotem = ? and idTotem = ?;", usuario, senha, idTotem);

            return registro.size() > 1;
        } catch (EmptyResultDataAccessException e) {
            return false;
        }

    }
    
    public boolean desligarTotem(String id) {
        try {
            Map<String, Object> registro = conAzu.queryForMap(
                    "select * from totem where idTotem = ? and  isAtivoTotem= 'd';", id);

            return registro.size() > 1;
        } catch (EmptyResultDataAccessException e) {
            return false;
        }

    }
    
    public Map<String, Object> limitesTotem(String id) {
        try {
            Map<String, Object> registro = conAzu.queryForMap(
                    "select limiteProcessador, limiteTemperatura, limiteRam, ultimoAlerta from totem where idTotem = ?", id);

            return registro;
        } catch (EmptyResultDataAccessException e) {
            return null;
        }

    }

}
