package disjointSet;

import java.util.Arrays;
import java.util.Random;

public class DetectCycleUndirectedGraph {
    public static void main(String[] args) {
        Random random = new Random(System.currentTimeMillis());
        int graphSize = random.nextInt(30)+1;
        int[] set = new int[graphSize];
        Edge[] edges = new Edge[graphSize];
        for(int i=0;i<graphSize;i++) {
            set[i] = -1;
            edges[i] = new Edge(random.nextInt(graphSize),random.nextInt(graphSize),graphSize);
        }
        for (int i=0;i<graphSize;i++)
            System.out.println(edges[i]);

        for (int i=0;i<edges.length;i++){
            Edge edge = edges[i];
            int x = find(set,edge.u);
            int y = find(set,edge.v);
            if(x==y) {
                System.out.println("Cycle Found for Edge "+edge+" at iteration "+i);
                printSet(set,i,edge);
                break;
            }
            else {
                set[x<y?x:y] = x<y?y:x;
                printSet(set,i,edge);
            }
        }
    }

    private static int find(int[] set, int u){
        if(set[u]==-1)
            return u;
        return find(set,set[u]);
    }


    private static void printSet(int[] set, int itr, Edge edge) {
        System.out.print("Iteration "+itr);
        System.out.println(" Edge "+edge);
        for (int i=0;i<set.length;i++)
            System.out.printf("%3d",i);
        System.out.println();
        for (int i=0;i<set.length;i++)
            System.out.printf("%3d",set[i]);
        System.out.println();
    }

    private static class Edge{
        int u,v;

        public Edge(int u, int v,int max) {
            this.u = u;
            this.v = v;
            if(u==v)
                this.v+=(v==max-1?-1:1);
        }

        @Override
        public String toString() {
            return "("+u+","+v+")";
        }
    }
}
