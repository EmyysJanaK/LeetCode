# Write your MySQL query statement below
-- CREATE INDEX idx_low_fats_recyclable ON Products(low_fats, recyclable);


SELECT product_id 
FROM Products
WHERE low_fats = True and recyclable = True ;