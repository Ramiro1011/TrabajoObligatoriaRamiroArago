import GRAFO.GrafoMA;


public class Main {
    public static void main(String[] args) {

        GrafoMA grafo = new GrafoMA();
        grafo.InicializarGrafo();
        grafo.AgregarVertice(0);
        grafo.AgregarVertice(1);
        grafo.AgregarVertice(2);
        grafo.AgregarVertice(3);
        grafo.AgregarVertice(4);
        grafo.AgregarVertice(5);
        grafo.AgregarVertice(6);
        grafo.AgregarArista(1,2,2);
        grafo.AgregarArista(1,4,3);
        grafo.AgregarArista(2,5,4);
        grafo.AgregarArista(3,1,1);
        grafo.AgregarArista(4,3,2);
        grafo.AgregarArista(5,4,5);

        Dfs dfs = new Dfs();
        dfs.inicializarDfs(grafo.Vertices().cantidad());
        String[] l = dfs.dfsForest(grafo);
        for (int i = 0; i < l.length;i++){
            if(l[i] == "negro"){
            System.out.println("el nodo "+i+" fue visitado por DFS");}
        }

        Bfs bfs = new Bfs();
        bfs.inicializarDfs(grafo.Vertices().cantidad());
        String[] n = bfs.bfsForest(grafo);
        for (int i = 0; i < n.length;i++){
            if(n[i] == "negro"){
                System.out.println("el nodo "+i+" fue visitado por BFS");}
        }
    }
}