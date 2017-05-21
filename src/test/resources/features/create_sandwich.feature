Feature: Welcome page

  Scenario: Check menu
    Given I am at the custom sandwich page
    When I choose one with:
      | 1   | hamburger |
      | 1   | egg       |
      | 1   | cheese    |
    Then It shows the right price sandwich price
      | 1   | hamburger |
      | 1   | egg       |
      | 1   | cheese    |

  Scenario: Hamburger Promotion
    Given I am at the custom sandwich page
    When I choose one with:
      | 3   | hamburger |
      | 1   | egg       |
    Then It shows the right price sandwich price
      | 2   | hamburger |
      | 1   | egg       |

  Scenario: Hamburger and cheese promotion with 6 cheese and 3 hamburgers
    Given I am at the custom sandwich page
    When I choose one with:
      | 3   | hamburger |
      | 6   | cheese |
      | 1   | egg       |
    Then It shows the right price sandwich price
      | 2   | hamburger |
      | 4   | cheese    |
      | 1   | egg       |

  Scenario: Example of light promotion
    Given I am at the custom sandwich page
    When I choose one with:
      | 3   | hamburger |
      | 3   | cheese    |
      | 1   | egg       |
      | 1   | lettuce   |
    Then It shows the right price sandwich price for light promotion
      | 2   | hamburger |
      | 2   | cheese    |
      | 1   | egg       |
      | 1   | lettuce   |

  Scenario: Light promotion is no longer valid if the sandwich contains bacon
    Given I am at the custom sandwich page
    When I choose one with:
      | 3   | hamburger |
      | 3   | cheese    |
      | 1   | egg       |
      | 1   | lettuce   |
      | 1   | bacon     |
    Then It shows the right price sandwich price
      | 2   | hamburger |
      | 2   | cheese    |
      | 1   | egg       |
      | 1   | bacon     |