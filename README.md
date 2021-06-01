# BSA 2019 JAVA - mini-project Thread

## Описание
[**Thread**](git@github.com:BinaryStudioAcademy/thread-java.git) - это [SPA](https://medium.com/NeotericEU/single-page-application-vs-multiple-page-application-2591588efe58 "SPA") с готовой архитектурой и структурой, подключенным базовым стеком технологий и стартовым функционалом, предназначенный для самостоятельной практики студентов.

Тематика проекта - социальная сеть, похожая на Twitter.

Основная идея проекта -  ознакомить студентов с нашим виденьем того, как реальный проект должен выглядеть изнутри, и дать возможность самостоятельно исследовать, как устроена архитектура и структура проекта, посмотреть его возможные конфигурации, попробовать покопаться и разобраться в чужом коде.


## Технологии

Здесь перечислены основные фреймворки и библиотеки, используемые в проекте. Полный список используемых технологий для каждой части проекта находится в файлах package.json и build.gradle в папках frontend и backend.

#### Common
1. [Git](https://git-scm.com/book/ru/v1/%D0%92%D0%B2%D0%B5%D0%B4%D0%B5%D0%BD%D0%B8%D0%B5-%D0%9E%D1%81%D0%BD%D0%BE%D0%B2%D1%8B-Git "Git")
1. [REST API](https://www.restapitutorial.com/lessons/restquicktips.html "REST API")
1. [JWT](https://en.wikipedia.org/wiki/JSON_Web_Token "JWT")
1. [WebSocket](https://en.wikipedia.org/wiki/WebSocket "WebSocket")

#### Frontend
1. ES2020
1. [React](https://reactjs.org/docs/getting-started.html "React")
1. [React Redux](https://redux.js.org/introduction/getting-started "React Redux")
1. [React Semantic UI](https://react.semantic-ui.com/ "React Semantic UI")
1. [Moment.js](https://momentjs.com/ "Moment.js")
1. [validator.js](https://www.npmjs.com/package/validator "validator.js")
1. [npm](https://en.wikipedia.org/wiki/Npm_(software))
1. [ESLint](https://eslint.org/docs/user-guide/getting-started "ESLint")
1. [history](https://www.npmjs.com/package/history "history")

#### Backend
1. [spring](https://spring.io/ "spring")
1. [lombok](https://projectlombok.org/ "lombok")
1. [Spring Data JPA](https://spring.io/projects/spring-data-jpa "Spring Data JPA")
1. [MapStruct](https://mapstruct.org/ "MapStruct")
1. [jjwt](https://github.com/jwtk/jjwt "jjwt")
1. [WebSocket](https://spring.io/guides/gs/messaging-stomp-websocket/ "WebSocket")

#### Database
1. [PostgreSQL](https://www.postgresql.org/download/ "PostgreSQL")

## Установка

1. Установить последнюю стабильную версию [Java](https://www.java.com/en/download/ "Java"). А также любую доступную IDE, например [IntelliJ IDEA](https://www.jetbrains.com/idea/download/#section=windows "IntelliJ IDEA")

1. Установить последнюю стабильную версию [Node.js](https://nodejs.org/en/ "Node.js") (LTS). **Note:** npm будет установлен автоматически. Проверьте корректность установки: для этого выполните в командной строке (терминале):

    ```
   node -v  // для проверки версии Node.js
   npm -v // для проверки версии npm
    ```

1. Установить последнюю стабильную версию [PostgreSQL](https://www.postgresql.org/download/ "PostgreSQL") для вашей OS. Проверьте корректность работы - попробуйте создать базу, таблицу, - для этого можете использовать [pgAdmin](https://www.pgadmin.org/ "pgAdmin") или другой удобный способ, который найдете.

1. Создайте в PostgreSQL **пустую** базу данных для проекта. Например, *threaddb*.

1. Установите Git.

1. Склонировать [репозиторий](https://github.com/BinaryStudioAcademy/thread-java) проекта:

    ```
    git clone git@github.com:BinaryStudioAcademy/thread-java.git
    ```
    
1. **Создать репозиторий на [Bitbucket](https://bitbucket.org/) и вести дальнейшую разработку там.**

#### Backend


1.  В папке backend\src\main\resources\ создайте файл **application.properties** и скопируйте в него содержимое из файла **application.properties.example**.

	**Note**: файл **application.properties** содержит реальные ключи проекта и не должен сохраняться в репозиторий.

	Замените в файле **application.properties** значения ключей на действительные. И укажите название созданной базы данных, используемой для работы с проектом.
	Для того, чтобы указать токен для Gyazo, необходимо зарегистрироваться на сайте [Gyazo](https://gyazo.com/welcome) и [зарегистрировать приложение](https://gyazo.com/oauth/applications), а также прочитать три строчки [документации](https://gyazo.com/api/docs), чтобы понимать, как работать с API.

1. Запустить проект можно с помощью предустановленной IDE.

1. Установить [lombok plugin](https://github.com/mplushnikov/lombok-intellij-plugin)
    - Используя встроенную системы плагинов IDE в Windows:
        - <kbd>File</kbd> > <kbd>Settings</kbd> > <kbd>Plugins</kbd> > <kbd>Browse repositories...</kbd> > <kbd>Search for "lombok"</kbd> > <kbd>Install Plugin</kbd>
    - Вручную:
        - Загрузите [latest release](https://github.com/mplushnikov/lombok-intellij-plugin/releases/latest) и установите его вручную, используя <kbd>Preferences</kbd> > <kbd>Plugins</kbd> > <kbd>Install plugin from disk...</kbd>

1. При первом старте создадутся все таблицы и автоматически запуститься Seed базы данных для заполнения ее первоначальными данными.

#### Frontend

1. В командной строке (терминале) зайдите в папку frontend:

    ```
    cd /* путь к папке frontend */
    ```

2. Установите все необходимы пакеты из package.json командой:

    ```
    npm install
    ```

3.  В папке frontend создайте файл **.env** и скопируйте в него содержимое из файла **.env.example**.

	**Note**: файл **.env** содержит реальные ключи проекта и не должен сохраняться в репозиторий.

	Замените в файле **.env** значения ключей на действительные.
    
4. Для запуска клиента в командной строке (терминале) в папке клиента выполните:

    ```
    npm start
    ```
    
    Приложение должно само автоматически открыться в брузере по умолчанию.
    
## Задания

Необходимо добавить следующие возможности:

1. Поставить dislike посту.
1. Редактировать свой пост.
1. Удалить свой пост. Soft deletion - пост должен остаться в базе данных.
1. Редактировать свой комментарий.
1. Удалить свой комментарий. Soft deletion - комментарий должен остаться в базе данных.
1. Поставить like комментарию.
1. Поставить dislike комментарию.
1. Фильтр - не отображать свои посты, а отображать только чужие.
1. Фильтр - отображать только те посты, которым я (как пользователь) поставил лайк.
1. Отобразить кто поставил like/dislike посту.
1. Отобразить кто поставил like/dislike комментарию.
1. Добавить больше real-time уведомлений (websocket), например при обновлении/удалении поста/комментария.
1. Редактировать собственный профиль. Добавить валидацию (например, пользователь не должен иметь возможности сохранить невалидный email).
1. Устанавливать статус пользователя (например, "А сегодня, в завтрашний день, не все могут смотреть. Вернее.."). Отображать его под username.
1. Сбросить пароль (Forgot password). Отправить email с ссылкой на страницу изменения пароля.
1. Отправить пользователю email, если его посту поставили like.
1. Поделиться постом по email.

## PS
Весь список тасков также можно найти на доске [**Trello**](https://trello.com/b/q23vPcv6 "**Trello**") в колонке Backlog Students. Доску нужно скопировать себе и по ней работать. Это поможет вам отслеживать весь процесс своей работы, а нам - определить, что уже готово. Таск будет считаться выполненным, если он полностью завершен и фича работает. Посмотрим на ее реализацию и оценим, правильно ли распределили логику в проекте. Это покажет, насколько вы разобрались в архитектуре. Также дадим комментарии по коду.

Основной результат работы можно определить тем, как глубоко вы смогли разобраться в проекте и понять его, и как далеко продвинулись в личном обучении.

Ссылки:
1. [Репозиторий](https://github.com/BinaryStudioAcademy/thread-java).
2. [Trello](https://trello.com/b/q23vPcv6).
