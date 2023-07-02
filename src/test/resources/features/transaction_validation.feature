@validateTxs
Feature: Validate transactions
  As a node operator,
  I want the system to automatically validate the largest possible set of mutually valid transactions,
  so that I can optimize my earnings from transaction fees.

  Scenario Outline:
    Given I have a set of candidate transactions <setId>
    When I extract a subset with the highest total fees
    Then the total fee of the subset should be <maximumFee>
    Examples:
      | setId | maximumFee |
      | 1     | 0.01       |
      | 2     | 0.003      |