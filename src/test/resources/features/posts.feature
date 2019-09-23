#Author: rupali.sinalkar@cognizant.com
Feature: This feature is to check POSTS endpoint

  Background: 
    Given Set the base url

  @test3
  Scenario: Check if user is able to submit GET API request and validate the title for id 100
    When posts endpoint is accessed for get method
    Then validate the status code
    And validate the title in response for post id 100

  @test4
  Scenario: Check if user is able to submit POST API request and validate the details of newly created post
    When posts endpoint is accessed for post method
    Then validate the status code
    And validate the json response and check new post id generated
