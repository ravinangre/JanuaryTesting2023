#Author: Ravi Nangare
Feature: Getting The Number of the patterns views from the Colorlover API XML Response and validate it it Greater than 4000


  @get
  Scenario Outline: GET the Number of the patterns view
    Given Color Lover Patterns API endpoint exists as "<URL>" for test case "<TestName>"
     When I send a valid Get Request to Get Patterns API XML File
    Then I try to verify the status code is "<StatusCode>"
 And I should see the Number of Views of Pattern "<patternNumber>" Greater Than "<threshold>"
    Examples: 
      | TestName  | URL                                      | StatusCode | patternNumber | threshold |
      | Demo test | http://www.colourlovers.com/api/patterns |    200     |       1       |   4000    |

  