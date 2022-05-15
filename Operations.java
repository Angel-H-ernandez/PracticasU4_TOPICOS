/**clase para realizar consulta en una BD
 * @uthor Miguel angel Cortes Hernandez
 * 15/may/2022*/
 
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.lang.NumberFormatException;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

//clase para operar sobre la base de datos
public class Operations{

    Mensaje M = new Mensaje();
//metodo para agregar nombre y calificaciones
    public void addName() {
        try {//connecion a BD y consulta a realizar
            Connection conex = DriverManager.getConnection("jdbc:mysql://localhost/BDPracticasU4", "root", "123456");
            PreparedStatement ps = conex.prepareStatement("insert into alumno values(?,?,?,?,?,?)");
        //se piden los datos
            String nombre = M.Insertnombre();
            int calif1 = M.insertScore("1era");
            int calif2 = M.insertScore("2da");
            int calif3 = M.insertScore("3ra");
            float promedio = (calif1+calif2+calif3)/3;
        //se mandan los datos y se ejecuta la peticion
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
    }
//metodo para modificar las calificaciones
    public void changeRegister() {
        try {//se piden los datos
            String nombre = M.Insertnombre();
            int calif1 = M.insertScore("1era");
            int calif2 = M.insertScore("2da");
            int calif3 = M.insertScore("3ra");
            Connection conex = DriverManager.getConnection("jdbc:mysql://localhost/BDPracticasU4", "root", "123456");
            PreparedStatement ps = conex.prepareStatement("update alumno set Calif1= ?, Calif2 = ?, Calif3 = ?, Promedio = ?  where Nombre = '"+nombre+"'");
            float promedio = (calif1+calif2+calif3)/3;
        //se envian y se ejecuta la consulta
            ps.setInt(1, calif1);
            ps.setInt(2, calif2);
            ps.setInt(3, calif3);
            ps.setFloat(4, promedio);
            ps.executeUpdate();
            M.datosInsetados();
        } catch (Exception e) {JOptionPane.showMessageDialog(null, e, "error", JOptionPane.ERROR_MESSAGE);}    
    }
//metodo para ver los datos de la tabla
    public void seeNamePoint_Average(){
        String datos="";
        try {//se estable conexion con BD
            Connection conex = DriverManager.getConnection("jdbc:mysql://localhost/BDPracticasU4", "root", "123456");
            PreparedStatement ps = conex.prepareStatement("select Nombre, Promedio from alumno");
        //se realiza la consulta
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
        //se va reccoriedo las filas y se guardan os datos en la bariable datos
                datos += rs.getString("Nombre")+"   ->>>" + rs.getString("Promedio")+"\n";
            }
            JOptionPane.showMessageDialog(null, datos, "registros", JOptionPane.INFORMATION_MESSAGE);
        }catch(Exception e){System.out.println(e);}
    }
//metodo para elimminar un registro
    public void delateRegister(){
        try {//pide el nombre y realiza la consulta
            String nombre = M.Insertnombre();
            Connection conex = DriverManager.getConnection("jdbc:mysql://localhost/BDPracticasU4", "root", "123456");
            PreparedStatement ps = conex.prepareStatement("delete from alumno where Nombre = ?");
            ps.setString(1, nombre);
            ps.executeUpdate();
            M.datosInsetados();
        }catch(SQLException e){M.errorDB();}
    }//fin del metodo delateRegister
}//fin de la clase Operations