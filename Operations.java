import java.sql.Connection;
//import java.sql.Statement;
import javax.swing.JOptionPane;
//import java.sql.DriverManager;
//import java.sql.ResultSet;
//import java.sql.ResultSetMetaData;
//import java.sql.SQLException;

public class Operations{

    Connection connection=null;

    public void addName() {
        connection = ConectionsDB.connectionS();
        try {
          //ingresar el nombre y sus tres calificaciones, el promedio se realiza en el calculo
          String nombre = JOptionPane.showInputDialog(null, "ingrese nombre del alumno");
          int calif1 = Integer.parseInt(JOptionPane.showInputDialog(null, "ingrese 1ra calificacion"));
          int calif2 = Integer.parseInt(JOptionPane.showInputDialog(null, "ingrese 2da calificacion"));
          int calif3 = Integer.parseInt(JOptionPane.showInputDialog(null, "ingrese 3ra calificacion"));
          float promedio = (calif1+ calif2+ calif3) / 3;

        } catch (Exception e) {}
        finally{ConectionsDB.closeConecctionS(connection);}
    }

    public void changeScore1() {
        try {
            connection = ConectionsDB.connectionS();
            int calif1 = Integer.parseInt(JOptionPane.showInputDialog(null, "ingrese nueva calificacion"));
  
        } catch (Exception e) {}
        finally{ConectionsDB.closeConecctionS(connection);}
    }

    public void changeScore2() {
        try {
            connection = ConectionsDB.connectionS();
            int calif2 = Integer.parseInt(JOptionPane.showInputDialog(null, "ingrese nueva calificacion"));

        } catch (Exception e) {}
        finally{ConectionsDB.closeConecctionS(connection);}
    }

    public void changeScore3() {
        try {
            connection = ConectionsDB.connectionS();
            int calif3 = Integer.parseInt(JOptionPane.showInputDialog(null, "ingrese nueva calificacion"));

        } catch (Exception e) {}
        finally{ConectionsDB.closeConecctionS(connection);}
    }

    public void seeNamePoint_Average() {
        try {
            connection = ConectionsDB.connectionS();
            //mostrar solo el nombre y el promedio 
      
        } catch (Exception e) {}
        finally{ConectionsDB.closeConecctionS(connection);}
    }

    public void delateRegister() {
        try {
            connection = ConectionsDB.connectionS();
            //eliminar completamente ese registro
    
        } catch (Exception e) {}
        finally{ConectionsDB.closeConecctionS(connection);}
    }
   
}