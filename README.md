### Installation (pre-requisites)
1. JDK 1.8+ (make sure Java class path is set)
2. Maven (make sure .m2 class path is set)
3. Eclipse
4. Eclipse Plugins for
    - Maven
    - Cucumber
5. Browser driver (make sure you have your desired browser driver and class path is set)

### Run Some Sample Tests
Open terminal (MAC OSX) or command prompt / power shell (for windows OS) and navigate to the project directory
type `mvn clean test` command to run features. With this command it will invoke the default Firefox browser and will execute the tests.

- To run features on specific browser use, `mvn test "-Dbrowser=browser_name"`
browser_name can be one of following but make sure that browser’s driver file are present and specified in system variable. -- ff -- chrome -- ie -- safari etc.

##### Allure Report:
You can generate a report using one of the following command.
- `mvn allure:serve`