package Controlers;

import Entities.Consultation;
import Tools.ConnexionBDD;

import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CtrlConsultation
{
    private Connection cnx;
    private PreparedStatement ps;
    private ResultSet rs;
    private String query;

    public CtrlConsultation() {
        cnx = ConnexionBDD.getCnx();
    }

    public ArrayList<Consultation> GetAllConsultations()
    {
        ArrayList<Consultation> lesConsultations = new ArrayList<>();
        try {
            query =  "select idConsult, dateConsult, nomPatient, nomMedecin from consultation inner join medecin on numMedecin = idMedecin inner join patient on numPatient = idPatient";
            ps = cnx.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()){
                Entities.Consultation consultation = new Consultation(rs.getInt("idConsult"),rs.getDate("dateConsult"),rs.getString("nomPatient"),rs.getString("nomMedecin"));
                lesConsultations.add(consultation);
            }
            ps.close();
            rs.close();
        } catch (SQLException e) {
            Logger.getLogger(CtrlConsultation.class.getName()).log(Level.SEVERE, null, e);
        }
        return lesConsultations;
    }
    public int getLastNumberOfConsultation() throws SQLException {
        // ArrayList<Consultation> lesConsultations = new ArrayList<>();
        int lastNumber = 0;
        try {
            query = "select max(idConsult) from consultation";
            ps = cnx.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()){
                lastNumber = new Integer(rs.getInt("idConsult"));
                // lesConsultations.add(lastNumber);
            }
            ps.close();
            rs.close();
        } catch (Exception e) {
            Logger.getLogger(CtrlConsultation.class.getName()).log(Level.SEVERE, null, e);
        }
        return lastNumber;
    }
    public void InsertConsultation(int idConsult, String dateConsultation, int numPatient,int numMedecin)
    {
        try {
            query = "insert into consultation values (?,?,?,?)";
            ps = cnx.prepareStatement(query);
            ps.setObject(1, null);
            ps.setInt(2, idConsult);
            ps.setDate(3, Date.valueOf(dateConsultation));
            ps.setInt(4, numPatient);
            ps.setInt(5, numMedecin);
            ps.executeUpdate();
            ps.close();
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(CtrlConsultation.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
