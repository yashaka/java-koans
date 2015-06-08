package beginner;


import com.sandwich.koan.Koan;
import static com.sandwich.koan.constant.KoanConstants.__;
import static com.sandwich.util.Assert.assertEquals;


public class AboutLoops {

	/*
		Лупы - это циклы.
		В програмировании циклы используются для того что бы повторить какую то часть кода много раз, но со возможностью
		задавать разные "условия". Разные условия - обычно представлены использованием переменных с разными значениями
		в разных "итерациях" цикла.
	 */

	@Koan
	public void basicForLoop() {
		String s = "";
		for(int i = 0; i < 5; i++) {
			s += i + " ";
		}
        /*
            цикл говорит: 5 раз (пока i меньше пяти) выполнить код
                s += i + " ";
            При этом на каждой итерации увеличивать значение живущее в i на единицу
            Вот этот оператор ++ - как раз и обозначает "увеличение на единицу"

            оператор += означает присвоить тому что слева себя же увеличенного на то что справа

            То есть
                s += " "
            то же что и
                s = s + " "
         */
		assertEquals(s, __);
	}
	
	@Koan
	public void basicForLoopWithTwoVariables() {
		String s = "";
		for(int i = 0, j = 10; i < 5 && j > 5; i++, j--) {
			s += i + " " + j + " ";
		}
        /*
            по аналогии, но с двумя переменными цикла.
            -- - уменьшает значение на единицу
         */
		assertEquals(s, __);
	}
	
	@Koan
	public void extendedForLoop() {
		int[] is = {1,2,3,4};
		String s = "-";
		for(int j : is) {
			s += "." + j;
		}
        /*
            Это специальная форма цикла for в которой не нужно указывать границы "переменной цикла".
            Достаточно просто указать набор значений которые должна принимать переменная цикла на каждой итерации.
            набор значений - например в виде "массива".

            Цикл выше читается таким образом:
                Для каждого j с is
            (то есть
                Присваивая переменной цикла j значения из {1,2,3,4} по порядку для кождой итерации соответсвенно)

                выполнить код
                    s += "." + j;

         */
		assertEquals(s, __);
	}
	
	@Koan
	public void whileLoop() {
		int result = 0;
		while(result < 3) {
			result++;
		}
        /*
            все очевидно: пока выпонляется условие (то есть результат выражения в скобках после while - true)
            выполнять код в фигурных скобках.
         */
		assertEquals(result, __);
	}
	
	@Koan
	public void doLoop() {
		int result = 0;
		do {
			result++;
		} while(false);
        /*
            "противоположная" версия вайла.
            - Выполнять код в скобках до тех пока выполняется условие.
            Отличие на лицо: даже если условие не выполняется (как в нашем случае) цикл "do" хотя бы раз выполнит
            код в скобках.
         */
		assertEquals(result, __);
	}
	
	@Koan
	public void extendedForLoopBreak() {
		String[] sa = {"Dog", "Cat", "Tiger"};
		int count = 0;
		for(String current : sa) {
			if("Cat".equals(current)) {
				break;
			}
			count++;	
		}
        /*
            break - специальный оператор который прерывает выполнение всего цикла
         */
		assertEquals(count, __);
	}
	
	@Koan
	public void extendedForLoopContinue() {
		String[] sa = {"Dog", "Cat", "Tiger"};
		int count = 0;
		for(String current : sa) {
			if("Dog".equals(current)) {
				continue;
			} else {
				count++;	
			}
		}
        /*
            сontinue - специальный оператор который прерывает выполнение текущей итерации и сразу запускает "следующую"
            итерацию.
         */
		assertEquals(count, __);
	}

	@Koan
	public void forLoopContinueLabel() {
		int count = 0;
		outerLabel:
		for(int i = 0; i < 5; i++) {
			for(int j = 0; j < 5; j++)
			{
				count++;
				if(count > 2) {
					continue outerLabel;	
				}
			}
			count += 10;
		}
		// What does continue with a label mean? 
		// What gets executed? Where does the program flow continue?

        /*
            continue с меткой - удобен когда есть два вложеных цыкла и нужно "перепрыгнуть" с поточной итерации внутреннего
            цикла сразу на следующую итерацию внешнего.

            Обязательно попробуйте расписать все итерации в этом коане, что бы понять почему результат таков каков есть.
         */
		assertEquals(count, __);
	}
	
	@Koan
	public void forLoopBreakLabel() {
		int count = 0;
		outerLabel:
		for(int i = 0; i < 5; i++) {
			for(int j = 0; j < 5; j++)
			{
				count++;
				if(count > 2) {
					break outerLabel;	
				}
			}
			count += 10;
		}
		// What does break with a label mean? 
		// What gets executed? Where does the program flow continue?

        /*
            метка используется в том же контексте что и выше, но с целью - завершить сразу внешний цикл (обозначенный меткой)
            а не только внутренний.
         */
		assertEquals(count, __);
	}

}
