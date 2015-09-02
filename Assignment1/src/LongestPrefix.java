import java.util.*;

/**
 * 
 * @author Jonathan Monreal
 */
public final class LongestPrefix {
    
    /**
     * Do not allow this class to be instantiated.
     */
    private LongestPrefix() {}
    
    /**
     * 
     * @param a
     * @param b
     * @param cmp
     * @return
     */
    public static <T> List<T> longestPrefix(List<T> a, List<T> b,
	    Comparator<? super T> cmp) {
	if (eitherEmpty(a, b) || !areEqual(a.get(0), b.get(0), cmp))
	    return new LinkedList<T>();
	else {
	    List<T> prefix = new LinkedList<T>();
	    prefix.add(a.get(0));
	    a.remove(0);
	    b.remove(0);
	    prefix.addAll(longestPrefix(a, b, cmp));
	    return prefix;
	}
    }
    
    /**
     * 
     * @param a
     * @param b
     * @return
     */
    private static <T> boolean eitherEmpty(List<T> a, List<T> b) {
	return a.isEmpty() || b.isEmpty();
    }
    
    /**
     * 
     * @param a
     * @param b
     * @param cmp
     * @return
     */
    private static <T> boolean areEqual(T a, T b,
	    Comparator<? super T> cmp) {
	return cmp.compare(a, b) == 0;
    }
    
}