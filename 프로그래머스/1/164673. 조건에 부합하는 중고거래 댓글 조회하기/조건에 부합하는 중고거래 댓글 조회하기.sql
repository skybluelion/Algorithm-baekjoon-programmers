-- 코드를 입력하세요
SELECT A.TITLE, A.BOARD_ID, B.REPLY_ID, B.WRITER_ID, B.CONTENTS, DATE_FORMAT(B.CREATED_DATE, '%Y-%m-%d') AS CREATED_DATE
FROM used_goods_board A 
JOIN used_goods_reply B ON A.board_id = B.board_id 
WHERE DATE_FORMAT(A.CREATED_DATE, '%y-%m') = '22-10' 
ORDER BY B.created_date ASC, A.title ASC