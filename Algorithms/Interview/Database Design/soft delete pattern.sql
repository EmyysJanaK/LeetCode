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


-- in micro services architecture, what would happen if one microservice has an issue in it will it affect the whole system?
-- In a microservices architecture, if one microservice experiences an issue, it typically does not bring down the entire system. Each microservice operates independently, so a failure in one service can be isolated. However, the overall system's functionality may be affected if other services depend on the failing service. To mitigate this, strategies such as circuit breakers, retries, and fallbacks are often implemented to handle failures gracefully and maintain system resilience.
-- circuit breaker is a design pattern used in microservices architecture to prevent cascading failures and improve system resilience. It works by monitoring the number of failed requests to a particular service and, if the failures exceed a certain threshold, it "trips" the circuit breaker. When tripped, the circuit breaker stops further requests to the failing service for a specified period, allowing it time to recover. During this time, fallback mechanisms can be employed to provide alternative responses or degrade functionality gracefully. Once the timeout period elapses, the circuit breaker allows a limited number of test requests to check if the service has recovered before fully closing the circuit again. This pattern helps maintain overall system stability and responsiveness in the face of service failures.
--expand the system when there are more users - 
-- To expand a microservices system to handle more users, several strategies can be employed:
-- 1. Horizontal Scaling: Add more instances of the microservices to distribute the load. This can be done using container orchestration tools like Kubernetes or Docker Swarm.
-- 2. Load Balancing: Implement load balancers to evenly distribute incoming requests across multiple instances of each microservice.
-- 3. Database Scaling: Use database sharding, replication, or partitioning to handle increased data loads and improve read/write performance.
-- 4. Caching: Implement caching mechanisms (e.g., Redis, Memcached) to reduce the load on databases and speed up response times for frequently accessed data.
-- 5. Asynchronous Processing: Use message queues (e.g., RabbitMQ, Kafka) to handle tasks asynchronously, allowing services to process requests without blocking.
-- 6. Optimize Code and Queries: Regularly profile and optimize the code and database queries
-- to improve performance and reduce latency.
-- 7. Monitoring and Auto-scaling: Implement monitoring tools to track performance metrics and set



