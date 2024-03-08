-- SELECT TO_CHAR(apnt_ymd, 'yyyy-MM')
-- FROM appointment

SELECT mcdp_cd AS "진료과코드", COUNT(*) AS "5월예약건수"
FROM appointment
WHERE TO_CHAR(apnt_ymd, 'yyyy-MM') = '2022-05'
GROUP BY mcdp_cd
ORDER BY "5월예약건수" ASC, "진료과코드" ASC