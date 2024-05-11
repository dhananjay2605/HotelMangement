# HotelMangement

* Using Java 13 for this project

1) This project provides a RESTful API for user authentication using JSON Web Tokens (JWT). It includes an endpoint for generating JWT tokens based on user credentials. For accessing different api in this project you have to create jwt token first by this API then use it to different access another API's.

Endpoints:

Get JWT Token
URL: /token
Method: POST
Description: Generate a JWT token for user authentication.
Request Body: JSON object representing the user's credentials

curl:-

curl --location 'http://localhost:8080/token' \
--header 'Content-Type: application/json' \
--data '{
    "userName": "Dhananjay",
    "password": "Dhananjay"
}


1) Create Hotel
URL: /hotel/createHotel
Method: POST
Description: Create a new hotel.
Request Body: JSON object representing the hotel details
 
curl :- 
curl --location 'localhost:8080/hotel/createHotel' \
--header 'Authorization: Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJEaGFuYW5qYXkiLCJleHAiOjE3MTU0NDIxMjksImlhdCI6MTcxNTQwNjEyOX0.Axl2hIZIDCHO-adCj2Hoo5z2dW4cnwDPhLbsKB72Fx4' \
--header 'Content-Type: application/json' \
--data '{
    "hotelName":"VCom hotel",
    "location": "Delhi",
    "about": "Best Experience in Varanasi",
    "chargePerHead": 500
}'

2) Get All Hotels
URL: /hotel/getAllHotel
Method: GET
Description: Retrieve all hotels.
Response: Returns a list of all hotels.
json

curl:-
curl --location 'localhost:8080/hotel/getAllHotel' \
--header 'Content-Type: application/json' \
--header 'Cookie: JSESSIONID=75D714566BE9B8EF9C4540039E2F6DCB' \
--header 'Authorization: Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJEaGFuYW5qYXkiLCJleHAiOjE3MTU0NDIxMjksImlhdCI6MTcxNTQwNjEyOX0.Axl2hIZIDCHO-adCj2Hoo5z2dW4cnwDPhLbsKB72Fx4'

3) Get Hotel by Location
URL: /hotel/getByLocation
Method: GET
Parameters:
location (String): Location of the hotel.
Description: Retrieve hotels by location.
Response: Returns a list of hotels matching the specified location

curl --location --request GET 'localhost:8080/hotel/getByLocation?location=Agra' \
--header 'Content-Type: application/json' \
--header 'Cookie: JSESSIONID=75D714566BE9B8EF9C4540039E2F6DCB' \
--header 'Authorization: Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJEaGFuYW5qYXkiLCJleHAiOjE3MTU0NDIxMjksImlhdCI6MTcxNTQwNjEyOX0.Axl2hIZIDCHO-adCj2Hoo5z2dW4cnwDPhLbsKB72Fx4' \
--data '

4) Create Booking
URL: /booking/create
Method: POST
Description: Create a new booking.
Request Body: JSON object representing the booking details

curl:-

curl --location 'localhost:8080/booking/create' \
--header 'Authorization: Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJEaGFuYW5qYXkiLCJleHAiOjE3MTU0NDIxMjksImlhdCI6MTcxNTQwNjEyOX0.Axl2hIZIDCHO-adCj2Hoo5z2dW4cnwDPhLbsKB72Fx4' \
--header 'Content-Type: application/json' \
--data '{
    "hotelId": "fbc87500-0418-4999-9de5-2c6e1da723b1",
    "checkInDate": "2024-04-10T19:01:17.425496300",
    "checkOutDate": "2024-05-10T19:01:17.425496300",
    "numberOfGuests": 60

5) Get Booking by ID
URL: /booking/getById
Method: GET
Parameters:
id (String): Booking ID.
Description: Retrieve a booking by its ID.
Response: Returns the booking with the specified ID

curl:-

curl --location 'localhost:8080/booking/getById?id=c8f9862a-d2f4-47ea-b69f-083524e8962c' \
--header 'Authorization: Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJEaGFuYW5qYXkiLCJleHAiOjE3MTU0NDIxMjksImlhdCI6MTcxNTQwNjEyOX0.Axl2hIZIDCHO-adCj2Hoo5z2dW4cnwDPhLbsKB72Fx4'

6) Cancel Booking
URL: /booking/cancel
Method: DELETE
Parameters:
bookingId (String): Booking ID.
Description: Cancel a booking by its ID.
Response: Returns ACCEPTED (202) status code indicating the booking has been successfully canceled.

Curl:-

curl --location --request DELETE 'http://localhost:8080/booking/cancel?bookingId=8e1f2803-3b19-45a9-a5b8-3b21685a4190' \
--header 'Content-Type: application/json' \
--header 'Authorization: Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJEaGFuYW5qYXkiLCJleHAiOjE3MTU0NDIxMjksImlhdCI6MTcxNTQwNjEyOX0.Axl2hIZIDCHO-adCj2Hoo5z2dW4cnwDPhLbsKB72Fx4' \
--data ''
