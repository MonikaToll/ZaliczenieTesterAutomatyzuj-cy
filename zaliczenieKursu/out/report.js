$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("google-test-search.feature");
formatter.feature({
  "line": 1,
  "name": "Google search",
  "description": "",
  "id": "google-search",
  "keyword": "Feature"
});
formatter.scenario({
  "line": 3,
  "name": "user can search any keyword",
  "description": "",
  "id": "google-search;user-can-search-any-keyword",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 6,
  "name": "an open browser with duckduckgo.com.com",
  "keyword": "Given "
});
formatter.step({
  "line": 8,
  "name": "a keyword selenium is entered in input field",
  "keyword": "When "
});
formatter.step({
  "line": 10,
  "name": "the first one should contain selenium",
  "keyword": "Then "
});
formatter.step({
  "line": 12,
  "name": "close browser",
  "keyword": "And "
});
formatter.match({
  "location": "GoogleSearch.openGoogleSearch()"
});
formatter.result({
  "duration": 90331959872,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "selenium",
      "offset": 10
    }
  ],
  "location": "GoogleSearch.enterKeyword(String)"
});
formatter.result({
  "duration": 10524162738,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "selenium",
      "offset": 29
    }
  ],
  "location": "GoogleSearch.theFirstOneShouldContainKeyword(String)"
});
formatter.result({
  "duration": 290934,
  "status": "passed"
});
formatter.match({
  "location": "GoogleSearch.closeBrowser()"
});
formatter.result({
  "duration": 1413942725,
  "status": "passed"
});
});