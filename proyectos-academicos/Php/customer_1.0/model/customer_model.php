<?php
require 'vendor/autoload.php';
$connection_mongoDB = new MongoDB\Client("mongodb+srv://adminDBproject:a1b2c3d@cluster0.vpt14.mongodb.net/test");
$connection_mongoDB->customerdb->customers;
return $connection_mongoDB;
$value=$_POST['txt_value'];
switch($value)
{
    case 1:
        save_customer();
    break;
}
function save_customer()
{
    try 
    {
       
      //  $result = $con->insertOne(['name'=>$_POST['txt_name'],'address'=>$_POST['txt_address'],'age'=>$_POST['txt_age'],'password'=>$_POST['txt_password']]);
       // header('Location: http://localhost/customer');
    } 
    catch (Exception $error) 
    {
        die($error->getMessage());
    }
    
}
/*function load_customers()
    {
        try
        {
            $result = $con->find() ;
            return $result;
        }
        catch (Exception $error) 
        {
            die($error->getMessage());
	}
    }

  /*  public function __construct()
    {
	try
	{
            $this->con=db::connection();
        }
	catch(Exception $error)
	{
            die($error->getMessage());
	}
    }
    public function load_customers()
    {
        try
        {
            $result = $con->find() ;
            return $result;
        }
        catch (Exception $error) 
        {
            die($error->getMessage());
	}
    }
  /*  public function save_customer(customer $data)
    {
	try 
	{
            $query = array( 'name' => $data->name, 'address' => $data->address,'age' => $data->age, 'password' => $data->password);
            $result = $con->insertOne($query);
            header('Location: http://localhost/customer');
		
        } 
        catch (Exception $error) 
        {
            die($error->getMessage());
	}
    }
    public function update_customer(customer $data, $id)
    {
	try 
	{
            $query = array( 'name' => $data->name, 'address' => $data->address,'age' => $data->age, 'password' => $data->password);
            $result = $con->updateOne(['_id'=>new MongoDB\BSON\ObjectId($id)],['$set'=>['name'=>$data->name, 'address' => $data->address,'age' => $data->age, 'password' => $data->password],]);
            header('Location: http://localhost/customer');
		
        } 
        catch (Exception $error) 
        {
            die($e->getMessage());
	}
    }
    public function search_customer($id)
    {
	try 
	{
            $query=$con->findOne(['_id'=>new MongoDB\BSON\ObjectId($id)]);
            return $query;
	} 
        catch (Exception $e) 
	{
            die($e->getMessage());
	}
    }
    public function delete_customer($id)
    {
	try 
	{
            $query=$con->deleteOne(['_id'=>new MongoDB\BSON\ObjectId($id)]);
            return $query->getDeletedCount();
        } 
        catch (Exception $error) 
	{
            die($error->getMessage());
	}
    }*/

?>
