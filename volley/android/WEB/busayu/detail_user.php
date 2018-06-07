<?php
    include "koneksi.php";
    if($_POST['idx']) {
        $id_user = $_POST['idx'];      
        $sql = mysqli_query($con,"SELECT * FROM users WHERE id_user = $id_user");
        while ($result = mysqli_fetch_array($sql)){
		?>
        <form action="edit-user.php" method="post">
            <input type="hidden" name="id" value="<?php echo $result['id_user']; ?>">
            <div class="form-group">
                <label>Username</label>
                <input type="text" class="form-control" name="username" value="<?php echo $result['username']; ?>">
            </div>
            <div class="form-group">
                <label>Password</label>
                <input type="text" class="form-control" name="password" value="<?php echo $result['password']; ?>">
            </div>
            <div class="form-group">
                <label>Email</label>
                <input type="text" class="form-control" name="email" value="<?php echo $result['email']; ?>">
            </div>
            <div class="form-group">
                <label>Level</label>
                <input type="text" class="form-control" name="level" value="<?php echo $result['level']; ?>">
            </div>
            <button class="btn btn-primary" type="submit">Update</button>
        </form>     
        <?php } }
?>