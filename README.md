## Opis
Projekt to prosta gra w milionerów. Klient przeglądarkowy komunikuje się z serwerem poprzez interfejs RESTowy. W grze dostępne są trzy koła ratunkowe, użytkownik musi odpowiedzieć poprawnie na 12 pytań. Po wygraniu miliona gra się restartuje.

Użyte frameworki :
-Scala.js
-Play framework
-Slick

## Odpalanie projektu
```shell
$ sbt
> run
$ open http://localhost:9000
```

Podstawa projektu pomagającego w integracji framerworków Playframework oraz Scala.js pobrana z:
https://github.com/vmunier/play-with-scalajs-example

Aby projekt mógł działać należy stworzyć nową bazę danych na lokalnym serwerze MySQL o nazwie **Millionaires**. Pliki
do tworzenia schematu oraz z przykładowymi danymi znajdują się w folderze **database**.
Należy również stworzyć użytkownika z danymi :

login : millionaires
password : millionaires

i nadać mu odpowiednie prawa do czytania oraz zapisywania z i do bazy danych.

