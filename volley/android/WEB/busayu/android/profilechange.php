<?php
	include "../koneksi.php";
	
	class emp{}
	
	$id 	= $_POST['id_user'];
	$nama 	= $_POST['nama'];
	$username = $_POST['username'];
	$email = $_POST['email'];
	

	$query = mysqli_query($con,"UPDATE users SET nama='".$nama."', username='".$username."', email='".$email."' WHERE id_user='".$id."'");
	
	if (empty($id) || empty($nama) || empty($username) || empty($email)) { 
		$response = new emp();
		$response->success = 0;
		$response->message = "Tidak Boleh Kosong"; 
		die(json_encode($response));
	} else {
		
		if ($query) {
			$response = new emp();
			$response->success = 1;
			$response->message = "Data berhasil di update";
			die(json_encode($response));
		} else{ 
			$response = new emp();
			$response->success = 0;
			$response->message = "Error update Data";
			die(json_encode($response)); 
		}	
	}
?>