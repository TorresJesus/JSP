/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utng.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import utng.model.Chofer;
import utng.util.utilDB;

/**
 *
 * @author Erick
 */
public class ChoferDAOImp implements ChoferDAO {
    
    private Connection connection;
    
    public ChoferDAOImp() {
        connection = utilDB.getConnection();
    }
    
    @Override
    public void agregarChofer(Chofer chofer) {
        try {
            String query = "INSERT INTO chofer(nombre,email ,telefono,direccion,edad)" + 
                            "  VALUES(?,?,?,?,?)";
            PreparedStatement ps = connection.prepareStatement(query);
            
            ps.setString(1, chofer.getNombre());
            ps.setString(2, chofer.getEmail());
            ps.setInt(3,chofer.getTelefono());
            ps.setString(4, chofer.getDireccion());
            ps.setInt(5, chofer.getEdad());
            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    @Override
    public void borrarChofer(int idChofer) {
        try {
            String query = "DELETE FROM chofer WHERE "
                    + " id_chofer=?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, idChofer);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
    }
    
    @Override
    public void cambiarChofer(Chofer chofer) {
        try {
            String query = "UPDATE chofer SET nombre= ?"
                    + ", email=?"
                    + ", telefono=?"
                    + ", direccion=?"
                    + ", edad"
                    + " WHERE id_chofer=?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, chofer.getNombre());
            ps.setString(2, chofer.getEmail());
            ps.setInt(3, chofer.getTelefono());
            ps.setString(4, chofer.getDireccion());
            ps.setInt(5, chofer.getEdad());
            ps.setInt(6, chofer.getIdChofer());
            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public List<Chofer> desplegarChofer() {
        List<Chofer> choferes = new ArrayList<Chofer>();
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM chofer");
            while (rs.next()) {
                Chofer chofer = new Chofer(rs.getInt("id_chofer"),
                        rs.getString("nombre"),
                        rs.getString("email"),
                        rs.getInt("telefono"),
                        rs.getString("direccion"),
                        rs.getInt("edad"));
                choferes.add(chofer);
            }
            rs.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return choferes;
    }
    
    @Override
    public Chofer elegirChofer(int idChofer) {
        Chofer chofer=null;
        try {
            String query = " SELECT * FROM chofer WHERE id_chofer=?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, idChofer);
            ResultSet rs = statement.executeQuery();
            
            if (rs.next()) {
                  chofer = new Chofer(
                        rs.getInt("id_chofer"),
                        rs.getString("nombre"),
                        rs.getString("email"),
                        rs.getInt("telefono"),
                        rs.getString("direccion"),
                        rs.getInt("edad"));
             
            }
            rs.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return chofer;
    }

    
}//FIN DE LA CLASE
