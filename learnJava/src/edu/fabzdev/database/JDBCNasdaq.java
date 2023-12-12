/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.fabzdev.database;

import edu.fabzdev.sockets.NasdaqReader2;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.StringTokenizer;

/**
 *
 * @author fabio
 */
public class JDBCNasdaq {

    public static Connection getConnection() throws SQLException {
        Connection con = null;
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            con = DriverManager.getConnection("jdbc:derby://localhost:1527/c:/TheJavaPathV2/javaPathDB");
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println("Clase no encontrada: " + ex.getMessage());
        }
        return con;
    }

    public static void main(String[] args) throws Exception {
        Connection con = JDBCNasdaq.getConnection();
        con.setAutoCommit(false);

        PreparedStatement ps = con.prepareStatement("insert into company (name, symbol, id_companyStatus) values (?, ?, ?)");
        PreparedStatement ps2 = con.prepareStatement("select id_companyStatus from companyStatus where code=?");
        PreparedStatement ps3 = con.prepareStatement("insert into companystatus (code) values (?)", Statement.RETURN_GENERATED_KEYS);
        PreparedStatement ps4 = con.prepareStatement("update companyStatus set id_companyStatus =? where code =?");

        BufferedReader br = new BufferedReader(new InputStreamReader(NasdaqReader2.getInputStream()));
        String line = br.readLine();
        line = br.readLine();
        String nextLine = br.readLine();

        while (nextLine != null) {
            String symbol = null;
            String name = null;
            String companyStatus = null;
            int idCompanyStatus = 1;
            int count2 = 1;
            StringTokenizer st = new StringTokenizer(line, "|");
            while (st.hasMoreElements()) {
                if (count2 == 1) {
                    symbol = st.nextToken();
                } else if (count2 == 2) {
                    name = st.nextToken();
                } else if (count2 == 5) {
                    companyStatus = st.nextToken();

                    //EMPIEZA
                    ps2.setString(1, companyStatus);
                    ResultSet rsId = ps2.executeQuery();
                    if (!rsId.next()) { // si no existe el registro, crealo
                        ps3.setString(1, companyStatus);
                        System.out.println(companyStatus);
                        ps3.executeUpdate();
                        ResultSet id = ps3.getGeneratedKeys();
                        id.next();
                        idCompanyStatus = id.getInt(1);
                        ps4.setInt(1, idCompanyStatus);
                        System.out.println(idCompanyStatus);
                        ps4.setString(2, companyStatus);
                        ps4.executeUpdate();
                    } else {
                        idCompanyStatus = rsId.getInt(1);
                    }
                    break;
                } else {
                    st.nextToken();
                }
                count2++;
            }
//            System.out.println("Symbol: " + symbol + "// Name: " + name + " // ID Company Status " + idCompanyStatus);

            ps.setString(1, name);
            ps.setString(2, symbol);
            ps.setInt(3, idCompanyStatus);
            ps.execute();

//            System.out.println();
            line = nextLine;
            nextLine = br.readLine();
        }

        ps.close();
        con.commit();
        con.close();
    }

}
