package cork_vaccine_application;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import javax.swing.JOptionPane;
public class database {
   
 
//INFO TO CONNECT TO THE DATABASE 
    public static final String URL = "jdbc:mysql://localhost:3306/dbo_vaccine";
    public static final String USER = "root";
    public static final String PASS = "1234567890";
    private Connection con;
    private  ResultSet rs;
    
    //OBTAIN THE CONNECTION 
    public Connection getConection()
    {
       con=null;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = (Connection) DriverManager.getConnection(URL, USER, PASS);
        }catch(Exception e){
            System.out.println("Error: " + e.getMessage());
        }
        return con;
    }
    
    //INSERT THE LIST IN THE DATABASE
    public void insert_clients(List<Client> clientlist)
    {
        PreparedStatement ps_client, ps_vaccination;
        String sql_client, sql_vaccination=null;
        ResultSet rscompare=this.load_client();
       
        try
        {
            con = this.getConection();
            sql_client = "insert into tbl_client(idclient,firstname,lastname,phone) values (?,?,?,?)";
            sql_vaccination = "insert into tbl_vaccinationinfo(idclient,idvaccine,firstdose,lastdose) values (?,?,?,?)";
            ps_client = con.prepareStatement(sql_client);
            ps_vaccination = con.prepareStatement(sql_vaccination);

            for(Client insert_list:clientlist)
            {
                ps_client.setString(1,insert_list.get_idClient());
                ps_client.setString(2,insert_list.get_firstName());
                ps_client.setString(3,insert_list.get_lastName());
                ps_client.setString(4,insert_list.get_phoneClient());
                ps_client.executeUpdate();
                ps_vaccination.setString(1,insert_list.get_idClient());
                ps_vaccination.setInt(2,insert_list.get_vac().get_idvaccine());
                ps_vaccination.setDate(3,java.sql.Date.valueOf(insert_list.get_vac().get_startDoseDate()));
                ps_vaccination.setDate(4,java.sql.Date.valueOf(insert_list.get_vac().get_next_dose_date()));
                ps_vaccination.executeUpdate();
            }
            JOptionPane.showMessageDialog(null, "Data saved!");
        }
        catch(SQLException e)
        {
            JOptionPane.showMessageDialog(null, "Error de conexión:" + e.getMessage());
        }
    }
    //REMOVE CLIENT IN THE DATABASE
    public void remove_clients(String idclient)
    {
        PreparedStatement ps_client;
        String sql_client;
        try
        {
            con = this.getConection();
            sql_client = "DELETE tbl_client, tbl_vaccinationinfo FROM tbl_client inner join"
                    + " tbl_vaccinationinfo on tbl_vaccinationinfo.idclient = tbl_client.idclient WHERE tbl_client.idclient='"+idclient+"';";
            ps_client = con.prepareStatement(sql_client);
            ps_client.executeUpdate(); 
            JOptionPane.showMessageDialog(null, "Client delete!");
        }
        catch(SQLException e)
        {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
        }
    }
    
    //Load the vaccine info to jcombobox
    public ResultSet load_vaccine()
    {  
        rs=null;
        try
        {
            con = this.getConection();
            Statement s = con.createStatement();
            rs = s.executeQuery ("select * from tbl_vaccine;");  
        }
        catch(SQLException e)
        {
            JOptionPane.showMessageDialog(null, "Error:" + e.getMessage());
        }
        return rs;
    }
    //LOAD ALL DATA
    public ResultSet load_client()
    {
        rs=null;
        try
        {
            con = this.getConection();
            Statement s = con.createStatement();
           
            rs = s.executeQuery ("Select c.idClient,phone, firstname, lastname, v.idvaccine,vaccinename,efficacy,dosequantity,firstdose,lastdose "
                    + "from tbl_client c inner join tbl_vaccinationinfo i on c.idclient=i.idclient inner join"
                   + " tbl_vaccine v on i.idvaccine=v.idvaccine;");  
        }
        catch(SQLException e)
        {
            JOptionPane.showMessageDialog(null, "Error:" + e.getMessage());
        }
        return rs;
    }
    //LOAD THE DATA ORDER BY ID
    public ResultSet load_client_by_id()
    {
        rs=null;
        try
        {
            con = this.getConection();
            Statement s = con.createStatement();
           
            rs = s.executeQuery ("Select c.idClient,phone, firstname, lastname, v.idvaccine,vaccinename,efficacy,dosequantity,firstdose,lastdose \n" +
"             from tbl_client c inner join tbl_vaccinationinfo i on c.idclient=i.idclient inner join\n" +
"tbl_vaccine v on i.idvaccine=v.idvaccine order by c.idclient;");  
        }
        catch(SQLException e)
        {
            JOptionPane.showMessageDialog(null, "Error:" + e.getMessage());
        }
        return rs;
    }
    //LOAD THE INFORMATION ORDER BY VACCINE NAME
    public ResultSet load_client_by_vaccine_name()
    {
        rs=null;
        try
        {
            con = this.getConection();
            Statement s = con.createStatement();
           
            rs = s.executeQuery ("Select c.idClient,phone, firstname, lastname, v.idvaccine,vaccinename,efficacy,dosequantity,firstdose,lastdose from tbl_client c inner join tbl_vaccinationinfo i on c.idclient=i.idclient inner join tbl_vaccine v on i.idvaccine=v.idvaccine order by vaccinename;");  
        }
        catch(SQLException e)
        {
            JOptionPane.showMessageDialog(null, "Error:" + e.getMessage());
        }
        return rs;
    }
    
    
}
