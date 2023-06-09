Feature: test archive and restore event functionality
 
  Scenario: photographer can archive any event
    Given photographer should login with his credentials email as "b@gmail.com" and password as "Admin123!" and create an event title as "testarchiveeevents"
    When photographer click on the three buttouns
    And Choose archive for the event name as "testarchiveeevents"
    Then the event as "testarchiveeevents" is archived

  Scenario: photographer can restore event
    Given photographer should login with his credentials email as "b@gmail.com" and password as "Admin123!"
    When photographer should go to the archive event
    And photographer click on the three buttouns
    And Choose restore for the event "testarchiveeevents"
    Then the title of event as "testarchiveeevents" is restored

