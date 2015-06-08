package beginner;

import static com.sandwich.koan.constant.KoanConstants.__;
import static com.sandwich.util.Assert.assertEquals;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;

import com.sandwich.koan.Koan;

public class AboutObjects {

	@Koan
	public void newObjectInstancesCanBeCreatedDirectly() {
		assertEquals(new Object() instanceof Object, __);
		/*
			просто знакомимся с еще одним оператором ("операцией") - instanseof
			Который проверяет является ли обьект слева обьектом того класса что справа.
		 */
	}

	@Koan
	public void allClassesInheritFromObject() {
		/*
			это мы уже "проходили", сейчас посмотрим на реальном примере, и убедимся что именно так
		 */
		class Foo {}
		/*
			вот так вот создается новый клас. Как видите его можно создать внутри метода (по факту - нашего коана)
			Хотя обычно классы создаются на "самом верхнем уровне" - то есть просто внутри какого то файла з тем же именем
			что мы собераемся дать класу (и с расширением .java)

			В даном случае мы создаем "пустой клас", то есть "тип который не определяет никаких опереаций надо своими обьектами
			и никаких их свойств.

			Кстати такие "внутренние" классы - так и называются - "внутренние" (inner) и даже делятся на несколько под-типов:)
			Но о других "под-типах" внутренних классов - позже...
		 */

		Class<?>[] ancestors = getAncestors(new Foo());
		/*
			квадратные скобки после типа переменной обозначают что по сути мы имеем не один ящик
			а много ящиков этого же типа, в которые мы можем "разместить" совокупность значений/обьектов, вместо одного
			Например так:
				String[] greetings = {"Hello", "Привет", "Hola", "Oi"};
		    В нашем случае типом "ящиков" будет Class<?> - что есть способом указать джаве что в ящики мы положим
		    не значения/обьекты какого то типа/класса а сами Типы/Класси "как значения".

		    То что мы размещаем по "ящикам" - мы получаем с помощью команды getAncestors - которая получает праметром
		    обьект, и вычисляет всю его "семью", начиная от прямого Класса этого обьекта
		    до всех Родительских классов "прямого класса обьекта"
		 */
		assertEquals(ancestors[0], __);
		assertEquals(ancestors[1], __);

		/*
			вот эта "куча ящиков" известна под одним именем - ancestors
			с помосчью квадратных скобок мы можем "вытасчить" то что лежит в этих ящиках по индексу ящика
			(первый ящик имеет индекс 0, второй - 1, и так далее)

			Пример:
				 assertEquals(greetings[0], "Hello");
				 assertEquals(greetings[1], "Привет");
		 */
        /*
            вот этот "набор ящиков" обьявленный спомощью синтаксиса: Тип[]
            Называется "массивом". В джаве есть такоже множество других способов представить "совокупность сущностей".
            Но о них - позже.
         */
	}

	@Koan
	public void objectToString() {
		Object object = new Object();
		// TODO: Why is it best practice to ALWAYS override toString?
		String expectedToString = MessageFormat.format("{0}@{1}", Object.class.getName(), Integer.toHexString(object.hashCode()));
        /*
            Object.class - способ использования класса самого по себе, вне контекста "обьявления переменной".
            Object.class.getName() - способ получить имя класа в виде строки...
            Integer.toHexString(1) - способ конвертировать свой параметр - целое число (в этом случае - 1) - в строку
            object.hashCode() - возвращает специальный "хеш код" для обьекта, в виде целого числа - особого идентификатора
            обьекта, характеризующего его с точки зрения его уникальности. Этот хеш код, обычно вычисляется обьектом каждого
            класса по своему. Каждый обьект обычно имеет разные свойства определяющие его состояние.
            Например допустим обьект класса Person имеет "свойства" (поля/внутренние переменные) - name, surname
            Тогда идея хеш кода - трансформировать каким то образом эти свойства в целое число
            - таким образом что бы обьекты с одинаковими свойствами возвращали один и тот же такой хеш код, причем возвращали
            всегда, в независимости от других условий использования этого обьекта.

        */
		assertEquals(expectedToString, __); // hint: object.toString()
        /*
            Помните мы говорили о том, что класс Object определяет метод equals "что бы было", ожидая что все классы наследники
            переопределят его.

            Так вот с toString - та же история. Идея этого метода - в том чтобы возвращать "строковое представление" обьекта.

            Коан хочет показать нам какая же "что бы было" реализация этого toString() метода в классе Object - просто
            лепиться в кучу имя класса и хешкод его обьекта.
            Что как то совсем не феншуйно....
            То есть, если мы определим наш клас
                class Person{
                    public String name;
                    public String surname;
                }
            То мы хотели бы что бы обьект нашего класа имел строковое представление, типа: "Vasya Pupkin"
            Но на самом деле мы получим после
                Person vpupkin = new Person();
                vpupkin.name = "Vasya";
                vpupkin.surname = "Pupkin";
                print(vpupkin.toString());
            что то типа:
                Person@342435435436

            И того мораль такова: всегда переопределяйте метод toString если вам важно строковое представление вашего обьекта


                class Person{
                    public String name;
                    public String surname;

                    public String toString(){
                        return name + " " + surname
                    }
                }

            Кстати, замечательное свойстов команды print в том что не нужно явно вызывать toString(), на его параметрах
            Достаточно просто:
                print(vpupkin);

            Помните ми говорили о полиморфизме? (если точно - sub-typing полиморфизме)
            Вот это еще один пример - в даном случае "полиморфным" методом является метод toString - который имеет разные
            реализации в разных классах наследниках класса Object

            метод print принимает на вход параметр (ящик) типа Object - то есть обьект любого класса - наследника класса
            Object (то есть любого класса, так как все наследуются от Object) и далее посылает сущности живущей в этом
            ящике - команду .toString()
            (на самом деле немножко сложнее, но по сути именно так)

            И дальше джава за счет поддержки полиморфизма - находит правильную реализацию этого метода (реализацию
            соответствующего класса того обьекта который реально был положен в ящик-параметр).
         */
	}

	@Koan
	public void toStringConcatenates() {
		final String string = "ha";
		Object object = new Object() {
			@Override public String toString() {
				return string;
			}
		};
		assertEquals(string + object, __);
        /*
            окей... ребята - автора коанов эти шутят все злобнее:) Всунули в этот коан еще кучу новых вещей:)
            Хотя можно было бы обойтись чем то таким:

               class Person{
                    public String name;
                    public String surname;

                    public String toString(){
                        return name + " " + surname
                    }
                }

                Person vpupkin = new Person();
                vpupkin.name = "Vasya";
                vpupkin.surname = "Pupkin";

                assertEquals("Hello ," + vpupkin + "!", __);

            Идея в том, что бы показать вам, что если вы используете обьект в контексте конкатенации с другими строками,
            то в месте его "упоминания" в таком коде, автоматически будет послана ему команда toString()
            То есть реально код выше "превращается" джавой в:

                assertEquals("Hello ," + vpupkin.toString() + "!", __);

            Что-бы обьяснить эту идею..
            Авторы решили использовать еще один "под-тип" внутренних классов в джаве, который называется Анонимные Классы

            И так, давайте же попробуем подойти к этой концепции по-чуть-чуть :)

            Код этого коана можно переписать вот так, если учитывать что вы еще не знаете что такое Анонимные Классы:

		        class HaClass {
			        public String toString() {
				        return "ha";
			        }
		        }
		        HaClass object = new HaClass();
		        assertEquals("ha" + object, "haha");

		    Сдесь нужно помнить момент что на самом деле, неявно HaClass наследуется от Object.
		    Давайте просто для наглядности напишем это явно:

		        class HaClass extends Object {
			        public String toString() {
				        return "ha";
			        }
		        }
		        HaClass object = new HaClass();
		        assertEquals("ha" + object, "haha");

		    Исходя из того что метод toString на самом деле, не обьявляется в этом классе с нуля, а именно "переопределяется"
		    (потому как он уже определен в классе Object)
		    - что бы явно обращать на это внимание (просто что бы визуально отличать такие методы от других)
		    - можно добавить анотацию @Override:

		        class HaClass extends Object {
		            @Override
			        public String toString() {
				        return "ha";
			        }
		        }
		        HaClass object = new HaClass();
		        assertEquals("ha" + object, "haha");

            Теперь представьте что вам не нужно создавать кучу обьектов для класса HaClass.
            То есть ви не будете писать код типа:

		        HaClass object1 = new HaClass();
		        assertEquals("ha" + object1, "haha");
		        HaClass object2 = new HaClass();
		        assertEquals("ha" + object2, "haha");

		    Вам реально нужен только "один обьект" этого класса...
		    Вопрос... Обязательно ли тогда создавать отдельно класс, что бы плодить его обьекты? Ведь нужен только
		    один обьект? Может можно сразу обьект создать? Без класса?

		    Ответ - не обязательно. Да, можно создать сразу обьект класса не обьявляя этот класс отдельно. В таком
		    случае мы по сути создаем "класс без имени"
		    (как бы только часть в скобках { ...fields and methods definitions... })
		    Именно по-этому в джаве такие "классы" называются "Анонимными".
		    Вот как это выглядит:

		        HaClass object = new Object() {         // <<< Сдесь Object означает как раз класс от которого "анонимный" класс
		            @Override                           // <<< (то есть часть в {}) - должен отнаследоваться
			        public String toString() {
				        return "ha";
			        }
		        };
		        assertEquals("ha" + object, "haha");

		    сравните с тем что было (http://joxi.ru/BA0MKqGtRyV8ry):

		        class HaClass extends Object {
		            @Override
			        public String toString() {
				        return "ha";
			        }
		        }
		        HaClass object = new HaClass();
		        assertEquals("ha" + object, "haha");

            Еще в коане был один нюанс который нужно понимать...
            В коане реализация метода toString использувала внешнюю переменную string. Пока не ясно зачем это сделали в
            коане, но в реальной жизни это происходит очень часто (позже поймете почему).
            И нужно уметь "использовать" эти внешние по тношению к анонимному классу переменные.
            Потому что просто такой код:

                String string = "ha";
		        HaClass object = new Object() {
		            @Override
			        public String toString() {
				        return string;
			        }
		        };
		        assertEquals("ha" + object, "haha");

            работать не будет!
            Конфуз для джавы приходит поскольку класс определяется один раз, в момент создания обьекта, и она совсем не будет
            знать что же ей делать, если мы напишем такой вот код:

                String string = "ha";
		        HaClass object = new Object() {
		            @Override
			        public String toString() {
				        return string;
			        }
		        };
		        string = "ho";
		        assertEquals("ha" + object, "<????????????>");

		    Поэтому в анонимных классах позволено использовать только "неизменямые" переменные, другими словами  - "константы".
		    Что бы указать джаве что это неизменяемая переменная достаточно добавить в ее обьявлении слово final:

                final String string = "ha";
		        HaClass object = new Object() {
		            @Override
			        public String toString() {
				        return string;
			        }
		        };
		        assertEquals("ha" + object, "haha");

		    Такой код будет работать.
		    Вот такой вот коанчик-перекоанчик получился:)
         */
	}

	@Koan
	public void toStringIsTestedForNullWhenInvokedImplicitly() {
		String string = "string";
		assertEquals(string + null, __);
        /*
            так как null-у нельзя посылать команды, любые, то в этом случае джава достаточно умна что бы этого не делать.
            Это и хочет показать этот коан.
         */
	}

    /*
        это реализация метода getAncestors который мы использовали выше. Просто проигнорьте этот код.
        Пока он через чур сложный для вас.
     */
	private Class<?>[] getAncestors(Object object) {
		List<Class<?>> ancestors = new ArrayList<Class<?>>();
		Class<?> clazz = object.getClass();
		while(clazz != null) {
			ancestors.add(clazz);
			clazz = clazz.getSuperclass();	
		}
		return ancestors.toArray(new Class[]{});	
	}
	
}
