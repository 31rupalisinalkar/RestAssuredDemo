#Author: rupali.sinalkar@cognizant.com
Feature: This feature is to check USERS endpoint

  Background: 
    Given Set the base url

  @test1
  Scenario: Check if user is able to submit GET API request and validate the details of user 10
    When users endpoint is accessed for get method
    Then validate the status code
    And validate the json response received for user id 10

  @test2
  Scenario: Check if user is able to submit POST API request and validate the details of newly created user
    When users endpoint is accessed for post method
    Then validate the status code
    And validate the json response and check new user id generated
