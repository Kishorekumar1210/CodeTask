Feature: Customer is notified when no offers match given criteria

Scenario: Search for a job matching given criteria
  Given Customer is on "https://akamaicareers.inflightcloud.com/"
  When Customer specifies Find Your Career "XXX"
  Then Notification about no offers found is displayed: "We found 0 jobs based on your search criteria"