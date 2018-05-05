Feature: sensor testing

  Scenario Outline: a
    Given that I have a measurement
      | Date and Time   | Measurement   |
      | <Date and Time> | <Measurement> |
    Then the date and time are understood
    Then the measurement is understood

    Examples:
      | Date and Time       | Measurement |
      | 2018-04-22_17:03:33 | 12.34       |

