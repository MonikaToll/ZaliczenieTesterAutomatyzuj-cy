Feature: Login and add address

  Scenario Outline: Login to shop and then add address.

    Given Open browser with https://mystore-testlab.coderslab.pl/index.php
    And SignIn button clicked

    Then Input qwerty@wp.pl and 12345 in LogIn page
    And Submit LogIn Data

    Then Add new address button clicked

    Then Create new address button clicked

    Then Fill sheet with <alias>, <firstName> , <lastName> , <company>, <vat>, <addressLine1>, <addressLine2>, <city> ,<zipPostcode>, <country> and <phone>
    And Submit sheet
    And Check if address data is correct <alias>, <firstName>, <lastName>, <company>, <vat>, <addressLine1>, <addressLine2>, <city>, <zipPostcode>,  <country> and <phone>

    Then Delete address
    And Check if address is deleted

    Then Quit browser


    Examples:
      |alias|firstName | lastName |company|vat|addressLine1  |addressLine2 |city    |zipPostcode    |country          | phone     |
      |LL   |Monika    | Toll     |MT     |23 |ul.3Maja      |11/1         |Warszawa| 00-800        |United Kingdom   | 661651155 |



