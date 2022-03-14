/**
*Problema resuelto en NETBeans IDE
*por: Yessenia Martínez
*Un productor de leche lleva el registro de lo que produce en litros, 
*pero cuando entrega le pagan en galones. 
*Realice un programa en java que ayude al productor a saber cuánto recibirá por la 
*entrega de su producción de un día (1 galón = 3.785 litros).
*__________________________________
*Análisis:
*Datos de entrada: Cantidad de litros producidos, precio de venta.
*Datos de salida: Ganancia obtenida por su producción
* 
* Problem solved in NETBeans IDE
*By: Yessenia Martinez
*A milk producer keeps the track of what he produce in liters, but when he
*delivers they pay him in gallons.
*Make a Java program that helps the producer to know how much he will receive for the
*delivery of it's one day production (1 gallon = 3.785 liters)
*___________________________________
*Analysis:
*Input data: Quantity of milk liters produced, sale price.
*Output data: Profits by production
 */
package registro_produccion;
import java.util.Scanner;
public class Registro_produccion {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner leer = new Scanner(System.in);
        Double litros_producidos;
        Double precio_venta;
        Double ganancia_obtenida;
        
        System.out.print("Introduzca la cantidad de litros producidos:");
        litros_producidos=leer.nextDouble();
        System.out.print("Introduzca el precio de venta:");
        precio_venta=leer.nextDouble();
        ganancia_obtenida=((litros_producidos*1)/3.785)*precio_venta;
        System.out.print("La ganancia obtenida por la cantidad de "+litros_producidos+" litros producidos es de: "+Math.round(ganancia_obtenida*100.0)/100.0);   
    }
    
}
