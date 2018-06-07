<?php
        session_start();
        if (empty($_SESSION['username']))
                {
                    header("location:login.php");
                }

?> 
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>Beranda</title>
    <script type="text/javascript" src="assets/DataTables/media/js/jquery.js"></script>
    <script type="text/javascript" src="assets/DataTables/media/js/jquery.dataTables.js"></script>
    <link rel="stylesheet" type="text/css" href="assets/css/bootstrap.css">
    <link rel="stylesheet" type="text/css" href="assets/DataTables/media/css/jquery.dataTables.css">
    <link rel="stylesheet" type="text/css" href="assets/DataTables/media/css/dataTables.bootstrap.css">
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="css/style.css" rel="stylesheet">
        <script type="text/javascript">
    $(document).ready( function () {
        $('.tabel').DataTable();
    } );
    </script>
  </head>
  <body>
  	<div class="container-fluid">
	  	<div class="page-header">
	  		<h1>TOFAN <span>MOTOR</span></h1>
	  	</div>
  	</div>

    <div class="container-fluid">
    <div class="row">
        <div class="col-sm-3 col-md-3">
            <div class="panel-group" id="accordion">
                <div class="panel panel-default">
                    <div class="panel-heading">
                        <h4 class="panel-title">
                            <a data-toggle="collapse" data-parent="#accordion"><span class="glyphicon glyphicon-home">
                            </span><a href="beranda.php">Beranda</a>
                        </h4>
                    </div>
                </div>
                <div class="panel panel-default">
                    <div class="panel-heading">
                        <h4 class="panel-title">
                            <a data-toggle="collapse" data-parent="#accordion" href="#collapseTwo"><span class="glyphicon glyphicon-th">
                            </span>Master Data</a>
                        </h4>
                    </div>
                    <div id="collapseTwo" class="panel-collapse collapse">
                        <div class="panel-body">
                            <table class="table">
                                <tr>
                                    <td>
                                        <span class="glyphicon glyphicon-list-alt"></span><a href="data-barang.php">Data Barang</a>
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        <span class="glyphicon glyphicon-user"></span><a href="data-supplier.php">Data Supplier</a>
                                    </td>
                                </tr>
                            </table>
                        </div>
                    </div>
                </div>
                <div class="panel panel-default">
                    <div class="panel-heading">
                        <h4 class="panel-title">
                            <a data-toggle="collapse" data-parent="#accordion" href="#collapseThree"><span class="glyphicon glyphicon-list-alt">
                            </span>Transaksi Data</a>
                        </h4>
                    </div>
                    <div id="collapseThree" class="panel-collapse collapse">
                        <div class="panel-body">
                            <table class="table">
                                <tr>
                                    <td>
                                        <span class="glyphicon glyphicon-arrow-down"></span><a href="input_barang_masuk.php">Data Barang Masuk</a>
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        <span class="glyphicon glyphicon-arrow-up"></span><a href="barang_keluar.php">Data Barang Keluar</a>
                                    </td>
                                </tr>
                            </table>
                        </div>
                    </div>
                </div>
                <div class="panel panel-default">
                    <div class="panel-heading">
                        <h4 class="panel-title">
                            <a data-toggle="collapse" data-parent="#accordion" href="#collapseFour"><span class="glyphicon glyphicon-file">
                            </span>Laporan</a>
                        </h4>
                    </div>
                    <div id="collapseFour" class="panel-collapse collapse">
                        <div class="panel-body">
                            <table class="table">
                                <tr>
                                    <td>
                                        <span class="glyphicon glyphicon-arrow-down"></span><a href="laporan_barang_masuk.php">Barang Masuk</a>
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        <span class="glyphicon glyphicon-arrow-up"></span><a href="laporan_barang_keluar.php">Barang Keluar</a>
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        <span class="glyphicon glyphicon-tasks"></span><a href="stok-barang.php">Data Stok Barang</a>
                                    </td>
                                </tr>
                            </table>
                        </div>
                    </div>
                </div>
                <div class="panel panel-default">
                    <div class="panel-heading">
                        <h4 class="panel-title">
                            <a data-toggle="collapse" data-parent="#accordion" ><span class="glyphicon glyphicon-off">
                            </span>
                            <a href="logout.php"> 
                           Logout</a>
                        </h4>
                    </div>
                </div>
            </div>
        </div>
        <div class="col-sm-9 col-md-9">
            <div class="well">
			<h2 class="judul">DATA BARANG</h2>
			<a href="tambah-barang.php">
			<button class="btn btn-warning atas"><span class="glyphicon glyphicon-plus"></span>Tambah Barang</button>
			</a>

			<form action="cari_barang.php" method="POST">
				<input type="text" name="input_pencarian" placeholder="Nama Barang"></input>
				<input type="submit" name="cari_barang" value="Cari"></input>
			</form>
            <div class="table-responsive">
			<table class="table table-striped example">
                <tr>
                <th>Kode Barang</th>
                <th>Nama Barang</th>
                <th>Supplier</th>
                <th>Harga</th>
                <th>Satuan</th>
                <th>Stok</th>
                <th>Keterangan</th>
                <th>Aksi</th>
                </tr>
                <?php
                include 'koneksi.php';
                $sql = mysqli_query($konek, "SELECT * from data_barang");
                while ($data = mysqli_fetch_array($sql)){
                ?>
                <tr>
                	<td><?php echo $data['kode_barang'];?></td>
                	<td><?php echo $data['nama_barang'];?></td>
                	<td><?php echo $data['supplier'];?></td>
                	<td><?php echo $data['harga'];?></td>
                	<td><?php echo $data['satuan'];?></td>
                	<td><?php echo $data['stok']?></td>
                	<td><?php echo $data['keterangan']?></td>
                	<td>
                		<a href="edit-barang.php?kode_barang=<?=$data['kode_barang']?>"><button class="btn btn-warning"><span class="glyphicon glyphicon-pencil"></span>Edit</button></a>
                		<a href="delete-barang.php?kode_barang=<?=$data['kode_barang']?>"onclick="return confirm('Yakin akan dihapus ?');"><button class="btn btn-warning"><span class="glyphicon glyphicon-trash"></span>Hapus</button></a>
                	</td>
                </tr>
                <?php
                }
                ?>
            </table>
            </div>
            </div>
        </div>
    </div>
</div>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
  </body>
</html>