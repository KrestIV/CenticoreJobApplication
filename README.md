# Тестовое задание для сайта компании [Centicore](https://centicore.ru/)

<p style="text-align:center">
<img src="src/test/resources/logos/Centicore.svg" height="96" width="310" style="background: #FFFFFF" alt="centicore_logo">
</p>

# Содержание
- [Стек технологий](#стек-технологий)
- [Список тестов](#список-тестов)
- [Запуск автотестов](#запуск-автотестов)
- [Allure-отчет](#allure-отчеты)
- [Уведомления в телеграм](#уведомления-в-телеграм)


## Стек технологий
<p style="background:#FFFFFF;text-align:center">
<img width="8%" title="Java" src="src/test/resources/logos/java-original.svg" alt="java_logo">
<img width="8%" title="IntelliJ IDEA" src="src/test/resources/logos/intellij-original.svg" alt="intelliJIDEA_logo">
<img width="8%" title="Selenide" src="src/test/resources/logos/Selenide.svg" alt="selenide_logo">
<img width="8%" title="Selenoid" src="src/test/resources/logos/Selenoid.svg" alt="selenoid_logo">
<img width="8%" title="Allure Report" src="src/test/resources/logos/Allure_Report.svg" alt="allure_logo">
<img width="8%" title="Gradle" src="src/test/resources/logos/Gradle.svg" alt="gradle_logo">
<img width="8%" title="JUnit5" src="src/test/resources/logos/junit-original-wordmark.svg" alt="jUnit5_logo">
<img width="8%" title="GitHub" src="src/test/resources/logos/GitHub.svg" alt="gitHub_logo">
<img width="8%" title="Jenkins" src="src/test/resources/logos/Jenkins.svg" alt="jenkins_logo">
<img width="8%" title="Telegram" src="src/test/resources/logos/Telegram.svg" alt="telegram_logo">
</p>  

Автотесты в проекте написаны на <code>Java</code> с использованием фреймворка [Selenide](https://selenide.org/),  
сборщик - <code>Gradle</code>,  
фреймворк модульного тестирования - <code>JUnit 5</code>,  
удаленный запуск браузера и прохождение сценариев - [Selenoid](https://aerokube.com/selenoid/),  
управление удаленным запуском, настройка параметров и формирование отчета - <code>Jenkins + Allure</code>.  
Реализована отправка результатов в <code>Telegram</code> при помощи бота.

### Список тестов
**fullFilledApplicationForPartnershipShouldDisplaySuccessMessageTest** - Тест отправки заявки для сотрудничества
**partFilledApplicationForPartnershipShouldDisplayErrorMessageTest** - Тест ошибки при неполном заполнении формы
**vacanciesListShouldContainRelevantItemsOrBeEmptyTest** - Тест фильтра вакансий по специальности
**fullFilledRequestCallbackFormShouldDisplaySuccessMessageTest** - Тест формы заказа обратного звонка
**contactsPageShouldContainAllLocationsTest** - Тест отображения локаций офисов

### Запуск автотестов
Автотесты запускаются сборкой в <code>Jenkins</code> с заполнением параметров выполнения  

<p>
<img src="src/test/resources/screenshots/jenkinsBuildOptions.png" height="331" width="610" style="background: #FFFFFF" alt="jenkins_build_parameters">
</p>  

- **EXEC_SERVER** - Адрес сервера выполнения тестов
- **CREDENTIALS_LOGIN** - Логин для доступа к серверу выполнения тестов
- **CREDENTIALS_PW** - пароль для доступа к серверу выполнения тестов
- **BROWSER, BROWSER_VERSION, BROWSER_SIZE** - Выбор браузера/версии/разрешения экрана для исполнения тестов
- **COMMENT** - Параметр, определяющий текст сообщения в боте уведомлений

### Allure-отчеты

Allure-отчет содержит в себе результаты выполнения всех тестов с дополнительной информацией:
- Скриншот финала теста
- код страницы
- журнал консоли браузера при выполнении теста
- видео-запись выполнения теста

<p>
<img src="src/test/resources/screenshots/allureReportExample.png" height="296" width="884" style="background: #FFFFFF" alt="allure_report">
</p>  

### Уведомления в телеграм

По завершении выполнения тестов отправляется краткий отчет в телеграм-бот со ссылкой на полный allure-отчет

<p>
<img src="src/test/resources/screenshots/telegramNotification.png" style="background: #FFFFFF" alt="telegram_notification">
</p> 