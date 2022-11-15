package Controlers;

import Tools.ConnexionBDD;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CtrlPrescrire
{
    private Connection cnx;
    private PreparedStatement ps;
    private ResultSet rs;
    private String query;

    public CtrlPrescrire() {
        cnx = ConnexionBDD.getCnx();
    }

    public void InsertPrescrire(int idConsult, int numMedicament,int quantite)
    {
        try {
            query = "insert into consultation values (?,?,?)";
            ps = cnx.prepareStatement(query);
            ps.setObject(1, null);
            ps.setInt(2, idConsult);
            ps.setInt(3, numMedicament);
            ps.setInt(4, quantite);
            ps.executeUpdate();
            ps.close();
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(CtrlPrescrire.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
