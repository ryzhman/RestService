<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Landing page</title>
</head>
<body>

<h1>Hello in REST Service</h1>
To use service type 
http://localhost:8080/Rest.api/getprice?mpn=ball&availability=1&pricesort=0
where mpn - name of article, 
availability = 0 - unsorted;
availability = 1 - enough;
availability = 2 - lots of;

pricesort = 0 - unsorted;
pricesort = 1 - ASC;
pricesort = 2 - DESC;


</body>
</html>