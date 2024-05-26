# Аннотация
Здесь предоставлены работы, решение технических заданий по дисциплине "Технологии программирования" направления "Бизнес-информатика" студента НИУ ВШЭ Малеванной Ренаты Борисовны группы ББИ236.

[Репозиторий дисциплины "Технологии программирования"](https://github.com/demist/tp_hse?tab=readme-ov-file)

# Содержание
- [Техническое задание №1 (ТЗ1)](https://github.com/RenataMal/Tech-Programming/tree/main?tab=readme-ov-file#%D1%82%D0%B5%D1%85%D0%BD%D0%B8%D1%87%D0%B5%D1%81%D0%BA%D0%BE%D0%B5-%D0%B7%D0%B0%D0%B4%D0%B0%D0%BD%D0%B8%D0%B5-1-%D1%82%D0%B71)
- [Техническое задание №2 (ТЗ2)](https://github.com/RenataMal/Tech-Programming/blob/main/README.md#%D1%82%D0%B5%D1%85%D0%BD%D0%B8%D1%87%D0%B5%D1%81%D0%BA%D0%BE%D0%B5-%D0%B7%D0%B0%D0%B4%D0%B0%D0%BD%D0%B8%D0%B5-2-%D1%82%D0%B72)
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

### Результат
Здесь предоставлен скрипт [ТЗ1](https://github.com/RenataMal/Tech-Programming/blob/main/TZ1.sh), написанный на Bash.

Чтобы воспользоваться данным скриптом, можно его сохранить и запустить его в терминале в правильном каталоге. Также нужно проверить, имеет ли скрипт права на выполнение (chmod +x ...). 

Также можно клонировать репозиторий `git clone https://github.com/RenataMal/Tech-Programming.git`. После того как клонирование завершено, перейдите в каталог репозитория `cd Tech-Programming`. После того как вы внутри клонированного репозитория, вы можете выполнить скрипт, указав его путь `./TZ1.sh` и перед этим дать доступ к файлу `chmod +x TZ1.sh`.

### Описание работы

Этот скрипт предназначен для копирования файлов из одной директории в другую с учетом различных условий доступа и типов файлов. Он начинает с запроса ввода путей к входной и выходной директориям (подразумевается правильное ведение директорий и их существование), затем обходит содержимое входной директории, копируя файлы в выходную и выводя информацию о процессе.

1. Пользователю предлагается ввести путь к входной и выходной директориям.

2. Списки для хранения информации о директориях и файлах инициализируются.
   
3. Функция process обрабатывает каждый элемент во входной директории:
	
	- Для директорий: если у пользователя нет прав на выполнение, они добавляются в список dir_list_block; в противном случае они добавляются в список dir_list и их содержимое рекурсивно обрабатывается.
	
	- Для файлов: если у пользователя нет прав на чтение, они добавляются в список files_list_block; если файл является символической ссылкой, он добавляется в список files_list_links; в противном случае файл копируется в выходную директорию, соблюдая условия (например, при наличии файла с тем же именем в выходной директории, к имени добавляется номер).

4. После завершения обработки выводится информация о посещенных директориях, скрытых элементах, скопированных файлах и пропущенных элементах из-за ограничений доступа.
   
# Техническое задание №2 (ТЗ2)
## Часть №1 Тестирование
Реализована на Java программа, которая считывает из файла числа, а далее отдельными функциями ищет среди этих чисел минимальное число, максимальное число, считает их общую сумму и произведение.

В Main классе программы следующие функции:

- `main`: Это основная функция, которая запускает ваше приложение. В этой функции происходит ввод пользователем пути к файлу, чтение чисел из файла, вызов функций для нахождения минимального, максимального, суммарного и произведения чисел, а также вывод результатов.

- `min`: Эта функция принимает массив чисел и возвращает минимальное значение из этого массива.

- `max`: Эта функция принимает массив чисел и возвращает максимальное значение из этого массива.

- `sum`: Эта функция принимает массив чисел и возвращает сумму всех чисел из этого массива.

- `mult`: Эта функция принимает массив чисел и возвращает произведение всех чисел из этого массива.

Эти функции предоставляют основную функциональность вашего приложения, позволяя читать числа из файла и выполнять различные вычисления над ними.

В программе обрабатываются следующие исключения:

- `FileNotFoundException`: Происходит, когда файл, указанный пользователем, не найден по указанному пути.

- `IOException`: Это общее исключение для ошибок ввода-вывода. Оно может произойти при чтении файла или других операциях ввода-вывода.

- `NumberFormatException`: Происходит, когда строка, прочитанная из файла, не может быть преобразована в целое число (например, если строка содержит нечисловые символы).

- `ArithmeticException`: Происходит при арифметических ошибках, таких как переполнение при сложении.

### Требования к файлу с числами
1. **Тип чисел**:
   - Числа должны быть целыми числами в пределах диапазона `int` (от -2^31 до 2^31-1).

2. **Формат чисел**:
   - Числа должны быть записаны в текстовом формате.
   - Числа должны быть записаны в одной первой строке.
   - Числа должны быть разделены пробелами.
   - В файле есть минимум одно число.
   - Максимально возможное количество чисел в файле - 1 млн.

3. **Примеры чисел**:
   - Корректные: `123 456 -789 0 42`
   - Некорректные: `123 abc 456.78`, пустая строка, строки с нечисловыми символами.

### Описание тестов
Тестирование программы включает:

**Тесты включающие проверки для методов нахождения минимального и максимального значений, вычисления суммы и произведения чисел.**

Примеры тестов:
- Нахождение минимального числа в массиве.
- Нахождение максимального числа в массиве.
- Вычисление суммы всех чисел в массиве.
- Вычисление произведения всех чисел в массиве.

**Тесты, оценивающие время выполнения основных операций при обработке массивов разного размера.**

Тесты производительности измеряют, насколько быстро функции выполняют свои задачи, и выводят время выполнения в наносекундах. 

Примеры тестов:
- Оценка времени выполнения функции поиска минимального числа в массивах различных размеров (от 10 до 1 000 000 элементов), (числа генерируются в диапозоне 100).
- Оценка времени выполнения функции поиска максимального числа в массивах различных размеров.
- Оценка времени выполнения функции вычисления суммы чисел в массивах различных размеров.
- Оценка времени выполнения функции вычисления произведения чисел в массивах различных размеров.

**Дополнительный тест.**
Этот тест проверяет, выполняется ли функция поиска минимума за приемлемое время.

### Как запустить проект 
1. Для начала нужно проверить, что у вас установлен Maven.
2. Склонируйте репоизторий `git clone https://github.com/RenataMal/Tech-Programming.git`.
3. Перейдите в путь `сd /Tech-Programming`.
4. Сделайте команду `mvn compile`. Команда `mvn compile` компилирует исходные файлы проекта, преобразуя их в байт-код Java. Она проверяет синтаксис кода и генерирует файлы классов, которые могут быть выполнены виртуальной машиной Java (JVM). В случае успеха, команда создаст директорию target, где будут расположены скомпилированные файлы классов.
5. Чтобы запустить саму программу, сделайте команду `mvn exec:java`. Команда `mvn exec:java` выполняет главный класс программы, используя Maven. 
6. Чтобы запустить все тесты, сделайте команду `mvn test`. При выполнении команды Maven ищет все классы тестов, отмеченные аннотациями JUnit (@Test), и запускает их. По завершении тестирования выводятся результаты, включая количество пройденных и не пройденных тестов.

### График зависимости времени выполнения от кол-ва чисел в файле
Представлен график зависимости времени выполнения нахождения минимума от кол-ва чисел в файле. Время выполнения поиска минимума возрастает с увеличением количества чисел в файле. Это наблюдение подтверждает, что алгоритму требуется больше времени для обработки больших объемов данных. (от 10 до 1 000 000 элементов), (числа генерируются в диапозоне 100).

![График](https://github.com/RenataMal/Tech-Programming/blob/main/%D0%93%D1%80%D0%B0%D1%84%D0%B8%D0%BA%20%D0%B7%D0%B0%D0%B2%D0%B8%D1%81%D0%B8%D0%BC%D0%BE%D1%81%D1%82%D0%B8%20%D0%B2%D1%80%D0%B5%D0%BC%D0%B5%D0%BD%D0%B8%20%D0%B2%D1%8B%D0%BF%D0%BE%D0%BB%D0%BD%D0%B5%D0%BD%D0%B8%D1%8F%20%D0%BD%D0%B0%D1%85%D0%BE%D0%B6%D0%B4%D0%B5%D0%BD%D0%B8%D1%8F%20%D0%BC%D0%B8%D0%BD%D0%B8%D0%BC%D1%83%D0%BC%D0%B0%20%D0%BE%D1%82%20%D0%BA%D0%BE%D0%BB-%D0%B2%D0%B0%20%D1%87%D0%B8%D1%81%D0%B5%D0%BB%20%D0%B2%20%D1%84%D0%B0%D0%B9%D0%BB%D0%B5.png)
## Часть №2
Этот проект представляет собой пример использования GitHub Actions для автоматизации сборки и тестирования Java-проекта с помощью Maven. После успешной сборки и прохождения тестов происходит оповещение о результате в чат Telegram. Чтобы бот работал, нужно знать токен бота и ID чата. 

![Пример работы бота](https://github.com/RenataMal/Tech-Programming/blob/main/%D0%A1%D0%BA%D1%80%D0%B8%D0%BD%20%D1%80%D0%B0%D0%B1%D0%BE%D1%82%D1%8B%20%D1%82%D0%B3%20%D0%B1%D0%BE%D1%82%D0%B0.jpg)

Чтобы запустить тесты вручную, нужно нажать на кнопку "Actions" вверху страницы, выбрать workflow "Java CI" и запустить его.

### Статус тестов

[![Статус тестов](https://github.com/RenataMal/Tech-Programming/actions/workflows/maven.yml/badge.svg)](https://github.com/RenataMal/Tech-Programming/actions/workflows/maven.yml)

