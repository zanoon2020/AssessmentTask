Feature: Validate Subscription Package Type , Price , Currency For Each Available Country on Subscriptions Page

  Scenario: Navigate To Subscription Page
  Assert The Package type And Price For Each Country

    Given I Open The Browser
    When I Navigate To "https://subscribe.stctv.com/sa-en"
    And I assert That Chosen Country Is KSA
    Then I assert That Package "LITE" Price Equals "15" "SAR"
    And I assert That Package "CLASSIC" Price Equals "25" "SAR"
    And I assert That Package "PREMIUM" Price Equals "60" "SAR"
    When I Change The Country To Bahrain
    Then I assert That Package "LITE" Price Equals "2" "BHD"
    And I assert That Package "CLASSIC" Price Equals "3" "BHD"
    And I assert That Package "PREMIUM" Price Equals "6" "BHD"
    When I Change The Country To Kuwait
    Then I assert That Package "LITE" Price Equals "1.2" "KWD"
    And I assert That Package "CLASSIC" Price Equals "2.5" "KWD"
    And I assert That Package "PREMIUM" Price Equals "4.8" "KWD"

