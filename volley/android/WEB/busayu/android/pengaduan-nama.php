<?php
	include "../koneksi.php";

	class pgd{}
	
	$id_user = $_POST["id_user"];
	
	$query = mysqli_query($con, "SELECT * FROM users WHERE id_user='$id_user'");
	
	$row = mysqli_fetch_array($query);
	
	if (!empty($row)){
		$response = new pgd();
		$response->name = $row['nama'];
		die(json_encode($response));
	}
	
	mysqli_close($con);

?>