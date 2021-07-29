# **Инструкция по запуску проекта - "Diplom"**

_Должен быть установлен Docker_

1. Загружаем ZIP архив проекта [Diplom](https://github.com/EvgeniyaSelivanova/Diplom)    

Step1.png

2. Распаковываем проект в Diplom-master 

3. Запускаем в папке Diplom-master терминальную систему, например, Git Bush Here

Step3.png

4. В открывшемся окне терминала вводим команду ```docker-compose up -d mysql``` для запуска контейнера MySQL или
   ```docker-compose up -d postgres``` ля запуска контейнера Postgres и нажимаем Enter.

Step4.1.png
Step4.2.png

5. Ожидаем запуск контейнеров MySQL или Postgres

6. Переходим в папку gate-simulator, введя в терминальном окне команду ```cd gate-simulator``` и нажимаем Enter.

Step6.png

7. Перейдя в терминальном окне в папку gate-simulator, вводим команду ```npm start``` и нажимаем Enter

Step7.png

8. Ожидаем запуск симулятора банковских сервисов
   
9. Открываем новое терминальное окно, вводим команду ```java -jar artifacts/aqa-shop.jar``` и нажимаем Enter

Step9.png

10. Ожидаем запуска jar файла приложения

11. Открываем новое терминальное окно, запускаем очищаем предыдущие сборки и запускаем тесты,
    введя команду ```./gradlew clean test```, и нажимаем Enter

Step11.png

12. Ожидаем исполнение тестов

13. После завершения исполнения тестов, запускаем формирование отчета,
    в терминальном окне вводим команду ```./gradlew allureServe```, и нажимаем Enter

Step13.png