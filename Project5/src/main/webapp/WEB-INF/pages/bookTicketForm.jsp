<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Book Ticket</title>

    <!-- Bootstrap CSS -->
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-pzjw8f+ua7Kw1TIq0v8FqLEHf0Bsz1Lh3RsFq9eZgr7yZlI3zzF5N3TtkcICg0fB" crossorigin="anonymous">
</head>
<body>

    <div class="container mt-5">
        <h1 class="text-center mb-4">Book Ticket</h1>

        <form action="${pageContext.request.contextPath}/bookTicketForm" method="POST">
            <div class="form-group">
                <label for="fromStation">From Station:</label>
                <input type="text" class="form-control" id="fromStation" name="fromStation" required>
            </div>

            <div class="form-group">
                <label for="toStation">To Station:</label>
                <input type="text" class="form-control" id="toStation" name="toStation" required>
            </div>

            <div class="form-group">
                <label for="passengerName">Passenger Name:</label>
                <input type="text" class="form-control" id="passengerName" name="passengerName" required>
            </div>

            <div class="form-group">
                <label for="noOfTickets">Number of Tickets:</label>
                <input type="number" class="form-control" id="noOfTickets" name="noOfTickets" required>
            </div>

            <div class="form-group">
                <label for="travelDate">Travel Date (YYYY-MM-DD):</label>
                <input type="text" class="form-control" id="travelDate" name="travelDate" required>
            </div>

            <div class="text-center">
                <button type="submit" class="btn btn-primary">Book Ticket</button>
            </div>
        </form>
    </div>

    <!-- Bootstrap JS, Popper.js, and jQuery -->
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy5/Xv7p6pVhEO6gs68nBsa+PpRz6JWh3bQlr/2V" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js" integrity="sha384-I0v9jJr9qSt5NY9hAYYO44STptc6LMkZe/0w/XU2D6EV9u51jl5zxHkHohm1vYke" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js" integrity="sha384-pzjw8f+ua7Kw1TIq0v8FqLEHf0Bsz1Lh3RsFq9eZgr7yZlI3zzF5N3TtkcICg0fB" crossorigin="anonymous"></script>
</body>
</html>
