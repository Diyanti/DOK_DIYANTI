<?php
        session_start();
        if (empty($_SESSION['username']))
                {
                    header("location:login.php");
                }

?> 
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>Busayu - Wisata Alam</title>
	<link href="css/bootstrap.min.css" rel="stylesheet">
	<link href="css/font-awesome.min.css" rel="stylesheet">
	<link href="css/datepicker3.css" rel="stylesheet">
	<link href="css/styles.css" rel="stylesheet">

	<link rel="stylesheet" type="text/css" href="datatables/media/css/jquery.dataTables.css">
    <link rel="stylesheet" type="text/css" href="datatables/media/css/dataTables.bootstrap.css">	
	
	<!--Custom Font-->
	<link href="https://fonts.googleapis.com/css?family=Montserrat:300,300i,400,400i,500,500i,600,600i,700,700i" rel="stylesheet">
</head>
<body>

	<!-- header utama -->
	<nav class="navbar navbar-custom navbar-fixed-top" role="navigation">
		<div class="container-fluid">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#sidebar-collapse"><span class="sr-only">Toggle navigation</span>
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
					<span class="icon-bar"></span></button>
				<a class="navbar-brand" href="#"><span>BUSAYU</span> | ADMIN</a>
				<ul class="nav navbar-top-links navbar-right">
					<li class="dropdown"><a class="dropdown-toggle count-info" data-toggle="dropdown" href="#">
						<em class="fa fa-envelope"></em><span class="label label-danger"></span>
					</a>
					</li>
					<li class="dropdown"><a class="dropdown-toggle count-info" data-toggle="dropdown" href="#">
						<em class="fa fa-bell"></em><span class="label label-info"></span>
					</a>
					</li>
				</ul>
			</div>
		</div>
	</nav>
	<!-- /header utama -->

	
	<div id="sidebar-collapse" class="col-sm-3 col-lg-2 sidebar">
		<!-- profil admin -->
		<div class="profile-sidebar">
			<div class="profile-userpic">
				<img src="http://placehold.it/50/30a5ff" class="img-responsive" alt="">
			</div>
			<div class="profile-usertitle">
				<div class="profile-usertitle-name">Username</div>
				<div class="profile-usertitle-status"><span class="indicator label-success"></span>Online</div>
			</div>
			<div class="clear"></div>
		</div>
		<!-- /profil admin -->
		
		<!-- navigation bar -->
		<ul class="nav menu">
			<li><a href="index.php"><em class="fa fa-dashboard">&nbsp;</em> Dashboard</a></li>
			<li class="parent "><a data-toggle="collapse" href="#sub-item-1">
				<em class="fa fa-navicon">&nbsp;</em> Data <span data-toggle="collapse" href="#sub-item-1" class="icon pull-right"><em class="fa fa-plus"></em></span></a>
				<ul class="children collapse" id="sub-item-1">
					<li><a class="" href="user.php">
						<span class="fa fa-arrow-right">&nbsp;</span> User
					</a></li>
					<li><a class="" href="budaya.php">
						<span class="fa fa-arrow-right">&nbsp;</span> Budaya
					</a></li>
					<li><a data-toggle="collapse" href="#sub-item-2">
						<em class="fa fa-navicon">&nbsp;</em> Pariwisata <span data-toggle="collapse" href="Pariwisata.php" class="icon pull-right"></span>
						</a>
						<ul class="children collapse" id="sub-item-2">
							<li><a class="" href="wisata_alam.php">
								<span class="fa fa-arrow-right">&nbsp;</span> Wisata Alam
							</a></li>
							<li><a class="" href="wisata_buatan.php">
								<span class="fa fa-arrow-right">&nbsp;</span> Wisata Buatan
							</a></li>
							<li><a class="" href="resto_cafe.php">
								<span class="fa fa-arrow-right">&nbsp;</span> Resto & Cafe
							</a></li>
							<li><a class="" href="kuliner.php">
								<span class="fa fa-arrow-right">&nbsp;</span> Kuliner
							</a></li>
							<li><a class="" href="Hotel.php">
								<span class="fa fa-arrow-right">&nbsp;</span> Hotel
							</a></li>
							<li><a class="" href="travel.php">
								<span class="fa fa-arrow-right">&nbsp;</span> Travel
							</a></li>
						</ul>
					</li>
				</ul>
			</li>
			<li><a href="pengaduan.php"><em class="fa fa-calendar">&nbsp;</em> Pengaduan</a></li>
		</ul>
	</div>
	<!-- /navigation bar -->
		
	<!-- body halaman 1 -->	
	<div class="col-sm-9 col-sm-offset-3 col-lg-10 col-lg-offset-2 main">
		<!-- page navigation -->
		<div class="row">
			<ol class="breadcrumb">
				<li>
					<a href="#">
					<em class="fa fa-home">
					</em></a>
				</li>
				<li>Data</li>
				<li>Pariwisata</li>
				<li class="active"><a href="resto_cafe.php">Resto & Kafe</li>
			</ol>
		</div>
		<!-- /page navigation -->
		
		<!-- judul halaman -->
		<div class="row">
			<div class="col-lg-12">
				<h1 class="page-header">Resto & Kafe</h1>
			</div>
		</div>
		<!-- /judul halaman -->

		<!-- body halaman 2 -->
		<div class="row">
			<div class="col-md-12">
				<div class="panel panel-default">
					<!-- tambah resto & kafe -->
					<div class="panel-heading">
						<button type="button" class="pull-left btn btn-primary" data-toggle="modal" data-target="#myModal"><span class="glyphicon glyphicon-plus"></span><a href="aksi.php"></a> Tambah</button>

						<!-- modal resto & kafe -->
						<div class="modal fade" id="myModal">
						  <div class="modal-dialog">
						    <div class="modal-content">
						      <!-- Modal Header -->
						      <div class="modal-header">
							        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
									<h4 class="modal-title"><strong>Tambah Wisata Resto & Kafe</strong></h4>
							   </div>

						      <!-- Modal body -->
						      <div class="modal-body"></div>
						     
						    	<div class="container">
								    <div class="row">
								   		<div class="col-md-6">
								    		<div class="form-group">
								      			<label for="Username">Nama Resto & Kafe</label>
								      			<input type="Nama_Wisata" class="form-control" id="Nama_Wisata" placeholder="Nama Wisata" name="Nama_Wisata">
								    		</div>
								    	</div>
								    </div>

									<div class="row">
								   		<div class="col-md-6">
								    		<div class="form-group">
								      			<label for="deskripsi">Deskripsi</label>
								      			<input type="deskripsi" class="form-control" id="deskripsi" placeholder="Deskripsi" name="deskripsi">
								    		</div> 
								     	</div>
								    </div>
								</div>

  							<div class="row">
								<div class="col-md-6">
							  		<label class="btn btn-primary btn-file">Pilih Gambar<input type="file" style="display: none;"></label>
								</div>
							</div>

						      	<!-- Modal footer -->
						  	  	<div class="modal-footer">
						        	<button type="button" class="btn btn-primary">Simpan</button>
						      		<button type="button" class="btn btn-default" data-dismiss="modal">Keluar</button>
						      	</div>
						    </div>
						</div>
						<!-- /modal wisata alam -->
					</div>
				</div>

				<!-- tabel data resto & kafe -->
				<div class="panel-body">
					<div class="canvas-wrapper">
						<div class="table-responsive">
							<table id="ngoding" class="table table-striped table-bordered">
						        <thead>
						            <tr>
							            <th>Id Jenis Pariwisata</th>
								        <th>Id Pariwisata</th>
								        <th>Nama Resto & Kafe</th>
								        <th>Deskripsi</th>
								        <th>Gambar</th>
										<th>Aksi</th>
					            	</tr>
					        	</thead>
							<tbody>
							    <?php
					                include 'koneksi.php';
					                $sql = mysqli_query($con, "SELECT * from pariwisata");
					                while ($data = mysqli_fetch_array($sql)){
					            ?>
							    
							    <tr>
				                    <td><?php echo $data['id_jenis'];?></td>
				                    <td><?php echo $data['id_pariwisata'];?></td>
				                    <td><?php echo $data['nama'];?></td>
				                    <td><?php echo $data['deskripsi'];?></td>
				                    <td><?php echo $data['gambar'];?></td>
				          			    <td>
				                           	<a href="?page=databarang&id=20&kode_barang=<?=$data['kode_barang']?>">
				                           	<button class="btn btn-warning"><span class="glyphicon glyphicon-pencil"></span> Edit</button></a>
                       						<a data-toggle="modal" data-target="#modalDelete"><button class="btn btn-danger"><span class="glyphicon glyphicon-trash"></span> Hapus</button></a>
				                        </td>
						            </tr>
					            </tbody>
					
				                <div id="modalDelete" class="modal fade">
								<div class="modal-dialog">
									<div class="modal-content">
										<div class="modal-header">
										    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
								            <h4 class="modal-title">Konfirmasi</h4>
										</div>
										
										<div class="modal-body">
										    <p>Apakah Anda ingin menyimpan perubahan sebelum keluar?</p>
										    <p class="text-warning">Jika tidak, Data akan hilang.</p>
										</div>
										            
										<div class="modal-footer">
										  	<button type="button" class="btn btn-default" data-dismiss="modal">Batal</button>
										    <a href="delete-barang.php?id_user=<?=$data['id_user']?>">
										    <button type="button" class="btn btn-primary">Simpan Perubahan</button></a>
										</div>
									</div>
								</div>
							</div>
						    
						    <?php
						        }
		                    ?>				                		
		                </table>
					</div>
				</div>
			</div>
			<!-- /tabel data user -->
		</div>
		<!-- /body halaman 2 -->
	</div>
	<!-- /body halaman 1 -->
	</div>

	<!-- footer -->
	<div class="footer">
		<p>Copyright © PBL KELOMPOK 4 | D3TI.2D | POLITEKNIK NEGERI INDRAMAYU </p>
	</div>
	<!-- footer -->

	<script src="js/jquery-1.11.1.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<script src="js/chart.min.js"></script>
	<script src="js/chart-data.js"></script>
	<script src="js/easypiechart.js"></script>
	<script src="js/easypiechart-data.js"></script>
	<script src="js/bootstrap-datepicker.js"></script>
	<script src="js/custom.js"></script>
	<script src="js/custom.js"></script>
	<script type="text/javascript" src="datatables/media/js/jquery.js"></script>
    <script type="text/javascript" src="datatables/media/js/jquery.dataTables.js"></script>
    <script type="text/javascript">
	    $(document).ready( function () {
	        $('#ngoding').DataTable();
	    } );
    </script>
</body>
</html>
