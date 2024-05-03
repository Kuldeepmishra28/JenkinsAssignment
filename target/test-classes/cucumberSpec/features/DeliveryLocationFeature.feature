Feature: Delivery Location Feature
    
    Background:
     Given user is on home page
    
    @smoke   
    Scenario Outline: valid location pincode
    And user clicked on location update button
    When user entered pincode "<pincode>"
    Then location updated to "<pincode>"
    
    Examples: 
      | pincode	|      
      | 226010  |
      | 226012  |
    
     
    Scenario Outline: invalid location pincode 
    And user clicked on location update button
    When user entered pincode "<pincode>"
    Then location not get updated    
    
    Examples: 
      | pincode	|      
      | 22601s  |
      | 43fd    |