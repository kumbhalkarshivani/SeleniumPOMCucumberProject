Feature: End to End workflow to verify the final cost of the product

  Background:
    Given Navigate to base URL "https://www.saucedemo.com/"
    And Login to application with below credentials
      | username      | password     |
      | standard_user | secret_sauce |

  @SmokeTest
  Scenario: To verify the final cost of the product
    Given Add below list of products in the cart
      | Products            |
      | Sauce Labs Backpack |
      | Sauce Labs Bike Light |
      | Sauce Labs Onesie   |
    When Open cart
    And Check products count in the cart
    And Click on checkout
    And  Add check out info
      | firstname      | lastname     |zip|
      | firsttest | lasttest | 90209|
    And click on continue
    Then Check Item total of the Products
    And Check Total Price
    And Click on Finish