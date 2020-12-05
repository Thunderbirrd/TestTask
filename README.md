# TestTask
Test task for Mozlab

REST API находится по сслыке: https://users-test-task.herokuapp.com/
Список команд: 
  1)GET /getUserByID/{id} - получение пользователя по ID
  2)GET /getUserByEmail/{email} - получение пользователя по email
  3)POST /addUser - добавление пользвателя. Тело запроса:
    email
    password
    fullName - ФИО
    position - должность
    phone - телефон в формате +7 XXX XX XX
  3)POST /deleteUser - удаление пользователя. Тело запроса:email
  4)POST /updateUser - обновление пользователя. Тело запроса:
    email(неизменное поле, по нему происходит поиск пользователя, остальные поля можно заменить)
    password
    fullName - ФИО
    position - должность
    phone - телефон в формате +7 XXX XX XX
  5)GET /getAllUsers - получение всего списка пользвателей
