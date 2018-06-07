<?php
include "koneksi.php";
$delete = mysqli_query($con,"DELETE FROM budaya WHERE id_budaya='".$_GET['id_budaya']."'");
if($delete){
	header("location:budaya.php");
}else{
	echo "Gagal Hapus";
}
?>