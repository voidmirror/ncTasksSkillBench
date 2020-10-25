package ru.skillbench.tasks.text;

import java.io.PrintStream;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/**
 * ЦЕЛИ ЗАДАЧИ - разобраться с интерфейсом java.util.Map, 
 *   а также с API для сортировки и синтаксисом параметризованных (generic) методов.<br/>
 * Дополнительно: разобраться с использованием регулярных выражений в Java
 *  или хотя бы с базовым API для работы со строками.<br/>
 * <p/>
 * ЗАДАНИЕ<br/>
 * Подсчитать количества вхождений слов в тексте без учета регистра символов.<br/>
 * <br/>
 * ТРЕБОВАНИЯ<br/>
 * Словом считается любая последовательность символов длиной не менее 1го символа, отделенная 
 *  от других произвольным количеством пробелов, символов табуляции и переводов строк.<br/>
 * НЕОБХОДИМО:<br/>
 * - подсчитать количества вхождений слов в тексте без учета регистра символов
 *   (слова 'Программа' и 'программа' считаются одним и тем же словом!),<br/>
 * - упорядочить результаты подсчета в порядке убывания числа вхождений слова.<br/>
 * ДОПОЛНИТЕЛЬНО: <br/>
 * - распечатать результаты подсчета в {@link PrintStream},<br/>
 * - исключить из рассмотрения слова, заключенные внутри угловых скобок &lt;...&gt;.<br/>
 * <p/>
 * ПРИМЕЧАНИЯ:<br/>
 * - В HTML &gt; - это > (больше), &lt; - это < (меньше), а комментарии пишутся в таком "странном" 
 *  виде, чтобы они корректно отображались в HTML, который из них генерируется через javadoc).<br/>
 *  То есть, вышеприведенную фразу следует читать: "внутри угловых скобок <...>".<br/>
 * - Данная задача не требует убирать из слов знаки препинания (.,;:-), однако при желании 
 *   их можно убрать (класс будет тестироваться текстами, не содержащими этих знаков).<br/>
 * - Для самопроверки можно взять длинный текст, например, из http://www.gnu.org/licenses/lgpl-3.0.txt<br/>
 * 
 * @author Andrey Shevtsov
 */
public interface WordCounter
{
	/**
	 * Принимает текст для анализа
	 * @param text текст для анализа
	 */
	void setText(String text);
	
	/**
	 * @return текст, переданный для анализа при последнем вызове метода
	 * {@link #setText(java.lang.String) setText}, или <code>null</code>,
	 * если указанный метод еще не вызывался или последний раз вызывался
	 * с параметром <code>null</code>
	 */
	String getText();
	
	/**
	 * Возвращает {@link Map}&lt;{@link String}, {@link Long}&gt;, сопоставляющую каждому 
	 *   слову (длиной не менее 1 символа) количество его вхождений в анализируемый текст.<br/>
	 * Все возвращаемые слова должны быть приведены к нижнему регистру.<br/>
	 * Дополнительно оценивается, если из рассмотрения исключены слова, начинающиеся с &lt;
	 *  и заканчивающиеся на &gt; (то есть, расположенные в угловых скобках).<br/>
	 * @return результат подсчета количеств вхождений слов
	 * @throws IllegalStateException если не задан текст для анализа
	 *   (если метод {@link #setText(String)} еще не вызывался
	 *   или последний раз вызывался с параметром <code>null</code>)
	 */
	Map<String, Long> getWordCounts();
	
	/**
	 * Возвращает список из {@link Entry Map.Entry}&lt;{@link String}, {@link Long}&gt;,
	 * сопоставляющий каждому слову количество его вхождений в анализируемый текст
	 * и упорядоченный в прядке убывания количества вхождений слова.<br/>
	 * Слова с одинаковым количеством вхождений упорядочиваются в алфавитном порядке (без учета регистра!).<br/>
	 * Все возвращаемые слова должны быть приведены к нижнему регистру.<br/>
	 * 
	 * ПРИМЕЧАНИЕ: при реализации рекомендуется использовать {@link #sort(Map, Comparator)}
	 * @return упорядоченный результат подсчета количеств вхождений слов
	 * @throws IllegalStateException если не задан текст для анализа
	 *   (если метод {@link #setText(String)} еще не вызывался
	 *   или последний раз вызывался с параметром <code>null</code>)
	 */
	List<Map.Entry<String, Long>> getWordCountsSorted();
	
	/**
	 * Упорядочивает содержимое <code>map</code> (это слова и количество их вхождений) 
	 *  в соответствии с <code>comparator</code>.<br/>
	 * <br/>
	 * ПРИМЕЧАНИЕ:Этот метод работает только со своими параметрами, но не с полями объекта {@link WordCounter}.
	 * @param map Например, неупорядоченный результат подсчета числа слов
	 * @return Содержимое <code>map</code> в виде списка, упорядоченного в соответствии с <code>comparator</code>
	 */
	<K extends Comparable<K>, V extends Comparable<V>> List<Map.Entry<K,V>> sort(Map<K,V> map, Comparator<Map.Entry<K,V>> comparator);
	
	/**
	 * Распечатывает <code>entryList</code> (это слова и количество их вхождений) 
	 *  в поток вывода <code>ps</code>.<br/>
	 * Формат вывода следующий:
	 * <ul>
	 *	<li>Каждое слово вместе с количеством вхождений выводится на отдельной строке</li>
	 *	<li>На каждой строке слово и количество вхождений разделены одним(!) пробелом,
	 * никаких других символов на строке быть не должно</li>
	 * </ul>
	 * Все выводимые слова должны быть приведены к нижнему регистру.<br/>
	 * <br/>
	 * ПРИМЕЧАНИЕ: Этот метод работает только со своими параметрами, но не с полями объекта {@link WordCounter}.
	 * @param entryList Список пар - например, результат подсчета числа слов
	 * @param ps Поток вывода - например, System.out.
	 */
	<K,V> void print(List<Map.Entry<K, V>> entryList, PrintStream ps);
}
