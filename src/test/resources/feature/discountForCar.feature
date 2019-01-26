Feature: Car own product

  @CarRent
  Scenario Outline: TO1 user creates car, search for car with correct filter, books it and checks reservation data
    Given supplier and office are created
    When TO1 user login and sets <markup> markup
    And creates car, price list with price 50 EUR, <penalty> penalty and <discount> discount
    Then he should see car at cars list
    When TO1 user search for the car in car search form
    Then he should see the car with correct prices: <supplierPrice> for supplier and <clientPrice> for client
    When TO1 user books the car
    Then he should see reservation status Confirmed and prices: <supplierPrice> for supplier, <clientPrice> for client

    Examples:
      | penalty   | discount   | markup | supplierPrice | clientPrice |
      | -         | -          | -      | 50            | 50          |
      | -         | -          | 50 %   | 50            | 75          |
      | -         | -          | 10 EUR | 50            | 60          |
      | 50 %      | -          | -      | 50            | 50          |
      | 100%      | -          | -      | 50            | 50          |
      | 10 EUR    | -          | -      | 50            | 50          |
      | 50 % FT   | -          | -      | 50            | 50          |
      | 100 % FT  | -          | -      | 50            | 50          |
      | 10 EUR FT | -          | -      | 50            | 50          |
      | -         | 50 %       | -      | 50            | 25          |
      | -         | 10 EUR     | -      | 50            | 40          |
      | -         | 50 % FT    | -      | 50            | 25          |
      | -         | 10 EUR FT  | -      | 50            | 40          |

    # FT - create from tariff

  @CarRentCancellation
  Scenario Outline: TO1 user cancels car reservation and checks if changes in reservation are applied
    Given supplier and office are created
    And zero markup is set
    And car, with price list with price 50 EUR and <penalty> are created by TO1 user
    And car is found
    And car is booked
    When TO1 user cancels reservation
    Then he should see reservation status Cancelled and prices: <supplierPrice> for supplier, <clientPrice> for client

    Examples:
      | penalty | supplierPrice | clientPrice |
      | 50 %    | 25            | 25          |
      | 10 EUR  | 40            | 40          |

  @CarSearch
  Scenario: TO1 search for car with wrong filter options, don't find it and then changes options to correct
    Given supplier and office are created
    When TO1 user login and sets zero markup
    And creates car and edits default driver
    Then he should see car at cars list
    When TO1 user search for the car in car search form with incorrect search options
    Then he shouldn't see the car at search results
    When TO1 user search for the car in car search form with correct search options
    Then he should see the car at search results

  # @author Siarhei Sviarkaltsau











































