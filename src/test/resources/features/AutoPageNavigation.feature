Feature: As a user I want to navigate Auto site sections.

  Scenario: Navigation header category submenu contains options.
    Given user navigates home page
    When user hovers 'Автобарахолка' category in header
    Then submenu with options appears
      | Гомель           |
      | BMW              |
      | Минск            |
      | Авто до 4000 р.  |
      | Авто до 10000 р. |