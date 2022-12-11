# Queue-edu-project

Учебный проект, создание схемы "точка-точка".

Простой запуск приложения: 

В каталоге /dev выполнить команду <strong>docker-compose up -d</strong>


В разных терминалах выполнить команду 

1) <strong>mvn clean package spring-boot:run</strong> в /queue-edu-new.
2) <strong>mvn clean package spring-boot:run</strong> в /queue-edu

queue-edu-new публикует сообщение в fanout-exchange. Оба приложения читают одинаковое сообщение и выводят в консоль.

Должны быть установлен maven и docker-compose.


