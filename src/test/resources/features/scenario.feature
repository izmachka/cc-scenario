Feature: Find restaurant
  #Позитивный сценарий: выбираем город краснодар и получем меню для краснодара
  Scenario: chose restaurant city
    Given url of restaurant 'https://dodopizza.ru/'
    Then  choose city 'Санкт-Петербург'
    And assert that choosen city is 'Санкт-Петербург'
    #Негатинвый сценарий: выбираем несушествующий город, получаем соответствуещее уведомление
  Scenario: chose absent city
    Given url of restaurant 'https://dodopizza.ru/'
    Then  choose city 'Эльдарадо'
    And assert that user got message 'Пиццерия в этом городе еще не открылась'
    #Позитивный сценарий: вход в личный кабинет с правильными входными данными
  Scenario: Sign in to Dodopizza
    Given url of restaurant 'https://dodopizza.ru/'
    Then  choose city 'Санкт-Петербург'
    Then choose button 'Войти'
    Then user enters login '9773430958'
    Then assert the button is orange and push 'Выслать код'
    And user got message 'Вход на сайт'
    #Негатинвый сценарий: вход в личный кабинет с не правильными входными данными
  Scenario: Sign in to Dodopizza
    Given url of restaurant 'https://dodopizza.ru/'
    Then  choose city 'Санкт-Петербург'
    Then choose button 'Войти'
    Then user enters login '111111111'
    Then assert the button is grey and do not push 'Выслать код'


