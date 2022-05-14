import java.sql.Connection;
//import java.sql.Statement;
import java.sql.PreparedStatement;
//import javax.swing.JOptionPane;
import java.lang.NumberFormatException;
//import java.sql.DriverManager;
//import java.sql.ResultSet;
//import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class Operations{

    Connection connection=null;
    Mensaje M = new Mensaje();

    public void addName() {

        try {
            connection = ConectionsDB.connectionS();
            PreparedStatement ps;
           
          //ingresar el nombre y sus tres calificaciones, el promedio se realiza en el calculo
            String nombre = M.Insertnombre();
            int calif1 = M.insertScore("1era");
            int calif2 = M.insertScore("2da");
            int calif3 = M.insertScore("3ra");
            int promedio = (calif1+ calif2+ calif3) / 3;
            String sql = "INSERT INTO alumno(Nombre, Calif1, Calif2, Calif3, Promedio) values(?,?,?,?,?)";
            ps = connection.prepareStatement(sql);
            ps.setString(2, nombre);
            ps.setInt(3, calif1);
            ps.setInt(4, calif2);
            ps.setInt(5, calif3);
            ps.setInt(6, promedio);
            ps.executeUpdate();
            M.datosInsetados();

        } catch (SQLException e) {M.errorDB();}
        catch(NumberFormatException e){M.invalidData();}
        finally{ConectionsDB.closeConecctionS(connection);}
    }

    public void changeScore1() throws SQLException {
        try {
            connection = ConectionsDB.connectionS();
            PreparedStatement ps;
            String nombre = M.Insertnombre();
            int calif1 = M.newScore();
            ps = connection.prepareStatement("UPDATE alumno SET Calif1=? WHERE Nombre="+nombre);
            ps.setInt(3, calif1);
            ps.executeUpdate();
            M.datosInsetados();
  
        }
       catch(NumberFormatException e){M.invalidData();}
        finally{ConectionsDB.closeConecctionS(connection);}
    }

    public void changeScore2() throws SQLException {
        try {
            connection = ConectionsDB.connectionS();
            PreparedStatement ps;
            String nombre = M.Insertnombre();
            int calif2 = M.newScore();
            ps = connection.prepareStatement("UPDATE alumno SET Calif2=? WHERE Nombre="+nombre);
            ps.setInt(4, calif2);
            ps.executeUpdate();
            M.datosInsetados();
  

        }catch(NumberFormatException e){M.invalidData();}
        finally{ConectionsDB.closeConecctionS(connection);}
    }

    public void changeScore3() throws SQLException {
        try {
            connection = ConectionsDB.connectionS();
            PreparedStatement ps;
            String nombre = M.Insertnombre();
            int calif3 = M.newScore();
            ps = connection.prepareStatement("UPDATE alumno SET Calif3=? WHERE Nombre="+nombre);
            ps.setInt(5, calif3);
            ps.executeUpdate();
            M.datosInsetados();
  

        } catch(NumberFormatException e){M.invalidData();}
        finally{ConectionsDB.closeConecctionS(connection);}
    }

    public void seeNamePoint_Average() throws SQLException {
        try {
            connection = ConectionsDB.connectionS();
            //mostrar solo el nombre y el promedio 
      
        } catch(NumberFormatException e){M.invalidData();}
        finally{ConectionsDB.closeConecctionS(connection);}
    }

    public void delateRegister() throws SQLException {
        try {
            connection = ConectionsDB.connectionS();
            PreparedStatement ps;
            String nombre = M.Insertnombre();
            ps = connection.prepareStatement("DELETE FROM alumno WHERE Nombre = ?");
            ps.setString(2, nombre);
            ps.executeUpdate();
            M.datosInsetados();
    
        }catch(SQLException e){M.errorDB();}
        finally{ConectionsDB.closeConecctionS(connection);}
    }
   
}