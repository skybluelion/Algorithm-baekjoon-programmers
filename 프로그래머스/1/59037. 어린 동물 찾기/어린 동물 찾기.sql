-- 코드를 입력하세요
SELECT ANIMAL_ID, NAME
FROM ANIMAL_INS
WHERE NOT intake_condition = 'Aged'
ORDER BY animal_id;