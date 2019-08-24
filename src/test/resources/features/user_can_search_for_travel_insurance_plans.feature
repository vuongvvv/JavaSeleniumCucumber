Feature: Login
        As user I should able to search for the travel insurance plans
 
 Scenario: I login with valid credential
 		Given I navigate to "https://www.gobear.com/ph?x_session_type=UAT"
 		And I select "Insurance" tab
 		And I select "Travel" subtab of insurance
 		And I select "single trip" option for travel plan
 		And I select "2 persons" option for people dropdown
 		And I select "Thailand" option for travel location
		And I select "25" and "Dec" and "2021" as start date
		And I select "26" and "Dec" and "2021" as end date
		When I click on Show My Results button
		Then I see more than 3 travel insurance plans in the search results
		When I select "Malayan Insurance" filter in Insurers
		Then I see all travel insurance plans match with "Malayan Insurance"
		When I select "Price: High to low" sort option
		Then I see all travel insurance plans sort by price High to Low
		When I select "annual trip" policy details
		And I select "Asia" destination
		And I select "26" and "Dec" and "2021" as start date
		And I click on See More button
		And I set 1000000 min and 2000000 max for "Personal Accident" slider