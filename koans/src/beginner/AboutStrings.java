package beginner;

import com.sandwich.koan.Koan;

import java.util.*;
import java.text.MessageFormat;

import static com.sandwich.koan.constant.KoanConstants.*;
import static com.sandwich.util.Assert.*;

public class AboutStrings {

	@Koan
	public void implicitStrings() {
		assertEquals("just a plain ole string".getClass(), __);
	}

	@Koan
	public void newString() {
		// very rarely if ever should Strings be created via new String() in 
		// practice - generally it is redundant, and done repetitively can be slow
		String string = new String();
		String empty = "";
		assertEquals(string.equals(empty), __);

		/*
			читайте английский текст выше:) всегда:) не понимаете английского - гугл в помощь ;)

			Дополнительно вы должны понимать следуюющее.

			new String() - создание обьекта класса String "по параметрам передающимся в скобках" (в нашем случае их нет,
			и будет создана "пустая строка")
			На самом деле это по сути специальный вызов специальново метода (не зря же скобки после имени)
			с именем таким же как у Класса String. Это единственный "метод" имя которого начинается с большой буквы (как
			раз потому что совпадает с именем класса)
			Такие методы - называются конструкторы - их задача создание обьекта класса и инициализация каких
			то "свойств" (полей/переменных) класса начальными значениями, а так же "любые другие операции котоые нужны
			при создании обьекта" (например чай кофе заварить, и т.д. ;)

			если мы не используем конструктора явно, как здесь:
			    String empty = "";
			Он все равно будет использован джавой неявно, но каким то хитрым заумным способом:) Оптимизированым.
			Именно поэтому выше не рекомендуется часто использовать "обычный" не оптимизированный способ через
			конструктор.

			Вот это "умное неявное создание обьекта" по передаче просто "значения" вместо конструктора - называется в
			джаве упаковкой (auto-boxing).
			То же мы видели раньше в случае:
			    Object integerObject = 1; // (1 запаковывается в new Integer(1) но "хитрым оптимизированным способом")
		 */
	}

	@Koan
	public void newStringIsRedundant() {
		String stringInstance = "zero";
		String stringReference = new String(stringInstance);
		assertEquals(stringInstance.equals(stringReference), __);
        /*
            здесь просто еще раз показивается что эффект один и тот же (в контексте значения живущего в обьекте на выходе)
         */
	}

	@Koan
	public void newStringIsNotIdentical() {
		String stringInstance = "zero";
		String stringReference = new String(stringInstance);
		assertEquals(stringInstance == stringReference, __);

        /*
             как бы очевидно... но вскоре появятся нюансы которые могут запутывать)
             Не помню когда они появятся поэтому поддам жару в печку мозга прямо сейчас:

                String stringInstance  = "zero";
                String sameStringInstance = "zero";
                assertEquals(stringInstance == sameStringInstance, true)

             Помните, выще упоминалась "хитроумная оптимизация" во время "упаковки" - вот это ее последствия.
             Джава видит что "zero" уже упаковался в обьект раньше, и второй раз джава уже не "упакует это же значение
             в новый обьект" а просто "скопирует ссылку на старый".

             То же происходит и c целыми числами (но только от -128 до 127):
                Integer integerInstance = 127;
                Integer sameIntegerInstance = 127;
                assertEquals(integerInstance == sameIntegerInstance, true) // => PASS

                Integer integerInstance = 128;
                Integer newIntegerInstance = 128;
                assertEquals(integerInstance == newIntegerInstance, false) // => PASS

         */
	}

	@Koan
	public void stringConcatenation() {
		String one = "one";
		String space = " ";
		String two = "two";
		assertEquals(one + space + two, __);
	}

	@Koan
	public void stringBuilderCanActAsAMutableString() {
		// StringBuilder concatenation looks uglier, but is useful when you need a
		// mutable String like object. It used to be more efficient than using +
		// to concatenate numerous strings, however this is optimized in the compiler now.
		// Usually + concatenation is more appropriate than StringBuilder.
		assertEquals(new StringBuilder("one").append(" ").append("two").toString(), __);

        /*
            Идея в том.... Что во время простой на первый вгляд операции:
                "one" + " " + "two"

            На самом деле создадутся в памяти:
                "one", " ", "two"
                "one "
                "one two"
            целых 5 строк... Хотя нам нужен был всего то одна - результирующая - "one two"

            Допустим 6 строк не так уж и много, и на произвадительность не повлияет. Но представьте более сложный случай?
            И того нужно быть внимательным и окуратным с операциями с "обычними" строковыми значениями...
            И если вы видите что операций много - лучше использовать StringBuilder - он будет работать с одной и той же
            строкой, во время "конкатенации" с помощью команд-сообщений append
         */

        /*
                new StringBuilder("one").append(" ").append("two").toString()

            Давайте попробуем глубже понять что здесь происходит...

                new StringBuilder("one").append(" ").append("two").toString()
                ________________________
               /
               конструктор класса StringBuilder создает
               (и возвращает в место вызова)
               обьект-строитель-строк по параметру "one"
               - начальному значению ("фундаменту строки-дома")

               new StringBuilder("one").append(" ").append("two").toString()
                                       ____________
                                      /
                                      посылается команда-сообщение append с параметром " "
                                      обьекту стоящему слева (теперь там обьект-строитель-строк созданый на предыдущем шаге)
                                      который способен ее понять в соответсвии с тем, как описана эта команда (метод)
                                      в его классе - StringBuilder
                                      (вы можете загуглить java StringBuilder append что бы посмотреть что же она делает
                                      (но я вам и так скажу)
                                      Обычно же в случае правильной настройки проекта в редакторе типа Intellij Idea
                                      или Eclipse, если вы зажмете контрол (команд на маке), наведете мышку на
                                      имя комманды - вы увидете тип параметров которые она принимает (в скобках)
                                      и тип результата который возвращает команда (слева от имени команды)
                                      - и дальше, если вы кликните по методу, вы попадете в место где эта команда реализована
                                      (собственно в клас обьекта, которому вы команду эту "посылаете")
                                      и обычно там вы сможете найти в коментариях документацию к этой команде)

                                      И так, обьект-строитель-строк понимает эту команду таким образом: "добавить к тому
                                      значению которое я помню (а помнит он пока только "one") - то что пришло мне
                                      в качестве параметра в сообщении append, и вернуть на место вызова команды append
                                      себя же - обьекта-строителя-строк (но уже с новым значением которое он "помнит" - "one "

               new StringBuilder("one").append(" ").append("two").toString()
                                                    _____________
                                                   /
                                                   делаем то же, что и выще, но теперь слева стоит обьект-строитель-строк
                                                   с значением которое "он помнит" - "one "
                                                   Соответсвенно результатом будет - обьект-строитель-строк со значением
                                                   "one two"

               new StringBuilder("one").append(" ").append("two").toString()
                                                                  __________
                                                                 /
                                                                 и на конец конвертируем обьект-строитель-строк в обычную
                                                                 строку (по сути "достаем" из него то строковое значение
                                                                 которое он помнит на момент вызова toString - "one two"

               Вы часто можете увидеть такие длинные цепочки вызовов методов.
               Главное на что здесь нужно обращать внимание - "что возвращает следующая команда на место своего вызова".

         */
	}

	@Koan
	public void readableStringFormattingWithStringFormat() {
		assertEquals(String.format("%s %s %s", "a", "b", "a"), __);

        /*
            еще один способ создания строки - подставляем значения параметров начиная со второго - в соответсвующие места
            обозначеные с помощью % внутри строки на месте параметра

            вот это буквенное обозначение после % - s - обозначает тип/класс того что мы собераемся "подставлять"
            (в нашем случае s обозначает String)
         */
	}

	@Koan
	public void extraArgumentsToStringFormatGetIgnored() {
		assertEquals(String.format("%s %s %s", "a", "b", "c", "d"), __);

        /*
            еще раз напоминаю: просто читайте имена коанов. Часто (как в этом случае) - этого вполне достаточно что бы понять
            что происходит.
         */
	}

	@Koan
	public void insufficientArgumentsToStringFormatCausesAnError() {
		try {
			String.format("%s %s %s", "a", "b");
			fail("No Exception was thrown!");
		} catch (Exception e) {
			assertEquals(e.getClass(), __);
			assertEquals(e.getMessage(), __);
		}

        /*
            мы уже упоминали "ошибки с которыми падают" некоторые методы, такие как
            - fail - всегда
            - методы типа assertSomethingIsAsExpected - когда параметры не соответствуют ожиданиям

            Еще говорят методы "бросают ошибки".
            Правильно такие "ошибки" называть "исключениями"
            Еще исключения называют "эксепшенами".
            Исключения - тоже "обьекты", соответствующих классов. Многие исключения есть обьектами классов которые наследуются
            от базового класса Exception - именно поэтому их часто так и называют жаргонно - эксепшены.
            (есть исключения которые наследуются и от других класов (http://habrahabr.ru/company/golovachcourses/blog/225585/))

            Если исключение "брошено" каким то методом - и "ничего не сделать" - программа завершит выполнение с ошибкой
            описываемой "брошеным" исключением.

            Но... исключение можно "перехватить".
            Именно это и делается в этом коане.
            Синтаксис "перехвата" довольно очевиден.
            Мы помещаем код, который потенциально может бросить исключение в блок:
            try {
                // СЮДА....
            }

            далее мы заканчиваем этот блок "перехватчиком" catch

                try {
                   // code
                } catch (Exception e) {   // <<< сюда мы указываем ящик с классом каких исключений "отлавливать" и в этот ящик ложить
                   // а здесь мы можем что то сделать в случае если мы "словили исключение"
                }

            Больше можете почитать здесь: http://developer.alexanderklimov.ru/android/java/exception.php
         */

        /*
            в этом коане, мы должны убедиться в том какое именно исключение будет брошено...
            То что бросает всегда метод fail
            Или какое то другое... ?
            И почему...
            Снова - ответ на "какое и почему" кроется в имени самого коана.
         */
	}

	@Koan
	public void readableStringFormattingWithMessageFormat() {
		assertEquals(MessageFormat.format("{0} {1} {0}", "a", "b"), __);

        /*
            здесь мы видим альтернативу использованию % для обозначения мест куда нужно подставить аргументы начиная
            с второго.

            Как видим этот способ более удобен, так как позовляет "более умно и экономно" подставлять аргументы...

            Экономия проявляется вот в чем:
            вместо
                String.format("%s %s %s %s %s %s", "a", "b", "a", "b", "a", "b",)
            проще ведь и понятней писать:
                MessageFormat.format("{0} {1} {0} {1} {0} {1}", "a", "b")
         */
	}

	@Koan
	public void extraArgumentsToMessageFormatGetIgnored() {
		assertEquals(MessageFormat.format("{0} {1} {0}", "a", "b", "c"), __);
	}

	@Koan
	public void insufficientArgumentsToMessageFormatDoesNotReplaceTheToken() {
		assertEquals(MessageFormat.format("{0} {1} {0}", "a"), __);
	}

}
