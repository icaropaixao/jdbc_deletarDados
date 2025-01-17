package application;

import db.DB;
import db.DbIntegrityException;

import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Program {
    public static void main(String[] args) {


        // programa para deletar dados no banco de dadoss

        Connection conn = null;
        PreparedStatement st = null; // classe para criar os comandos SQL

        try{
            conn = DB.getConnection();

            st = conn.prepareStatement(
                    "DELETE FROM department "
                       + "WHERE "
                       + "Id = ? ");

            st.setInt(1,7);

            int rowsAffected = st.executeUpdate();

            System.out.println("Pronto! Linhas modificadas: " + rowsAffected);
        }
        catch (SQLException e){
            throw new DbIntegrityException(e.getMessage());
        }


    }

}
