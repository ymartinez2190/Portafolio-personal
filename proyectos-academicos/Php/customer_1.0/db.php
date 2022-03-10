<?php
require 'vendor/autoload.php';

    public static function connection()
    {
        $connection_mongoDB = new MongoDB\Client("mongodb+srv://adminDBproject:a1b2c3d@cluster0.vpt14.mongodb.net/test");
        $connection_mongoDB->customerdb->customers;
        return $connection_mongoDB;
    }

?>