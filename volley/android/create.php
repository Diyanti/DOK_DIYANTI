<?php  
	include 'koneksi.php';

	class psn{}

	$nama = $_POST["nama"];
	$wisata = $_POST["wisata"];
	$total = $_POST["total"];
	$jumlah = $_POST["jumlah"];

	if ((empty($nama))) { 
		$response = new psn();
		$response->success = 0;
		$response->message = "Kolom nama tidak boleh kosong"; 
		die(json_encode($response));
	}else if((empty($jumlah))) {
		$response = new psn();
		$response->success = 0;
		$response->message = "Jumlah tidak boleh kosong";
	}else if ((empty($wisata))) { 
		$response = new psn();
		$response->success = 0;
		$response->message = "wisata tidak boleh kosong"; 
		die(json_encode($response));
	}else{
		$query = mysql_query("insert into pesan values('".$nama."','".$jumlah."','".$wisata."','".$total."')");
		if ($query) {
			$response = new psn();
			$response->success = 1;
			$response->message = "berhasil ditambahkan";
			die(json_encode($response));
		}
		else { 
				$response = new psn();
				$response->success = 0;
				$response->message = "gagal";
				die(json_encode($response));
			}
	}
	mysql_close();
?>