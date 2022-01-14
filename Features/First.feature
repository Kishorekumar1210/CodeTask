Feature: Akamai Job portal 

Scenario: Search for a job matching given criteria
  Given Customer is on "https://akamaicareers.inflightcloud.com/"
  When Customer specifies Find Your Career: "Senior Software Development Engineer in Test"
  And Filter by country: "Poland"
  Then Any job offers are found