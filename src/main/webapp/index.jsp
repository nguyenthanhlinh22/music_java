<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">

    <title>JSP - Hello World</title>
</head>
<body>
<!-- Content -->
<div class="container d-flex justify-content-center my-4 mb-5">

    <div id="mobile-box">

        <!-- Card -->
        <div class="card">
            <div class="bg-image hover-overlay ripple" data-mdb-ripple-color="light">
                <img class="card-img-top" src="https://mdbootstrap.com/wp-content/uploads/2019/02/flam.jpg"
                     alt="Card image cap">
                <a href="#!">
                    <div class="mask" style="background-color: rgba(251, 251, 251, 0.15);"></div>
                </a>
            </div>
            <div class="card-body text-center">

                <h5 class="h5 font-weight-bold"><a href="#" target="_blank">Dj Flam</a></h5>
                <p class="mb-0">Urban Bachata remix</p>

                <audio id="music" preload="">
                    <source src="#">
                </audio>
                <div id="audioplayer">
                    <i id="pButton" class="fas fa-play"></i>
                    <div id="timeline">
                        <div id="playhead"></div>
                    </div>
                </div>

            </div>
        </div>
        <!-- Card -->
    </div>
</div>
<!-- Content -->
<br/>
<a href="hello-servlet">Hello Servlet</a>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js" integrity="sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js" integrity="sha384-cVKIPhGWiC2Al4u+LWgxfKTRIcfu0JTxR+EQDz/bgldoEyl4H0zUF0QKbrJ0EcQF" crossorigin="anonymous"></script>

</body>
</html>