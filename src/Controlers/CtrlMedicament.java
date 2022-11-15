package Controlers;

import Entities.Consultation;
import Entities.Medicament;
import Tools.ConnexionBDD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CtrlMedicament
{
    private Connection cnx;
    private PreparedStatement ps;
    private ResultSet rs;
    private String query;

    public CtrlMedicament() {
        cnx = ConnexionBDD.getCnx();
    }

    public ArrayList<Medicament> GetAllMedicamentsByIdConsultations(int idConsultation)
    {
        ArrayList<Medicament> lesMedicaments = new ArrayList<>();
        try {
            query =  "select * from medicament where ";
            ps.setInt(1,idConsultation);
            ps = cnx.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()){
                Medicament medicament = new Medicament(rs.getInt("idMedoc"),rs.getString("nomMedoc"),rs.getDouble("prixMedoc"),rs.getInt("numVignette"));
                lesMedicaments.add(medicament);
            }
            ps.close();
            rs.close();
        } catch (SQLException e) {
            Logger.getLogger(CtrlMedicament.class.getName()).log(Level.SEVERE, null, e);
        }
        return lesMedicaments;
    }
    public ArrayList<Medicament> getAllMedicaments()
    {

        return null;
    }
}
