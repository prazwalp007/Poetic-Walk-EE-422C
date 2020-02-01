/* EE422C Assignment #3 submission by
 * <Student Name>
 * <Student EID>
 */


package assignment3;

import java.io.File;
import java.io.IOException;

public class Main {
    /**
     * Example program using GraphPoet.
     */


        /**
         * Generate example poetry.
         *
         * @param args unused
         * @throws IOException if a poet corpus file cannot be found or read
         */
        public static void main(String[] args) throws IOException {
            final GraphPoet nimoy = new GraphPoet(new File("/home/ecelrc/students/ppokharel/assignment3/corpus.txt"));
            System.out.println(nimoy.poem(new File("/home/ecelrc/students/ppokharel/assignment3/input.txt")));
        }
}
