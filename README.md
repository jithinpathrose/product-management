# product-management
Management of Banking Products based on rules

Java version : 17,
Kotlin code : none,
Maven : 3.8.1.

# Application class 

Run ProductManagementApplication.java file as java application

# Endpoints

1. GET /product/myProducts -> Gets all the products based on the Customer questions. The products will be empty if no
products are added to the system through the POST endpoint.
2. POST /product/addProduct -> Adds a new Product to the system.
3. GET /product/allProducts -> Gets all products in the system.

# Rules

Rules are present in the src/main/resources folder.

# Repository

In memory java.util.Map implementation to store the products.

# Unit Tests

Tests are available in src/test/java

# logger

No logger implemented


