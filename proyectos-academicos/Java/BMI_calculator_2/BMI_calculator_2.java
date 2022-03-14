/*Problema resuelto en NETBeans IDE
 *por: Yessenia Martínez
 * Se desea desarrollar un programa que calcule el índice de masa corporal de
*una persona. Para ello, se requiere definir el peso de la persona (en kilogramos)
*y su estatura (en metros).Luego, a partir del IMC obtenido se pueden calcular si una persona tiene
*un peso normal, inferior o superior al normal u obesidad.
 *__________________________________
 **ESTA VERSIÓN DEL CÓDIGO UTILIZA MÉTODOS GET Y SET**
 */
package bmi_calculator_2;
import java.util.Scanner;
public class BMI_calculator_2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        double val_peso;
        double val_estatura;
        
        Scanner leer=new Scanner(System.in);
     
        System.out.print("Introduzca el peso de la persona: ");
        val_peso=leer.nextDouble();
        System.out.print("Introduzca la estatura de la persona: ");
        val_estatura=leer.nextDouble();
        BMI IMC_persona=new BMI(val_peso,val_estatura);
        
        System.out.println("El IMC de la persona es "+ IMC_persona.getIMC());
        System.out.println("En base a este IMC, se considera que la persona se encuentra en: "+IMC_persona.getIMC_descrip());
        
       
    
    }
    
}
