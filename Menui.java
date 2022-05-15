/**clase para mostrar el menu de las opciones
 * @uthor Miguel angel Cortes Hernandez
 * 15/may/2022*/

import javax.swing.JOptionPane;

public class Menui {
//objeto para operar los metodos de la clase operations
    Operations obj = new Operations();
//contructor para llamar al menu
    public Menui(){
        menu();
    }
//menu principal
    public void menu(){//inicio del menu
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
//switch de las opciones disponibles
            switch(option){
                case 1: obj.addName(); break;
                case 2: obj.seeNamePoint_Average(); break;
                case 3: obj.changeRegister();break;
                case 4: obj.delateRegister(); break;
                case 5: System.exit(0);
                default: JOptionPane.showMessageDialog(null, "opcion ivalida");
            }
        } while (option!=5);    
    }///fin del munu
//metodo principal
    public static void main(String[] args){
        Mensaje.author();
        new Menui();//llama al contructor, que asu vez llama al munu()
    }
}//fin de la clase