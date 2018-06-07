<?php
	include "koneksi.php";
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
	<title>Busayu - Budaya</title>
	<link href="css/bootstrap.min.css" rel="stylesheet">
	<link href="css/font-awesome.min.css" rel="stylesheet">
	<link href="css/datepicker3.css" rel="stylesheet">
	<link href="css/styles.css" rel="stylesheet">

	<link rel="stylesheet" type="text/css" href="datatables/media/css/jquery.dataTables.css">
    <link rel="stylesheet" type="text/css" href="datatables/media/css/dataTables.bootstrap.css">	
	
	<!--Custom Font-->
	<link href="https://fonts.googleapis.com/css?family=Montserrat:300,300i,400,400i,500,500i,600,600i,700,700i" rel="stylesheet">
	<!--[if lt IE 9]>
	<script src="js/html5shiv.js"></script>
	<script src="js/respond.min.js"></script>
	<![endif]-->
</head>
<body>
	<nav class="navbar navbar-custom navbar-fixed-top" role="navigation">
		<div class="container-fluid">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#sidebar-collapse"><span class="sr-only">Toggle navigation</span>
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
					<span class="icon-bar"></span></button>
				<a class="navbar-brand" href="#"><span>Busayu</span> | Admin</a>
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
		</div><!-- /.container-fluid -->
	</nav>
	<div id="sidebar-collapse" class="col-sm-3 col-lg-2 sidebar">
		<div class="profile-sidebar">
			<div class="profile-userpic">
				<img src="http://placehold.it/50/30a5ff/fff" class="img-responsive" alt="">
			</div>
			<div class="profile-usertitle">
                <div class="profile-usertitle-name"><?php echo $_SESSION["username"]; ?></div>
				<div class="profile-usertitle-status"><span class="indicator label-success"></span>Online</div>
			</div>
			<div class="clear"></div>
		</div>
		<div class="divider"></div>
		<ul class="nav menu">
			<li><a href="index.php"><em class="fa fa-dashboard">&nbsp;</em> Dashboard</a></li>
			<li class="parent "><a data-toggle="collapse" href="#sub-item-1">
				<em class="fa fa-navicon">&nbsp;</em> Data <span data-toggle="collapse" href="#sub-item-1" class="icon pull-right"><em class="fa fa-plus"></em></span>
				</a>
				<ul class="children collapse" id="sub-item-1">
					<li><a class="" href="user.php">
						<span class="fa fa-arrow-right">&nbsp;</span> User
					</a></li>
					<li><a class="" href="budaya.php">
						<span class="fa fa-arrow-right">&nbsp;</span> Budaya
					</a></li>
					<li>
				<a data-toggle="collapse" href="#sub-item-2">
				<em class="fa fa-navicon">&nbsp;</em> Pariwisata <span data-toggle="collapse" href="Pariwisata.php" class="icon pull-right"></span>
				</a>
				<ul class="children collapse" id="sub-item-2">
					<li><a class="" href="wisata_alam.php">
						<span class="fa fa-arrow-right">&nbsp;</span> Wisata Alam
					</a></li>
					<li><a class="" href="wisata_buatan.php">
						<span class="fa fa-arrow-right">&nbsp;</span> Wisata Buatan
					</a></li>
					<li><a class="" href="travel.php">
						<span class="fa fa-arrow-right">&nbsp;</span> Travel
					</a></li>
					<li><a class="" href="kuliner.php">
						<span class="fa fa-arrow-right">&nbsp;</span> Kuliner
					</a></li>
					<li><a class="" href="hotel.php">
						<span class="fa fa-arrow-right">&nbsp;</span> Hotel
					</a></li>
					<li><a class="" href="restoran.php">
						<span class="fa fa-arrow-right">&nbsp;</span> Restoran
					</a></li>
				</ul>
			</li>
				</ul>
			</li>
			<li><a href="kegiatan.php"><em class="fa fa-calendar">&nbsp;</em> Kegiatan</a></li>
			<li class="active"><a href="pengaduan.php"><em class="fa fa-inbox">&nbsp;</em> Pengaduan</a></li>
			<li><a href="logout.php"><em class="fa fa-power-off">&nbsp;</em> Logout</a></li>
		</ul>
	</div><!--/.sidebar-->
		
	<div class="col-sm-9 col-sm-offset-3 col-lg-10 col-lg-offset-2 main">
		<div class="row">
			<ol class="breadcrumb">
				<li><a href="#">
					<em class="fa fa-home"></em>
				</a></li>
				<li class="active">Pengaduan</li>
			</ol>
		</div><!--/.row-->
		
		<div class="row">
			<div class="col-lg-12">
				<h1 class="page-header">Pengaduan</h1>
			</div>
		</div><!--/.row-->
		<div class="row">
			<div class="col-md-12">
				<div class="panel panel-default">
					<div class="panel-body">
						<div class="canvas-wrapper">
							<div class="table-responsive">
								<table id="ngoding" class="table table-striped table-bordered">
							        <thead>
							            <tr>
							            	<th>Jenis</th>
							                <th>Nama</th>
							                <th width="400px">Deskripsi</th>
							                <th>Gambar</th>
							                <th>Aksi</th>
							            </tr>
							        </thead>
							        <tbody>
							        	<?php
					                        $sql = mysqli_query($con, "SELECT * from pengaduan");
					                        while ($data = mysqli_fetch_array($sql)){
					                    ?>
							            <tr>
							            	<td><?php echo $data['jenis'];?></td>
							                <td><?php echo $data['nama'];?></td>
                                            <td><?php echo $data['deskripsi'];?></td>
                                            <td><img src="image/pengaduan/<?php echo $data['gambar']; ?>" border="0" style="height: 150px;width: 200px"/></td>
                                            <td>
                        					<a href="delete_pengaduan.php?id_pengaduan=<?=$data['id_pengaduan']?>"onclick="return confirm('Yakin akan dihapus ?');"><button class="btn btn-danger"><span class="glyphicon glyphicon-trash"></span> Hapus</button></a></td>
							            </tr>
							            <?php
					                    	}
					                    ?>
							        </tbody>
							    </table>
					        </div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	
	  

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
