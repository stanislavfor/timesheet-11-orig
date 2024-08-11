# Фреймворк Spring (семинары)

## Урок 11. 
## Spring Actuator. Настройка мониторинга с Prometheus и Grafana.

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


<br>

## Дополнительно
<br>

### Eureka Server:
## http://localhost:8761/

### Страница с данными:
## http://localhost:8081/timesheets

### Страница проекта:
## http://localhost:3333/timesheets

<br><br><br><br>