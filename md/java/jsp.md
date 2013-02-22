## 得到所有请求参数，cookie的jsp
```Java
ige language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>

<title></title>

</head>

<body>
<%
out.println("<br/><table border='1' cellspacing='0' cellpadding='0' width='700'>");
out.println("<tr><td colspan='2'>Request Headers</td></tr>");
out.println("<tr><td width='300'></td><td width='400'></td></tr>");
out.println("<tr><td>localAddr</td><td>" +
request.getLocalAddr() + "</td></tr>");
out.println("<tr><td>localName</td><td>" +
request.getLocalName() + "</td></tr>");
out.println("<tr><td>localPort</td><td>" +
request.getLocalPort() + "</td></tr>");

out.println("<tr><td>RemoteAddr</td><td>" +
request.getRemoteAddr() + "</td></tr>");
out.println("<tr><td>RemoteHost</td><td>" +
request.getRemoteHost() + "</td></tr>");
out.println("<tr><td>RemotePort</td><td>" +
request.getRemotePort() + "</td></tr>");
out.println("<tr><td>RemoteUser</td><td>" +
request.getRemoteUser() + "</td></tr>");
out.println("</table>");

Enumeration em;

em = request.getHeaderNames();
out.println("<br/><table border='1' cellspacing='0' cellpadding='0' width='700'>");
out.println("<tr><td colspan='2'>Request Headers</td></tr>");
out.println("<tr><td width='300'></td><td width='400'></td></tr>");
while(em.hasMoreElements()){
String paramName = (String)em.nextElement();
out.println("<tr><td>" + paramName + "</td><td>" +
request.getHeader(paramName) + "</td></tr>");
}
out.println("</table>");

em = request.getParameterNames();
out.println("<br/><table border='1' cellspacing='0' cellpadding='0' width='700'>");
out.println("<tr><td colspan='2'>Request Parameter</td></tr>");
out.println("<tr><td width='300'></td><td width='400'></td></tr>");
while(em.hasMoreElements()){
String paramName = (String)em.nextElement();
out.println("<tr><td>" + paramName + "</td><td>" +
request.getParameter(paramName) + "</td></tr>");
}
out.println("</table>");

em = request.getAttributeNames();
out.println("<br/><table border='1' cellspacing='0' cellpadding='0' width='700'>");
out.println("<tr><td colspan='2'>Request Attributes</td></tr>");
out.println("<tr><td width='300'></td><td width='400'></td></tr>");
while(em.hasMoreElements()){
String paramName = (String)em.nextElement();
out.println("<tr><td>" + paramName + "</td><td>" +
request.getAttribute(paramName) + "</td></tr>");
}
out.println("</table>");

em = request.getSession().getAttributeNames();
out.println("<br/><table border='1' cellspacing='0' cellpadding='0' width='700'>");
out.println("<tr><td colspan='2'>Session Attributes</td></tr>");
out.println("<tr><td width='300'></td><td width='400'></td></tr>");
while(em.hasMoreElements()){
String paramName = (String)em.nextElement();
out.println("<tr><td>" + paramName + "</td><td>" +
request.getSession().getAttribute(paramName) + "</td></tr>");
}
out.println("</table>");

em = this.getServletContext().getAttributeNames();
out.println("<br/><table border='1' cellspacing='0' cellpadding='0' width='700'>");
out.println("<tr><td colspan='2'>Context Attributes</td></tr>");
out.println("<tr><td width='300'></td><td width='400'></td></tr>");
while(em.hasMoreElements()){
String paramName = (String)em.nextElement();
out.println("<tr><td>" + paramName + "</td><td>" +
this.getServletContext().getAttribute(paramName) + "</td></tr>");
}
out.println("</table>");

Cookie[] cookies = request.getCookies();
out.println("<br/><table border='1' cellspacing='0' cellpadding='0' width='700'>");
out.println("<tr><td colspan='2'>Cookies</td></tr>");
out.println("<tr><td width='300'></td><td width='400'></td></tr>");
if(cookies!=null){
for(int i = 0; i < cookies.length; i++){
Cookie c = cookies[i];
String paramName = c.getName();
out.println("<tr><td>" + paramName + "</td><td>" +
c.getValue() + "</td></tr>");
}
}
out.println("</table>");
%>
</body>
</html> 

```
