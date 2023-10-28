SELECT DATETIME as 시간
FROM 
(SELECT DATETIME, RANK() OVER(ORDER BY datetime) as 순위
FROM animal_ins) a
WHERE 순위 = 1;