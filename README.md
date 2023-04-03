# Queue-edu-project

Учебный проект, создание схемы "точка-точка".

+ [Простой запуск приложения](#Start)
+ [О настройке приложений](#Apps)
+ [О настройке брокера RabbitMQ в контейнере](#Broker)

### <a name="Start"></a> Простой запуск приложения 

Должны быть установлен maven и docker-compose.

В каталоге /dev выполнить команду <strong>docker-compose up -d</strong>

В каталоге /queue-edu-new-api <strong>mvn clean install</strong>


В разных терминалах выполнить команду 

1) <strong>mvn clean package spring-boot:run</strong> в /queue-edu-new.
2) <strong>mvn clean package spring-boot:run</strong> в /queue-edu

queue-edu-new публикует сообщение в fanout-exchange. Оба приложения читают одинаковое сообщение и выводят в консоль.

### <a name="Apps"></a> О настройке приложений

В application.yaml добавлен параметр <strong>spring.rabbitmq.listener.simple.default-requeue-rejected: false</strong>
По умолчанию этот параметр имет значение true, и при ошибках в листенере сообщение заново отправляется в очередь, после чего хэдер amqp_redelivered принимает значение true (дефолт amqp_redelivered=false)
Для того, чтобы сообщения отправлялись в dlq, мы меняем значение с true на false

### <a name="Broker"></a> О настройке брокера RabbitMQ в контейнере

В файле /dev/rabbitmq-defs.json производится стартовая настройка брокера в контейнере:
1) Exchanges: везде установлено значение <strong>durable: false</strong>, чтобы при каждом перезапуске контейнера все exchange создавались заново (в рамках учебного проекта). 
Для dql-exchange установлено значение <strong>internal: true</strong> - это значит, что эти exchange используются для внутреннего взаимодействия на брокере, и продьюсер не может напрямую в них отправить сообщение.
Значение <strong>auto_delete: false</strong> указывает на то, что это не временные exchange, и если для них не будет листенеров, то они не удалятся автоматически.
2) Queues: параметры <strong> durable / auto_delete </strong> выставлены аналогично с exchanges. Также добавлены аргументы, где указываются dlq-exchange, а для самих dlq указываются параметры лимита сообщений и параметры переполнения.
3) Bindings: биндинг exchange и queue. Для fanout-exchange биндинг двух очередей из разных сервисов.
4) Vhosts - задаем хосты
5) Users / Permissions - можно задавать списки пользователей и политики для них

В файле /dev/rabbitmq.conf укзывается, какой файл с определениями брать при запуске <strong>(load_definitions = )</strong>





