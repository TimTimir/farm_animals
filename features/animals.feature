Feature: Work with animals

  Scenario: Buy
    When I buy a "sheep" with eid "abc" from "Juan"
    Then the sheep with eid "abc" is at the farm

  Scenario: Newborn animal

  Scenario: Sell

  Scenario: Vaccinate

  Scenario: Death
    Given a "sheep" with eid "abc" exists on the farm
    When I search for the animal with eid "abc"
    And the animal is reported as dead
    Then the "sheep" with eid "abc" is no longer on the farm

  Scenario: Illness treatment

  Scenario: Medical history

  Scenario: Growth history

  Scenario: Find details about animal
    Given a "sheep" with eid "abc" exists on the farm
    When I search for the animal with eid "abc"
    Then I see details about a "sheep" with eid "abc"
