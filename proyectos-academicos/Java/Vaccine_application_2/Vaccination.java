package cork_vaccine_application;
import java.io.Serializable;
import java.time.LocalDate;

public class Vaccination implements Serializable
{
    private int idvaccine;
    private String name;
    private int efficacy;
    private int dosequantity;
    private LocalDate startDoseDate;
    private LocalDate nextVacinationDate;
    //CONSTRUCTOR
    public Vaccination(int idvaccine,String name, int efficacy, int dosequantity, LocalDate startDoseDate, LocalDate nextVacinationDate)
    {
        this.idvaccine=idvaccine;
        this.name=name;
        this.efficacy=efficacy;
        this.dosequantity=dosequantity;
        this.startDoseDate=startDoseDate;
        this.nextVacinationDate=nextVacinationDate;
    }
     public Vaccination(int idvaccine,String name, int efficacy, int dosequantity)
    {
        this.idvaccine=idvaccine;
        this.name=name;
        this.efficacy=efficacy;
        this.dosequantity=dosequantity; 
    }
     //GETTERS
     public int get_idvaccine()
    {
        return idvaccine;
    }
      public int get_dosequantity()
    {
        return dosequantity;
    }
    public LocalDate get_next_dose_date(){
       
      
        return nextVacinationDate;
    }
     public String get_name()
    {
        return name;
    }
     
      public int get_efficacy()
    {
        return efficacy;
    }
       public LocalDate get_startDoseDate()
    {
        return startDoseDate;
    }
    
      //SETTERS
    public void set_name(String name)
    {
        this.name=name;
    }
    public void set_idvaccine(int idvaccine)
    {
        this.idvaccine=idvaccine;
    }
     public void set_dosequantity(int dosequantity)
    {
        this.dosequantity=dosequantity;
    }
    public void set_efficacy(int efficacy)
    {
        this.efficacy=efficacy;
    }
    
    public void set_startDoseDate(LocalDate startDoseDate)
    {
        this.startDoseDate=startDoseDate;
    }
     public void set_next_dose_date(LocalDate nextVacinationDate)
    {
        this.nextVacinationDate=nextVacinationDate;
    }
     public String toString(){
        return name +","+efficacy+","+startDoseDate+ ","+nextVacinationDate;
    }
}
