/* EE422C Assignment #3 submission by
 * <Student Name>
 * <Student EID>
 */

package assignment3;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class GraphPoet {
    Graph graphWords = new Graph();
    /**
     *
     * @param corpus text file from which to derive the poet's affinity graph
     * @throws IOException if the corpus file cannot be found or read
     */

    public GraphPoet(File corpus) throws IOException {
        /* Read in the File and place into graph here */
        String st;
        ArrayList <String> wordsLookUp = new ArrayList<>();

        File file = new File("/home/ecelrc/students/ppokharel/assignment3/corpus.txt");
        BufferedReader br = new BufferedReader(new FileReader(file));

        while ((st = br.readLine())!= null) {
            String[] words = st.split(" ");
            for (int i = 0; i < words.length; i++) {
                wordsLookUp.add(words[i]);
            }
        }

        Vertex node;

        for (int i = 0; i < wordsLookUp.size(); i++){
            //create vertex for unique words
            if (!graphWords.isVertexPresent(wordsLookUp.get(i))) {
                node = new Vertex<>(wordsLookUp.get(i));
                int j = i + 1;
                if (j != wordsLookUp.size()) {
                    node.addEdges(wordsLookUp.get(j));
                }
                graphWords.addNodes(node);
                }else{
                    int j = i + 1;
                    if (j != wordsLookUp.size()) {
                       graphWords.addEdgesforVertexinList(wordsLookUp.get(i), wordsLookUp.get(j));
                    }

                }

            }
       // System.out.println(graphWords);

    }




    /**
     * Generate a poem.
     *
     * @param input File from which to create the poem
     * @return poem (as described above)
     */
    public String poem(File input) throws IOException {

        /* Read in input and use graph to complete poem */
        String poem = "";
        String st;
        ArrayList <String> poemWords = new ArrayList<>();
        File file = new File("/home/ecelrc/students/ppokharel/assignment3/input.txt");
        BufferedReader br = new BufferedReader(new FileReader(file));

        while ((st = br.readLine())!= null) {
            String[] words = st.split(" ");
            for (int i = 0; i < words.length; i++) {
                poemWords.add(words[i]);

            }
        }

        for (int i =  0; i < poemWords.size(); i++){
               // System.out.println(words[i]);
                if (i < poemWords.size() - 1 ) {
                    String bridgeWord = graphWords.findBridgeWords(poemWords.get(i), poemWords.get(i+1));
                    if (!(bridgeWord.equals(""))){
                        poemWords.add(i+1, bridgeWord);
                    }
                }
        }


        for (int i = 0; i < poemWords.size(); i++){
            poem = poem + poemWords.get(i) + " ";
        }

        return poem;
    }

}
