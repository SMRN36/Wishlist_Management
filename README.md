# Wishlist Management 

This is the backend application designed to manage wishlists for an online shopping platform. It's built using Spring Boot, Spring Security with JWT authentication, and Spring Data JPA.

## Features

- **User Authentication:** Secure signup and login using Spring Security with JWT authentication.
- **Wishlist Management:** RESTful API endpoints to create and delete wishlist items.
- **Database Integration:** Works with a relational database using Spring Data JPA to store user information and wishlist items.

### Installation

1. **Clone the repository:**

    ```
    git clone https://github.com/SMRN36/Wishlist_Management.git
    ```
    

2. **Build the project with Maven:**

    ```
    mvn clean install
    ```

### Running the Application

- Run the application using Maven:

    ```
    mvn spring-boot:run
    ```

- The application will start on the default port `8080`.

### API Usage

- **Sign Up:**
    - Send a POST request to `http://localhost:8080/auth/register` with user details in JSON format.

- **Login:**
    - Send a POST request to `http://localhost:8080/auth/login` with user credentials in JSON format.

- **Note:** Save the JWT token received in the response.

- **Accessing Other APIs:**
    - Include the JWT token in the Authorization header for authenticated requests.
    - Use these endpoints for other API functionalities:
        - Wishlist: `http://localhost:8080/api/wishlists`
        - Products: `http://localhost:8080/api/products`
