-- 코드를 입력하세요 이름별 조회/ 쓰인 횟수 2번이상
SELECT name, count(name) AS count
FROM animal_ins
WHERE name IS NOT NULL
GROUP BY name
HAVING count(name) > 1
ORDER BY name;




