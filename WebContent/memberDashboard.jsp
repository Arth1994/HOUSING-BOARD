<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Member - Home Page</title>
</head>
<body>
<h1>Your User Details are as follows:-</h1>

${user.name}

<a href="${user}"></a>
<br/><br/><br/><br/>
<form action="/HousingBoard/updateprofile/dataretrieve" method="post">
     			<input type="submit" value="Update details" />
            </form>

<a href ="AdForm.jsp">Manage Ads</a><br/><br/><br/>s
</form>
</body>
</html>