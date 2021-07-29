# **Инструкция по запуску проекта - "Diplom"**

_Должен быть установлен Docker_

1. Загружаем ZIP архив проекта [Diplom](https://github.com/EvgeniyaSelivanova/Diplom)    

![Step1](https://user-images.githubusercontent.com/75242936/126556537-7d769fee-97a1-4697-b220-21285045a1c8.png)

2. Распаковываем проект в Diplom-master 

3. Запускаем в папке Diplom-master терминальную систему, например, Git Bush Here

![Step3](https://user-images.githubusercontent.com/75242936/126556593-2c25d5cf-cc67-4b4a-9500-82fc84dc8b1c.png)

4. В открывшемся окне терминала вводим команду ```docker-compose up -d mysql``` для запуска контейнера MySQL или
   ```docker-compose up -d postgres``` для запуска контейнера Postgres и нажимаем Enter.

![Step4 1](https://user-images.githubusercontent.com/75242936/127553213-ca0f8f92-dd72-4e11-94d3-c7dcbd705fb9.png)

![Step4 2](https://user-images.githubusercontent.com/75242936/127553237-a627cf1c-0d8d-46ca-ba12-97ccb9accae2.png)

5. Ожидаем запуск контейнеров MySQL или Postgres

6. Переходим в папку gate-simulator, введя в терминальном окне команду ```cd gate-simulator``` и нажимаем Enter.

![Step6](https://user-images.githubusercontent.com/75242936/126556692-dd327265-2bce-4cc7-90f0-1ec5b3ba2ead.png)

7. Перейдя в терминальном окне в папку gate-simulator, вводим команду ```npm start``` и нажимаем Enter

![Step7](https://user-images.githubusercontent.com/75242936/126556728-c54afdc3-cd99-455c-a0f2-6aaa90d20ba8.png)

8. Ожидаем запуск симулятора банковских сервисов
   
9. Открываем новое терминальное окно, вводим команду ```java -jar artifacts/aqa-shop.jar``` и нажимаем Enter

![Step9](https://user-images.githubusercontent.com/75242936/126556781-c55401cb-a97f-4d07-a643-1f0045b1efec.png)

10. Ожидаем запуска jar файла приложения

11. Открываем новое терминальное окно, очищаем предыдущие сборки и запускаем тесты,
    введя команду ```./gradlew clean test```, и нажимаем Enter

![Step11](https://user-images.githubusercontent.com/75242936/126556808-ac9fdddc-3b28-4acc-bcb8-8c0357389bfa.png)

12. Ожидаем исполнение тестов

13. После завершения исполнения тестов, запускаем формирование отчета,
    в терминальном окне вводим команду ```./gradlew allureServe```, и нажимаем Enter

![Step13](https://user-images.githubusercontent.com/75242936/126556837-766c3eb6-91d8-45ce-a947-dd6d9357e2e8.png)
