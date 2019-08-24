### Installation (pre-requisites)
1. JDK 1.8+ (make sure Java class path is set)
2. Maven (make sure .m2 class path is set)
3. Install Chrome Driver
- `npm install chromedriver`
	

### Run Some Sample Tests
Open terminal (MAC OSX) or command prompt / power shell (for windows OS) and navigate to the project directory type command to run features.
- ` mvn clean test "-Dbrowser=chrome" `


### Allure Report:
You can generate a report using one of the following command.
- `mvn allure:serve`
