# IntegrationTest
<b>This library is not actual: it contains deprecated interfaces implementations and has no some actual concepts</b>
<p>Approach to integration tests</p>
<p>Basics:</p>
<ul>
<li>config-based test flow</li>
<li>test flow consists of actions and has Composite structure</li>
<li>any action in test flow - is Command & implementation of Action functional interface</li>  
<li>low coupling of Cucumber test cases with tests code: JUnit tests can be developed and run independent from Cucumber test cases</li>
<li>POM (Page Object Model) approach to UI</li>
</ul>
<p>Tools:<br />&nbsp; #Java&nbsp; #Selenium&nbsp; #JUnit&nbsp; #Cucumber&nbsp; #Spring</p>
<p>Basics of design:<br />&nbsp; #Composite&nbsp; #Command&nbsp; #Page Object</p>
<p>Tests:<br />&nbsp; package test.searchfilter.product.flight<br /> Cucumber:<br />&nbsp; FlightSearchFilterCucumberIT class<br /> JUnit:<br />&nbsp; OfferFilterFormSupplierFilterIT class<br />&nbsp; SearchFormSupplierFilterIT class<br />&nbsp; SearchFormDirectFlightFilterIT class<br />&nbsp; SearchFormFlightClassFilterIT class<br />&nbsp; SearchFormAirlineFilterIT class</p>


