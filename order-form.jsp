<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Order Form</title>
   <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
    <div class="container">
        <h1>Order Form</h1>
        <form action="${order.id != null ? '/orders/' + order.id : '/orders'}" method="post">
            <div class="form-group">
                <label for="userId">User ID</label>
                <input type="text" class="form-control" id="userId" name="userId" value="${order.userId}" required>
            </div>
            <div class="form-group">
                <label for="orderDate">Order Date</label>
                <input type="date" class="form-control" id="orderDate" name="orderDate" value="${order.orderDate}" required>
            </div>
            <div class="form-group">
                <label for="totalAmount">Total Amount</label>
                <input type="number" step="0.01" class="form-control" id="totalAmount" name="totalAmount" value="${order.totalAmount}" required>
            </div>
            <button type="submit" class="btn btn-primary">Save</button>
            <a href="/orders" class="btn btn-secondary">Cancel</a>
        </form>
    </div>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
