/*Problema resuelto en NETBeans IDE
 *por: Yessenia Martínez
 * Se desea desarrollar un programa que calcule el índice de masa corporal de
*una persona. Para ello, se requiere definir el peso de la persona (en kilogramos)
*y su estatura (en metros).Luego, a partir del IMC obtenido se pueden calcular si una persona tiene
*un peso normal, inferior o superior al normal u obesidad.
 *__________________________________
 */
package bmi_calculator_1;
import java.util.Scanner;
public class BMI_calculator_1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        double val_peso;
        double val_estatura;
        double val_IMC;
        Scanner leer=new Scanner(System.in);
        
        System.out.print("Introduzca el peso de la persona: ");
        val_peso=leer.nextDouble();
        System.out.print("Introduzca la estatura de la persona");
        val_estatura=leer.nextDouble();
        val_IMC=val_peso/(val_estatura*val_estatura);
        System.out.println("El IMC de la persona es "+ val_IMC);
        System.out.print("En base a este IMC, se considera que la persona se encuentra en: ");
        if(val_IMC<16)
        {
           System.out.println("Delgadez extrema");
        }
        else
        {
            if(val_IMC<17)
            {
                System.out.println("Delgadez leve");
            }
            else
            {
                if(val_IMC<25)
                {
                    System.out.println("Peso normal");
                }
                else
                {
                    if(val_IMC<30)
                    {
                        System.out.println("Sobrepeso");
                    }
                    else
                    {
                        if(val_IMC<35)
                        {
                            System.out.println("Obesidad leve");
                        }
                        else
                        {
                            if(val_IMC<40)
                            {
                                System.out.println("Obesidad moderada");
                            }
                            else
                            {
                                System.out.println("Obesidad mórbida");
                            }
                        }
                    }
                }
            }
        }
       
    }
    
}
