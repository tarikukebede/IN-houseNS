# Trilateration-based Navigation System
![Frame 1 (1)](https://github.com/tarikukebede/IN-houseNS/assets/46628322/fd160835-b5f9-4bfe-86a0-0bddfdc618b9)
### Description

This project demonstrates a navigation system utilizing trilateration techniques to determine the precise location of a mobile station within a designated environment. 
Trilateration, a mathematical method based on measuring distances to known reference points, is employed to calculate the mobile station's coordinates.

### Features
#### Trilateration Algorithm Implementation: 
Algorithms for trilateration are used to process signal data received from multiple reference points.

#### Data Processing and Calculation: 
The system computes the mobile station's location by analyzing signal strength or time-of-flight measurements from reference points.

#### Location Estimation: 
The calculated coordinates represent the precise position of the mobile station relative to the known reference points.

#### Technologies Used

1. Spring Boot 2.7.10
2. H2 Database

### Database

###### H2 Console
@ http://localhost:8080/h2-console
#### username : root
#### password : root



### Note :
- Spring Boot V. 2.7.10 is used for documentation compatibility, hence openAPI 3 is currently not supporting
  spring boot 3.0
#### You can find the Documentation on the routs below, once you run the application successfully.
Swagger UI -> http://localhost:8080/swagger-ui/index.html
Open API -3 -> http://localhost:8080/v3/api-docs
