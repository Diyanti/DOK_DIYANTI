<?php
	include "../koneksi.php";
	
	class emp{}
	
	$id 	= $_POST['id_user'];
	$old_password = $_POST['old_password'];
	$new_password = $_POST['new_password'];
	$confirm_password = $_POST['confirm_password'];

	$query_password = mysqli_query($con,"SELECT password FROM users WHERE id_user='$id' AND password='$old_password'");
	$cek_password = mysqli_num_rows($query_password);
	
	$query = mysqli_query($con,"UPDATE users SET password='".$new_password."' WHERE id_user='".$id."' AND password='".$old_password."'");
	
	if (empty($old_password) || empty($new_password) || empty($confirm_password)) { 
		$response = new emp();
		$response->success = 0;
		$response->message = "Tidak Boleh Kosong"; 
		die(json_encode($response));
	} else if ($new_password != $confirm_password) {
		$response = new emp();
		$response->success = 0;
		$response->message = "Password baru tidak sama"; 
		die(json_encode($response));
	} else if (!$cek_password>0) {
		$response = new emp();
		$response->success = 0;
		$response->message = "Password lama tidak cocok"; 
		die(json_encode($response));
	} else {
			if ($query) {
			$response = new emp();
			$response->success = 1;
			$response->message = "password berhasil di update";
			die(json_encode($response));
		} else{ 
			$response = new emp();
			$response->success = 0;
			$response->message = "Error update Data";
			die(json_encode($response)); 
		}	
	}
?>