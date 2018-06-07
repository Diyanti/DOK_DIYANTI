<?php
include "koneksi.php";
$delete = mysqli_query($con,"DELETE FROM kegiatan WHERE id_kegiatan='".$_GET['id_kegiatan']."'");
if($delete){
	header("location:kegiatan.php");
}else{
	echo "Gagal Hapus";
}
?>