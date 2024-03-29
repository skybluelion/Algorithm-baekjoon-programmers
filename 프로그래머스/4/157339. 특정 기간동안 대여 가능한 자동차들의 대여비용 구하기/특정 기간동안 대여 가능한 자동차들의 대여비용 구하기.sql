SELECT DISTINCT(c.CAR_ID), c.CAR_TYPE, c.DAILY_FEE * 30 * (100 - dp.DISCOUNT_RATE) / 100 AS "FEE"
FROM CAR_RENTAL_COMPANY_CAR c
JOIN CAR_RENTAL_COMPANY_DISCOUNT_PLAN dp ON c.CAR_TYPE = dp.CAR_TYPE
AND dp.DURATION_TYPE = '30일 이상'
LEFT JOIN CAR_RENTAL_COMPANY_RENTAL_HISTORY rh ON c.CAR_ID = rh.CAR_ID
AND (rh.START_DATE <= DATE '2022-11-30' AND rh.END_DATE >= DATE '2022-11-01')
WHERE c.CAR_TYPE IN ('세단', 'SUV')
AND c.DAILY_FEE * 30 * (100 - dp.DISCOUNT_RATE) / 100 BETWEEN 500000 AND 1999999
AND rh.CAR_ID IS NULL
ORDER BY 3 DESC, 2 ASC, 1 DESC;
