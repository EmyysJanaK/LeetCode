SELECT DISTINCT article_id AS id, author_id, viewer_id
FROM Views
WHERE author_id = viewer_id
ORDER BY id ASC;
