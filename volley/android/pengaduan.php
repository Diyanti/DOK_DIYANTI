<?php 
include "../koneksi.php";

class pgd{}

$image = $_POST["image"];
$jenis = $_POST["jenis"];
$name = $_POST["nama"];
$deskripsi = $_POST["deskripsi"];
$gambar = $_POST["gambar"];
$upload_path = "../image/pengaduan/$gambar";

if(empty($jenis) || empty($name) || empty($deskripsi)){
	$response = new pgd();
	$response->success = 0;
	$response->message = "Harus Diisi Semua"; 
	die(json_encode($response));
}else {
	$query = mysqli_query($con,"INSERT INTO pengaduan VALUES (0,'".$jenis."','".$name."','".$deskripsi."','".$gambar."')");
	if ($query){
		file_put_contents($upload_path, base64_decode($image));
		// echo json_encode(array('response'=>'Image Uploaded Successfully'));
		$response = new pgd();
		$response->success = 1;
		$response->message = "Pengaduan Berhasil Dikirim"; 
		die(json_encode($response));
	}else{
	// echo json_encode(array('response'=>'Image Upload Failed'));
		$response = new pgd();
		$response->success = 0;
		$response->message = "Pengaduan Gagal Dikirim"; 
		die(json_encode($response));
	}
}

mysqli_close($con);

?>