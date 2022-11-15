package Controlers;

import Entities.Consultation;
import Tools.ConnexionBDD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CtrlMedecin
{
    private Connection cnx;
    private PreparedStatement ps;
    private ResultSet rs;
    private String query;

    public CtrlMedecin() {
        cnx = ConnexionBDD.getCnx();
    }

    public ArrayList<String> getAllMedecins()
    {
        <ArrayList><String> noms = new ArrayList<>();
        try {
            ps = cnx.prepareStatement("select * from medecin");
            rs = ps.executeQuery();
            while (rs.next()){

            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    public int getIdMedecinByName(String nomMed)
    {
        try {
            ps = cnx.prepareStatement("select id from medecin where nomMedecin = ?");
            ps.setInt(1, Integer.parseInt(nomMed));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return 0;
    }
}
