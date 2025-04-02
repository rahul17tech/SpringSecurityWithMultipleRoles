# **SpringSecurityWithMultipleRoles**

Spring Security implemented with two roles (**"USER"** and **"ADMIN"**).

## **Features**
- JWT-based authentication.
- Role-based access control for users and admins.
- Secure role assignment endpoint for **ADMIN**.

## **Technologies Used**
- **Spring Boot**
- **Spring Security**
- **JWT (JSON Web Token)**
- **Oracle Database**

## **Endpoints**
| HTTP Method | Endpoint   | Description |
|------------|------------|-------------|
| POST       | `/register` | Registers a new user. |
| POST       | `/login` | Authenticates user and returns a JWT token. |
| GET        | `/product` | Accessible by users with role `USER` or `ADMIN`. |
| POST       | `/product` | Adds a new product, accessible by `ADMIN`. |
| POST       | `/assign` | Assigns roles to users (Accessible only by `ADMIN`). |

## **Installation and Setup**
1. Clone the repository.
2. Update `application.properties` with necessary configurations.
3. Run the application using `mvn spring-boot:run`.
4. Use tools like **Postman** to test API endpoints.

## **Conclusion**
This project extends the first one by adding an **ADMIN** role with elevated permissions. The `ADMIN` can manage products and assign roles to users.

---
