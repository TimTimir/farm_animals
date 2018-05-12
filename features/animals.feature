Feature: Work with animals

  Background:
    Given I am "Stephan Schwab"

  Scenario: Buy animal with EID
    When I buy a "male" "sheep" with eid "abc" from "Juan"
    Then the animal with eid "abc" is at the farm

  Scenario: Find details about animal
    Given a "male" "sheep" with eid "abc" exists on the farm
    When I search for the animal with eid "abc"
    Then I see details about a "sheep" with eid "abc"

  Scenario: Death
    Given a "male" "sheep" with eid "abc" exists on the farm
    When I search for the animal with eid "abc"
    And the animal is reported as dead
    Then the "sheep" with eid "abc" is no longer on the farm

  Scenario: Buy a horse
    When I buy a "male" "horse" with eid "724002012808916" from "Felix Aguado Molino" with details:
      | Name      | Race               | Color |
      | Apolo LXI | Pura Raza Espanola | White |
    Then the animal with eid "724002012808916" is at the farm
    And the details stored for the animal with eid "724002012808916" are:
      | Name      | Sex  | Race               | Color |
      | Apolo LXI | MALE | Pura Raza Espanola | White |

  Scenario: Newborn animal

  Scenario: Sell

  Scenario: Vaccinate

  Scenario: Illness treatment

  Scenario: Medical history

  Scenario: Growth history

