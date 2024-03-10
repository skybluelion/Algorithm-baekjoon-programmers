SELECT member_id, member_name, gender, TO_CHAR(date_of_birth, 'yyyy-mm-DD') AS "DATE_OF_BIRTH"
FROM member_profile
WHERE TO_CHAR(date_of_birth, 'mm') = 3 AND gender = 'W' AND TLNO IS NOT NULL
ORDER BY member_id ASC