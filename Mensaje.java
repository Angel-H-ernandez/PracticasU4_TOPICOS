import javax.swing.JOptionPane;
//clase para mostrar mensajes
public class Mensaje {
//retorna el nombre del alumno
    public String Insertnombre() {
        return JOptionPane.showInputDialog(null, "ingrese nombre del alumno");
    }
//mensaje de operacion
    public void datosInsetados() {
        JOptionPane.showMessageDialog(null, "Operacion exitosa");
    }
//mensaje de error en la bd
    public void errorDB() {
        JOptionPane.showMessageDialog(null, "ha ocurrido un error al conectar BD", "error", JOptionPane.INFORMATION_MESSAGE);
    }
//error de dato ingresados
    public void invalidData() {
        JOptionPane.showMessageDialog(null, "ingrese datos validos", "error", JOptionPane.INFORMATION_MESSAGE);    
    }
//retorna calificaion
    public int insertScore(String n){
        return Integer.parseInt(JOptionPane.showInputDialog(null, "ingrese "+n+" calificacion"));
    }
}//fin del aclase mensaje
