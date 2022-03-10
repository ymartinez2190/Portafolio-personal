package cork_vaccine_application;
import java.time.LocalDate;
public class SecondVaccineNeeded extends Vaccination
{
    public SecondVaccineNeeded(int idvaccine, String name, int efficacy,int dosequantity, LocalDate startDoseDate, LocalDate nextVacinationDate)
    {
        super(idvaccine,name,efficacy,dosequantity,startDoseDate,nextVacinationDate);
 
    }
}
