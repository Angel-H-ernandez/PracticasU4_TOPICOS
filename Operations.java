import java.sql.Connection;
//import java.sql.Statement;
import java.sql.PreparedStatement;
//import javax.swing.JOptionPane;
import java.lang.NumberFormatException;
import java.sql.DriverManager;
import java.sql.ResultSet;
//import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class Operations{

    Connection connection=null;
    Mensaje M = new Mensaje();

    public void addName() {
        try {
            Connection conex = DriverManager.getConnection("jdbc:mysql://localhost/BDPracticasU4", "root", "");
            PreparedStatement ps = conex.prepareStatement("insert into alumno values(?,?,?,?,?,?)");
           
            String nombre = M.Insertnombre();
            int calif1 = M.insertScore("1era");
            int calif2 = M.insertScore("2da");
            int calif3 = M.insertScore("3ra");
            float promedio = (calif1+calif2+calif3)/3;
          
            ps.setString(1,"0");
            ps.setString(2, nombre);
            ps.setInt(3, calif1);
            ps.setInt(4, calif2);
            ps.setInt(5, calif3);
            ps.setFloat(6, promedio);
            ps.executeUpdate();
            M.datosInsetados();
        } catch (SQLException e) {System.out.println(e);}
        catch(NumberFormatException e){M.invalidData();}
        //finally{ConectionsDB.closeConecctionS(connection);}
    }

    public void changeScore1() throws SQLException {
        try {
            //connection = ConectionsDB.connectionS();
            PreparedStatement ps;
            String nombre = M.Insertnombre();
            int calif1 = M.newScore();
            ps = connection.prepareStatement("UPDATE alumno SET Calif1=? WHERE Nombre="+nombre);
            ps.setInt(3, calif1);
            ps.executeUpdate();
            M.datosInsetados();
  
        }
       catch(NumberFormatException e){M.invalidData();}
        //finally{ConectionsDB.closeConecctionS(connection);}
    }

    public void changeScore2() throws SQLException {
        try {
            //connection = ConectionsDB.connectionS();
            PreparedStatement ps;
            String nombre = M.Insertnombre();
            int calif2 = M.newScore();
            ps = connection.prepareStatement("UPDATE alumno SET Calif2=? WHERE Nombre="+nombre);
            ps.setInt(4, calif2);
            ps.executeUpdate();
            M.datosInsetados();
  

        }catch(NumberFormatException e){M.invalidData();}
        //finally{ConectionsDB.closeConecctionS(connection);}
    }

    public void changeScore3() throws SQLException {
        try {
            //connection = ConectionsDB.connectionS();
            PreparedStatement ps;
            String nombre = M.Insertnombre();
            int calif3 = M.newScore();
            ps = connection.prepareStatement("UPDATE alumno SET Calif3=? WHERE Nombre="+nombre);
            ps.setInt(5, calif3);
            ps.executeUpdate();
            M.datosInsetados();
  

        } catch(NumberFormatException e){M.invalidData();}
        //finally{ConectionsDB.closeConecctionS(connection);}
    }

    public void seeNamePoint_Average(){
        String datos="";
        try {
            Connection conex = DriverManager.getConnection("jdbc:mysql://localhost/BDPracticasU4", "root", "");
            PreparedStatement ps = conex.prepareStatement("select Nombre, Promedio from alumno");
            //ps.setString(1, "");
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                datos += rs.getString("Nombre")+"   " + rs.getString("Promedio")+"\n";
            }
            JOptionPane.showMessageDialog(null, datos, "registros", JOptionPane.INFORMATION_MESSAGE);
        }catch(Exception e){System.out.println(e);}
        //finally{ConectionsDB.closeConecctionS(connection);}
    }

    public void delateRegister(){
        try {
            //connection = ConectionsDB.connectionS();
            PreparedStatement ps;
            String nombre = M.Insertnombre();
            ps = connection.prepareStatement("DELETE FROM alumno WHERE Nombre = ?");
            ps.setString(2, nombre);
            ps.executeUpdate();
            M.datosInsetados();
    
        }catch(SQLException e){M.errorDB();}
        //finally{ConectionsDB.closeConecctionS(connection);}
    }
   
}