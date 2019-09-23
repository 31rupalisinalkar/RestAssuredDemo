Rest-Assured Automation Example:
This is an example application of Rest-Assured as a basis for API test fremwork.
I have used possible options one can have for handling requests, responses and assertions.


Endpoints
/users - all users
/posts - all posts
/comments - all comments by user

Framework Structure:
This project is standard Maven Java project with src folders and POM.xml along with feature files.

Properties:
src/main/resources/config.properties is a simple properties file to store various configurations such as service url

Tests
src/main/java/BaseClass.java is the superclass for configuration and common code src/test/java/ holds test classes (JUnit4)# RestApi
# RestAssuredDemo
