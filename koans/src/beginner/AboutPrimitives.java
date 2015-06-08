package beginner;

import static com.sandwich.koan.constant.KoanConstants.__;
import static com.sandwich.util.Assert.assertEquals;

import com.sandwich.koan.Koan;

public class AboutPrimitives {

	@Koan
	public void wholeNumbersAreOfTypeInt() {
		assertEquals(getType(1), __); // hint: int.class

		/*
			в даном случае нам нужно сравнить тип значения 1 с __ (тем что нужно подставить)
			Понятно что нам по сути нужно угадать что возвражает метод getType получая параметром - 1
			И как бы понятно что это должен быть примитивный тим - int
			но если мы просто напишем int вместо __ -  ничего не получится. Так как если джава встречает имя типа
		    она думает что будет обьявлена новая переменная.
		    Что бы ей указать на обратное, на то что мы просто хотим использовать тип "как значение", "сам по себе",
		    - нужно дописать .class в конце - int.class

		    И так прийдется делать везде в похожих контекстах... "Жизнь сложна" ;)
		 */
	}

	@Koan
	public void primitivesOfTypeIntHaveAnObjectTypeInteger() {
		Object number = 1;
		assertEquals(getType(number), __);

		// Primitives can be automatically changed into their object type via a process called auto-boxing
		// We will explore this in more detail in intermediate.AboutAutoboxing

        /*
            если джава видит что мы хочем положить значение примитивного типа в ящик "с биркой" класса, а не
            примитивного типа - джава сразу попробует запаковать это примитивное значение (в нашем случае - 1)
            в обьект соответствующего типа (в нашем случае - Integer).
         */
	}

	@Koan
	public void integersHaveAFairlyLargeRange() {
		assertEquals(Integer.MIN_VALUE, __);
		assertEquals(Integer.MAX_VALUE, __);
	}

	@Koan
	public void integerSize() {
		assertEquals(Integer.SIZE, __);  // This is the amount of bits used to store an int

        /*
            Внутри даные хранятся в ячейках памяти. Ячейки имеют определенный размер. Минимальный размер ячейки - 8 бит,
            что равно 1 байту. Один бит - это мини-ячейка которая может хранить значение - или 0 или 1.
            Все даные кодируются в виде наборов нулей и единиц и хранятця в соответствующего размера ячейках.
            Целые числа хранятця в ячейках из 4 байт - 4х8 бит = 32
            Именно финальное количетсво битов исопльзуемых для кодировки - и влияет на максимально допустимое число.
            Минимальным целым числом - будет -(2^31) (2 в 31 степени), а максимальным  ((2^31) - 1).
            31 а не 32 - потому что последний бит используется для обозначения отрицательных чисел
            Примеры:
                 1: 0000 0000, 0000 0000, 0000 0000, 0000 0001
                -1: 1000 0000, 0000 0000, 0000 0000, 0000 0001
                 2: 0000 0000, 0000 0000, 0000 0000, 0000 0010
                -2: 1000 0000, 0000 0000, 0000 0000, 0000 0010
                 3: 0000 0000, 0000 0000, 0000 0000, 0000 0011
                -3: 1000 0000, 0000 0000, 0000 0000, 0000 0011
                ...
            2^31-1: 0111 1111, 1111 1111, 1111 1111, 1111 1111
             -2^31: 1111 1111, 1111 1111, 1111 1111, 1111 1111

         */
	}

	@Koan
	public void wholeNumbersCanAlsoBeOfTypeLong() {
		assertEquals(getType(1L), __);
        /*
            если джава видит числовое значение - она ожидает что это значение типа int
            если нужно явно указать что это значение типа long - нужно добавить L в конце числа

            Будьте внимательны, и добавляйте всегда L в конце если нужно ввести значение именно типа long,
            особенно когда число достаточно большое и в ячейку для int не влезет....

            (лонг - тоже целочисленный тип, но под него
            выделяются ячейки в два раза больше - 64 бита (8 байт))
         */
	}

	@Koan
	public void primitivesOfTypeLongHaveAnObjectTypeLong() {
		Object number = 1L;
		assertEquals(getType(number), __);
	}

	@Koan
	public void longsHaveALargerRangeThanInts() {
		assertEquals(Long.MIN_VALUE, __);
		assertEquals(Long.MAX_VALUE, __);
	}

	@Koan
	public void longSize() {
		assertEquals(Long.SIZE, __);
	}

	@Koan
	public void wholeNumbersCanAlsoBeOfTypeShort() {
		assertEquals(getType((short) 1), __); // The '(short)' is called an explicit cast - to type 'short'

        /*
            в джаве можно явно "привести" тип какого то значения (или обьекта) к нужному типу
            это делается с помощью записи нужного типа в скобках перед значением (или обьектом)
         */
	}

	@Koan
	public void primitivesOfTypeShortHaveAnObjectTypeShort() {
		Object number = (short) 1;
		assertEquals(getType(number), __);
	}

	@Koan
	public void shortsHaveASmallerRangeThanInts() {
		assertEquals(Short.MIN_VALUE, __);  // hint: You'll need an explicit cast
		assertEquals(Short.MAX_VALUE, __);
	}

	@Koan
	public void shortSize() {
		assertEquals(Short.SIZE, __);
	}

	@Koan
	public void wholeNumbersCanAlsoBeOfTypeByte() {
		assertEquals(getType((byte) 1), __);
	}

	@Koan
	public void primitivesOfTypeByteHaveAnObjectTypeByte() {
		Object number = (byte) 1;
		assertEquals(getType(number), __);
	}

	@Koan
	public void bytesHaveASmallerRangeThanShorts() {
		assertEquals(Byte.MIN_VALUE, __);
		assertEquals(Byte.MAX_VALUE, __);

		// Why would you use short or byte considering that you need to do explicit casts?
	}

	@Koan
	public void byteSize() {
		assertEquals(Byte.SIZE, __);
	}

	@Koan
	public void wholeNumbersCanAlsoBeOfTypeChar() {
		assertEquals(getType((char) 1), __);
	}

	@Koan
	public void singleCharactersAreOfTypeChar() {
		assertEquals(getType('a'), __);

        /*
            значение записанное в одинарных скобках есть "символ" - тип которого - char
            в одинарных скобках соответственно нельзя вписать больше одного символа.
            больше одного символа - есть текстовой строкой - имеет класс String - и записывается в двойних кавычках ""
         */
	}

	@Koan
	public void primitivesOfTypeCharHaveAnObjectTypeCharacter() {
		Object number = (char) 1;
		assertEquals(getType(number), __);
	}

	@Koan
	public void charsCanOnlyBePositive() {
		assertEquals((int) Character.MIN_VALUE, __);
		assertEquals((int) Character.MAX_VALUE, __);

		// Why did we cast MIN_VALUE and MAX_VALUE to int? Try it without the cast.
	}

	@Koan
	public void charSize() {
		assertEquals(Character.SIZE, __);
	}

	@Koan
	public void decimalNumbersAreOfTypeDouble() {
		assertEquals(getType(1.0), __);
	}

	@Koan
	public void primitivesOfTypeDoubleCanBeDeclaredWithoutTheDecimalPoint() {
		assertEquals(getType(1d), __);
	}

	@Koan
	public void primitivesOfTypeDoubleCanBeDeclaredWithExponents() {
		assertEquals(getType(1e3), __);
		assertEquals(1.0e3, __);
		assertEquals(1E3, __);
	}

	@Koan
	public void primitivesOfTypeDoubleHaveAnObjectTypeDouble() {
		Object number = 1.0;
		assertEquals(getType(number), __);

        /*
            к этому месту вы уже должны понять что у каждого примитивного типа есть свой "умный" аналог-класс
         */
	}

	@Koan
	public void doublesHaveALargeRange() {
		assertEquals(Double.MIN_VALUE, __);
		assertEquals(Double.MAX_VALUE, __);
	}

	@Koan
	public void doubleSize() {
		assertEquals(Double.SIZE, __);
	}

	@Koan
	public void decimalNumbersCanAlsoBeOfTypeFloat() {
		assertEquals(getType(1f), __);
	}

	@Koan
	public void primitivesOfTypeFloatCanBeDeclaredWithExponents() {
		assertEquals(getType(1e3f), __);
		assertEquals(1.0e3f, __);
		assertEquals(1E3f, __);
	}

	@Koan
	public void primitivesOfTypeFloatHaveAnObjectTypeFloat() {
		Object number = 1f;
		assertEquals(getType(number), __);
	}

	@Koan
	public void floatsHaveASmallerRangeThanDoubles() {
		assertEquals(Float.MIN_VALUE, __);
		assertEquals(Float.MAX_VALUE, __);
	}

	@Koan
	public void floatSize() {
		assertEquals(Float.SIZE, __);
	}


    /*
        Внизу мы видим еще один пример "перегрузки" методов (ad hoc полиморфизм).

        Странное Class<?>  - способ сказать что метод возвращает не значение какого то типа, а сам тип.
        Думаю теперь вам станет понятно как работал метод getType который вы встречали раньше...
     */

	private Class<?> getType(int value) {
		return int.class;
	}

	private Class<?> getType(long value) {
		return long.class;
	}

	private Class<?> getType(float value) {
		return float.class;
	}

	private Class<?> getType(double value) {
		return double.class;
	}

	private Class<?> getType(byte value) {
		return byte.class;
	}

	private Class<?> getType(char value) {
		return char.class;
	}

	private Class<?> getType(short value) {
		return short.class;
	}

	private Class<?> getType(Object value) {
		return value.getClass();
	}
	
}
