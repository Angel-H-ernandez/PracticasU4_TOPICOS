import javax.swing.JOptionPane;

public class Menui {

    public Menui(){
        menu();
    }
    
    public void menu() {
        int option;
        String message = "OPCIONES \n"+
            "1. Nuevo registro \n"+
            "2. Consultar\n"+
            "3. Modificar\n"+
            "4. Dar de baja a ulumno\n"+
            "5. Salir\n"+
            "ingrese una opcion";
        
        do {
            option = Integer.parseInt(JOptionPane.showInputDialog(null, message));
        
            switch(option){
                case 1: mes(); break;
                case 2: mes(); break;
                case 3: menu2(); break;
                case 4: mes(); break;
                case 5: System.exit(0);
            }
        } while (option!=5);    
    }

    public void menu2(){
        int option;
        String message = "MODIFICAR CALIFICACION \n"+
            "1. Modificar calificacion 1 \n"+
            "2. Modificar calificacion 2\n"+
            "3. Modificar calificacion 3\n"+
            "4. salir\n"+
            "Digite una opcion.";
        
        
        do {
            option = Integer.parseInt(JOptionPane.showInputDialog(null, message));
            switch(option){
                case 1:mes(); break;
                case 2:mes(); break;
                case 3:mes(); break;
                case 4: break;
            }
        } while (option!=4);   
    }


    public void mes() {
        JOptionPane.showMessageDialog(null, "en proceso");
    }
    public static void main(String[] args) {
        new Menui();
    }
}
