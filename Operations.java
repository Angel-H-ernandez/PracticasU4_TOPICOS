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

    //Connection connection=null;
    Mensaje M = new Mensaje();

    public void addName() {
        try {
            Connection conex = DriverManager.getConnection("jdbc:mysql://localhost/BDPracticasU4", "root", "123456");
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

    public void changeRegister() {
        try {
            String nombre = M.Insertnombre();
            int calif1 = M.insertScore("1era");
            int calif2 = M.insertScore("2da");
            int calif3 = M.insertScore("3ra");
            Connection conex = DriverManager.getConnection("jdbc:mysql://localhost/BDPracticasU4", "root", "123456");
            PreparedStatement ps = conex.prepareStatement("update alumno set Calif1= ?, Calif2 = ?, Calif3 = ?, Promedio = ?  where Nombre = '"+nombre+"'");
            float promedio = (calif1+calif2+calif3)/3;
          
            ps.setInt(1, calif1);
            ps.setInt(2, calif2);
            ps.setInt(3, calif3);
            ps.setFloat(4, promedio);
            ps.executeUpdate();
            M.datosInsetados();
        } catch (Exception e) {JOptionPane.showMessageDialog(null, e, "error", JOptionPane.ERROR_MESSAGE);}
        
    }

    public void changeScore1(){
        try {
            String nombre = M.Insertnombre();
            int calif1 = M.insertScore("nueva");
            Connection conex = DriverManager.getConnection("jdbc:mysql://localhost/BDPracticasU4", "root", "123456");
            PreparedStatement ps = conex.prepareStatement("update alumno set Calif1 = ? where Nombre = '"+nombre+"'");
            ps.setInt(1, calif1);
            ps.executeUpdate();
            M.datosInsetados();
        }
       catch(Exception e){System.out.println(e);}
        //finally{ConectionsDB.closeConecctionS(connection);}
    }

    public void changeScore2(){
        try {
            String nombre = M.Insertnombre();
            int calif2 = M.insertScore("nueva");
            Connection conex = DriverManager.getConnection("jdbc:mysql://localhost/BDPracticasU4", "root", "123456");
            PreparedStatement ps = conex.prepareStatement("update alumno set Calif2 = ? where Nombre = '"+nombre+"'");
            ps.setInt(1, calif2);
            ps.executeUpdate();
            M.datosInsetados();
        }catch(Exception e){System.out.println(e);}
        //finally{ConectionsDB.closeConecctionS(connection);}
    }

    public void changeScore3(){
        try {
            String nombre = M.Insertnombre();
            int calif3 = M.insertScore("nueva");
            Connection conex = DriverManager.getConnection("jdbc:mysql://localhost/BDPracticasU4", "root", "123456");
            PreparedStatement ps = conex.prepareStatement("update alumno set Calif3 = ? where Nombre = '"+nombre+"'");
            ps.setInt(1, calif3);
            ps.executeUpdate();
            M.datosInsetados();
        } catch(Exception e){System.out.println(e);}
        //finally{conex.close{}}
    }

    public void seeNamePoint_Average(){
        String datos="";
        try {
            Connection conex = DriverManager.getConnection("jdbc:mysql://localhost/BDPracticasU4", "root", "123456");
            PreparedStatement ps = conex.prepareStatement("select Nombre, Promedio from alumno");
            //ps.setString(1, "");
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                datos += rs.getString("Nombre")+"   ->>>" + rs.getString("Promedio")+"\n";
            }
            JOptionPane.showMessageDialog(null, datos, "registros", JOptionPane.INFORMATION_MESSAGE);
        }catch(Exception e){System.out.println(e);}
        //finally{ConectionsDB.closeConecctionS(connection);}
    }

    public void delateRegister(){
        try {
            String nombre = M.Insertnombre();
            Connection conex = DriverManager.getConnection("jdbc:mysql://localhost/BDPracticasU4", "root", "123456");
            PreparedStatement ps = conex.prepareStatement("delete from alumno where Nombre = ?");
            ps.setString(1, nombre);
            ps.executeUpdate();
            M.datosInsetados();
    
        }catch(SQLException e){M.errorDB();}
        //finally{ConectionsDB.closeConecctionS(connection);}
    }
   
}