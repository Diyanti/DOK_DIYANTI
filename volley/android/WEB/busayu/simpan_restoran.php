<?php
	    include "koneksi.php";
	    $nama				    = $_POST['nama'];
	    $deskripsi				= $_POST['deskripsi'];
	    $jenis 					= 6;
		$nama_file   			= $_FILES['gambar']['name'];
		$namafolder				= "image/restoran/$nama_file";
		// $cek 					= mysqli_num_rows(mysqli_query($con,"SELECT * FROM data_barang WHERE kode_barang='$kode_barang'"));

        // if($cek>0){
        // 	echo "<script>alert('Kode Barang Tidak Boleh Sama!')</script>";
	       //  echo "<meta http-equiv='refresh' content='1 url=index.php?page=databarang&id=15'>"; 
        // }
        if ($nama==''|$deskripsi==''){
        	echo "<script>alert('Harap diisi Semua')</script>";
        	echo "<meta http-equiv='refresh' content='1 url=tambah_restoran.php'>"; 
        }
        else{
        	if (!empty($_FILES["gambar"]["tmp_name"]))
			{
			    $jenis_gambar=$_FILES['gambar']['type'];
			    if($jenis_gambar=="image/jpeg" || $jenis_gambar=="image/jpg" || $jenis_gambar=="image/gif" || $jenis_gambar=="image/png")
			    {           
			        if (move_uploaded_file($_FILES['gambar']['tmp_name'], $namafolder)) {
			            mysqli_query($con,"INSERT INTO pariwisata VALUES (0,'$nama','$deskripsi','$nama_file','$jenis')");
				        echo "<script>alert('Data Disimpan')</script>";
				        echo "<meta http-equiv='refresh' content='1 url=restoran.php'>"; 
			        } else {
			           echo "Data gagal disimpan";
			        }
			   } else {
			        echo "Jenis gambar yang anda kirim salah. Harus .jpg .gif .png";
			   }
			} else {
			    echo "<script>alert('Anda Belum Memilih Gambar')</script>";
				echo "<meta http-equiv='refresh' content='1 url=tambah_restoran.php'>"; 
			}
        }
?>