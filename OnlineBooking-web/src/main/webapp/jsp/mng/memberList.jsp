<%-- 
    Document   : memberList
    Created on : 2015/06/16, 0:40:31
    Author     : Eiichi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
    <head id="pageHeader">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="http://w2ui.com/src/w2ui-1.4.2.min.css" />
<!--        <link rel="stylesheet" type="text/css" href="../../css/OnlineBokking.css" />-->
        
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
        <script type="text/javascript" src="http://w2ui.com/src/w2ui-1.4.2.min.js"></script>
        <script type="text/javascript" src="../../js/common/onlineBooking.js"></script>
        <script type="text/javascript" src="../../js/common/validation.js"></script>
        <script type="text/javascript" src="../../js/memberList.js"></script>
        <title>オンライン授業予約</title>
    </head>
    <body>
        <div id="main" style="width: 100%; height: 960px;"></div>
        <div id="debug">
            <ul id="debugarea"></ul>
        </div>
        
        <script>
            $(function (){
                init();
            });
        </script>
    </body>
</html>
