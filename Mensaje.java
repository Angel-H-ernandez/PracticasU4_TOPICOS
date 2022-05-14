import javax.swing.JOptionPane;

public class Mensaje {
    public String Insertnombre() {
        return JOptionPane.showInputDialog(null, "ingrese nombre del alumno");
    
    }

    public void datosInsetados() {
        JOptionPane.showMessageDialog(null, "Datos insertados");
    }

    public void errorDB() {
        JOptionPane.showMessageDialog(null, "ha ocurrido un error al conectar BD", "error", JOptionPane.INFORMATION_MESSAGE);
        
    }

    public void invalidData() {
        JOptionPane.showMessageDialog(null, "ingrese datos validos", "error", JOptionPane.INFORMATION_MESSAGE);
        
    }

    public int newScore() {
        return Integer.parseInt(JOptionPane.showInputDialog(null, "ingrese nueva calificacion"));
        
    }
    public int insertScore(String n){
        return Integer.parseInt(JOptionPane.showInputDialog(null, "ingrese "+n+" calificacion"));
    }
}
