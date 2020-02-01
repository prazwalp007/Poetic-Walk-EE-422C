package assignment3;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;

class Graph {
    ArrayList<Vertex> Vertices = new ArrayList<>();

    public boolean isVertexPresent(String vertexName) {
        for (int i = 0; i < Vertices.size(); i++) {
            String name = (String) Vertices.get(i).getVertexName();
            if (name.equals(vertexName)) {
                return true;
            }
        }
        return false;
    }

    public void addEdgesforVertexinList(String vertexName, String adjVertex) {
        for (int i = 0; i < Vertices.size(); i++) {
            String name = (String) Vertices.get(i).getVertexName();
            if (name.equals(vertexName)) {
                Vertices.get(i).addEdges(adjVertex);
            }

        }
    }


    public void addNodes(Vertex newVertex) {
        Vertices.add(newVertex);
    }

    @Override
    public String toString() {
        String contentofList = "";
        for (int i = 0; i < Vertices.size(); i++) {
            System.out.println(Vertices.get(i).getVertexName() + "------->" + Vertices.get(i).getEdges());
        }
        return contentofList;
    }

    public String findBridgeWords(String word, String nextWord) {
        ArrayList<String> bridgeWords = new ArrayList<>() ;
        String bridge = "";
        int indexofVertex = 0;
        if ((isVertexPresent(word)) && (isVertexPresent(nextWord))) {

            //find vertex in ArrayList
            for (int i = 0; i < Vertices.size(); i++) {
                String vertexName = (String) Vertices.get(i).getVertexName();
                if (vertexName.equals(word)) {
                    indexofVertex = i;
                }
            }

            Set setofEdges = Vertices.get(indexofVertex).getEdges().keySet();

                for (int j = 0; j < Vertices.size(); j++) {
                    Iterator iterator = setofEdges.iterator();
                    while (iterator.hasNext()){

                    String vertexName = (String) Vertices.get(j).getVertexName();
                    if (vertexName.equals(iterator.next())) {
                        if (Vertices.get(j).getEdges().containsKey(nextWord)) {

                            bridgeWords.add((String) Vertices.get(j).getVertexName());
                        }
                    }
                }
            }

        }

        int weight = 0;
        for (int i = 0; i < bridgeWords.size();i++){
            if ((int)Vertices.get(indexofVertex).getEdges().get(bridgeWords.get(i)) > weight){
                weight = (int)Vertices.get(indexofVertex).getEdges().get(bridgeWords.get(i));
                bridge = bridgeWords.get(i);
            }
        }


       // System.out.println("The bridge is " + bridge);
        return bridge;
    }
}
