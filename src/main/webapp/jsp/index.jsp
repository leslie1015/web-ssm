<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>

 <jsp:include page="../common/jsp/common_head.jsp"/>
 <title>Bootstrap Basic Template</title>

</head>

<body>

<div class="row">
  <div class="col-3">
   key： ${parameter.paramKey}<br>
  </div>
 <div class="col-3">
  value：${parameter.paramValue}<br>
 </div>
</div>

<button type="button" class="btn btn-primary">Hello World!666</button>

</body>
</html>