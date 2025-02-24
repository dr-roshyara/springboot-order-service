# Order Service Microservice

This is a **Spring Boot**-based microservice for managing orders. It provides RESTful APIs to create, retrieve, and manage orders. The application uses **MySQL** as the database and **Spring Data JPA** for data access.

---

## **Features**
1. **Create an Order**:
    - Add a new order with details like order number, SKU code, price, and quantity.

2. **Get an Order by ID**:
    - Retrieve an order by its unique ID.

3. **Get All Orders**:
    - Retrieve a list of all orders with pagination support.

4. **Database Integration**:
    - Uses **MySQL** for storing order data.
    - Supports CRUD operations via **Spring Data JPA**.

5. **RESTful APIs**:
    - Follows RESTful principles for API design.
    - Uses proper HTTP methods (`GET`, `POST`) and status codes.

6. **Error Handling**:
    - Global exception handling for consistent error responses.

7. **Validation**:
    - Validates incoming requests using Bean Validation (`@Valid`).

8. **Containerization**:
    - Dockerized for easy deployment.

---

## **Technologies Used**
- **Java 17**
- **Spring Boot 3.x**
- **Spring Data JPA**
- **MySQL**
- **Lombok** (for reducing boilerplate code)
- **Docker** (for containerization)
- **Maven** (for dependency management)

---

## **Prerequisites**
1. **Java Development Kit (JDK) 17 or later**
2. **MySQL** (or any other relational database)
3. **Maven** (for dependency management)
4. **Docker** (optional, for containerization)
5. **Postman** (for testing the APIs)

---

## **Setup and Installation**

### **1. Clone the Repository**
```bash
git clone https://github.com/dr-roshyara/springboot-order-service.git
cd order-service
```

### **2. Configure the Database**
1. Create a MySQL database named `order_service`:
   ```sql
   CREATE DATABASE order_service;
   ```
2. Update the `application.properties` file with your MySQL credentials:
   ```properties
   spring.datasource.url=jdbc:mysql://localhost:3306/order_service?useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true
   spring.datasource.username=root
   spring.datasource.password=mysql
   ```

### **3. Build the Application**
```bash
mvn clean install
```

### **4. Run the Application**
```bash
mvn spring-boot:run
```
The application will start on port `8081`.

---

### **5. Run with Docker (Optional)**
1. Build the Docker image:
   ```bash
   docker build -t order-service .
   ```
2. Run the Docker container:
   ```bash
   docker run -p 8081:8081 order-service
   ```

---

## **API Documentation**

### **Base URL**
```
http://localhost:8081/api/orders
```

### **Endpoints**

#### **1. Create an Order**
- **Method**: `POST`
- **URL**: `/api/orders`
- **Request Body**:
  ```json
  {
    "orderNumber": "ORD123",
    "skuCode": "SKU001",
    "price": 100.0,
    "quantity": 2
  }
  ```
- **Response**:
  ```json
  {
    "id": 1,
    "orderNumber": "ORD123",
    "skuCode": "SKU001",
    "price": 100.0,
    "quantity": 2
  }
  ```

#### **2. Get an Order by ID**
- **Method**: `GET`
- **URL**: `/api/orders/{id}`
- **Response**:
  ```json
  {
    "id": 1,
    "orderNumber": "ORD123",
    "skuCode": "SKU001",
    "price": 100.0,
    "quantity": 2
  }
  ```

#### **3. Get All Orders**
- **Method**: `GET`
- **URL**: `/api/orders`
- **Query Parameters**:
    - `page` (default: `0`)
    - `size` (default: `10`)
- **Response**:
  ```json
  [
    {
      "id": 1,
      "orderNumber": "ORD123",
      "skuCode": "SKU001",
      "price": 100.0,
      "quantity": 2
    },
    {
      "id": 2,
      "orderNumber": "ORD456",
      "skuCode": "SKU002",
      "price": 200.0,
      "quantity": 1
    }
  ]
  ```

---

## **Database Schema**

### **Table: `t_orders`**
| Column Name     | Data Type        | Constraints               |
|-----------------|------------------|---------------------------|
| `id`            | `BIGINT`         | Primary Key, Auto Increment |
| `order_number`  | `VARCHAR(255)`   | Unique, Not Null          |
| `sku_code`      | `VARCHAR(255)`   | Not Null                  |
| `price`         | `DECIMAL(10, 2)` | Not Null                  |
| `quantity`      | `INT`            | Not Null                  |

---

## **Error Handling**
The application provides consistent error responses for common scenarios:
- **400 Bad Request**: Invalid input data.
- **404 Not Found**: Resource not found.
- **500 Internal Server Error**: Unexpected server error.

Example Error Response:
```json
{
  "timestamp": "2025-02-24T20:17:36.934+00:00",
  "status": 404,
  "error": "Not Found",
  "message": "Order not found with ID 1",
  "path": "/api/orders/1"
}
```

---

## **Testing**
### **Unit Tests**
- Use JUnit and Mockito to test individual components (e.g., `OrderService`, `OrderController`).

### **Integration Tests**
- Test the interaction between the Controller, Service, and Repository.

### **Postman**
- Use Postman to test the APIs:
    - Import the Postman collection from the `postman` folder.

---

## **Logging and Monitoring**
- **Logging**: Uses SLF4J with Logback for logging important events and errors.
- **Monitoring**: Integrate with tools like Prometheus and Grafana for performance tracking.

---

## **Deployment**
### **Docker**
1. Build the Docker image:
   ```bash
   docker build -t order-service .
   ```
2. Run the Docker container:
   ```bash
   docker run -p 8081:8081 order-service
   ```

### **CI/CD**
- Set up a CI/CD pipeline (e.g., Jenkins, GitHub Actions) for automated testing and deployment.

---

## **Contributing**
1. Fork the repository.
2. Create a new branch for your feature or bugfix.
3. Submit a pull request.

---

## **License**
This project is licensed under the MIT License. See the [LICENSE](LICENSE) file for details.

---

## **Contact**
For questions or feedback, please contact:
- **Dr. Nab Raj Roshyara**
- **Email**: roshyara@gmail.com
- **GitHub**: [dr-roshyara](https://github.com/dr-roshyara)

---

Thank you for using the **Order Service Microservice**! 🚀