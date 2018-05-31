package PageObjects;

/**
 * @author: Akhilesh Maloo
 * @date: 1/26/18.
 */
public class WrongPageException extends RuntimeException {
    public WrongPageException(String s) {
        super(s);
    }
}
