Feature: Flight search filter

  @FlightSearchFilter
  Scenario Outline: User go to flight search form and search for flight with different filters
    Given Flight search form: airports: departure: "LHR", arrival: "FRA" -> search result is displayed
    When User sets the <filter> on the <form>
    Then He should see only offers matching the filter

    Examples:
      | form                     | filter        |
      | flight offer filter form | supplier      |
      | flight search form       | supplier      |
      | flight search form       | direct flight |
      | flight search form       | flight class  |
      | flight search form       | airline       |

    # @author Siarhei Sviarkaltsau

