# Test Automation Engineering Bootcamp - Project 2

This repository contains the second project for the Test Automation Engineering Bootcamp. The project focuses on building automation tests using Selinide framework in pom pattern. Below are the steps and requirements for the project.

## Step 1

### Repository Setup

- Create a new repository named "Project2."
- Create a branch called "project_dev" and make the following changes in this branch.

## Step 2

### Automation Test Setup

- Run the attached script for creating the database.

#### Test Scenarios

1. **Create 1st Test Method**
    - Open the Chrome browser.
    - Navigate to the "swoop.ge" website.
    - Go to the "დასვენება" section.
    - In the 'ფასი' element, set the range from 200 to 230.
    - Check that all returned elements on the first page are in the selected range.

2. **Create 2nd Test Method**
    - Go to "კატეგორიები."
    - Hover on "კვება" and click on "სუში."
    - Attempt to add the first returned item to the favorites list and verify that the Login Window has appeared.
    - Check that the vouchers are not sold out.

3. **Create 3rd Test Method**
    - Go to "კატეგორიები."
    - Hover on "კვება" and click on "სუში."
    - Sort elements by "ფასით კლებადი."
    - Check that the price of the first item is higher than the price of the second item.

4. **Create 4th Test Method**
    - Go to "კატეგორიები."
    - Hover on "კვება" and click on "სუში."
    - Navigate to the first returned item.
    - Click on 'გაზიარება.'
    - Validate that the window with the Facebook login page has appeared.

5. **Create 5th Test Method**
    - Generate data for a new user and insert it into the database (see attached file for modeling DB).
    - Register for a new account as 'ფიზიკური პირი.'
    - Fill all mandatory fields, except Gender.
    - Check that the error message 'გთხოვთ აირჩიოთ სქესი!' appears.

6. **Create testng.xml**
    - Create two groups named 'Regression1' and 'Regression2.'
    - Add the first two methods to 'Regression1' and the last three to 'Regression2.'

## Step 3

### Finalize and Submit

- Commit the final version of your project and make a pull request to the 'main' branch.
- Add mentors as reviewers to the pull request.

## Project Development Requirements

- Utilize the Page Object Model and Fluent Interface patterns.
- Configure the ability to run groups of tests in parallel.
- Implement before and after methods for opening and closing the browser.
- Use soft assertions when there is more than one assert in a test.
- Provide clear step names, test names, and descriptions in the report.
- Organize tests into groups with Epic, Features, and Stories.
- Generate a readable Allure report and attach it to the classroom post.
- Include screenshots for failed test cases.
- Avoid using Thread.sleep or Selenide sleep().

### Technologies Used

- Java
- Selinide
- TestNG
- Allure
- Microsoft SQL Server

## Prerequisites

Make sure you have the following software installed:

- Java 20.0.2
- IntelliJ IDEA
- Maven
- Chrome browser

### Building and Running Tests

To build and run the tests, follow these steps:

1. Clone this repository.
2. Open the project in IntelliJ IDEA.
3. Run the testng.xml file to execute the tests.