<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
  <html>
  <head>
    <sql:query var="global" dataSource="jdbc/TestDB">
     SELECT *
       FROM information_schema.global_variables 
      WHERE variable_name like '%';
    </sql:query>

  </head>
  <body>
    <h1>MySQL Global Variables Test</h1>
    <table width='600' border='1'>
      <tr>
        <th align='left'>Variable Name</th>
        <th align='left'>Value</th>
      </tr>
      <c:forEach var="row" items="${global.rows}">
        <tr>
           <td>${row.Variable_name}</td>
           <td>${row.variable_value}</td>
       </tr>
      </c:forEach>
    </table>
  </body>
  </html>
