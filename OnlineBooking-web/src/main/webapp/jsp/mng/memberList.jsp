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
        <link rel="stylesheet" 
              href="https://ajax.googleapis.com/ajax/libs/jqueryui/1.11.2/themes/smoothness/jquery-ui.css" />
        <link rel="stylesheet" type="text/css" href="http://w2ui.com/src/w2ui-1.4.min.css" />
        <link rel="stylesheet" type="text/css" href="../../css/OnlineBokking.css" />
        <title>オンライン授業予約</title>
    </head>
    <body>
        <div id="pagebody"></div>
        <div id="debug">
            <ul id="debugarea"></ul>
        </div>
    </body>
    
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
    <script type="text/javascript" src="http://code.jquery.com/ui/1.10.3/jquery-ui.min.js"></script>
    <script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jqueryui/1.10.3/i18n/jquery-ui-i18n.min.js"></script>
    <script type="text/javascript" src="../../js/lib/jquery.blockUI.js"></script>
    <script type="text/javascript" src="../../js/common/onlineBooking.js"></script>
    <script type="text/javascript" src="../../js/common/validation.js"></script>
    <script type="text/javascript" src="../../js/memberList.js"></script>
    <script type="text/javascript" src="http://w2ui.com/src/w2ui-1.4.min.js"></script>
    <script>
        $(function () {
            w2utils.locale('/src/locale/ja-jp.json');
            // レイアウト初期設定            
            $('#pagebody').w2layout(config.layout);
            w2ui.layout.content('left', $().w2sidebar(config.sidebar));
            w2ui.layout.content('main', $().w2grid(config.grid));
        });
    </script>
</html>
