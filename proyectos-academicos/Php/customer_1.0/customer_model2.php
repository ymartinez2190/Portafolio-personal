<?php
require 'vendor/autoload.php';
require 'db/db.php';
try 
{
     $connection=db::connection();
   
  
} catch (Exception $ex) 
{
    echo $ex;
}
$value=$_POST['txt_value'];
if(isset($_GET['txt_value']))
{
    echo "hay valor";
}

switch($value)
{
    case 1:
        save_customer();
    break;
    case 2:
        update_customer();
    break;
    case 3:
        delete_customer();
    break;
}
function save_customer()
{
    try 
    {
       
      $connection=db::connection();
    $document = array( 'name' => $_POST['txt_name'], 'address' => $_POST['txt_address'],'age' => $_POST['txt_age'], 'password' => $_POST['txt_pass'] );
    $result = $connection->insertOne($document);
      
    echo "<script type='text/javascript'>alert('New costumer added');</script>";
    echo"<script type='text/javascript'>window.location.href='index.php';</script>";
     
    } 
    catch (Exception $error) 
    {
        echo "<script type='text/javascript'>alert('Failed to insert data.');</script>";
        echo"<script type='text/javascript'>window.location.href='index.php';</script>";
        die($error->getMessage());
        
       
    }
      
 
}
function load_customers()
    {
        try
        {
           $connection=db::connection();
           $result = $connection->find() ;
           return $result;
        }
        catch (Exception $error) 
        {
            die($error->getMessage());
	}
    }

function update_customer()
{
    try 
    {
       
     $connection=db::connection();
     $result = $connection->updateOne(
    ["_id" => new MongoDB\BSON\ObjectId($_POST['txt_id'])], [
        '$set' => [
            "name" => $_POST['txt_name'],
            "address" => $_POST['txt_address'],
            "age"=>$_POST['txt_age'],
            "password"=>$_POST['txt_pass']
        ],
    ]
);
   
   echo "<script type='text/javascript'>alert('Costumer modified');</script>";
            echo"<script type='text/javascript'>window.location.href='index.php';</script>";
    } 
    catch (Exception $error) 
    {
        echo "<script type='text/javascript'>alert('Error to modified data');</script>";
            echo"<script type='text/javascript'>window.location.href='index.php';</script>";
        die($error->getMessage());
    }
    
}
  
   function delete_customer()
    {
        try
        {
            $connection=db::connection();
            $result = $connection->deleteOne(["_id" => new MongoDB\BSON\ObjectId($_POST['txt_id'])]);
            echo "<script type='text/javascript'>alert('Costumer delete');</script>";
            echo"<script type='text/javascript'>window.location.href='index.php';</script>";
        }
        catch (Exception $error) 
        {
            echo "<script type='text/javascript'>alert('Failed to delete data.');</script>";
            echo"<script type='text/javascript'>window.location.href='index.php';</script>";
            die($error->getMessage());
	}
    }
  
?>
