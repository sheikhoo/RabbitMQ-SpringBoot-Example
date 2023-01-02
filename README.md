# RabbitMQ-SpringBoot-Example
Example RabbitMQ SpringBoot

## Run Rabbitmq on Docker
  
  `docker run -d --name my-rabbit -p 4369:4369 -p 5671:5671 -p 5672:5672 -p 15672:15672 rabbitmq:3.9-management`
 
then you can enable its management plugins while that container runs using the following command:

`docker container exec -it my-rabbit rabbitmq-plugins enable rabbitmq_management`
  
