import java.io.File;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Scanner;
/**
 * A class that represents the student directory and different ways to sort it
 *
 * @author Darvensky Daniel
 * @version 1.0 Build 2024.02.25
 */
public class DirectorySort {
    /**
     * An arraylist that will contain all the students in the directory
     */
    private SortableArrayList<Student> allStudents = new SortableArrayList<>();

    /**
     * Main function demonstrating the use of the Directory Sort class
     *
     * @param args The command line arguments
     */
    public static void main (String[] args) {
        DirectorySort everyone = new DirectorySort();

        everyone.readFile("directory-files/directory.txt");

        System.out.println("Smallest SU box: ");
        System.out.println(everyone.getSmallestSU());

        System.out.println("Largest SU box: ");
        System.out.println(everyone.getLargestSU());

        System.out.println("First by last name: ");
        System.out.println(everyone.getFirstByLastName());

        System.out.println("Last by last name: ");
        System.out.println(everyone.getLastByLastName());

        System.out.println("Most vowels: ");
        System.out.println(everyone.getMostVowels());

        System.out.println("Least vowels: ");
        System.out.println(everyone.getLeastVowels());

        System.out.println("Fancy phone: ");
        System.out.println(everyone.getFancyPhone());
    }

    /**
     * A class that represents a comparator of integers
     *
     * @author Darvensky Daniel
     * @version 1.0 Build 2024.02.25
     */
    private static class IntComparator implements Comparator<Integer> {

        /**
         * Compare the two given values
         *
         * @param a the first object to be compared.
         * @param b the second object to be compared.
         * @return The value indicating if a or b is bigger
         */
        @Override
        public int compare(Integer a, Integer b) {
            if (a < b) {
                return -1; // note: magnitude of the result is irrelevant
            } else if (a == b) {
                return 0;
            } else {
                return 1;
            }
        }
    }

    /**
     * A class that represents a comparator of strings
     *
     * @author Darvensky Daniel
     * @version 1.0 Build 2024.02.25
     */
    private static class StringComparator implements Comparator<String> {

        /**
         * Compare the two given values based on alphabetical order
         *
         * @param a the first object to be compared.
         * @param b the second object to be compared.
         * @return The value indicating if a or b is bigger
         */
        public int compare(String a, String b) {
            if (a.compareTo(b) < 0) {
                return -1;
            } else if (a.compareTo(b) == 0) {
                return 0;
            } else {
                return 1;
            }
        }
    }

    /**
     * Takes in a file, reads it line by line, makes each line a student and adds
     * the student to an arraylist
     *
     * @param someFilename The file name to be read
     */
    public void readFile(String someFilename) {
        Scanner scan;
        try {
            scan = new Scanner(new File(someFilename));
        } catch (Exception e) {
            // Failed to read file - good idea to print an error and exit/return
            System.out.println("Failed to read file.");
            return;
        }
        while (scan.hasNext()) { // While there’s more of the file to read
            String line = scan.nextLine(); // Read the next line
            Student newStudent = new Student(line);
            allStudents.add(newStudent);
        }
        scan.close(); // Done reading the file, so we close the Scanner.
    }

    /**
     *Find the smallest SU box number and find all students who have that number
     *
     * @return All students who have the smallest SU box number
     */
    public String getSmallestSU() {
        String qualifiedPeople = "";
        SortableArrayList<Integer> numbs = new SortableArrayList<>();

        for (int i = 0; i < this.allStudents.size(); i++) {
            numbs.add(this.allStudents.get(i).getSuBox());
        }
        numbs.sort(new IntComparator());
        for (int i = 0; i < allStudents.size(); i++) {
            if (allStudents.get(i).getSuBox() == numbs.getFirst()) {
                qualifiedPeople += allStudents.get(i) + "\n";
            }
        }
        return qualifiedPeople;
    }

    /**
     *Find the largest SU box number and find all students who have that number
     *
     * @return All students who have the largest SU box number
     */
    public String getLargestSU() {
        String qualifiedPeople = "";
        SortableArrayList<Integer> numbs = new SortableArrayList<>();

        for (int i = 0; i < this.allStudents.size(); i++) {
            numbs.add(this.allStudents.get(i).getSuBox());
        }
        numbs.sort(new IntComparator());
        for (int i = 0; i < allStudents.size(); i++) {
            if (allStudents.get(i).getSuBox() == numbs.getLast()) {
                qualifiedPeople += allStudents.get(i) + "\n";
            }
        }
        return qualifiedPeople;
    }

    /**
     * Sort the students alphabetically by last name and get the student(s) at the top of the list
     *
     * @return Student(s) at the top of the alphabetically sorted list of students
     */
    public String getFirstByLastName() {
        String qualifiedPeople = "";
        SortableArrayList<String> lastNames = new SortableArrayList<>();

        for (int i = 0; i < this.allStudents.size(); i++) {
            lastNames.add(this.allStudents.get(i).getLastName());
        }
        lastNames.sort(new StringComparator());
        for (int i = 0; i < allStudents.size(); i++) {
            if (allStudents.get(i).getLastName().equals(lastNames.getFirst())) {
                qualifiedPeople += allStudents.get(i) + "\n";
            }
        }
        return qualifiedPeople;
    }

    /**
     * Sort the students alphabetically by last name and get the student(s) at the end of the list
     *
     * @return Student(s) at the bottom of the alphabetically sorted list of students
     */
    public String getLastByLastName() {
        String qualifiedPeople = "";
        SortableArrayList<String> lastNames = new SortableArrayList<>();

        for (int i = 0; i < this.allStudents.size(); i++) {
            lastNames.add(this.allStudents.get(i).getLastName());
        }
        lastNames.sort(new StringComparator());
        for (int i = 0; i < allStudents.size(); i++) {
            if (allStudents.get(i).getLastName().equals(lastNames.getLast())) {
                qualifiedPeople += allStudents.get(i) + "\n";
            }
        }
        return qualifiedPeople;
    }

    /**
     * Find the students with the most vowels in their first and last names
     *
     * @return All students who have the most vowels in first and last names
     */
    public String getMostVowels() {
        String qualifiedPeople = "";
        SortableArrayList<Integer> vowelCounts = new SortableArrayList<>();
        HashMap<Student, Integer> studentsAndCounts = new HashMap<>();

        for (int i = 0; i < this.allStudents.size(); i++) {
            int count = 0;
            String fullName = allStudents.get(i).getFirstName() +
                    allStudents.get(i).getLastName();
            for (int j = 0; j < fullName.length(); j++) {
                if (fullName.toLowerCase().charAt(j) == 'a' ||
                        fullName.toLowerCase().charAt(j) == 'e' ||
                        fullName.toLowerCase().charAt(j) == 'i' ||
                        fullName.toLowerCase().charAt(j) == 'o' ||
                        fullName.toLowerCase().charAt(j) == 'u'){
                    count++;
                }
            }
            studentsAndCounts.put(allStudents.get(i), count);
            vowelCounts.add(count);
        }
        vowelCounts.sort(new IntComparator());
        for (int k = 0; k < studentsAndCounts.size(); k++) {
            if (studentsAndCounts.get(allStudents.get(k)) == vowelCounts.getLast()) {
                qualifiedPeople += allStudents.get(k) + "\n";
            }
        }
        return qualifiedPeople;
    }

    /**
     * Find the students with the least vowels in their first and last names
     *
     * @return All students who have the least vowels in first and last names
     */
    public String getLeastVowels(){
        String qualifiedPeople = "";
        SortableArrayList<Integer> vowelCounts = new SortableArrayList<>();
        HashMap<Student, Integer> studentsAndCounts = new HashMap<>();

        for (int i = 0; i < this.allStudents.size(); i++) {
            int count = 0;
            String fullName = allStudents.get(i).getFirstName() +
                    allStudents.get(i).getLastName();
            for (int j = 0; j < fullName.length(); j++) {
                if (fullName.toLowerCase().charAt(j) == 'a' ||
                        fullName.toLowerCase().charAt(j) == 'e' ||
                        fullName.toLowerCase().charAt(j) == 'i' ||
                        fullName.toLowerCase().charAt(j) == 'o' ||
                        fullName.toLowerCase().charAt(j) == 'u') {
                    count++;
                }
            }
            studentsAndCounts.put(allStudents.get(i), count);
            vowelCounts.add(count);
        }
        vowelCounts.sort(new IntComparator());
        for (int k = 0; k < studentsAndCounts.size(); k++) {
            if (studentsAndCounts.get(allStudents.get(k)) == vowelCounts.getFirst()) {
                qualifiedPeople += allStudents.get(k) + "\n";
            }
        }

        return qualifiedPeople;
    }

    /**
     * Find the most occurrences of a digit in a phone number and get students that
     * also have that number of occurrences in their phone number
     *
     * @return All students who have the most occurrences of a digit in the phone number
     */
    public String getFancyPhone() {
        String qualifiedPeople = "";
        HashMap<Student, Integer> studentAndNumber = new HashMap<>();
        SortableArrayList<Integer> occurrences = new SortableArrayList<>();

        for (int i = 0; i < allStudents.size(); i++) {
            studentAndNumber.put(allStudents.get(i),
                    this.getCount(this.allStudents.get(i).getPhone()));
            occurrences.add(this.getCount(this.allStudents.get(i).getPhone()));
        }
        occurrences.sort(new IntComparator());
        for (int j = 0; j < studentAndNumber.size(); j++) {
            if (studentAndNumber.get(allStudents.get(j)) == occurrences.getLast()) {
                qualifiedPeople += allStudents.get(j) + "\n";
            }
        }
        return qualifiedPeople;
    }

    /**
     * Take in a string and get the highest number of occurrences of a
     * character within that string
     *
     * @param input The string to be looped through
     * @return The highest number of occurrences of a character within the input
     */
    public int getCount(String input) {
        HashMap<Character, Integer> soloCharAndCount = new HashMap<>();
        int max = 0;

        for(int i = 0; i < input.length(); i++) {
            char key = input.charAt(i);
            if (soloCharAndCount.containsKey(key)) {
                soloCharAndCount.replace(input.charAt(i), soloCharAndCount.get(key)+1);
            } else {
                soloCharAndCount.put(key, 1);
            }
        }
        for (int value : soloCharAndCount.values()) {
            if (value > max){
                max = value;
            }
        }
        return max;
    }
}
