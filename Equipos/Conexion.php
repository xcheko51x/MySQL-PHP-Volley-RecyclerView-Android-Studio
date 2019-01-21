<?php

$db_host = "localhost";
$db_user = "root";
$db_pass = "";
$db_name = "Equipos";

// VARIABLE QUE ALMACENA LA CONEXION A LA DB
$mysqli = new mysqli("localhost", "root", "","equipos");

if($mysqli->connect_errno){
    die("Fallo la conexion");
} else {
    //echo "Conexion exitosa";
}
