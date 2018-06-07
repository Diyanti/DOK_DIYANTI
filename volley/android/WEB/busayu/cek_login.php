<?php
include "koneksi.php";
$username = $_POST['username'];
$password = $_POST['password'];
$captcha = $_POST['captcha'];


if (empty($username)){
	echo "<script>alert('Username belum diisi')</script>";
	echo "<meta http-equiv='refresh' content='1 url=login.php'>";
}else if (empty($password)){
	echo "<script>alert('Password belum diisi')</script>";
	echo "<meta http-equiv='refresh' content='1 url=login.php'>";
}else if (empty($captcha)){
	echo "<script>alert('captcha belum diisi')</script>";
	echo "<meta http-equiv='refresh' content='1 url=login.php'>";
}else{
	
	session_start();

	$login = mysqli_query($con,"select * from users where username='$username' and password='$password'");
	$level = mysqli_query($con,"select level from users where username='$username' and password='$password'");
	$admin = "admin";

	if($_SESSION['kodecap']==$_POST['captcha']){
		if (mysqli_num_rows($login) > 0){
			if ($d = mysqli_fetch_array($level)) {
				if ($d["level"]==$admin) {
						$_SESSION['username'] = $username;
						echo "<script>alert('Selamat Datang $username!')</script>";
						echo "<meta http-equiv='refresh' content='1 url=index.php'>";
				}else{
					echo "<script>alert('Anda Tidak Memiliki Akses Admin')</script>";
					echo "<meta http-equiv='refresh' content='1 url=login.php'>";
				}
			}else{
				echo "<script>alert('Username atau Password salah')</script>";
				echo "<meta http-equiv='refresh' content='1 url=login.php'>";
			}
		}
		else{
			echo "<script>alert('Username atau Password salah')</script>";
			echo "<meta http-equiv='refresh' content='1 url=login.php'>";
		}
	}else{
		echo "<script>alert('Captcha salah')</script>";
		echo "<meta http-equiv='refresh' content='1 url=login.php'>";
	}
}
?>