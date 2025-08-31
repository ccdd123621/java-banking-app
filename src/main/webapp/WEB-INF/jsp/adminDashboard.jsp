<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Admin Dashboard</title>
    <link rel="stylesheet" href="<c:url value='/resources/css/style.css' />">
    <style>
        body {
            font-family: Arial, sans-serif;
            background: #f7f9fb;
            margin: 0;
            padding: 0;
        }
        header {
            background: #003366;
            color: #fff;
            padding: 15px;
            text-align: center;
        }
        nav {
            background: #0059b3;
            padding: 10px;
        }
        nav a {
            color: white;
            text-decoration: none;
            margin: 0 15px;
            font-weight: bold;
        }
        nav a:hover {
            text-decoration: underline;
        }
        .container {
            margin: 20px;
        }
        .card {
            background: #fff;
            border-radius: 8px;
            box-shadow: 0 2px 6px rgba(0,0,0,0.1);
            padding: 20px;
            margin-bottom: 20px;
        }
        .card h2 {
            margin-top: 0;
            color: #003366;
        }
    </style>
</head>
<body>

<header>
    <h1>Admin Dashboard</h1>
</header>

<nav>
    <a href="<c:url value='/role/list' />">Manage Roles</a>
    <a href="<c:url value='/user/list' />">Manage Users</a>
    <a href="<c:url value='/branch/list' />">Manage Branches</a>
    <a href="<c:url value='/account/list' />">Manage Accounts</a>
    <a href="<c:url value='/transaction/list' />">Transactions</a>
    <a href="<c:url value='/loan/list' />">Loans</a>
    <a href="<c:url value='/report/list' />">Reports</a>
    <a href="<c:url value='/logout' />">Logout</a>
</nav>

<div class="container">
    <div class="card">
        <h2>Welcome, Admin</h2>
        <p>You can manage system-wide configurations, users, roles, accounts, transactions, and reports from here.</p>
    </div>

    <div class="card">
        <h2>Quick Stats</h2>
        <ul>
            <li>Total Users: <strong>${totalUsers}</strong></li>
            <li>Total Branches: <strong>${totalBranches}</strong></li>
            <li>Total Accounts: <strong>${totalAccounts}</strong></li>
            <li>Total Loans: <strong>${totalLoans}</strong></li>
        </ul>
    </div>
</div>

</body>
</html>
