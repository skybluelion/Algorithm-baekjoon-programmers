-- 코드를 입력하세요
SELECT COUNT(DISTINCT(NAME)) as"count"
FROM animal_ins
WHERE name IS NOT NULL;