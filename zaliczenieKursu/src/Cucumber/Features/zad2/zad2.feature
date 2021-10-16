Feature: zad2_Order

  Scenario Outline: order clothes in on-line shop
    Given Open browser with https://mystore-testlab.coderslab.pl/index.php
    And SignIn button approved

    Then Input qwerty@wp.pl and 12345 in LogIn area
    And User LogIn to the shop

    Then Search <productName> in search area
    And Open product page

    Then Select correct <size>
    And Choose quantity <quantity>

    Then Add products to cart
    And Go to checkout
    And Proceed to checkout

    Then Choose address to order
    And Confirm to continue

    Then Get shipping method PrestaShop pick up in-store
    And Continue to payment

    Then Select first payment method
    And Agree to the terms
    And Click the button order with an obligation to pay

    Then Take screenshot that confirm the order and total amount

    Then Close browser


    Examples:
      |size|quantity  |productName                    |
      |M   |5         |Hummingbird printed sweater    |

