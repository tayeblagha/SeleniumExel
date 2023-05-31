@contact_us
Feature: Contact Us Feature

Scenario Outline: Contact Us scenario with different set of data
Given user navigates to contact us page
When user fills the form from given sheetname "<SheetName>" and rownumber <RowNumber>
And user clicks on send button
Then it shows a successful message "Thanks for contacting us! We will get in touch with you shortly."

Examples:
|SheetName|RowNumber|
|contactus|0|
#|contactus|1|
#|contactus|2|
#|contactus|3|
#|contactus|4|
#|contactus|5|


