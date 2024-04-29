# Аннотация
Здесь предоставлены работы, решение технических заданий по дисциплине "Технологии программирования" направления "Бизнес-информатика" студента НИУ ВШЭ Малеванной Ренаты Борисовны группы ББИ236.

[Репозиторий дисциплины "Технологии программирования"](https://github.com/demist/tp_hse?tab=readme-ov-file)

# Содержание
- [Техническое задание №1 (ТЗ1)](https://github.com/RenataMal/Tech-Programming/blob/main/README.md#%D1%82%D0%B5%D1%85%D0%BD%D0%B8%D1%87%D0%B5%D1%81%D0%BA%D0%BE%D0%B5-%D0%B7%D0%B0%D0%B4%D0%B0%D0%BD%D0%B8%D0%B5-1-%D1%82%D0%B71)
- Техническое задание №2 (ТЗ2)
- Техническое задание №3 (ТЗ3)

# Техническое задание №1 (ТЗ1)

### Легенда задания 

Нужно написать скрипт на bash, который на вход принимает два параметра - две директории (`входная директория` и `выходная директория`).
Во `входной директории` могут находиться как файлы, так и вложенные директории (внутри которых тоже могут быть как файлы, так и папки) - уровень вложенности может быть любой.
Задача скрипта - "обойти" `входную директорию` и скопировать все файлы из нее (и из всех сложенных директорий) в `выходную директорию` - но уже без иерархии, а просто все файлы - внутри `выходной директории`.

Пример:

`Входная директория` = `/home/input_dir`; `Выходная директория` = `/home/output_dir`.

`/home/output_dir` изначально пустая.

Структура `/home/input_dir`: 
- input_dir
	- a.txt
	- dir2
		- b.txt
	 - dir3
   		- c.txt

Тогда после работы вашего скрипта структура `/home/output_dir` должна быть следующая: 
- output_dir
	- a.txt
 	- b.txt
  	- c.txt

**Обратите внимание**: в разных поддиректориях `входной директории` могут быть файлы с одинаковым названием. В момент копирования в `выходную аудиторию` необходимо такие ситуации каким-либо образом разрешить без потери файлов и содержания файлов (как именно - на ваше усмотрение).

### Требования
- Скрипт запускается и принимает два параметра
- Реализовано получение списка файлов, находящихся непосредственно во `входной директории` (не во вложенных в нее директориях)
- Реализовано получение списка директорий, находящихся во `входной директории`
- Реализовано получение списка всех файлов, вложенных во `входную директорию`
- Реализовано копирование  всех файлов, вложенных во `входную директорию` в `выходную директорию`
- Решена проблема с файлами, имеющими одинаковое название 
