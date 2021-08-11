# rest-clients
Scaffolded code and resources to learn about rest clients

## Exercises
1. cURL
   - Hit several of the existing Customer endpoints using cURL.  Set debuggers in the relevant endpoints to verify you are connecting to the application
     ```
     curl -X GET http://localhost:8081/customer/1
     ```
     ```
     curl -X PUT 'http://localhost:8081/customer/1' -H 'Content-Type: application/json' -d '{"name": "Jimmy"}'
     ```
   - Make a POST request to the endpoint with data ‘Hello World’ and content type “text/plain”
     - You should receive the response: {"contentType":"text/plain","greeting":"Hello World"}

1. Postman
   - Populate the [Developer](src/main/java/com/credera/examples/serialization/dto/developer/Developer.java) such that the [developer.json](src/main/resources/serialization/developer.json) can be deserialized into a `Developer` object
     - verify your solution by hitting the `POST /serialization/developer` endpoint with the `developer.json` using Postman

1. RestTemplate
   - create a new endpoint in the `Customer Service` (`POST /customer/{id}/inactivate`) which accepts the customer id as a path variable
   - from the service layer, call the account service endpoint `POST /account/{id}/change-activation` and inactive the customers account.
     - this endpoint expects a request body that looks like: `{"active": boolean}`
   - Hit your new endpoint and validate that the account is now inactive