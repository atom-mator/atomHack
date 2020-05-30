Feature: MakeMyTrip Hotel booking

  @test1
  Scenario Outline: Verify hotel Booking summary is as per the selected user criteria
    Given I open MakeMyTrip in browser
    #---------HomePage------------
    When I login to MakeMyTrip portal
    And I select "<NavigationMenu>" navigation menu
    And I select place "<Place>"
    And I select CheckIn date "<CheckInDate>" and Checkout date "<CheckOutDate>"
    And I select "<RoomCount>" rooms for "<AdultCount>" adults and "<ChildrenCount>" children each
    And I select reason for travelling "Leisure"
    Then I click on Search button
    #---------------------------
    When I select min price range to "1000" INR
    And I select User rating "4 & above"
    And I capture name of "5th" listed hotel from the top
    And I select "5th" listed hotel from the top
    #---------switch page---------
    Then I am navigated to rooms section page
    And I capture name of "1st" available room
    When I select "1st" available room
    #---------------------------------
    #may include a verification point
    And I fill in traveller's information with below values
      | Title | FirstName   | LastName   | Email   | PhoneNumber   |
      | Mr    | <FirstName> | <LastName> | <Email> | <PhoneNumber> |
    And I select below COMMONLY REQUESTED options
      | Smoking room  |
      | Late check-in |
    And I uncheck Rs 5 to MMT foundation option
    When I click "Pay Now" button on review your booking page
    #----------------------------
    Then I verify below information in Booking summary section
      | Hotel name      |
      | Checkin date    |
      | Checkout date   |
      | number of rooms |
      | guests          |
      | room type       |
      | first name      |
      | last name       |
      | phone number    |
      | email id        |

#      | Hotel name      | saved
#      | Checkin date    | param
#      | Checkout date   | param
#      | number of rooms | param
#      | guests          | param
#      | room type       | saved
#      | first name      | param
#      | last name       | param
#      | phone number    | param
#      | email id        | param
#
    Examples:
      | NavigationMenu | Place    | CheckInDate | CheckOutDate | RoomCount | AdultCount | ChildrenCount | FirstName | LastName | Email                     | PhoneNumber |
      | Hotel          | Mirzapur | 2-July-2020 | 10-July-2020 | 2         | 2          | 2             | Ramesh    | Babu     | ramesh.babu.xyz@gmail.com | 9577483377  |







