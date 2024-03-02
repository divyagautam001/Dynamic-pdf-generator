# Dynamic PDF Generator

a Spring Boot Application with REST API to generate PDF using Java Template Engine Thymeleaf.
Requirement

### Features -
```text
1. Generate pdf from given BuyerSellerDetails Synchronously
2. Generate pdf from given BuyerSellerDetails Asynchronously
3. Store the above-generated PDF on the local storage
4. Download generated pdf
5. Validation on input request
6. Exception handling to return proper Error Response
```

### API Endpoints -
postman collection json is provided to import - Dynamic PDF Generator.postman_collection.json

ASYNC POST http://localhost:8082/api/generate-pdf
```
curl --location 'http://localhost:8082/api/generate-pdf' \
        --header 'Content-Type: application/json' \
        --data '{
        "seller": "XYZ Pvt. Ltd.",
        "sellerGstin": "46KZAHM6385P6Z2",
        "sellerAddress": "New Delhi, India",
        "buyer": "Vedant Computers",
        "buyerGstin": "16BZAHM6385P6Z2",
        "buyerAddress": "New Delhi, India",
        "items": [
        {
        "name": "Product 2",
        "quantity": "2 Nos",
        "rate": 222.00,
        "amount": 2222.00
        },
        {
        "name": "Product 1",
        "quantity": "12 Nos",
        "rate": 123.00,
        "amount": 1476.00
        },
        {
        "name": "Product 1",
        "quantity": "12 Nos",
        "rate": 123.00,
        "amount": 1476.00
        }
        ]
        }'
```
SYNC POST http://localhost:8082/api/sync/generate-pdf
```text
same payload as above
```
GET http://localhost:8082/api/pdf/pdfname.pdf

-----
### Validations on BuyerSellerDetails -
```
seller - length 1 to 40
buyer - length 1 to 40
sellerGstin - 
        It should be 15 characters long.
        The first 2 characters should be a number.
        The next 10 characters should be the PAN number of the taxpayer.
        The 13th character (entity code) should be a number from 1-9 or an alphabet.
        The 14th character should be Z.
        The 15th character should be an alphabet or a number.
buyerGstin - 
        It should be 15 characters long.
        The first 2 characters should be a number.
        The next 10 characters should be the PAN number of the taxpayer.
        The 13th character (entity code) should be a number from 1-9 or an alphabet.
        The 14th character should be Z.
        The 15th character should be an alphabet or a number.
```
-----
### ValidGstin's -
```
06BZAHM6385P6Z2
17AZAHM6385P6Z2
26VZAHM6385P6Z2
36DZAHM6385P6Z2
46KZAHM6385P6Z2
```

### ISSUES -

pdf generator not picking up css folder under static solution -
https://stackoverflow.com/questions/53203909/spring-boot-thymeleaf-css-is-not-applied-to-template