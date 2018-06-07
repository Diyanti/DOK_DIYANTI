<?php

include "../koneksi.php";	

$query = mysqli_query($con,"SELECT * FROM budaya ORDER BY nama ASC");	

$json = array();	

while($row = mysqli_fetch_assoc($query)){
	$json[] = $row;
}	

echo json_encode($json);	

mysqli_close($con);

?>
<!-- <?php
// include '../koneksi.php';

// $query = $con->prepare("select * from budaya");

// $query->execute();

// $query->bind_result($id_budaya, $nama, $deskripsi, $gambar);

// $budaya = array();

// while ($query->fetch()) {
// 	$temp = array();
// 	$temp['id_budaya'] = $id_budaya;
// 	$temp['nama'] = $nama;
// 	$temp['deskripsi'] = $deskripsi;
// 	$temp['gambar'] = $gambar;

// 	array_push($budaya, $temp);
// }

// echo json_encode($budaya);



?> -->