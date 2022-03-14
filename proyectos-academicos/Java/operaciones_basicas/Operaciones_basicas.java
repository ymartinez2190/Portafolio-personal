/*Problema resuelto en NETBeans IDE
 *por: Yessenia Martínez
 * Declara dos variables numéricas (con el valor que desees), muestra por consola la suma,
 *resta, multiplicación, división y módulo (resto de la división).
 *__________________________________
 */
package operaciones_basicas;
import java.util.Scanner;
public class Operaciones_basicas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int val_a;
        int val_b;
        int resultado;  
       Scanner leer=new Scanner(System.in);
        System.out.print("Introduzca el primer valor numérico: ");
        val_a=leer.nextInt();
        System.out.print("Introduzca el segundo valor numérico: ");
        val_b=leer.nextInt();
        System.out.println("Los resultados de las operaciones matemáticas con los valores ingresados son: ");
        resultado=val_a+val_b;
        System.out.println("Suma: "+resultado);
        resultado=val_a-val_b;
        System.out.println("Resta: "+resultado);
        resultado=val_a*val_b;
        System.out.println("Multiplicación: "+resultado);
        resultado=val_a/val_b;
        System.out.println("División: "+resultado);
        resultado=val_a%val_b;
        System.out.println("Módulo: "+resultado);
    }
    
}
