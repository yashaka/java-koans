package beginner;
/*
    обычно каждому джава файлу с кодом "приcваивается" своя фамилия (как минимум что бы не путать код с одинаковыми именами)
    В джава фамилия это - пакет (package) или набор вложеных друг в друга пакетов (вложеных папок на диске)
    и записаных через точку, папка в которой живет файл с джава кодом (который должен иметь расширение .java)

    "Фамилия" если она есть, должна быть обьявлена вначале файла.
 */

import static com.sandwich.util.Assert.fail;
import com.sandwich.koan.Koan;
/*
    джава имеет свой синтаксис и понимает определнный набор ключевых слов.

    Любой програмист может создать свои сущности и дать им свои имена.
    Что бы использовать эти сущности (команды, классы) в другом файле с джава кодом, нужно явно указать что они такое и где они
    живут, что бы джава знала что они означают :)

    Делается это с помощью import
 */


/*
    Любой джава код может быть описан только внутри класа, который должен иметь имя такое же как
    имя файла в котором он описан. В даном случае class AboutKoans в файле AboutKoans.java

    под класом мы пока будем понимать просто такой специальный контейнер для хранения кода:)

    слово public означает что эта "сущность", в даном случае - класс, может быть использована извне, то есть в другом коде.
 */
public class AboutKoans {

    /*
        любой джава код можно поделить на два типа
        - код который обьявляет данные
        - код который что то делает то ли с уже обьявленными данными где то в другом месте, то ли со своими собственными
        данными обьявленными локально

        Код второго типа недостаточно поместить внуть класса, его нужно еще и запихнуть в еще одну структуную штуку - обьявление метода,
        проще говоря - обьявление команды.

        Следующий код обьявляет команду с именем findAboutKoansFile

        Слово void означает что команда "ничего не возвращает" в то место где будет вызвана.
        Например команда sin(3.14) - вернет результат математической функции синус от числа пи.
        Такая команда была бы обьявлена как float sin(float angle),
        где вместо слова void - мы указываем тип результата (вещественное число). Так же мы указали параметр angle (угол)
        и его тип - float (вещественное число). В джаве всегда нужно указывать тип результатов функций если они его возвращают,
        тип параметров функций, а также тип переменных (ящиков со значениями) - с последними мы познакомимся дальше.
     */
	@Koan
	public void findAboutKoansFile(){
		fail("delete this line");
	}
    /*
        @Имя перед описанием сущности служит способом обозначить эту сущность таким образом что другой код может узнать в ней
        кандидата на определенные операции. В даном случае мы указываем что следующий код есть именно коаном, то есть "таким особым кодом,
        который может проходить а может и не проходить (упасть, остановить исполнение с ошыбкой) и должен быть определенным способ залогирован
        в логе (то что вы видите в консольке когда запускаете run.sh/run.bat)
     */
	
	@Koan
	public void definitionOfKoanCompletion(){
		boolean koanIsComplete = false;
		if(!koanIsComplete){
			fail("what if koanIsComplete was true?");
		}
	}
	
}

/*
    Помните что коаны - это способ быстро познакомиться с языком. В этой версии коанов так же "на пальцах" обьясняются
    основные нюансы в комментариях.

    Но в любом случае для систематизации знаний, и углубленного понимания, к прочтению рекомендуются книги или
    соответствующие онлайн ресурсы.
    Лучше читать книги пралельно с решением коанов.

    Обратите внимание на Java. Экспресс-курс ( http://developer.alexanderklimov.ru/android/java/java.php ).

    И книгу Изучаем Java. Кэти Сьерра, Берт Бейтс

    Для продвинутых рекомендуется книга: Философия Java. Брюс Эккель.
 */































/* Подсказки *




   	public void findAboutKoansFile(){
		fail("delete this line");

		// обычно код состоит из набора команд
		// идентификатором команды в джаве служыт набор символов (имя команды) за которыми следуют круглые скобки
		// с параметром (ами) внутри или его (их) остсутвие

		// fail - команда которая завершает выполнение программы бросая ошыбку и прикрепляет к ней сообщение которое было передано
		// в виде параметра команде (в нашем случае "delete this line")

		// Любое прерывание коана ошыбкой служыт идентификатором его "не прохождения"
		// еcли ошыбок не было, коан считается пройденым

		// решение коана простое, и соотвествует подсказке в тексте параметра команде fail - достаточно просто удалить
		// эту строчку кода, что бы коан "проходил", ведь теперь не будет команды которая "валит" коан бросая ошыбку.
	}





	public void definitionOfKoanCompletion(){
	    // следующая строчка кода есть примером "обьявления данных" а не "делания какой то работы"
		boolean koanIsComplete = false;
		// мы обьявляем переменную, по сути ящик с именем koanIsComplete и указываем (написав слово boolean перед именем)
		// что в ящике будет лежать значения типа boolean (этот тип определяет только два значения - true и false ~ правда и неправда)
		// Указывать тип нужно что бы другой код знал кто в ящике сидит и как с ним общаться (так как крышка ящика будет закрыта)
		// Тип - по простому как раз и есть описанием того, что можно делать с его "значениями".
		// Пример - Целые числа можно сумировать, отнимать, и т.д.
		// Знак равенства означает операцию присваивания то есть операцию "положить в ящик".

		// далее в момент упоминания имени переменной/ящика на самом деле будет происходить операция с ее содержимым
		if(!koanIsComplete){
		    // операция ! означает "отрицание", то есть если значение в ящике было false, то результатом операрции будет true
		    // а если true -  будет false

		    // if - особая конструкция которая проверяет результат выражения в скобках и если оно равно true то
		    // выполняет код в фигурных скобках
			    fail("what if koanIsComplete was true?");
			// соответственно так как у нас в ящике лежыт false, а if видит результат его логического отрицания то есть
			// true - значит будет исполнен код в фигурных скобках - а там у нас живет команда fail
			// которая кидает ошибку - и все, капут, коан завален.
			// мы конечно могли бы просто ее удалить эту команду как в первый раз
			// но суть не в том:)
			// суть в том что бы научиться что то еще делать с кодом кроме удаления:)

			// суть в том что бы изменить ход исполнения программы, сделать так что бы код "внутри ифа" не исполнялся

			// это сделать просто - поменять то что лежит в ящике на true ;)
		}
	}
 */
