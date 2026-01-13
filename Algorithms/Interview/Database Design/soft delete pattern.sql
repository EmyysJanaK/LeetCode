-- Schema for blog posts where deleted posts should be recoverable
-- and not shown to users, but remain in the database.

CREATE TABLE blog_posts (
    post_id INT PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    content TEXT NOT NULL,
    author_id INT NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    is_deleted BOOLEAN DEFAULT FALSE, -- Soft delete flag
    deleted_at TIMESTAMP NULL, -- Timestamp for when the post was deleted
    FOREIGN KEY (author_id) REFERENCES authors(author_id)
);

-- Example of how to "soft delete" a blog post
-- UPDATE blog_posts
-- SET is_deleted = TRUE, deleted_at = CURRENT_TIMESTAMP
-- WHERE post_id = 1;
-- Example of how to query for non-deleted blog posts
-- SELECT * FROM blog_posts 
-- WHERE is_deleted = FALSE;
-- Example of how to "restore" a soft-deleted blog post
-- UPDATE blog_posts
-- SET is_deleted = FALSE, deleted_at = NULL
-- WHERE post_id = 1;   