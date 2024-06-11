import java.util.Comparator;
/**
 * A class that represents an arraylist that can be sorted
 *
 * @author Darvensky Daniel
 * @version 1.0 Build 2024.02.25
 */
public class SortableArrayList<T> extends SimpleArrayList<T> {

    /**
     * Construct a new default arraylist
     */
    public SortableArrayList() {
        super();
    }

    /**
     * Construct a new arraylist with a starting capacity
     * @param startingCap The length of the arraylist
     */
    public SortableArrayList(int startingCap) {
        super(startingCap);
    }

    /**
     * Sorts an arraylist in ascending order using given parameter
     *
     * @param c the {@code Comparator} used to compare list elements.
     *          A {@code null} value indicates that the elements'
     *          {@linkplain Comparable natural ordering} should be used
     */
    @Override
    public void sort(Comparator<? super T> c) {
        int index = 0;
        for (int j = this.size()-1; j >= 0; j--) {
            T max = this.get(j);
            for (int i = 0; i < j; i++){
                if (c.compare(this.get(i), max) > 0) {
                    max = this.get(i);
                    index = i;
                }
            }
            if (c.compare(this.get(index), this.get(j)) > 0) {
                this.set(index, this.get(j));
            }
            this.set(j, max);
        }
    }
}
