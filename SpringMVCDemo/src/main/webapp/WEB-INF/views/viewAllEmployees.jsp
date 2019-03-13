<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
 
<html>
<head>
    <title>Spring MVC Hello World</title>
</head>
 
<body>
    <h2>All Employees in System</h2>
 
    <table border="1">
        <tr>
            <th>Employee Id</th>
            <th>First Name</th>
            <th>Last Name</th>
            <th>Email Address</th>
            <th>Department</th>
            <th>Employee Photo</th>
        </tr>
        <c:forEach items="${allEmployees}" var="employee">
            <tr>
                <td>${employee.employeeId}</td>
                <td>${employee.firstName}</td>
                <td>${employee.lastName}</td>
                <td>${employee.emailAddress}</td>
                <td>${employee.department}</td>
                <td>  
                 <c:forEach items="${employee.images}" var="image">
                   <li>${image.originalFilename}
                   <img width="100" src="<c:url value="${pageContext.request.servletPath}/WEB-INF/image/"/>${image.originalFilename}"/>
                   </li>
                 </c:forEach> 
               </td>
            </tr>
            
            
        </c:forEach>
    </table>
 
</body>
</html>