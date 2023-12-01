# VinhoJá

### Projeto FullStack: 🍇🍷

O Projeto VinhoJá é uma aplicação web desenvolvida utilizando as tecnologias Java, Spring boot 3+ e Angular. O objetivo do projeto é fornecer para uma plataforma de vinho um sistema onde os usuários possam comprar seus vinhos com segurança e tratamento personalizado.  O projeto é feito em arquitetura de microsservice que seguem boas práticas como LoadBalance, Distributed Tracing, gataway, centralized configuration, centralized documentation, Docker, comunicação síncrona e assíncrona.

https://github.com/AugustoMello09/Locadora/assets/101072311/b490b3c7-200d-4a45-9ee7-7c9226a5de35

### Backend: ⚙️

## Arquitetura de Microsservices vinhoJá 🧱


![arquitetura](https://github.com/AugustoMello09/Locadora/assets/101072311/18af3776-c311-4ba6-b269-a114fd7b5fe4)


#### Microsservice de cadastro de usuário (User Service): 👷‍♀️

- Responsável pelo cadastro e gerenciamento de informações do usuário, como nome e e-mail.
- Fornece endpoints para registro de novos usuários.

#### Microsservice de cadastro de cartão (Card Service): 💳

- Responsável pelo cadastro e gerenciamento de informações do cartão, como nome do cartão, número do cartão, data de validade e código de segurança.
- Fornece endpoints para registro de novos cartões.


#### Microsservice  de pagamento (Payment Service): 💸

- Lida com informações financeiras, como detalhes do cartão de crédito, dados do usuário como nome e email.
- Fornece endpoints para fazer o processamento de pagamento.
- Se comunica com o a fila de emissão-pagamento.

#### Microsservice de email (Email Service): ✉️

- Fica responsável por escutar a fila de emissão-pagamento e enviar o Email de confirmação de compra agradecendo a pessoa.

## Fluxo entre Microsservices: 💫

- O User Service e o Card Service são responsáveis pelo cadastro de informações do usuário e do cartão, respectivamente. Esses serviços podem ser utilizados de forma independente para gerenciar perfis de usuário e detalhes do cartão.

- Quando um usuário realiza uma transação, o Payment Service é acionado. Ele utiliza as informações do usuário e do cartão para processar o pagamento.

- Após o processamento bem-sucedido, o Payment Service coloca uma mensagem na fila de emissão-pagamento para notificar o Email Service.

- O Email Service, ao escutar a fila de emissão-pagamento, envia automaticamente um e-mail de confirmação de compra ao usuário.

![fluxovinho](https://github.com/AugustoMello09/Locadora/assets/101072311/19ffe2a2-90e5-4966-a8ff-a25b9305d250)

## comunicação entre microsservices:

### Fluxo com comunicação síncrona: 🔄

- Para o processamento ser bem-sucedido ele depende de dois parâmetros como o UUID do usuário e UUID do mesmo, para pegar esses dados é usado OpenFeign para esse tipo de comunicação.

![si](https://github.com/AugustoMello09/Locadora/assets/101072311/384ee98a-87b1-4f19-8d53-cb61e64203c6)

### Fluxo com comunicação assíncrona: ⏱️

- Após o processamento bem-sucedido, o Payment Service coloca uma mensagem na fila de emissão-pagamento para notificar o Email Service e ele consome essa mensagem enviando para o endereço de e-mail informado.

![as](https://github.com/AugustoMello09/Locadora/assets/101072311/d92f50bf-4be5-40a0-be8e-b6f39769de8e)

## Documentação centralizada com Swagger: 📗

- Centralizamos a documentação do nosso sistema de pagamento usando Swagger, proporcionando uma visão unificada e acessível de todos os nossos serviços

![swagger](https://github.com/AugustoMello09/Locadora/assets/101072311/ac154f64-3fbe-4fef-b34a-75c016a96fbf)

https://github.com/AugustoMello09/Locadora/assets/101072311/7ccaf2f8-af35-44c9-9a45-6b7e29a93341

__Acesse a documentação do projeto:__

- __Acesse:__ http://localhost:8080/swagger-ui.html para visualizar os endpoints.

## Configuração centralizada com Config Service: ⚙️

- O serviço de Configuração Centralizada (Config Service) do projeto VinhoJá é uma parte essencial da arquitetura de microsservice. Ele é responsável por centralizar e gerenciar as configurações de todos os microsservices da aplicação.

__Acesse o repositório do config service:__

- __Acesse:__ https://github.com/AugustoMello09/vinhoja-config-server

## Distributed Tracing com ZIPKIN: 👁️‍🗨️

- Implementação Distributed Tracing no sistema utilizando o Zipkin, uma ferramenta poderosa para monitorar e analisar o fluxo de solicitações em ambientes distribuídos.

![zip](https://github.com/AugustoMello09/Locadora/assets/101072311/f84ac63b-062d-46a2-a3f1-99edf31890be)

https://github.com/AugustoMello09/Locadora/assets/101072311/7877152b-9175-409f-854a-89f09f7ece97

__Acesse a documentação do projeto:__

- __Acesse:__ http://localhost:9411/zipkin/ para visualizar o Zipkin.

### Ferramentas e Tecnologias usadas no Back-end 🧱
<div style="display: inline_block"><br>

<img align="center" alt="Augusto-Java" height="70" width="70" src="https://github.com/devicons/devicon/blob/master/icons/java/java-original.svg">
<img align="center" alt="Augusto-SpringBoot" height="70" width="70" src="https://raw.githubusercontent.com/devicons/devicon/1119b9f84c0290e0f0b38982099a2bd027a48bf1/icons/spring/spring-original-wordmark.svg">
<img align="center" alt="Augusto-POSTGRESQL" height="60" width="60" src="https://raw.githubusercontent.com/devicons/devicon/1119b9f84c0290e0f0b38982099a2bd027a48bf1/icons/postgresql/postgresql-original-wordmark.svg">
<img align="center" alt="Augusto-Rabbitmq" height="40" width="40"
src="https://www.svgrepo.com/show/303576/rabbitmq-logo.svg">
<img align="center" alt="Augusto-Docker" height="70" width="70" src="https://raw.githubusercontent.com/devicons/devicon/1119b9f84c0290e0f0b38982099a2bd027a48bf1/icons/docker/docker-original.svg">
<img align="center" alt="Augusto-Java" height="40" width="40" src="https://github.com/AugustoMello09/Locadora/assets/101072311/a895137a-8126-4eed-8a5c-9934ed30401b">

</div>

## Execute o projeto 👁‍🗨

### Backend 🧱

__Pré-requisitos:__ Java 17 e Docker

__Clone o repositório do projeto__

~~~~~~
git clone https://github.com/AugustoMello09/VinhoJa.git
~~~~~~

### Configurando o projeto local 🏠

__Configurando o ambiente:__

- Navegue até o diretório do projeto

~~~~~~
cd vinhoJa/vinhoJa-Backend
~~~~~~

- Acesse todos os diretórios do projeto, utilize o comando mvn install para instalar todas as dependências necessárias:

~~~~~~
# exemplo
cd vinhoJa-Backend/users

./mvnw install
~~~~~~

- Acesse o diretório de cada microsserviço (por exemplo, User Service, Card Service).
Abra o arquivo de configuração application.yml.

- Modifique as configurações necessárias, como URLs dos serviços dependentes.

~~~~~~
management:
  tracing:
    sampling:
      probability: 1.0
  zipkin:
    tracing:
      endpoint: http://localhost:9411/api/v2/spans

///////////////////////////////////////////////////

  config:
    import: optional:configserver:http://localhost:8888

  rabbitmq:
    host: localhost       
~~~~~~

__Senhas de App__

__Acesse a documentação do google:__

- __Acesse:__ https://support.google.com/accounts/answer/185833 para visualizar o como criar a senha de App.

- Tenha a verificação em duas etapas ativada.

![1](https://github.com/AugustoMello09/vinhoja-config-server/assets/101072311/fc6e1105-e9bf-4291-8b0c-7a4ff728d509)

- Acesse o local para criar a senha de App

![Screenshot_3](https://github.com/AugustoMello09/vinhoja-config-server/assets/101072311/1789f4a3-c6bd-44d5-8a71-528d84992ba4)

- Crie a senha de App

![Screenshot_2](https://github.com/AugustoMello09/vinhoja-config-server/assets/101072311/a547b0cb-6c0d-4483-ae94-53fe67cb607f)

- Acesse o diretório do microsservice email e coloque suas informações de email

`
🔴: o email com a verificação em duas etapas.
🟢: a senha de App que criou.
`

![email](https://github.com/AugustoMello09/vinhoja-config-server/assets/101072311/c7dd815d-fa7a-4c07-9f5a-7ca9286f5b27)

- Crie um network

~~~~~~
docker network create local
~~~~~~

- Suba o container do serviço ZIPKIN e Rabbitmqp

~~~~~~
docker run -d -p 9411:9411 --net local --name zipkin openzipkin/zipkin:latest

docker run -d -it --rm --name rabbitmq --net local -p 5672:5672 -p 15672:15672 rabbitmq:3.12-management
~~~~~~

- Acesse o rabbit para criar a fila de emissao-pagamento

- __Acesse:__ http://localhost:15672/ para visualizar o Rabbitmq.

![criarfila](https://github.com/AugustoMello09/Locadora/assets/101072311/8bb9f159-df0b-479d-b5f0-5d9d316cdf3a)

- Suba os microsservices na seguinte ordem:

`config-service, euraka-service, gateway e etc...`

~~~~~~
# Exemplo para o User Service
cd user-service
./mvnw spring-boot:run
~~~~~~

### Configurando o projeto para usar Docker-compose 🐳

__Executar com Docker-compose:__

- Navegue até o diretório do projeto

~~~~~~
cd vinhoJa/vinhoJa-Backend
~~~~~~

- Acesse todos os diretórios do projeto, utilize o comando mvn install para instalar todas as dependências necessárias:

~~~~~~
# exemplo
cd vinhoJa-Backend/users

./mvnw install
~~~~~~

- Acesse o diretório de cada microsserviço (por exemplo, User Service, Card Service).
Abra o arquivo de configuração application.yml.

- Modifique as configurações necessárias, como URLs dos serviços dependentes.

~~~~~~
management:
  tracing:
    sampling:
      probability: 1.0
  zipkin:
    tracing:
      endpoint: http://zipkin-service:9411/api/v2/spans

///////////////////////////////////////////////////

  config:
    import: optional:configserver:http://config-service:8888

///////////////////////////////////////////////////

 rabbitmq:
    host: rabbit-mq  // nome do serviço lá no docker-compose         
~~~~~~

- Navegue até o local do arquivo docker-compose.yml e suba

~~~~~~
cd vinhoJa-Backend

docker-compose up -d
~~~~~~

- __ATENÇÃO__: a primeira vez que sobe o conteiner da o seguinte erro:
`dependency failed to start: container config-service is unhealthy`.

- Acesse o rabbit para criar a fila de emissao-pagamento

![criarfila](https://github.com/AugustoMello09/Locadora/assets/101072311/8bb9f159-df0b-479d-b5f0-5d9d316cdf3a)

- Suba o docker-compose novamente.

~~~~~~
cd vinhoJa-Backend

docker-compose up -d
~~~~~~

### Frontend 🌐

__Pré-requisitos:__ Angular

__Executar__

- Certifique-se de ter o Node.js e o Angular CLI instalados em seu ambiente.
- Navegue até a pasta do projeto front-end:

~~~~~~
cd vinhoJa/vinhoJa-Frontend
~~~~~~

__Instale as dependências do projeto:__

~~~~~~
npm install
~~~~~~

__Inicie a aplicação:__

~~~~~~
ng serve
~~~~~~

__ATENÇÃO__ : não use os dados do cartão de crédito real.

- __Acesse:__ https://www.4devs.com.br/gerador_de_numero_cartao_credito para gerar os dados do cartão.

### Ferramentas e Tecnologias usadas no Frontend ⚙️
<div style="display: inline_block"><br>

<img align="center" alt="Augusto-HTML" height="50" width="50" src="https://raw.githubusercontent.com/devicons/devicon/1119b9f84c0290e0f0b38982099a2bd027a48bf1/icons/html5/html5-plain.svg">
<img align="center" alt="Augusto-CSS" height="50" width="50" src="https://raw.githubusercontent.com/devicons/devicon/1119b9f84c0290e0f0b38982099a2bd027a48bf1/icons/css3/css3-original.svg">
<img align="center" alt="Augusto-JAVASCRIP" height="50" width="50" src="https://raw.githubusercontent.com/devicons/devicon/1119b9f84c0290e0f0b38982099a2bd027a48bf1/icons/javascript/javascript-plain.svg">
<img align="center" alt="Augusto-TYPESCRIPT" height="60" width="60" src="https://img.icons8.com/?size=512&id=nCj4PvnCO0tZ&format=png">
<img align="center" alt="Augusto-ANGULAR" height="50" width="50" src="https://raw.githubusercontent.com/get-icon/geticon/fc0f660daee147afb4a56c64e12bde6486b73e39/icons/angular-icon.svg">

</div>

### Entre em contato  

Para mais informações sobre o projeto ou para entrar em contato, você pode me encontrar através dos canais abaixo:

<div style="display: flex">

  <a href="https://www.linkedin.com/in/jos%C3%A9-augusto-mello-794a94234" target="_blank"><img src="https://img.shields.io/badge/-LinkedIn-%230077B5?style=for-the-badge&logo=linkedin&logoColor=white" target="_blank"></a>
 <a href="mailto:joseaugusto.Mello01@gmail.com" target="_blank"><img src="https://img.shields.io/badge/Gmail-D14836?style=for-the-badge&logo=gmail&logoColor=white" target="_blank"></a>   

</div>
