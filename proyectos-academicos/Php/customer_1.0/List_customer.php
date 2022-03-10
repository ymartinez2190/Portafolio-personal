<?php
require 'vendor/autoload.php'; // incluir lo bueno de Composer
?>
<?php

try
{
$cliente = new MongoDB\Client("mongodb+srv://adminDBproject:a1b2c3d@cluster0.vpt14.mongodb.net/test");
$coleccion = $cliente->customerdb->customers;

$cursor = $coleccion->find();
?>
<html>
<form action="Connection.php" method="post">
    
        <?php 
        try
        {
        echo "<table border='1'>";
          foreach ($this->model->load_customer() as $documento) 
          {
      echo "<tr><td>".$documento["name"] . "</td><td>". $documento["address"] . "</td><td> ". $documento["age"] . " </td><td>". $documento["password"] . "</td></tr>";
   }
   echo " </table>";
   }
   
catch(exception $ex)
{
    echo $ex;
}
?>
</form>
</html>