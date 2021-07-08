# **Инструкция по запуску проекта - "Diplom"**

_Должен быть установлен Docker, IntelliJ IDEA 2021.1.1 x64_

1. Загружаем ZIP архив проекта [Diplom](https://github.com/EvgeniyaSelivanova/Diplom)    

![Step1](https://user-images.githubusercontent.com/75242936/124980115-a7a1f200-e03c-11eb-8075-7f6d192e4373.png)

2. Распаковываем проект в Diplom-master 

3. Запускаем IntelliJ IDEA 2021.1.1 x64

4. На начальном экране выбираем File/New/Project from Existing Sources.

![Step4](https://user-images.githubusercontent.com/75242936/124980187-bdafb280-e03c-11eb-85f5-4a65f80aba0a.png)

5. В открывшемся окне выбираем место, где сохранен распакованный ZIP архив проекта.

![Step5](https://user-images.githubusercontent.com/75242936/124981603-6ad6fa80-e03e-11eb-8aeb-bdc472773c0c.png)

6. Нажимаем кнопку Ok.

![Step6](https://user-images.githubusercontent.com/75242936/124981798-a5409780-e03e-11eb-9ea4-ccb190f715e4.png)

7. В открывшемся окне выбираем создание проекта на основе существующего ресурса и нажимаем кнопку Next

![Step7](https://user-images.githubusercontent.com/75242936/124980330-e768d980-e03c-11eb-8b7d-f3100b9d88ee.png)

8. Далее последовательно переходим по всем открывающимся окнам, нажимая кнопку Next.

![Step8 1](https://user-images.githubusercontent.com/75242936/124980358-f3549b80-e03c-11eb-98ed-3cfd301a759c.png)
![Step8 2](https://user-images.githubusercontent.com/75242936/124980385-fbacd680-e03c-11eb-9f28-885e1a871a76.png)
![Step8 3](https://user-images.githubusercontent.com/75242936/124980410-02d3e480-e03d-11eb-890b-cea9e7210aa1.png)
![Step8 4](https://user-images.githubusercontent.com/75242936/124980424-06676b80-e03d-11eb-8a8f-afab0acf4f91.png)
![Step8 5](https://user-images.githubusercontent.com/75242936/124980446-0c5d4c80-e03d-11eb-90c9-794b1c572167.png)

9. Завершаем создание проекта нажав кнопку Finish в открывшемся окне

![Step9](https://user-images.githubusercontent.com/75242936/124980471-15e6b480-e03d-11eb-9253-8e9a845825ad.png)

10. Ожидаем загрузки и инициализации проекта

11. Загружаем файл build.gradle, используя контекстное меню, нажав правую кнопку мыши

![Step11](https://user-images.githubusercontent.com/75242936/124980501-20a14980-e03d-11eb-91e2-8cb4ca43238d.png)

12. Открываем терминальное окно, нажав Alt+F12

13. Запускаем сервисы Docker в открывшемся окне терминала, введя команду ```docker-compose up```. 
    Нажимаем Enter и ожидаем загрузки сервисов

![Step13](https://user-images.githubusercontent.com/75242936/124980523-2a2ab180-e03d-11eb-800f-08f4699d86d0.png)

14. Создаем базу данных и устанавливаем связь с ней

![Step14 1](https://user-images.githubusercontent.com/75242936/124982165-14b68700-e03f-11eb-93b6-6206da70e1c2.png)
![Step14 2](https://user-images.githubusercontent.com/75242936/124980572-3878cd80-e03d-11eb-8ad9-2830102fa4ce.png)
![Step14 3](https://user-images.githubusercontent.com/75242936/124982478-6b23c580-e03f-11eb-8ba6-fd00f5e0b7ed.png)
![Step14 4](https://user-images.githubusercontent.com/75242936/124982836-d79ec480-e03f-11eb-8e52-8a85a59103b4.png)

15. Открываем новое терминальное окно, нажав Alt+F12

16. Запускаем jar файл, находящейся в папке artifacts, введя команду в терминальном окне 
```java -jar artifacts/aqa-shop.jar```

![Step16](https://user-images.githubusercontent.com/75242936/124980613-49c1da00-e03d-11eb-8af0-9af237504393.png)

17. Нажав Enter, ожидаем загрузки приложения

18. Открываем новое терминальное окно и переходим в папку gate-simulator, введя команду
```cd gate-simulator``` и нажимаем Enter

![Step18](https://user-images.githubusercontent.com/75242936/124980655-57775f80-e03d-11eb-9b69-bc2edc097583.png)

19. Запускаем симулятор банковских сервисов, введя команду
```npm start``` и нажимаем Enter

![Step19](https://user-images.githubusercontent.com/75242936/124980679-5fcf9a80-e03d-11eb-903d-e594e52f0fac.png)

20. Открываем новое терминальное окно. 

21. Запускаем тесты и формирование отчета командой ```gradlew clean test allureReport```
    и нажимаем Enter

![Step21](https://user-images.githubusercontent.com/75242936/124980709-69590280-e03d-11eb-8022-8fcf43b2b1e4.png)
