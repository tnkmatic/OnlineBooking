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

-- 性別マスタへの初期登録
INSERT INTO MST_GENDER VALUES ('1', '男性');
INSERT INTO MST_GENDER VALUES ('2', '女性');

-- 連絡方法区分マスタへの初期登録
INSERT INTO MST_CONTACT_WAY VALUES ('1', '電話');
INSERT INTO MST_CONTACT_WAY VALUES ('2', 'メール');

-- 雇用形態マスタへの初期登録
INSERT INTO MST_EMPLOY VALUES ('1', '正社員');
INSERT INTO MST_EMPLOY VALUES ('2', '契約社員');
INSERT INTO MST_EMPLOY VALUES ('3', '派遣社員');
INSERT INTO MST_EMPLOY VALUES ('4', 'パート／アルバイト');

-- コースマスタへの初期登録
INSERT INTO MST_COURSE VALUES ('1', 'Javaオブジェクト指向編(初級コース)');
INSERT INTO MST_COURSE VALUES ('2', '独習Javaサーバサイド編(中級コース)');
INSERT INTO MST_COURSE VALUES ('3', 'JavaEE6(マスタコース)');
INSERT INTO MST_COURSE VALUES ('4', 'JavaScript(初級コース)');


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