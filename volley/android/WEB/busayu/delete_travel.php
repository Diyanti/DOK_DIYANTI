<?php
include "koneksi.php";
$delete = mysqli_query($con,"DELETE FROM pariwisata WHERE id_pariwisata='".$_GET['id_pariwisata']."'");
if($delete){
	header("location:travel.php");
}else{
	echo "Gagal Hapus";
}
?>