Feature: As a user I want to search cruises to The Bahamas with duration between 6 and 9 days so that I will
  visualize all the options to choose one.
  Scenario: Look for cruises to the Bahama of 6-9 days duration
    Given Using "https://www.carnival.com/" as main page
    When User search cruises to "The Bahamas"
    And Sets duration from 6 to 9 days
    Then Results should be displayed on a grid
    And User will filter by price from 480 to 700 using slider Bar
    And User will sort by price

  Scenario: Select a cruise
    Given User is in the results page "https://www.carnival.com/#?dest=bh&layout=grid&numAdults=2&pageNumber=1&pageSize=8&showBest=true&sort=fromprice&useSuggestions=true"
    When User selects a cruise
    Then Itinerary page should load
    And User should be able to read about each day
    And A book now button should be placed