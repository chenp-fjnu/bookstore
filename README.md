# Build
```bash
mvn clean package
```
# Run
```bash
java -jar target/bookstore-0.0.1-SNAPSHOT.jar
```
# Swagger UI
`http://localhost:8080/swagger-ui/index.html`

# Restful API

## Add book to store

* add 1st book
```bash
curl -X POST http://localhost:8080/api/books -H "accept: */*" -H "Content-Type: application/json" -d "{\"title\": \"Steve Jobs: The Man Who Thought Different\",\"author\": \"Blumenthal, Karen\",\"price\": 59,\"category\": \"Computers and Internet\"}"
```

* add 2nd book
```bash
curl -X POST http://localhost:8080/api/books -H "accept: */*" -H "Content-Type: application/json" -d "{\"title\": \"The Great Gatsby\",\"author\": \"F.Scott Fitzgerald\",\"price\": 24,\"category\": \"Literature\"}"
```

* add 3rd book
```bash
curl -X POST http://localhost:8080/api/books -H "accept: */*" -H "Content-Type: application/json" -d "{\"title\": \"Who Moved My Cheese\",\"author\": \"Spencer Johnson\",\"price\": 40,\"category\": \"Business\"}"
```

## Get all books
```bash
curl http://localhost:8080/api/books -H "Content-Type: application/json"
```

## Add item to specific cart
### Notes 
* cardId can be different for each user
* bookId should exist in book store
---

* add 1st book to cart 1
```bash
curl -X POST http://localhost:8080/api/carts -H "accept: */*" -H "Content-Type: application/json" -d "{\"cartId\": 1,\"bookId\": 1,\"quantity\": 20}"
```
* add 2nd book to cart 1
```bash
curl -X POST http://localhost:8080/api/carts -H "accept: */*" -H "Content-Type: application/json" -d "{\"cartId\": 1,\"bookId\": 2,\"quantity\": 25}"
```
* add 3rd book to cart 1
```bash
curl -X POST http://localhost:8080/api/carts -H "accept: */*" -H "Content-Type: application/json" -d "{\"cartId\": 1,\"bookId\": 3,\"quantity\": 30}"
```
* add 1st book to cart 2
```bash
curl -X POST http://localhost:8080/api/carts -H "accept: */*" -H "Content-Type: application/json" -d "{\"cartId\": 2,\"bookId\": 2,\"quantity\": 40}"
```
* add 2nd book to cart 2
```bash
curl -X POST http://localhost:8080/api/carts -H "accept: */*" -H "Content-Type: application/json" -d "{\"cartId\": 2,\"bookId\": 3,\"quantity\": 50}"
```

* add non-exist book to cart 2
```bash
curl -X POST http://localhost:8080/api/carts -H "accept: */*" -H "Content-Type: application/json" -d "{\"cartId\": 2,\"bookId\": 5,\"quantity\": 50}"
```

## Get all items in specific cart
* get all items for cart 1
```bash
curl http://localhost:8080/api/carts/1 -H "Content-Type: application/json"
```
* get all items for cart 2
```bash
curl http://localhost:8080/api/carts/2 -H "Content-Type: application/json"
```
## Checkout for specific cart
* checkout for cart 1
```bash
curl http://localhost:8080/api/carts/1/checkout -H "Content-Type: application/json"
```
* checkout for cart 2
```bash
curl http://localhost:8080/api/carts/2/checkout -H "Content-Type: application/json"
```

# Design

## OpenAPI Specification
### ShoppingCartController
POST /api/carts

GET /api/carts/{cartId}

GET /api/carts/{cartId}/checkout

### BookController
GET /api/books

POST /api/books

## Domain Model
* Book
* ShoppingCartItem

## Service
* BookService
* ShoppingCartService

## Repository
* BookRepository
* ShoppingCartRepository


