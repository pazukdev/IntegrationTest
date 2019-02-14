Feature: Developer search

  Scenario: User search for developer, check if found developer matches filter and sign an online contract
    Given User is logged in
    When user searches for developer: skill: python, country: India, age: 50
    Then he should see the developer in search results

  @DeveloperSearch
  Scenario Outline: User search for developer, check if found developer matches filter and sign an online contract
    Given User is logged in
    When user searches for developer: <skill>, <country>, <age>
    Then he <expected result> the developer in search results

    Examples:
      | skill   | country | age | expected result |
      | python  | India   | 50  | should see      |
      | -       | India   | 50  | should see      |
      | python  | -       | 50  | should see      |
      | -       | India   | -   | should see      |
      | -       | -       | -   | should see      |
      | java    | Belarus | 90  | shouldn't see   |
      | java    | India   | 50  | shouldn't see   |
      | python  | Belarus | 50  | shouldn't see   |
      | python  | India   | 90  | shouldn't see   |


