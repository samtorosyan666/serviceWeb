<%@ page import="java.util.List" %>
<%@ page import="com.service.serviceWeb.model.Visit" %>
<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.0.8/css/all.css">

<div style="background-image:url('../images/2897380.jpg')" >
    <% List<Visit> visits = (List<Visit>) request.getAttribute("visit");%>
    <div class="container">
        <br>
        <h3 class="text-center">Welcome to user home!!!</h3><br>
        <hr>
    </div>
    </aside>
    <div class="container">
        <div class="row col-md-6 col-md-offset-2 custyle">
            <table class="table table-striped custab" border="1" >
                <thead>
                <h4 class="card-title mb-4 mt-1">All visits</h4>
                <tr>
                    <th>ID</th>
                    <th>Employer ID</th>
                    <th>Client ID</th>
                    <th>Car</th>
                    <th>Created Date</th>
                </tr>
                </thead>
                <% for (Visit visit : visits) {%>
                <tr>
                    <td><%=visit.getId()%></td>
                    <td><%=visit.getEmployerId()%></td>
                    <td><%=visit.getClientId()%></td>
                    <td><%=visit.getCar()%></td>
                    <td><%=visit.getCreatedDate()%></td>
                </tr>
                <%
                    }
                %>
            </table>
        </div>
    </div>
</div>

</div>
</div>



