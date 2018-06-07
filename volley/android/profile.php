<?php 

include "../koneksi.php";


$id = $_POST["id_user"];

$query = mysqli_query($con,"SELECT * FROM users WHERE id_user='$id'");

$json = array();	

while($row = mysqli_fetch_assoc($query)){
	$json[] = $row;
}	

echo json_encode($json);

// $row = mysqli_fetch_array($query);

// if (!empty($row)){
// 	$response->success = 1;
// 	$response->nama = $row['strNama'];
// 	$response->message = "Selamat datang ";
// 	die(json_encode($response));
		
// } else { 
// 	$response->success = 0;
// 	$response->message = "Username atau password salah";
// 	die(json_encode($response));
// }

mysqli_close($con);

?>