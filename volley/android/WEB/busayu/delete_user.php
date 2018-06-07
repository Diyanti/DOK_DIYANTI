<?php
include "koneksi.php";
$delete = mysqli_query($con,"DELETE FROM users WHERE id_user='".$_GET['id_user']."'");
if($delete){
	header("location:user.php");
}else{
	echo "Gagal Hapus";
}
?>