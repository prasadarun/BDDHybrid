Feature: Search Funcitonality

  Background: 
    Given Navigate to login page

  @searchMacBook
  Scenario: Search with Macbook in search box
    When user enters the "Macbook" in search box
    And click on enter button or search icon
    Then search results should contain all of the following
      | MacBook     |
      | MacBook Air |
      | MacBook Pro |
