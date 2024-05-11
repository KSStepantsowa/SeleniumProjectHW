Feature: login

 Background:
  Given user is on login page

 Scenario Outline: login with incorrect credentials
  When user enters <login> in user field
  And user enters <password> in password field
  And user clicks login button
  Then error screen appears
  And error message contains "Wrong password or the account is disabled, or does not exist"

  Examples:
  | login | password |
  | "xidepo1971@rartg.com" | "sfdfdsfds" |
  | "xidepo1971@rartg.incorrect" | "passIncorrect4637" |


