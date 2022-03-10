<?php
require 'vendor/autoload.php'; // incluir lo bueno de Composer
?>
<?php

try
{
$cliente = new MongoDB\Client("mongodb+srv://adminDBproject:a1b2c3d@cluster0.vpt14.mongodb.net/test");
$colección = $cliente->customerdb->customers;
$document = array( 'name' => $_POST['txt_name'], 'address' => $_POST['txt_address'], 'age' => $_POST['txt_age'], 'password' => $_POST['txt_pass']);
$resultado = $colección->insertOne($document);
header('Location: http://localhost/customer');
}
catch(exception $ex)
{
    echo $ex;
}
/*echo "Inserted with Object ID '{$resultado->getInsertedId()}'";
$resultado = $colección->find( [ 'name' => 'Hinterland', 'brewery' => 'BrewDog' ] );

foreach ($resultado as $entry) {
    echo $entry['_id'], ': ', $entry['name'], "\n";
}*/
?>