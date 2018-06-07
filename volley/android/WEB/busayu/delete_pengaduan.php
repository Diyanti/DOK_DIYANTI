<?php
include "koneksi.php";
$delete = mysqli_query($con,"DELETE FROM pengaduan WHERE id_pengaduan='".$_GET['id_pengaduan']."'");
if($delete){
	header("location:pengaduan.php");
}else{
	echo "Gagal Hapus";
}
?>