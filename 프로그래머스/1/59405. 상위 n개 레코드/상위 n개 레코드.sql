-- 코드를 입력하세요
SELECT a.NAME 
FROM 
(SELECT NAME, RANK() OVER (ORDER BY DATETIME ASC) AS RANKING FROM ANIMAL_INS) a
WHERE a.RANKING = 1