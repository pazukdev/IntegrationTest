# MyIntegrationAutotest
Approach to integration tests

Basics:
- config-based test flow
- Cucumber test cases 
- low coupling of Cucumber test cases with tests code: JUnit tests can be developed and run independent from Cucumber test cases
- POM (Page Object Model) approach to UI 

Technologies stack:<br>
 #Java #Selenium #JUnit #Cucumber #Spring

Tests:  
 package test.searchfilter.product.flight
Cucumber: 
 FlightSearchFilterCucumberIT class
JUnit: 
 OfferFilterFormSupplierFilterIT
 SearchFormSupplierFilterIT
 SearchFormDirectFlightFilterIT
 SearchFormFlightClassFilterIT
 SearchFormAirlineFilterIT


