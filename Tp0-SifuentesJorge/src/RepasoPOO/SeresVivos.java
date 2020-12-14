package RepasoPOO;
import java.util.Scanner;
public class SeresVivos {
    private static Tigre miTigre;
    private static Camaleon miCamaleon;
    Scanner teclado=new Scanner(System.in);
    public static void main(String[] args){
        System.out.println("Ingrese las patas del Tigre");
        miCamaleon = new Camaleon("verde",4);
        miCamaleon.calentarse(24);
        miTigre.setCrias(3);
        for(int i=0;i<5;i++){
            miCamaleon.ponerHuevo();
            i++;
        }
        miCamaleon = miTigre.alimentar(miCamaleon, 5);
        miCamaleon.setColor("oculto");
        miCamaleon.correr();
        miCamaleon = miTigre.buscar(miCamaleon);
        miCamaleon.calentarse(3);
        for(int i=0;i<6;i++){
            miCamaleon.ponerHuevo();
            i++;
        }
        miTigre.Grunir();
        miCamaleon = miTigre.alimentar(miCamaleon, 10);
        
        System.out.println("huevos restantes: "+miCamaleon.getHuevo());
    }
    
}
