<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>Busayu - Login</title>
	<link href="css/bootstrap.min.css" rel="stylesheet">
	<link href="css/datepicker3.css" rel="stylesheet">
	<link href="css/styles.css" rel="stylesheet">
	<!--[if lt IE 9]>
	<script src="js/html5shiv.js"></script>
	<script src="js/respond.min.js"></script>
	<![endif]-->
</head>
<body>
	<div class="row">
		<div class="col-xs-10 col-xs-offset-1 col-sm-8 col-sm-offset-2 col-md-4 col-md-offset-4">
			<div class="login-panel panel panel-default">
				<div>
					<img weight="300px" height="200px" padding="0" src="../busayu/image/icooon.png">
				</div>
			</div>
		</div><!-- /.col-->
	</div><!-- /.row -->	

	<div class="row">
		<div class="col-xs-10 col-xs-offset-1 col-sm-8 col-sm-offset-2 col-md-4 col-md-offset-4">
			<div class="login-panel panel panel-default">
				<div class="panel-heading" align="center"><strong>Log in</strong></div>
				<div class="panel-body">
					<form role="form" method="post" action="cek_login.php">
						<fieldset>
							<div class="form-group">
								<input class="form-control" placeholder="Username" name="username" type="username" autofocus="">
							</div>
							<div class="form-group">
								<input class="form-control" placeholder="Password" name="password" type="password" value="">
							</div>
							<img class="imgcaptcha" src="captcha.php" alt="Kode Acak" style="margin-bottom: 10px" />
							<div class="form-group">
								<input class="form-control" placeholder="captcha" name="captcha" type="text" value="">
							</div>
							<input type="submit" name="simpan" class="btn btn-primary" style="padding: 5px 180px;" value="Masuk"></input></fieldset>
					</form>
				</div>
			</div>
		</div><!-- /.col-->
	</div><!-- /.row -->	
	

<script src="js/jquery-1.11.1.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
</body>
</html>
