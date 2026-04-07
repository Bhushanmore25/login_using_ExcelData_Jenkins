Feature: DemoQA Login

Scenario: Login with user testuser
  Given user is on login page
  When user enters username "testuser" and password "Password123!"
  And clicks on login button
  Then login result should be "success"

Scenario: Login with user wronguser
  Given user is on login page
  When user enters username "wronguser" and password "wrong"
  And clicks on login button
  Then login result should be "fail"

Scenario: Login with user vinod
  Given user is on login page
  When user enters username "vinod" and password "nagpur"
  And clicks on login button
  Then login result should be "fail"

Scenario: Login with user  testuser
  Given user is on login page
  When user enters username " testuser" and password " Password123!"
  And clicks on login button
  Then login result should be " success"

Scenario: Login with user  testuser
  Given user is on login page
  When user enters username " testuser" and password " Password123!"
  And clicks on login button
  Then login result should be " success"

Scenario: Login with user  testuser
  Given user is on login page
  When user enters username " testuser" and password " Password123!"
  And clicks on login button
  Then login result should be " success"

Scenario: Login with user  testuser
  Given user is on login page
  When user enters username " testuser" and password " Password123!"
  And clicks on login button
  Then login result should be " success"

Scenario: Login with user  testuser
  Given user is on login page
  When user enters username " testuser" and password " Password123!"
  And clicks on login button
  Then login result should be " success"

Scenario: Login with user  testuser
  Given user is on login page
  When user enters username " testuser" and password " Password123!"
  And clicks on login button
  Then login result should be " success"

