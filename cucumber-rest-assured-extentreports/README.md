# Automation Task
This project is a plan project with Cucumber framework to automate Rest API's.
  - Automation of Rest API projects with Rest Assured
  - This also includes the extent reporting.
    
I have used following URL for   `GET` requests:
http://www.colourlovers.com/api/patterns


##Task Requirement : 
Make a GET request to colourlovers api http://www.colourlovers.com/api/patterns and write an assertion for <numViews> (from response) to be greater than 4000” 

## Table of Contents 

- [Preconditions](#Preconditions)
- [MAVEN_Dependencies](#MAVEN_Dependencies)
- [SetUp](#SetUp)
- [Add_features_and_respective_step_definitions](#Add_features_and_respective_step_definitions)

---

## Preconditions
```bash
- Maven 
- Java 8
- Cucumber Eclipse plugin
```

## MAVEN_Dependencies
Add the following dependencies to your `pom.xml`
All below dependencies are compatible.

```maven
<dependency>
	<groupId>com.vimalselvam</groupId>
	<artifactId>testng-extentsreport</artifactId>
	<version>1.3.1</version>
</dependency>
<dependency>
	<groupId>com.vimalselvam</groupId>
	<artifactId>cucumber-extentsreport</artifactId>
	<version>3.0.2</version>
</dependency>
<dependency>
	<groupId>info.cukes</groupId>
	<artifactId>cucumber-jvm-deps</artifactId>
	<version>1.0.5</version>
	<scope>provided</scope>
</dependency>
<dependency>
	<groupId>info.cukes</groupId>
	<artifactId>cucumber-junit</artifactId>
	<version>1.2.5</version>
	<scope>test</scope>
</dependency>
<dependency>
	<groupId>info.cukes</groupId>
	<artifactId>cucumber-java</artifactId>
	<version>1.2.5</version>
</dependency>
<dependency>
	<groupId>com.aventstack</groupId>
	<artifactId>extentreports</artifactId>
	<version>3.1.2</version>
</dependency>
```
## SetUp
- Configure `extent-config.xml`
```
<?xml version="1.0" encoding="UTF-8"?>
<extentreports>
	<configuration>
		<!-- report theme --> <!-- standard, dark -->
		<theme>standard</theme>

		<!-- document encoding -->  <!-- defaults to UTF-8 -->
		<encoding>UTF-8</encoding>

		<!-- protocol for script and stylesheets -->   <!-- defaults to https -->
		<protocol>https</protocol>

		<!-- title of the document -->
		<documentTitle>Cucumber Framework</documentTitle>

		<!-- report name - displayed at top-nav -->
		<reportName>Cucumber Extent Report</reportName>

		<!-- global date format override -->  <!-- defaults to yyyy-MM-dd -->
		<dateFormat>yyyy-MM-dd</dateFormat>

		<!-- global time format override -->   <!-- defaults to HH:mm:ss -->
		<timeFormat>HH:mm:ss</timeFormat>

		<!-- custom javascript -->
		<scripts>
      <![CDATA[
        $(document).ready(function() {
        
        });
      ]]>
		</scripts>

		<!-- custom styles -->
		<styles>
      <![CDATA[
        
      ]]>
		</styles>
	</configuration>
</extentreports>
```

- create a runner class for cucumber project
- Run with tags. Here i have added `@get,@post,@put,@getfail,@postfail,@putfail` tags.
```java
import java.io.File;

import org.junit.AfterClass;
import org.junit.runner.RunWith;

import com.cucumber.listener.Reporter;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(format = { "pretty" }, features = "src//test//java//com//factory//cucumber//features", glue = {
		"com.factory.cucumber.stepdefinitions" }, tags = { "@get,@post,@put,@getfail,@postfail,@putfail" }, plugin = {
				"com.cucumber.listener.ExtentCucumberFormatter:src/test/reports/cucumber_report.html",
				"html:output/html-report" }, monochrome = true)
public class RunCucumberTest {
	@AfterClass
	public static void writeExtentReport() {
		Reporter.loadXMLConfig(new File("src//test//java//com//factory//cucumber//configuration//extent-config.xml"));
		Reporter.setSystemInfo("user", System.getProperty("user.name"));
		Reporter.setSystemInfo("os", "Windows 10");
		Reporter.setTestRunnerOutput("Sample test runner output message");
	}

}
```
## Add_features_and_respective_step_definitions
```feature
#Author: Hesham
Feature: Getting The Number of the patterns views from the Colorlover API XML Response and validate it it Greater than 4000


  @get
  Scenario Outline: GET the Number of the patterns view
    Given Color Lover Patterns API endpoint exists as "<URL>" for test case "<TestName>"
     When I send a valid Get Request to Get Patterns API XML File
    Then I try to verify the status code is "<StatusCode>"
 And I should see the Number of Views of Pattern "<patternNumber>" Greater Than "<threshold>"
    Examples: 
      | TestName  | URL                                      | StatusCode | patternNumber | threshold |
      | Demo test | http://www.colourlovers.com/api/patterns |    200     |       1       |   4000    |

  
```

