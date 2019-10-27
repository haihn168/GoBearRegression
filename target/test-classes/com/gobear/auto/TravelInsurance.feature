Feature: Insurance-Travel

  Background:
    Given I am on Travel Insurance tab at Homepage

  Scenario: User should see at least 3 cards at Travel Result Page
    When I navigate to Travel Result Page
    Then I should see at least 3 cards displayed

  Scenario: User is able to use left side menu to filter results
    When I navigate to Travel Result Page
    Then I should be able to select Insurer
    And I should be able to select Personal Accident value
    And I should be able to sort By Price Low to high
    And I should be able to select Destination
    And I should be able to select Start date and End Date