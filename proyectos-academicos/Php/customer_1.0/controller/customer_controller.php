<?php
require_once 'model/customer_model.php';
$data=new customer_model();
$result=$data->load_customers();
require_once("view/list.php");
  
    /*private $model;
    
    public function __CONSTRUCT(){
        $this->model = new customer();
    }
    
    public function Index(){
       
    }
    
    public function Crud(){
        $alm = new customer();
        
        if(isset($_REQUEST['id'])){
            $alm = $this->model->search_customer($_REQUEST['id']);
        }
        
        
    }
    
    public function save_customer()
    {
        $alm = new customer();
        $alm->name= $_REQUEST['txt_name'];
        $alm->address = $_REQUEST['txt_address'];
        $alm->age = $_REQUEST['txt_age'];
        $alm->password = $_REQUEST['txt_password'];
        $this->model->save_customer($alm);
        header('Location: index.php');
    }
    
    public function delete_customer(){
        $this->model->delete_customer($_REQUEST['id']);
        header('Location: index.php');
    }*/

?>