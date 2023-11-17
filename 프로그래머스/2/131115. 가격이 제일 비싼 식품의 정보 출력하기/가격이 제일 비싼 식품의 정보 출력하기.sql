SELECT a.product_id, a.product_name, a.product_cd, a.category, a.price
FROM (SELECT product_id, product_name, product_cd, category, price, rank() over(order by price desc) ranking
        FROM food_product) a
WHERE a.ranking = 1; 