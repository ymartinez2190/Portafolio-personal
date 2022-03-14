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
public class BMI {
    private double peso;
    private double estatura;
    private double IMC;
    public BMI(double val_peso, double val_estatura)
    {
        this.peso=val_peso;
        this.estatura=val_estatura;
    }
    public void setPeso(double peso)
    {
        this.peso=peso;
    }
    public double getPeso()
    {
        return this.peso; 
    }
    
    public void setEstatura(double estatura)
    {
        this.estatura=estatura;
    }
    public double getEstatura()
    {
        return this.estatura;
    }
    
    public double getIMC()
    {
        this.IMC=this.peso/(this.estatura*this.estatura);
        return this.IMC;
    }
    public String getIMC_descrip()
    {
        if(this.IMC<16)
        {
           return  "Delgadez extrema";
        }
        else
        {
            if(this.IMC<17)
            {
                return "Delgadez leve";
            }
            else
            {
                if(this.IMC<25)
                {
                    return "Peso normal";
                }
                else
                {
                    if(this.IMC<30)
                    {
                        return "Sobrepeso";
                    }
                    else
                    {
                        if(this.IMC<35)
                        {
                            return "Obesidad leve";
                        }
                        else
                        {
                            if(this.IMC<40)
                            {
                                return "Obesidad moderada";
                            }
                            else
                            {
                                return "Obesidad mórbida";
                            }
                        }
                    }
                }
            }
        }
    }
}
