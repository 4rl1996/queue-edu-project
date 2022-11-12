# Queue-edu-project

Учебный проект, создание схемы "точка-точка".

Простой запуск приложения: 

В каталоге /dev выполнить команду <strong>docker-compose up -d</strong>

<strong>mvn clean install</strong> в /api-contracts

В разных терминалах выполнить команду <strong>mvn clean package spring-boot:run</strong> в /queue-edu и в /queue-edu-new.

queue-edu-new публикует сообщение в fanout-exchange. Оба приложения читают одинаковое сообщение и выводят в консоль.

Должны быть установлен maven и docker-compose.


