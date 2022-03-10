package cork_vaccine_application;
import java.io.Serializable;
import java.util.*;
import javax.swing.*;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.time.LocalDate;


public class ClientCollection  implements Serializable
{
   private List<Client> clientlist;
   private List<Client> clientload;
   private database connect=new database();
   private List<Vaccination> vaccineinfo;
    public ClientCollection()
    {
      clientlist = new ArrayList<Client>();
      vaccineinfo=new ArrayList<Vaccination>();
    }
    
    public List<Client> get_clientlist()
    {
       return clientlist;
    }
    //ADD CLIENT TO LIST
    public void add_client(Client client)
    {
        try
        {
            clientlist.add(client);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        } 
    }
    //FIND THE ID FOR THE DATA
     public int find_clientIndex(String id)
     {
        int i=0, index=-1;

        //LOOP FOR SEARCHING A CLIENT IN CLIENTS LIST BY ID
        for(Client client : clientlist){
            if(id.equalsIgnoreCase(client.get_idClient())){
                //IF FINDED THE INDEX IS STORED
                index=i;
            }
            i++;
        }
        
        return index;
    }
     //REMOVE CLIENT TO DATABASE
    public void remove_client(String id)
    {
        int index = find_clientIndex(id);
        if(index!=-1)
        {
            connect.remove_clients(id);
        
        }
        else
        {
           JOptionPane.showMessageDialog(null,"The given code doesnt exist for a valid client on this vaccine centre!");
        }
    }
    //REMOVE DUPLICATED VALUES FROM THE LIST BEFORE ENTERING THE DATABASE
    public void remove_duplicate_client()
    {
        try
        {
            ResultSet rscompare=connect.load_client();
            for(Client d:clientlist)
            {
                while(rscompare.next())
                {                
                    if(d.get_idClient().equals(rscompare.getString(1)))
                    {
                        int index = find_clientIndex(d.get_idClient());
                       clientlist.remove(index);         
                    }
                }
            }
           
        }
        catch(Exception e)
                {
                    e.printStackTrace();
                }
    }
            
    //SHOW ALL CLIENTS INFORMATION
    public List<Client> show_all_clients()
     {
         
        return clientlist;
    }
    //SAVE THE NEW DATA IN THE DATABASE
    public void save_data()
    {
        this.remove_duplicate_client();
        connect.insert_clients(clientlist);
    }
    //LOAD THE DATA FOR THE DATABASE
    public List<Client> load_data()
    {
      
       try
        {
            clientload=new ArrayList<Client>();
            ResultSet result=connect.load_client();
           
            while(result.next())
            {
             
              Name objname=new Name(result.getString(3),result.getString(4));
              Vaccination vac=new Vaccination(result.getInt("idvaccine"),result.getString("vaccinename"),result.getInt("efficacy"),result.getInt("dosequantity"),
              LocalDate.parse( new SimpleDateFormat("yyyy-MM-dd").format(result.getDate("firstdose"))),
              LocalDate.parse( new SimpleDateFormat("yyyy-MM-dd").format(result.getDate("lastdose"))));
              clientload.add(new Client(result.getString(1),result.getString(2),objname,vac));
           
            }  
        }
        catch(Exception e)
        {
                e.printStackTrace();
        }
        return clientload;
    }
    //LOAD THE DATA ORDER BY ID
    public List<Client> load_data_by_id()
    {
        
        try
        {
           clientload=new ArrayList<Client>();
            ResultSet result=connect.load_client_by_id();
            while(result.next())
            {
             
              Name objname=new Name(result.getString(3),result.getString(4));
              Vaccination vac=new Vaccination(result.getInt("idvaccine"),result.getString("vaccinename"),result.getInt("efficacy"),result.getInt("dosequantity"),
               LocalDate.parse( new SimpleDateFormat("yyyy-MM-dd").format(result.getDate("firstdose"))),
               LocalDate.parse( new SimpleDateFormat("yyyy-MM-dd").format(result.getDate("lastdose"))));
              clientload.add(new Client(result.getString(1),result.getString(2),objname,vac));
           
            }  
        }
        catch(Exception e)
        {
                e.printStackTrace();
        }
        
        return clientload;
    }
    //LOAD DATA ORDER BY VACCINE NAME
    public List<Client> load_data_by_vaccine()
    {
        
       try
        {
            clientload=new ArrayList<Client>();
            ResultSet result=connect.load_client_by_vaccine_name();
            while(result.next())
            {
             
              Name objname=new Name(result.getString(3),result.getString(4));
              Vaccination vac=new Vaccination(result.getInt("idvaccine"),result.getString("vaccinename"),result.getInt("efficacy"),result.getInt("dosequantity"),
               LocalDate.parse( new SimpleDateFormat("yyyy-MM-dd").format(result.getDate("firstdose"))),
               LocalDate.parse( new SimpleDateFormat("yyyy-MM-dd").format(result.getDate("lastdose"))));
              clientload.add(new Client(result.getString(1),result.getString(2),objname,vac));
           
            }  
        }
        catch(Exception e)
        {
                e.printStackTrace();
        }
        
        return clientload;
    }
    //LOAD DATA VACCINE
    public List<Vaccination> load_data_vaccine()
    {
        try
        {
            ResultSet result=connect.load_vaccine();
            while(result.next())
            {
                vaccineinfo.add(new Vaccination(result.getInt(1), result.getString(2), result.getInt(3),result.getInt(4)));
            }  
        }
        catch(Exception e)
        {
                e.printStackTrace();
        }
        return vaccineinfo;
    }
}

