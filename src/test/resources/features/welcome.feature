Feature: Welcome page

  Scenario: Check menu
    Given I go to weblanches website
    When I look at the menu
    Then All sandwich names and prices are right
      | XBURGER    |
      | XEGG       |
      | XEGGBACON  |
      | XBACON     |