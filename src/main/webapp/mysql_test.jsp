<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
  <html>
  <head>

    <sql:query var="checks" dataSource="jdbc/TestDB">
       select * from checks
    </sql:query>

  </head>
  <body>
    <h1>JDBC JNDI Resource Test</h1>
    <table width='600' border='1'>
      <tr>
        <th align='left'>Service ID</th>
        <th align='left'>Name</th>
        <th align='left'>Type</th>
      </tr>
      <c:forEach var="checks" items="${checks.rows}">
        <tr>
           <td> ${checks.id}</td>
           <td> ${checks.service_name} </td>
           <td> ${checks.service_type} </td>
       </tr>
      </c:forEach>
    </table>
  </body>
  </html>
