### Отчет по итогам автоматизации
Что было запланировано и что реализовано
Запланировано было 26 тестовых ценариев, реализовано 35. Были реадизованы все запланированные
тесты. Также п мере изучения сервиса были дописаны дополнительные UI-тесты.

### Причины, по которым что-то не было реалировано
1. Не была реализована интеграция системы с Appveyor CI, т.к нет достоточного опыта потребовалось бы 
значительное время для реализации.
2. Не удалось проверить обработку платежей и их фиксацию, т.к. не отправляются запросы

### Сработавшие риски
1. Неверная оценка трудозатрат. Основная причина с которой пришлось столкнуться это недостаточно опыта и
нехватка времени(т.к. много времени отнимает основная работа).
2. Трудности при поиске локаторов (отсутствие должного опыта).
3. Отсутствие какой-либо документации.

### Сколько запланировали и сколько выполнили с обоснованием расхождения
Написание тестов заняло больше времени, чем планировалось. Много времени ушло на запуск приложения.
Долгое время пыталась в таблицах увидеть какие-либо записи. Не удалось. Был сделан вывод, что это BUG. 
Автотесты DBTest были реализованы исходя из этого BUGа.  