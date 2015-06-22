USE onlinebooking;
-- メンバーグループへの初期登録
INSERT INTO MEMBER_GROUP VALUES (
    '1', 
    'administrators'
);

INSERT INTO MEMBER_GROUP VALUES (
    '2', 
    'students'
);

INSERT INTO MEMBER_GROUP VALUES (
    '3', 
    'teachers'
);

-- メンバーテーブルへのテストユーザ登録
INSERT INTO MEMBER VALUES (
    'A0001',
    '5E884898DA28047151D0E56F8DC6292773603D0D6AABBDD62A11EF721D1542D8',
    '管理者(名)',
    '管理者(姓)',
    'カンリシャメイ',
    'カンリシャセイ',
    '19000101',
    'administrator',
    '03-1234-9876',
    'administrator@onlinebooking.com',
    '1350021',
    '東京都',
    '江東区白河',
    '４丁目',
    null
);

-- メンバーグループ関連テーブルへの登録
INSERT INTO R_MEMBER_GROUP VALUES (
	'A0001',
	'0001'
);

COMMIT;