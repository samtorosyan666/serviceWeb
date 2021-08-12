<link href="../css/register.css" rel="stylesheet" id="bootstrap-css">
<script src="//netdna.bootstrapcdn.com/bootstrap/3.0.3/js/bootstrap.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<!------ Include the above in your HEAD tag ---------->

<!Doctype html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Registration Form</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
</head>
<body>
<div class="container">
    <!---heading---->
    <header class="heading"> Registration-Form</header><hr></hr>
    <!---Form starting---->
    <div class="row ">
        <form action="/clientRegister" method="post">
        <!--- For Name---->
        <div class="col-sm-12">
            <div class="row">
                <div class="col-xs-4">
                    <label class="firstname">Name :</label> </div>
                <div class="col-xs-8">
                    <input type="text" name="name" id="fname" placeholder="Enter your name" class="form-control ">
                </div>
            </div>
        </div>
        <div class="col-sm-12">
            <div class="row">
                <div class="col-xs-4">
                    <label class="lastname">Surname :</label></div>
                <div class ="col-xs-8">
                    <input type="text" name="surname" id="lname" placeholder="Enter your surname" class="form-control last">
                </div>
            </div>
        </div>

        <div class="col-sm-12">
            <div class="row">
                <div class="col-xs-4">
                    <label class="lastname">Email :</label></div>
                <div class ="col-xs-8">
                    <input type="email" name="email" id="lname" placeholder="Enter your email" class="form-control last">
                </div>
            </div>
        </div>

        <div class="col-sm-12">
            <div class="row">
                <div class="col-xs-4">
                    <label class="lastname">Password :</label></div>
                <div class ="col-xs-8">
                    <input type="password" name="password" id="lname" placeholder="Enter your password" class="form-control last">
                </div>
            </div>
        </div>

        <div class="col-sm-12">
            <div class="row">
                <div class="col-xs-4">
                    <label class="lastname">Number :</label></div>
                <div class ="col-xs-8">
                    <input type="number" name="number" id="lname" placeholder="Enter your phone number" class="form-control last">
                </div>
            </div>
        </div>
        <!-----For email---->
        <div class="col-sm-12">
            <div class="row">
                <div class="col-xs-4">
                    <label class="lastname">Type :</label></div>
                   <select name="type">
                       <option value="USER" id="lname" class="form-control last">USER</option>
                   </select>
            </div>
        </div>
        <!-----For Password and confirm password---->
        <div class="col-sm-12">
            <div class="row">
                <div class="col-xs-4">
                    <label class="pass">Password :</label></div>
                <div class="col-xs-8">
                    <input type="password" name="password" id="password" placeholder="Enter your Password" class="form-control">
                </div>
            </div>
        </div>
        <div class="col-sm-12">
                <div type="submit" class="btn btn-warning">Register</div>
            </div>
        </form>
        </div>
    </div>


</div>

</body>
</html>

