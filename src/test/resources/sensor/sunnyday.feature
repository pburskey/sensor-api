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



#
#
#  Start: Sun Apr 29 21:02:05 CDT 2018
#  Stop: Sun Apr 29 21:02:53 CDT 2018
#  Measurement: Sun Apr 29 21:02:08 CDT 2018 68.98
#  Measurement: Sun Apr 29 21:02:09 CDT 2018 69.43
#  Measurement: Sun Apr 29 21:02:10 CDT 2018 68.93
#  Measurement: Sun Apr 29 21:02:11 CDT 2018 68.98
#  Measurement: Sun Apr 29 21:02:12 CDT 2018 68.6
#  Measurement: Sun Apr 29 21:02:13 CDT 2018 68.1
#  Measurement: Sun Apr 29 21:02:14 CDT 2018 68.14
#  Measurement: Sun Apr 29 21:02:15 CDT 2018 68.1
#  Measurement: Sun Apr 29 21:02:16 CDT 2018 68.53
#  Measurement: Sun Apr 29 21:02:17 CDT 2018 68.15
#  Measurement: Sun Apr 29 21:02:18 CDT 2018 68.1
#  Measurement: Sun Apr 29 21:02:19 CDT 2018 68.14
#  Measurement: Sun Apr 29 21:02:20 CDT 2018 68.15
#  Measurement: Sun Apr 29 21:02:21 CDT 2018 68.12
#  Measurement: Sun Apr 29 21:02:22 CDT 2018 68.14
#  Measurement: Sun Apr 29 21:02:23 CDT 2018 68.1
#  Measurement: Sun Apr 29 21:02:24 CDT 2018 68.17
#  Measurement: Sun Apr 29 21:02:25 CDT 2018 68.12
#  Measurement: Sun Apr 29 21:02:26 CDT 2018 68.15
#  Measurement: Sun Apr 29 21:02:27 CDT 2018 68.17
#  Measurement: Sun Apr 29 21:02:28 CDT 2018 68.17
#  Measurement: Sun Apr 29 21:02:29 CDT 2018 69.01
#  Measurement: Sun Apr 29 21:02:30 CDT 2018 68.07
#  Measurement: Sun Apr 29 21:02:31 CDT 2018 68.53
#  Measurement: Sun Apr 29 21:02:32 CDT 2018 68.15
#  Measurement: Sun Apr 29 21:02:33 CDT 2018 68.12
#  Measurement: Sun Apr 29 21:02:34 CDT 2018 68.58
#  Measurement: Sun Apr 29 21:02:35 CDT 2018 68.57
#  Measurement: Sun Apr 29 21:02:36 CDT 2018 68.53
#  Measurement: Sun Apr 29 21:02:37 CDT 2018 68.56
#  Measurement: Sun Apr 29 21:02:38 CDT 2018 68.09
#  Measurement: Sun Apr 29 21:02:39 CDT 2018 68.53
#  Measurement: Sun Apr 29 21:02:40 CDT 2018 68.57
#  Measurement: Sun Apr 29 21:02:41 CDT 2018 68.52
#  Measurement: Sun Apr 29 21:02:42 CDT 2018 68.12
#  Measurement: Sun Apr 29 21:02:43 CDT 2018 68.57
#  Measurement: Sun Apr 29 21:02:44 CDT 2018 68.58
#  Measurement: Sun Apr 29 21:02:45 CDT 2018 68.19
#  Measurement: Sun Apr 29 21:02:46 CDT 2018 68.19
#  Measurement: Sun Apr 29 21:02:47 CDT 2018 68.12
#  Measurement: Sun Apr 29 21:02:48 CDT 2018 68.53
#  Measurement: Sun Apr 29 21:02:49 CDT 2018 68.1
#  Measurement: Sun Apr 29 21:02:50 CDT 2018 68.09
#  Measurement: Sun Apr 29 21:02:51 CDT 2018 68.12
#  Measurement: Sun Apr 29 21:02:52 CDT 2018 68.17
#
#
#
#
#
#
#
#
#  Measurement: Sun Apr 29 21:36:08 CDT 2018 2.615470642671832E13
#  Measurement: Sun Apr 29 21:36:09 CDT 2018 68.14
#  Measurement: Sun Apr 29 21:36:10 CDT 2018 68.29
#  Measurement: Sun Apr 29 21:36:11 CDT 2018 68.15
#  Measurement: Sun Apr 29 21:36:12 CDT 2018 68.12
#  Measurement: Sun Apr 29 21:36:13 CDT 2018 68.12
#  Measurement: Sun Apr 29 21:36:14 CDT 2018 399.49
#  Measurement: Sun Apr 29 21:36:15 CDT 2018 68.17
#  Measurement: Sun Apr 29 21:36:16 CDT 2018 68.07
#  Measurement: Sun Apr 29 21:36:17 CDT 2018 68.12
#  Measurement: Sun Apr 29 21:36:18 CDT 2018 68.09
#  Measurement: Sun Apr 29 21:36:19 CDT 2018 68.12
#  Measurement: Sun Apr 29 21:36:20 CDT 2018 68.14
#  Measurement: Sun Apr 29 21:36:21 CDT 2018 68.16
#  Measurement: Sun Apr 29 21:36:22 CDT 2018 68.57
#  Measurement: Sun Apr 29 21:36:23 CDT 2018 68.16
#  Measurement: Sun Apr 29 21:36:24 CDT 2018 68.53
#  Measurement: Sun Apr 29 21:36:25 CDT 2018 68.14
#  Measurement: Sun Apr 29 21:36:26 CDT 2018 69.03
#  Measurement: Sun Apr 29 21:36:27 CDT 2018 68.08
#  Measurement: Sun Apr 29 21:36:28 CDT 2018 68.14
#  Measurement: Sun Apr 29 21:36:29 CDT 2018 68.16
#  Measurement: Sun Apr 29 21:36:30 CDT 2018 68.12
#  Measurement: Sun Apr 29 21:36:31 CDT 2018 68.5
#  Measurement: Sun Apr 29 21:36:32 CDT 2018 68.07
#  Measurement: Sun Apr 29 21:36:33 CDT 2018 68.57
#  Measurement: Sun Apr 29 21:36:34 CDT 2018 68.2
#  Measurement: Sun Apr 29 21:36:35 CDT 2018 68.16
#  Measurement: Sun Apr 29 21:36:36 CDT 2018 68.12
#  Measurement: Sun Apr 29 21:36:37 CDT 2018 68.09
#  Measurement: Sun Apr 29 21:36:38 CDT 2018 68.15
#  Measurement: Sun Apr 29 21:36:39 CDT 2018 68.1
#  Measurement: Sun Apr 29 21:36:40 CDT 2018 68.14
#  Measurement: Sun Apr 29 21:36:41 CDT 2018 68.14
#  Measurement: Sun Apr 29 21:36:42 CDT 2018 68.14
#  Measurement: Sun Apr 29 21:36:43 CDT 2018 68.16
#  Measurement: Sun Apr 29 21:36:44 CDT 2018 68.53
#  Measurement: Sun Apr 29 21:36:45 CDT 2018 68.58
#  Measurement: Sun Apr 29 21:36:46 CDT 2018 68.1
#  Measurement: Sun Apr 29 21:36:47 CDT 2018 68.14
#  Measurement: Sun Apr 29 21:36:49 CDT 2018 68.05
#  Measurement: Sun Apr 29 21:36:50 CDT 2018 68.15
#  Measurement: Sun Apr 29 21:36:51 CDT 2018 68.1
#  Measurement: Sun Apr 29 21:36:52 CDT 2018 68.1
#  Measurement: Sun Apr 29 21:36:53 CDT 2018 68.17