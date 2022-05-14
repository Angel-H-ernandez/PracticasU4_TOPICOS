import java.sql.Connection;
//import java.sql.Statement;
import javax.swing.JOptionPane;
import java.sql.DriverManager;
//import java.sql.ResultSet;
//import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class ConectionsDB {
    Mensaje M = new Mensaje();

    static final String CONTROLADOR = "mysql-connector-java-8.0.29/mysql-connector-java-8.0.29.jar";
    //"com.mysql.jdbc.Driver";
    static final String URL_BASEDATOS = "jdbc:mysql://localhost/practicas";


    public  static Connection connectionS(){
        Connection conex = null;
        try {
            Class.forName(CONTROLADOR);
            conex = DriverManager.getConnection(URL_BASEDATOS, "root", "123456");
             
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al conectar con la base de datos.\n"
            + e.getMessage().toString(),"Error", JOptionPane.ERROR_MESSAGE);
        }
        return conex;
    }

    public static void closeConecctionS(Connection conex){
        try{
            conex.close();    
        }catch(SQLException e){
            System.out.println(e.getMessage().toString());
        }
    } 
    
    public static void main(String[] args) {
        Connection conex=null;
        conex = connectionS();
     
        if(conex != null){
            JOptionPane.showMessageDialog(null, "conectado correctamente");
        }else{
            JOptionPane.showMessageDialog(null, "no pudimos conectarnos a las BDD");
        }
    }
}
