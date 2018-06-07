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
	<title>Busayu - Pariwisata</title>
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
				<a class="navbar-brand" href="#"><span>Busayu</span>Admin</a>
				<ul class="nav navbar-top-links navbar-right">
					<li class="dropdown"><a class="dropdown-toggle count-info" data-toggle="dropdown" href="#">
						<em class="fa fa-envelope"></em><span class="label label-danger">15</span>
					</a>
						<ul class="dropdown-menu dropdown-messages">
							<li>
								<div class="dropdown-messages-box"><a href="profile.html" class="pull-left">
									<img alt="image" class="img-circle" src="http://placehold.it/40/30a5ff/fff">
									</a>
									<div class="message-body"><small class="pull-right">3 mins ago</small>
										<a href="#"><strong>John Doe</strong> commented on <strong>your photo</strong>.</a>
									<br /><small class="text-muted">1:24 pm - 25/03/2015</small></div>
								</div>
							</li>
							<li class="divider"></li>
							<li>
								<div class="dropdown-messages-box"><a href="profile.html" class="pull-left">
									<img alt="image" class="img-circle" src="http://placehold.it/40/30a5ff/fff">
									</a>
									<div class="message-body"><small class="pull-right">1 hour ago</small>
										<a href="#">New message from <strong>Jane Doe</strong>.</a>
									<br /><small class="text-muted">12:27 pm - 25/03/2015</small></div>
								</div>
							</li>
							<li class="divider"></li>
							<li>
								<div class="all-button"><a href="#">
									<em class="fa fa-inbox"></em> <strong>All Messages</strong>
								</a></div>
							</li>
						</ul>
					</li>
					<li class="dropdown"><a class="dropdown-toggle count-info" data-toggle="dropdown" href="#">
						<em class="fa fa-bell"></em><span class="label label-info">5</span>
					</a>
						<ul class="dropdown-menu dropdown-alerts">
							<li><a href="#">
								<div><em class="fa fa-envelope"></em> 1 New Message
									<span class="pull-right text-muted small">3 mins ago</span></div>
							</a></li>
							<li class="divider"></li>
							<li><a href="#">
								<div><em class="fa fa-heart"></em> 12 New Likes
									<span class="pull-right text-muted small">4 mins ago</span></div>
							</a></li>
							<li class="divider"></li>
							<li><a href="#">
								<div><em class="fa fa-user"></em> 5 New Followers
									<span class="pull-right text-muted small">4 mins ago</span></div>
							</a></li>
						</ul>
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
				<div class="profile-usertitle-name">Username</div>
				<div class="profile-usertitle-status"><span class="indicator label-success"></span>Online</div>
			</div>
			<div class="clear"></div>
		</div>
		<div class="divider"></div>
		<form role="search">
			<div class="form-group">
				<input type="text" class="form-control" placeholder="Search">
			</div>
		</form>
		<ul class="nav menu">
			<li class="active"><a href="index.php"><em class="fa fa-dashboard">&nbsp;</em> Dashboard</a></li>
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
					<li><a class="" href="#">
						<span class="fa fa-arrow-right">&nbsp;</span> Resto & Cafe
					</a></li>
					<li><a class="" href="kuliner">
						<span class="fa fa-arrow-right">&nbsp;</span> Kuliner
					</a></li>
					<li><a class="" href="Hotel.php">
						<span class="fa fa-arrow-right">&nbsp;</span> Hotel
					</a></li>
					<li><a class="" href="#">
						<span class="fa fa-arrow-right">&nbsp;</span> Travel
					</a></li>
				</ul>
			</li>
				</ul>
			</li>
			</li>
			<li><a href="pengaduan.php"><em cl<ul class="nav menu">
			<li class="active"><a href="index.php"><em class="fa fa-dashboard">&nbsp;</em> Dashboard</a></li>
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
					<li><a class="" href="#">
						<span class="fa fa-arrow-right">&nbsp;</span> Resto & Cafe
					</a></li>
					<li><a class="" href="kuliner">
						<span class="fa fa-arrow-right">&nbsp;</span> Kuliner
					</a></li>
					<li><a class="" href="Hotel.php">
						<span class="fa fa-arrow-right">&nbsp;</span> Hotel
					</a></li>
					<li><a class="" href="#">
						<span class="fa fa-arrow-right">&nbsp;</span> Travel
					</a></li>
				</ul>
			</li>
				</ul>
			</li>ass="fa fa-calendar">&nbsp;</em> Pengaduan</a></li>
			<li><a href="logout.php"><em class="fa fa-power-off">&nbsp;</em> Logout</a></li>
		</ul>
	</div><!--/.sidebar-->
		
	<div class="col-sm-9 col-sm-offset-3 col-lg-10 col-lg-offset-2 main">
		<div class="row">
			<ol class="breadcrumb">
				<li><a href="#">
					<em class="fa fa-home"></em>
				</a></li>
				<li class="active">Pariwisata</li>
			</ol>
		</div><!--/.row-->
		
		<div class="row">
			<div class="col-lg-12">
				<h1 class="page-header">Pariwisata</h1>
			</div>
		</div><!--/.row-->
		<div class="row">
			<div class="col-md-12">
				<div class="panel panel-default">
					<div class="panel-heading">
						Site Traffic Overview
					</div>
					<div class="panel-body">
						<div class="canvas-wrapper">
							<div class="table-responsive">
								<table id="ngoding" class="table table-striped table-bordered">
							        <thead>
							            <tr>
							                <th>Name</th>
							                <th>Position</th>
							                <th>Office</th>
							                <th>Age</th>
							                <th>Start date</th>
							                <th>Salary</th>
							            </tr>
							        </thead>
							        <tbody>
							            <tr>
							                <td>Tiger Nixon</td>
							                <td>System Architect</td>
							                <td>Edinburgh</td>
							                <td>61</td>
							                <td>2011/04/25</td>
							                <td>$320,800</td>
							            </tr>
							            <tr>
							                <td>Garrett Winters</td>
							                <td>Accountant</td>
							                <td>Tokyo</td>
							                <td>63</td>
							                <td>2011/07/25</td>
							                <td>$170,750</td>
							            </tr>
							            <tr>
							                <td>Ashton Cox</td>
							                <td>Junior Technical Author</td>
							                <td>San Francisco</td>
							                <td>66</td>
							                <td>2009/01/12</td>
							                <td>$86,000</td>
							            </tr>
							            <tr>
							                <td>Cedric Kelly</td>
							                <td>Senior Javascript Developer</td>
							                <td>Edinburgh</td>
							                <td>22</td>
							                <td>2012/03/29</td>
							                <td>$433,060</td>
							            </tr>
							            <tr>
							                <td>Airi Satou</td>
							                <td>Accountant</td>
							                <td>Tokyo</td>
							                <td>33</td>
							                <td>2008/11/28</td>
							                <td>$162,700</td>
							            </tr>
							            <tr>
							                <td>Brielle Williamson</td>
							                <td>Integration Specialist</td>
							                <td>New York</td>
							                <td>61</td>
							                <td>2012/12/02</td>
							                <td>$372,000</td>
							            </tr>
							            <tr>
							                <td>Donna Snider</td>
							                <td>Customer Support</td>
							                <td>New York</td>
							                <td>27</td>
							                <td>2011/01/25</td>
							                <td>$112,000</td>
							            </tr>
							        </tbody>
							        <tfoot>
							            <tr>
							                <th>Name</th>
							                <th>Position</th>
							                <th>Office</th>
							                <th>Age</th>
							                <th>Start date</th>
							                <th>Salary</th>
							            </tr>
							        </tfoot>
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
	    <script type="text/javascript" src="datatables/media/js/jquery.js"></script>
    <script type="text/javascript" src="datatables/media/js/jquery.dataTables.js"></script>
    <script type="text/javascript">
	    $(document).ready( function () {
	        $('#ngoding').DataTable();
	    } );
    </script>
</body>
</html>
