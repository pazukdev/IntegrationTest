Feature: Flight own product

  @FlightCreationAndBooking
  Scenario Outline: TO1 user creates flight, searches for it with correct filter, books it and checks reservation data
    Given Supplier is created

    # base flow

    When TO1 user login
    And goes to Sales settings
    And sets markup <markup>
    And goes to Charter product
    And creates charter Minsk-London: EUR currency, Belavia (B2) airline, MSQ pick up, LHR drop off points
    And goes to Catalogue
    And creates flight Minsk-London: Econom class, Outbound direction
    And if <trip type> is round-trip creates return flight London-Minsk: Econom class, Outbound direction
    And goes to Schedule
    And creates trip: flight number, departure 15:00, return 18:30, duration 04:30
    And if <trip type> is round-trip creates trip: return flight number, departure 15:00, return 18:30, duration 4:30
    And goes to Availability
    And selects flight, sets limited quantity 30, clicks Update
    And if <trip type> is round-trip selects return flight, sets limited quantity 30, clicks Update
    And goes to Prices, Price-lists
    And creates price list: one-way, prices: 200 adult, 100 child, 50 infant
    And if <trip type> is round-trip creates price list: round-trip, prices: 300 adult, 200 child, 100 infant
    And goes to Tariff
    And creates tariff
    And creates discount <discount>
    And creates penalty <penalty>
    Then he should see created flight with correct data: Minsk-London, supplier name, MSQ, LHR and Active status

    When The user goes to flight search form
    And inputs correct search data: <trip type>, from MSQ, to LHR, <adult>, <child>, <infant>
    Then he should find the flight
    And displayed prices should be correct: <supplierPrice> for supplier, <clientPrice> for client

    When The user clicks Book, inputs data of all passengers into form and clicks Continue
    And clicks "Cash payment", accepts Fare conditions, clicks Book
    Then he should see reservation status Confirmed and prices: <supplier price>, <client price>

    # specific features

    # cancellation
    When <specific feature> is cancellation user clicks Cancel and accepts cancellation
    Then he should see reservation status Cancelled and prices: <supplier price>, <client price>

    # rebook, new order
    When <specific feature> is rebook, new order user clicks "Book it again" and clicks "Create a new order"
    And checks availability
    And clicks "Cash payment", accepts Fare conditions, clicks Book
    Then he should see reservation status Ticket is issued and prices: <supplier price>, <client price>

    # rebook
    When <specific feature> is rebook user clicks "Book it again" and clicks "Add to the current order"
    And checks availability
    And clicks "Cash payment", accepts Fare conditions, clicks Book
    Then he should see reservation status Ticket is issued and prices: <supplier price>, <client price>

    # create tag
    When <specific feature> is create tag user goes to the charter -> Prices -> Tags spoiler and creates PRIVATE tag
    And goes to Clients sales settings, Tags tab
    And specifies PRIVATE tag in "Products, marked with these tags will NOT be offered via the contract" field
    And goes to flight search form
    And inputs correct search data: <trip type>, from MSQ, to LHR, <adult>, <child>, <infant>
    Then he shouldn't find the flight

    # change manager
    When <specific feature> is change manager user go to Reservations list, ticks the reservation and changes manager
    Then he should see that new manager is displayed in the reservation

    Examples:
     | #  | trip type  | markup | penalty | discount | adult | child | infant | specific feature  | supplier price | client price    |
     | 1  | round-trip | -      | -       | -        | 1     | 0     | 0      | -                 | EUR 300 (-)    | EUR 300 (-)     |
     | 2  | round-trip | 5 %    | -       | -        | 1     | 0     | 0      | -                 | EUR 300 (-)    | EUR 315 (-)     |
     | 3  | round-trip | 5 EUR  | -       | -        | 1     | 0     | 0      | -                 | EUR 300 (-)    | EUR 305 (-)     |
     | 4  | round-trip | -      | -       | -        | 1     | 0     | 1      | -                 | EUR 400 (-)    | EUR 400 (-)     |
     | 5  | round-trip | -      | -       | -        | 1     | 1     | 0      | -                 | EUR 500 (-)    | EUR 500 (-)     |
     | 6  | round-trip | -      | -       | -        | 2     | 0     | 0      | -                 | EUR 600 (-)    | EUR 600 (-)     |
     | 7  | round-trip | 5 %    | -       | -        | 2     | 0     | 0      | -                 | EUR 600 (-)    | EUR 630 (-)     |
     | 8  | round-trip | 5 %    | -       | -        | 2     | 0     | 0      | cancellation      | EUR 600 (0)    | EUR 630 (0)     |
     | 9  | round-trip | 5 %    | -       | -        | 2     | 0     | 0      | rebook, new order | EUR 600 (0)    | EUR 630 (0)     |
     | 10 | round-trip | 5 %    | -       | -        | 2     | 0     | 0      | rebook            | EUR 600 (0)    | EUR 630 (0)     |
     | 11 | one-way    | -      | -       | -        | 1     | 0     | 0      | -                 | EUR 200 (-)    | EUR 200 (-)     |
     | 12 | one-way    | 5 %    | -       | -        | 1     | 0     | 0      | -                 | EUR 200 (-)    | EUR 210 (-)     |
     | 13 | one-way    | 5 EUR  | -       | -        | 1     | 0     | 0      | -                 | EUR 200 (-)    | EUR 205 (-)     |
     | 14 | round-trip | 5 %    | 50 %    | -        | 1     | 0     | 0      | cancellation      | EUR 300 (150)  | EUR 315 (157.5) |
     | 15 | round-trip | 5 %    | 50 % FT | -        | 1     | 0     | 0      | cancellation      | EUR 300 (150)  | EUR 315 (157.5) |
     | 16 | round-trip | 5 %    | 10 EUR  | -        | 1     | 0     | 0      | cancellation      | EUR 300 (10)   | EUR 315 (10.5)  |
     | 17 | round-trip | 5 %    | 100 %   | -        | 1     | 0     | 0      | cancellation      | EUR 300 (300)  | EUR 315 (315)   |
     | 18 | round-trip | 5 %    | -       | 5 %      | 1     | 0     | 0      | -                 | EUR 300 (-)    | EUR 299.25 (-)  |
     | 19 | round-trip | 5 %    | -       | 5 % FT   | 1     | 0     | 0      | -                 | EUR 300 (-)    | EUR 299.25 (-)  |
     | 20 | round-trip | 5 %    | -       | 5 EUR    | 1     | 0     | 0      | -                 | EUR 300 (-)    | EUR 309.75 (-)  |
     | 21 | one-way    | 5 %    | -       | 5 %      | 1     | 0     | 0      | -                 | EUR 200 (-)    | EUR 199.5 (-)   |
     | 22 | one-way    | 5 %    | -       | 5 EUR    | 1     | 0     | 0      | -                 | EUR 200 (-)    | EUR 204.75 (-)  |
     | 23 | one-way    | 5 %    | -       | 5 % FT   | 1     | 0     | 0      | -                 | EUR 200 (-)    | EUR 199.5 (-)   |
     | 23 | one-way    | 5 %    | -       | 5 % FT   | 1     | 0     | 0      | -                 | EUR 200 (-)    | EUR 199.5 (-)   |
     | 24 | round-trip | -      | -       | -        | 1     | 0     | 0      | create tag        | -              | -               |
     | 25 | one-way    | -      | -       | -        | 1     | 0     | 0      | create tag        | -              | -               |
     | 26 | round-trip | -      | -       | -        | 1     | 0     | 0      | change manager    | -              | -               |

    # cases 1 - 26 from google docs

    # author Siarhei Sviarkaltsau





























