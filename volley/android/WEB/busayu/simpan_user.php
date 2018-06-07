<?php
	    include "koneksi.php";
	    $nama				    = $_POST['nama'];
	    $username			    = $_POST['username'];
	    $password			    = $_POST['password'];
	    $email					= $_POST['email'];
	    $level				    = $_POST['level'];
	   
		// $cek 					= mysqli_num_rows(mysqli_query($con,"SELECT * FROM data_barang WHERE kode_barang='$kode_barang'"));

        // if($cek>0){
        // 	echo "<script>alert('Kode Barang Tidak Boleh Sama!')</script>";
	       //  echo "<meta http-equiv='refresh' content='1 url=index.php?page=databarang&id=15'>"; 
        // }
        // if ($username==''|$nama==''|$email==''|$level==''){
        // 	echo "<script>alert('Harap diisi Semua')</script>";
        // 	echo "<meta http-equiv='refresh' content='1 url=tambah_user.php'>"; 
        // }
        // else{      
        	$query = mysqli_query($con,"INSERT INTO users VALUES (0,'$nama','$username','$password','$email','$level')");
			if ($query) {
				echo "<script>alert('Data Disimpan')</script>";
				echo "<meta http-equiv='refresh' content='1 url=user.php'>"; 
			} else {
				echo "<script>alert('Data Gagal Disimpan')</script>";
				echo "<meta http-equiv='refresh' content='1 url=tambah_user.php'>"; 
			}
        // }
?>