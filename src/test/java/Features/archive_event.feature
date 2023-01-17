Feature: test archive event functionality

  Scenario: photographer can archive any event
    Given photographer should login with his credentials email as "azizaouadi12@gmail.com" and password as "Aziz1996@" and create an event title as "koura"
    When photographer click on the three buttouns
    And Choose archive
    Then the event as "koura" is archived

  Scenario: photographer can restore event
    Given photographer should login with his credentials email as "azizaouadi12@gmail.com" and password as "Aziz1996@"
    When photographer should go to the archive event
    And photographer click on the three buttouns
    And Choose restore for the event "koura"
    Then the title of event as "koura" is restored
