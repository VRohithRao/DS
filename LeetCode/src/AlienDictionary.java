import java.util.*;

/**
 * Created by Rohith Vallu on 10/31/2015.
 */
public class AlienDictionary {

    public static String createVertex(String[] words){
        HashMap<Character,Set<Character>> graph = new HashMap<Character,Set<Character>>();
        for(int i=0;i<words.length;i++){
            for(int j=0;j<words[i].length();j++){
                char c = words[i].charAt(j);
                if(!graph.containsKey(c)){
                    graph.put(c,new HashSet<Character>());
                }
            }
            if(i>0){
                connectVertices(words[i - 1], words[i], graph);
            }
        }
        return topologicalSort(graph);
    }

    public static void connectVertices(String first,String second,HashMap<Character,Set<Character>> graph){
        for(int i=0; i<Math.min(first.length(),second.length());i++){
            char c1 = first.charAt(i);
            char c2 = second.charAt(i);

            if(c1!=c2){
                if(!graph.get(c1).contains(c2)){
                    graph.get(c1).add(c2);
                }
                break;
            }

        }

    }

    public static String topologicalSort(HashMap<Character,Set<Character>> graph){
        StringBuilder sb = new StringBuilder();
        HashMap<Character,Integer> inDegree = new HashMap<Character,Integer>();
        for(char parent:graph.keySet()){
            for(char child:graph.get(parent)){
                Integer count = inDegree.containsKey(child)? inDegree.get(child) + 1 : 1;
                inDegree.put(child,count);
            }
        }


        Queue<Character> queue= new LinkedList<Character>();

        // add the element which has 0 indegree to the queue
        for(char vertex:graph.keySet()){
            if(!inDegree.containsKey(vertex)){
                queue.add(vertex);
            }
        }

        while (!queue.isEmpty()){
            char c = queue.poll();

            for(char child : graph.get(c)){
                inDegree.put(child, inDegree.get(child) - 1);
                if(inDegree.get(child) == 0) {
                    queue.add(child);
                }
            }
            sb.append(c);
        }

        for (int a : inDegree.values()) {	// if there is any non sorted, this is not a DAG, return false
            if (a != 0) return "";
        }

        return sb.toString();

    }


    public static void main(String[] args) {
//        String[] words = {"baa","abcd","abca","cab","cad"};
//        String[] words = {"wrt","wrf","er","ett","rtff"};
//        String[] words = {"ri","xz","qxf","jhsguaw","dztqrbwbm","dhdqfb","jdv","fcgfsilnb","ooby"};
//        String[] words = {"aba","bba","aaa"};
        String[] words = {"d","ab","bb","cb","ab"};
        System.out.print(createVertex(words));
    }
}
