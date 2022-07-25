Feature: As a user I want to navigate site via submenu options.

  Scenario: Navigation header category submenu contains options.
    Given user navigates home page
    When user hovers 'Автобарахолка' category in header
    Then submenu with options appears
      | Гомель            |
      | BMW               |
      | Минск             |
      | Авто до 4000 р.   |
      | Авто до 10 000 р. |

  Scenario: Navigation header category submenu contains options.
    Given user navigates home page
    When user hovers 'Дома и квартиры' category in header
    Then submenu with options appears
      | Гомель          |
      | 1-комнатные     |
      | Минск           |
      | 30 000–80 000 $ |