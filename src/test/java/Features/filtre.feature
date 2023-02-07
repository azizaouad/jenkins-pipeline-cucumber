Feature: filter test

  Scenario: photographer should choose two date the first is the start date and the second is the finish date
    Given  user should navigate to the website
    When user write email as "azizaouadi12@gmail.com" and password as "Aziz1996@" and click on login
    And user click on all filters and should choose the start date as "2023-01-31" and the finish date as "2023-02-21"
    Then the user must find the events in the period from start date as "2023-01-31" to finish date as "2023-02-21"

  Scenario: photographer can filter by the name of event
    Given  user should navigate to the website
    When user write email as "azizaouadi12@gmail.com" and password as "Aziz1996@" and click on login
    And user click on all filters and should write the name of event as "koura"
    Then The user must find the events whose name of event as "koura"

  Scenario: photographer can filter by the location of event
    Given  user should navigate to the website
    When user write email as "azizaouadi12@gmail.com" and password as "Aziz1996@" and click on login
    And user click on all filters and should write the location of event as "tunis"
    Then The user must find the events whose location of event as "tunis"

  Scenario: photographer can filter by the status of event
    Given  user should navigate to the website
    When user write email as "azizaouadi12@gmail.com" and password as "Aziz1996@" and click on login
    And user click on all filters and should write the status of event as "In progress"
    Then The user must find the events whose status of event as "In progress"

  Scenario: photographer can filter the events of today
    Given  user should navigate to the website
    When user write email as "azizaouadi12@gmail.com" and password as "Aziz1996@" and click on login
    And user click on all filters and should click on today
    Then The user must find the events of today

  Scenario: photographer can filter the events of this week
    Given  user should navigate to the website
    When user write email as "azizaouadi12@gmail.com" and password as "Aziz1996@" and click on login
    And user click on all filters and should click on this week
    Then The user must find the events of this week

  Scenario: photographer can filter the events of this month
    Given  user should navigate to the website
    When user write email as "azizaouadi12@gmail.com" and password as "Aziz1996@" and click on login
    And user click on all filters and should click on this month
    Then The user must find the events of this month

  Scenario: photographer can filter the events of this year
    Given  user should navigate to the website
    When user write email as "azizaouadi12@gmail.com" and password as "Aziz1996@" and click on login
    And user click on all filters and should click on this year
    Then The user must find the events of this year

  Scenario: photographer can filter the events according to their names, locations, status and dates simultaneously
    Given  user should navigate to the website
    When user write email as "azizaouadi12@gmail.com" and password as "Aziz1996@" and click on login
    And user click on all filters and fill the name of event as "koura" , the location of event "tunis", and the status of event as "In progress" and the date of event
    Then The user must find the events whoose name of event as "koura" , location of event as "tunis", status of event as "In progress" and the date of event as




