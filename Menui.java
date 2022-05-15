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
                case 3: obj.changeRegister();
                //menu2(); 
                break;
                case 4: obj.delateRegister(); break;
                case 5: System.exit(0);
                default: JOptionPane.showMessageDialog(null, "opcion ivalida");
            }
        } while (option!=5);    
    }///fin del munu
//segundo munu para cambiar las calificaciones
    public void menu2(){//iniico del menu2
        int option;
        String message = "MODIFICAR CALIFICACION \n"+
            "1. Modificar calificacion 1 \n"+
            "2. Modificar calificacion 2\n"+
            "3. Modificar calificacion 3\n"+
            "4. salir\n"+
            "Digite una opcion.";
        do {
            option = Integer.parseInt(JOptionPane.showInputDialog(null, message));
            switch(option){//switch de las opciones disponibles
                case 1:
                        obj.changeScore1();
                     break;
                case 2:
                        obj.changeScore2();
                   break;
                case 3:
                        obj.changeScore3();
                     break; 
                case 4: break;
                default: JOptionPane.showMessageDialog(null, "opcion ivalida");
            }
        } while (option!=4);   
    }//fin del munu2
//metodo principal
//nueva bersion
    public static void main(String[] args){
        new Menui();//llama al contructor, que asu vez llama al munu()
    }
}//fin de la clase