# План тестирования
## 1 Перечень автоматизируемых сценариев
### 1.1 Оплата тура дебетовой картой
- нажать кнопку **Купить**

_Ожидаемый результат:_ открывается раздел **Оплата по карте**

### 1.1.1 Заполнить поля формы валидными значениями
#### для положительного результата
  - Номер карты 4444 4444 4444 4441
  - Месяц (01, 02, 03, 04, 05, 06, 07, 08, 09, 10, 11, 12)
  - Год (две последние цифры текущего и последующих годов)
  - Владелец (Фамилия и имя )
  - CVC/CVV (три цифры)
  - Нажать кнопку **Продолжить** 

  _Ожидаемый результат:_ на экране появляется сообщение "Операция одобрена Банком"

#### для отрицательного результата

  - Номер карты 4444 4444 4444 4442
  - Месяц (01, 02, 03, 04, 05, 06, 07, 08, 09, 10, 11, 12)
  - Год (две последние цифры текущего и последующих годов)
  - Владелец (Фамилия и имя )
  - CVC/CVV (три цифры)
  - Нажать кнопку **Продолжить**

  _Ожидаемый результат:_ на экране появляется сообщение "Банк отказал в проведении операции"

### 1.1.2 Оставить одно из полей пустыми

  - поле **Номер карты** оставить пустым, поля **Месяц**, **Год**, **Владелец**, **CVC/CVV** заполнить 
  валидными значениями
  
  _Ожидаемый результат:_ под полем **Номер карты** появляется сообщение красного 
цвета "Неверный формат"

  - поле **Месяц** оставить пустым, поля **Номер карты**, **Год**, **Владелец**, **CVC/CVV** заполнить валидными
  значениями

  _Ожидаемый результат:_ под полем **Месяц** появляется сообщение красного
    цвета "Неверный формат"

  - поле **Год** оставить пустым, поля **Номер карты**, **Месяц**, **Владелец**, **CVC/CVV** заполнить 
  валидными значениями

  _Ожидаемый результат:_ под полем **Год** появляется сообщение красного
    цвета "Неверный формат"

  - поле **Владелец** оставить пустым, поля **Номер карты**, **Месяц**, **Год**, **CVC/CVV** заполнить 
  валидными значениями

  _Ожидаемый результат:_ под полем **Владелец** появляется сообщение красного цвета 
  "Поле обязательно для заполнения"

  - поле **CVC/CVV** оставить пустым, поля **Номер карты**, **Месяц**, **Год**, **Владелец** заполнить
  валидными значениями

  _Ожидаемый результат:_ под полем **CVC/CVV** появляется сообщение красного цвета
  "Неверный формат"

### 1.1.3 Одно из полей заполнить невалидным значением

   - поле **Номер карты** заполнить значением, содержащим менее 16 цифр, поля **Месяц**, 
   **Год**, **Владеелец**, **CVC/CVV** заполнить валидными значениями

  _Ожидаемый результат:_ под полем **Номер карты** появляется сообщение красного цвета
  "Неверный формат"

   - поле **Месяц** заполнить любым числом (кроме чисел 01, 02, 03, 04, 05, 06, 07, 08, 09, 10,
   11, 12), либо числом ранее текущего месяца, поля **Номер карты**, **Год**, **Владелец**, **CVC/CVV** заполнить валидными значениями
   
   _Ожидаемый результат:_ под полем **Месяц** появляется сообщение красного цвета "Неверно указан
   срок действия карты"

   - поле **Год** заполнить значением меньше текущего года, поля **Номер карты**, **Месяц**, **Владелец**,
   **CVC/CVV** заполнить валидными значениями

   _Ожидаемый результат:_ под полем Год появляется сообщение красного цвета "Истек срок действия карты"
   
   - поле **Владелец** заполнить цифрами, поля **Номер карты**, **Месяц**, **Год**, **CVC/CVV** заполнить 
   валидными значениями

   _Ожидаемый результат:_ под полем **владелец** появляется сообщение красного цвета "Неверный формат"
   
   - поле **CVC/CVC** заполнить одно- или двухзначным числом, поля **Номер карты**, **Месяц**, **Год**, 
   **Владелец** заполнить валидными значениями
   
  _Ожидаемый результат:_ под полем **CVC/CVV** появляется сообщение красного цвета "Неверный формат"

### 1.2 Покупка тура в кредит

- нажать кнопку **Купить в кредит**
 
_Ожидаемый результат:_ открывается раздел **Кредит по данным карты**

### 1.2.1 Заполнить поля формы валидными значениями
#### для положительного результата
  - Номер карты 4444 4444 4444 4441
  - Месяц (01, 02, 03, 04, 05, 06, 07, 08, 09, 10, 11, 12)
  - Год (две последние цифры текущего и последующих годов)
  - Владелец (Фамилия и имя )
  - CVC/CVV (три цифры)
  - Нажать кнопку **Продолжить**

  _Ожидаемый результат:_ на экране появляется сообщение "Операция одобрена Банком"

#### для отрицательного результата
  - Номер карты 4444 4444 4444 4442
  - Месяц (01, 02, 03, 04, 05, 06, 07, 08, 09, 10, 11, 12)
  - Год (две последние цифры текущего и последующих годов)
  - Владелец (Фамилия и имя )
  - CVC/CVV (три цифры)
  - Нажать кнопку **Продолжить**

  _Ожидаемый результат:_ на экране появляется сообщение "Банк отказал в проведении операции"

### 1.2.2 Оставить одно из полей пустыми
  - поле **Номер карты** оставить пустым, поля **Месяц**, **Год**, **Владелец**, **CVC/CVV** заполнить
    валидными значениями

  _Ожидаемый результат:_ под полем **Номер карты** появляется сообщение красного
    цвета "Неверный формат"

  - поле **Месяц** оставить пустым, поля **Номер карты**, **Год**, **Владелец**, **CVC/CVV** заполнить валидными
    значениями

  _Ожидаемый результат:_ под полем **Месяц** появляется сообщение красного
    цвета "Неверный формат"

  - поле **Год** оставить пустым, поля **Номер карты**, **Месяц**, **Владелец**, **CVC/CVV** заполнить
    валидными значениями

  _Ожидаемый результат:_ под полем **Год** появляется сообщение красного
    цвета "Неверный формат"

  - поле **Владелец** оставить пустым, поля **Номер карты**, **Месяц**, **Год**, **CVC/CVV** заполнить
    валидными значениями

  _Ожидаемый результат:_ под полем **Владелец** появляется сообщение красного цвета
    "Поле обязательно для заполнения"

  - поле **CVC/CVV** оставить пустым, поля **Номер карты**, **Месяц**, **Год**, **Владелец** заполнить
    валидными значениями

  _Ожидаемый результат:_ под полем **CVC/CVV** появляется сообщение красного цвета
    "Неверный формат"

### 1.2.3 Одно из полей заполнить невалидным значением

  - поле **Номер карты** заполнить значением, содержащим менее 16 цифр, поля **Месяц**,
    **Год**, **Владеелец**, **CVC/CVV** заполнить валидными значениями

  _Ожидаемый результат:_ под полем **Номер карты** появляется сообщение красного цвета
  "Неверный формат"

  - поле **Месяц** заполнить любым числом (кроме чисел 01, 02, 03, 04, 05, 06, 07, 08, 09, 10,
    11, 12), либо числом ранее текущего месяца, поля **Номер карты**, **Год**, **Владелец**, **CVC/CVV**
    заполнить валидными значениями

  _Ожидаемый результат:_ под полем **Месяц** появляется сообщение красного цвета "Неверно указан
    срок действия карты"

  - поле **Год** заполнить значением меньше текущего года, поля **Номер карты**, **Месяц**, **Владелец**,
    **CVC/CVV** заполнить валидными значениями

  _Ожидаемый результат:_ под полем Год появляется сообщение красного цвета "Истек срок действия карты"
  - поле **Владелец** заполнить цифрами, поля **Номер карты**, **Месяц**, **Год**, **CVC/CVV** заполнить
    валидными значениями

  _Ожидаемый результат:_ под полем **владелец** появляется сообщение красного цвета "Неверный формат"

  - поле **CVC/CVC** заполнить одно- или двухзначным числом, поля **Номер карты**, **Месяц**, **Год**,
    **Владелец** заполнить валидными значениями

_Ожидаемы результат:_ под полем **CVC/CVV** появляется сообщение красного цвета "Неверный формат"

## 2 Перечень используемых инструментов с обоснованием выбора
  - Java - язык ООП
  - IntelliJ IDEA - для разработки ПО
  - Docker compose - для запуска контейнерв с БД
  - Selenide - для разработки UI-тестов на Java
  - JUnit - для тестирования кода
  - Faker - для генерации случайных значений
  - Allure - для отчетности

## 3 Перечень и описание возможных рисков при автоматизации
  - неверная оценка трудозатрат
  - изменение требований со стороны заказчика
  - трудности при поиске локаторов
  - изменение структуры сайта


## 4 Интервальная оценка с учетом рисков (в часах)
  - 4,5 часа для планирования тестирования
  - 40 часов для разработки и корректировки автотестов
  - 4 часа для подготовки отчетных документов по итогаи тестирования
  - 4 часа для подготовки отчетных документов по итогам автоматизации

## 5 План сдачи работ
  - 08.08.2022 план тестирования
  - 18.08.2022 автотесты
  - 22.08.2022 отчет по итогам тестирования
  - 26.08.2022 отчет по итогам автоматизации
