<?php

require 'Conexion.php';

//if($_SERVER['REQUEST_METHOD'] == 'POST') {
    if($mysqli) {
        $sql = "SELECT * FROM equipos";
        $query = $mysqli->query($sql);
        $data = array();

        while($r = $query->fetch_assoc()) {
            $data[] = $r;
        }

        echo json_encode(array("Equipos"=>$data));
 /*   } else {
        echo "ERROR";
    }*/
}
