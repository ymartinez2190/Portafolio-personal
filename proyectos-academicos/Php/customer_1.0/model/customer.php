<?php
Class customer
{
    private $con;
    
    public $name;
    public $address;
    public $age;
    public $password;
   

    public function __CONSTRUCT()
    {
	try
	{
            $this->con =database::connection();
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
            $result = $con->find();
            return $result;
        }
        catch (Exception $error) 
        {
            die($error->getMessage());
	}
    }
    public function save_customer(customer $data)
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
    }
}
?>
