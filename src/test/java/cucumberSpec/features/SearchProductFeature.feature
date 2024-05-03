Feature: Search Product Feature
 
 
  Scenario Outline: searched for valid product 
   Given user should be on homepage
    When user searches for "<Product>"
    Then search result should display
    
    Examples: 
      | Product	|
      | Air Conditioner	|   
      | laptop	| 
      
  @regression
   Scenario Outline: searched for  invalid product 
    Given user should be on homepage
    When user searches for "<Product>"
    Then search result should not display
    
    Examples: 
      | Product	|
      | sja382h	|   
      | dsa19j3 |    

  