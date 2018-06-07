<?php
	include_once "../koneksi.php";

	class usr{}
	
	$nama = $_POST["nama"];
	$username = $_POST["username"];
	$password = $_POST["password"];
	$confirm_password = $_POST["confirm_password"];
	$email = $_POST["email"];
	$level = "user";
	$cek_user = mysqli_num_rows(mysqli_query($con,"SELECT * FROM users WHERE username='$username'"));
	$cek_email = mysqli_num_rows(mysqli_query($con,"SELECT * FROM users WHERE email='$email'"));
	
	if ((empty($username))) { 
		$response = new usr();
		$response->success = 0;
		$response->message = "Kolom username tidak boleh kosong"; 
		die(json_encode($response));
	} else if ((empty($password))) { 
		$response = new usr();
		$response->success = 0;
		$response->message = "Kolom password tidak boleh kosong"; 
		die(json_encode($response));
	} else if ((empty($confirm_password)) || $password != $confirm_password) { 
		$response = new usr();
		$response->success = 0;
		$response->message = "Konfirmasi password tidak sama"; 
		die(json_encode($response));
	} else if((empty($email))){
	 	$response = new usr();
	 	$response->success = 0;
	 	$response->message = "Kolom email tidak boleh kosong"; 
	} 
	else if($cek_user>0){
		$response = new usr();
		$response->success = 0;
		$response->message = "username sudah ada"; 
		die(json_encode($response));
	} 
	else if($cek_email>0){
		$response = new usr();
		$response->success = 0;
		$response->message = "email sudah terdaftar"; 
		die(json_encode($response));
	} else {
		if (!empty($username) && $password == $confirm_password){
			$query = mysqli_query($con, "INSERT INTO users (id_user, nama, username, password, email, level) VALUES(0,'".$nama."','".$username."','".$password."','".$email."','".$level."')");
			if ($query){
				$response = new usr();
				$response->success = 1;
				$response->message = "Register berhasil, silahkan login.";
				die(json_encode($response));	
			} 
		}	
	}

	mysqli_close($con);

?>	