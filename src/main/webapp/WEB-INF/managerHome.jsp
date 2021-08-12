<%@ page import="com.service.serviceWeb.model.Client" %>
<%@ page import="java.util.List" %>
<%@ page import="com.service.serviceWeb.model.Employer" %>
<%@ page import="com.service.serviceWeb.model.Visit" %>
<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>


<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.0.8/css/all.css">

<div style="background-image:url('../images/2897380.jpg')" >
<% List<Client> clients = (List<Client>) request.getAttribute("allClients"); %>
<% List<Employer> employers = (List<Employer>) request.getAttribute("allEmployers");%>
<% List<Visit> visits = (List<Visit>) request.getAttribute("allVisits");%>
<div class="container">
    <br>
    <h3 class="text-center">Welcome to manager home!!!</h3><br>
    <h4 class="text-center">Scroll down to see all clients and all visits tables!!!</h4>
    <hr>
    <div class="row">
        <aside class="col-sm-4">
            <div class="card">
                <article class="card-body">
                    <h4 class="card-title mb-4 mt-1">Register user</h4>
                    <form action="/userRegister" method="post">
                        <div class="form-group">
                            <label>User's name</label>
                            <input type="text" name="name" class="form-control" placeholder="Email">
                        </div>
                        <div class="form-group">
                            <label>User's surname</label>
                            <input type="text" name="surname" class="form-control" placeholder="Surname">
                        </div>
                        <div class="form-group">
                            <label>User's email</label>
                            <input type="text" name="email" class="form-control" placeholder="Email">
                        </div>
                        <div class="form-group">
                            <label>User's password</label>
                            <input type="password" name="password" class="form-control" placeholder="*****">
                        </div>
                        <div class="form-group">
                            <label>User's number</label>
                            <input type="number" name="number" class="form-control" placeholder="Number">
                        </div>
                        <div class="form-group">
                            <label>User's type</label>
                            <select name="type">
                                <option value="USER">USER</option>
                                <option value="MANAGER">MANAGER</option>
                            </select>
                        </div><br>
                        <div class="form-group">
                            <button type="submit" class="btn btn-primary btn-block">Add user</button>
                        </div>

                    </form>
                </article>
            </div>

        </aside>
        <aside class="col-sm-4">

            <div class="card">
                <article class="card-body">
                    <h4 class="card-title mb-4 mt-1">Add visit</h4>
                    <hr>
                    <form action="/addVisit">
                        <div class="form-group">
                            <label>Employer id</label>
                            <input type="number" name="employer_id" class="form-control" placeholder="Employer Id">
                        </div>
                        <div class="form-group">
                            <label>Client id</label>
                            <input type="number" name="client_id" class="form-control" placeholder="Client id">
                        </div>
                        <div class="form-group">
                            <label>User's car</label>
                            <select name="car">
                                <option value="MERCEDES">MERCEDES</option>
                                <option value="BMW">BMW</option>
                                <option value="TOYOTA">TOYOTA</option>
                            </select>
                        </div>
                        <div class="form-group">
                            <label>Visit date</label>
                            <input type="date" name="created_date" class="form-control" placeholder="Created date">
                        </div>
                        <div class="form-control">
                            <label>Choose the client</label>
                            <select name="client_id">
                                <%
                                    for (Client client : clients) {

                                %>

                                <option value="<%=client.getId()%>"><%=client.getName()%> <%=client.getSurname()%>

                                </option>

                                <% }

                                %>

                            </select><br>

                        </div>
                        <div class="form-control">
                            <label>Choose the employer</label>
                        <select name="employer_id">

                                <%
                                    for (Employer employer : employers) {%>
                            <option value="<%=employer.getId()%>"><%=employer.getProfession()%> <%=employer.getContact()%>

                                <%
                                    }
                                %>

                        </select>
                        </div><br>
                        <div class="form-group">
                            <button type="submit" class="btn btn-primary btn-block">Add visit</button>
                        </div>
                    </form>
                </article>
            </div> <!-- card.// -->
        </aside>

                <div class="row col-md-6 col-md-offset-2 custyle">
                    <table class="table table-striped custab" border="1" >
                        <thead>
                        <h4 class="card-title mb-4 mt-1">All clients</h4>
                        <tr>
                            <th>ID</th>
                            <th>Name</th>
                            <th>Surname</th>
                            <th>Email</th>
                            <th>Number</th>
                            <th>Type</th>
                        </tr>
                        </thead>
                        <% for (Client client : clients) {%>
                        <tr>
                            <td><%=client.getId()%></td>
                            <td><%=client.getName()%></td>
                            <td><%=client.getSurname()%></td>
                            <td><%=client.getEmail()%></td>
                            <td><%=client.getNumber()%></td>
                            <td><%=client.getType()%></td>
                        </tr>
                            <%
                        }
                        %>
                    </table>
                </div>
            </div>
                </article>
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



