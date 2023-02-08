$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("DemoFeatureGet.feature");
formatter.feature({
  "comments": [
    {
      "line": 1,
      "value": "#Author: Ravi Nangare"
    }
  ],
  "line": 2,
  "name": "Getting The Number of the patterns views from the Colorlover API XML Response and validate it it Greater than 4000",
  "description": "",
  "id": "getting-the-number-of-the-patterns-views-from-the-colorlover-api-xml-response-and-validate-it-it-greater-than-4000",
  "keyword": "Feature"
});
formatter.scenarioOutline({
  "line": 6,
  "name": "GET the Number of the patterns view",
  "description": "",
  "id": "getting-the-number-of-the-patterns-views-from-the-colorlover-api-xml-response-and-validate-it-it-greater-than-4000;get-the-number-of-the-patterns-view",
  "type": "scenario_outline",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 5,
      "name": "@get"
    }
  ]
});
formatter.step({
  "line": 7,
  "name": "Color Lover Patterns API endpoint exists as \"\u003cURL\u003e\" for test case \"\u003cTestName\u003e\"",
  "keyword": "Given "
});
formatter.step({
  "line": 8,
  "name": "I send a valid Get Request to Get Patterns API XML File",
  "keyword": "When "
});
formatter.step({
  "line": 9,
  "name": "I try to verify the status code is \"\u003cStatusCode\u003e\"",
  "keyword": "Then "
});
formatter.step({
  "line": 10,
  "name": "I should see the Number of Views of Pattern \"\u003cpatternNumber\u003e\" Greater Than \"\u003cthreshold\u003e\"",
  "keyword": "And "
});
formatter.examples({
  "line": 11,
  "name": "",
  "description": "",
  "id": "getting-the-number-of-the-patterns-views-from-the-colorlover-api-xml-response-and-validate-it-it-greater-than-4000;get-the-number-of-the-patterns-view;",
  "rows": [
    {
      "cells": [
        "TestName",
        "URL",
        "StatusCode",
        "patternNumber",
        "threshold"
      ],
      "line": 12,
      "id": "getting-the-number-of-the-patterns-views-from-the-colorlover-api-xml-response-and-validate-it-it-greater-than-4000;get-the-number-of-the-patterns-view;;1"
    },
    {
      "cells": [
        "Demo test",
        "http://www.colourlovers.com/api/patterns",
        "200",
        "1",
        "4000"
      ],
      "line": 13,
      "id": "getting-the-number-of-the-patterns-views-from-the-colorlover-api-xml-response-and-validate-it-it-greater-than-4000;get-the-number-of-the-patterns-view;;2"
    }
  ],
  "keyword": "Examples"
});
formatter.before({
  "duration": 35728600,
  "status": "passed"
});
formatter.before({
  "duration": 1096100,
  "status": "passed"
});
formatter.before({
  "duration": 4779900,
  "status": "passed"
});
formatter.scenario({
  "line": 13,
  "name": "GET the Number of the patterns view",
  "description": "",
  "id": "getting-the-number-of-the-patterns-views-from-the-colorlover-api-xml-response-and-validate-it-it-greater-than-4000;get-the-number-of-the-patterns-view;;2",
  "type": "scenario",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 5,
      "name": "@get"
    }
  ]
});
formatter.step({
  "line": 7,
  "name": "Color Lover Patterns API endpoint exists as \"http://www.colourlovers.com/api/patterns\" for test case \"Demo test\"",
  "matchedColumns": [
    0,
    1
  ],
  "keyword": "Given "
});
formatter.step({
  "line": 8,
  "name": "I send a valid Get Request to Get Patterns API XML File",
  "keyword": "When "
});
formatter.step({
  "line": 9,
  "name": "I try to verify the status code is \"200\"",
  "matchedColumns": [
    2
  ],
  "keyword": "Then "
});
formatter.step({
  "line": 10,
  "name": "I should see the Number of Views of Pattern \"1\" Greater Than \"4000\"",
  "matchedColumns": [
    3,
    4
  ],
  "keyword": "And "
});
formatter.match({
  "arguments": [
    {
      "val": "http://www.colourlovers.com/api/patterns",
      "offset": 45
    },
    {
      "val": "Demo test",
      "offset": 102
    }
  ],
  "location": "GetAPITest.color_Lover_Patterns_API_endpoint_exists_as_for_test_case(String,String)"
});
formatter.result({
  "duration": 1639525200,
  "status": "passed"
});
formatter.match({
  "location": "GetAPITest.i_send_a_valid_Get_Request_to_Get_Patterns_API_XML_File()"
});
formatter.result({
  "duration": 2980994300,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "200",
      "offset": 36
    }
  ],
  "location": "GetAPITest.i_try_to_verify_the_status_code_is(String)"
});
formatter.result({
  "duration": 3480400,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "1",
      "offset": 45
    },
    {
      "val": "4000",
      "offset": 62
    }
  ],
  "location": "GetAPITest.i_should_see_the_Number_of_Views_of_Pattern_Greater_Than(String,String)"
});
formatter.result({
  "duration": 956074500,
  "status": "passed"
});
formatter.after({
  "duration": 2139800,
  "status": "passed"
});
formatter.after({
  "duration": 827600,
  "status": "passed"
});
formatter.after({
  "duration": 874300,
  "status": "passed"
});
});