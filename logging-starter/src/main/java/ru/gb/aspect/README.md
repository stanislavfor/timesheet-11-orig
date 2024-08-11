# Фреймворк Spring (семинары)

## Урок 11. Spring Actuator. Настройка мониторинга с Prometheus и Grafana.

#### Задание:<br> Напишите тесты для основной логики вашего приложения с использованием Spring Testing, JUnit и Mockito.<br><br>

### Описание<br>

- Настройка Spring Actuator для мониторинга приложения.<br>
- Интеграция Spring Actuator с Prometheus для сбора метрик.<br>
- Настройка дашборда Grafana для визуализации метрик, собранных Prometheus.<br>
  <br>

### Домашнее задание

1. Доделать logging-aspect:<br> 
  добавить настройку boolean printArgs = false.<br>
  Если значение true, тогда в аспекте логировать значения аргументов. <br>
2. ** Вынести RecoverAspect в стартер. <br>
  Добавить в его конфигурацию настройки:<br> 
  - boolean enabled - включает и выключает работу аспекта <br>
  - List<String> noRecoverFor - список названий классов (полное имя) исключений, для которых НЕ нужно делать Recover.<br>
<br>

### Решение

<br><br>

## Дополнительная информация

<br><br>

- Начальная страница локального сервера (Таблицы)<br><br>

  http://localhost:8080/login<br><br>
  или<br><br>
  http://localhost:8080/home/timesheets<br>

```
http://localhost:8080/home/timesheets

```

- Страница проекта, например :

```
http://localhost:8080/home/projects/1

```

- Страница записи, например :

```
http://localhost:8080/home/timesheets/1

```

<br>

### Автоматическое форматирование кода в Intellij IDEA<br><br>

- В настройках IDE для автоматического переформатирования кода необходимо проверить наличие форматирования
  java-файла,<br>
  для этого нажать сочетание клавиш **Ctrl + Alt + S**, чтобы открыть настройки IDE, и выбрать **Tools | Actions on Save
  **, далее включить параметр **Reformat code**, отметив чекбокс 'Reformat code'.<br><br>

- Для форматирования содержимого java-файла, нажать сочетание клавиш
  **Ctrl + Alt + L** - Reformat code

<br><br><br>