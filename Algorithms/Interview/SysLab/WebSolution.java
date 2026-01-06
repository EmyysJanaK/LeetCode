package Interview.SysLab;

public class WebSolution {
    //1. There are two users in my project. (I asked how to differentiate between those two.). 
    //Ans: You can differentiate between two users by assigning unique identifiers such as user IDs or usernames to each user. 
    // Additionally, you can implement role-based access control to manage permissions and access levels for different users.
    //simple implementation is to use JWT token where you can store user type in payload.



    //2. How to handle multiple requests at the same time.
    //Ans: To handle multiple requests at the same time, you can implement multithreading
    // or use asynchronous programming techniques. This allows the server to process multiple requests concurrently,
    // improving responsiveness and throughput. Additionally, using load balancers can help distribute incoming requests across multiple servers.

    // if we use jwt payload how to make it secure
    //Ans: To make JWT payload secure, you should follow these best practices:
    //1. Use strong signing algorithms such as RS256 or HS256 to sign the JWT.
    //2. Keep the secret key used for signing the JWT confidential and rotate it periodically.  
    //3. Avoid storing sensitive information in the JWT payload, as it can be decoded by anyone who has access to the token.
    //4. Set appropriate expiration times for the JWT to limit its validity period.

    //if somone change the usertype in jwt payload and send the request how to handle this?
    //Ans: To handle cases where someone changes the user type in the JWT payload, you should always validate the JWT signature on the server side.
    // If the signature is invalid, reject the request. Additionally, implement role-based access control
    // to ensure that users can only access resources and perform actions that are permitted for their assigned roles.

}

// class APIGateway {
//     // API Gateway acts as a reverse proxy to accept all application programming interface (API)
//     // calls, aggregate the various services required to fulfill them, and return the appropriate result.
//     // It is a server that is the single entry point into the system.
//     // It is responsible for request routing, composition, and protocol translation.
        // general implementation in spring boot

        public void apiGatewayExample() {
            // This is a placeholder for an API Gateway implementation.
            // In a real-world scenario, you would use a framework like Spring Cloud Gateway or Netflix Zuul.
            System.out.println("API Gateway is handling requests and routing them to appropriate services.");

        }
// }
// class LoadBalancer {
//     // A load balancer is a device that acts as a reverse proxy and distributes network or application traffic
//     // across a number of servers. Load balancers are used to increase capacity (concurrent users) and reliability of applications.
        // general implementation in spring boot
        