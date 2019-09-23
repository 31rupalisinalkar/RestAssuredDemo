#Author: rupali.sinalkar@cognizant.com
Feature: This feature is to check COMMENTS endpoint

  @test5
  Scenario: Check if user is able to submit GET API request and validate the name of id no. 4
    Given Set the base url
    When comments endpoint is accessed for get method
    Then validate the status code
    And validate the name of id 4
