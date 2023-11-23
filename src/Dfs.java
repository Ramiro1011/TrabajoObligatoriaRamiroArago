import CONJUNTO.conjuntoA;
import GRAFO.GrafoMA;

public class Dfs {
    String[] marca;
    int[]p;
    int tiempo;
    int[] d;
    int[] f;

    public void inicializarDfs(int n){
        //Se instancian los atributos de la clase necesarios para realizar el recorrido
        marca = new String[n];//Aca se guardan el estado del nodo, blanco para no visitado, gris para descubierto, negro para visitado, cada uno en el indice correspondiente al nodo
        p = new int[n];// los predecesores de cada nodo
        tiempo = 0;
        d = new int[n];
        f = new int[n];
    }

    public String[] dfsForest(GrafoMA grafo){ // Funcion forest para asegurarse de que se visiten todos los nodos
        conjuntoA conv = grafo.Vertices(); // crea un conjunto de los vertices del grafo llamando a la funcion Vertices()
        while (!conv.conjuntovacio()){ // entra en un bucle que se ejecuta siempre que el conjunto creado no este vacio
            int v = conv.elegir();// se elige un vertice del conjunto
            conv.sacar(v); // se saca el vertice del conjunto para que el bucle no sea infinito
            marca[v]="blanco"; // se marca en la lista de visitados en el indice que corresponde al vertice como blanco, osea no visitado
        }// este while asegura que todos los nodos esten en no visitados
        tiempo = 0; // marca el tiempo en cero
        conjuntoA conv2 = grafo.Vertices();
        while (!conv2.conjuntovacio()) {
            int v = conv2.elegir();
            conv2.sacar(v);
            if (marca[v] == "blanco") { // evalua si el vertice no esta visitado, osea si en la lista esta en blanco
                dfs(grafo, v); // si es asi, llama a la funcion dfs pasandole el grafo y el vertice como origen
            }
        } // este while se encarda de que todos los nodos sean visitados, incluyendo a los nodos que estan aislados
        return marca; // retorna la lista de los estados de los elementos para asegurarnos de que visito a todos
    }
    public void dfs(GrafoMA g, int o){// recorre los vertices del grafo, los que no estan visitados pasan a descubiertos, luego busca sus adyacentes y vuelve a hacer lo mismo, una vez que se descubrieron todos los adyacentes, el algoritmo vuelva hacia atras marcando como visitados osea "negro" en la lista
        tiempo = tiempo+1; // aumenta el tiempo por cada cada nodo que se descubre
        d[o]=tiempo;
        marca[o]="gris"; // marca al origen como descubierto
        conjuntoA conv = g.Adyacentes(o);//Obtiene el conjunto de adyacentes llamando a la funcion, pasando por parametro el vertice origen
        while (!conv.conjuntovacio()) {//hasta que el conjunto de vertices no este vacio se repite el bucle
            int v = conv.elegir();//elige un vertice
            conv.sacar(v);//lo elimina del conjunto
            if (marca[v] == "blanco") { // si el adyacente no esta visitado, osea en "blanco"
                p[v] = o;//le asigna el predecesor al adyacente, que seria en vertice origen
                dfs(g,v);//vuelve a llamar a la funcion dfs pasando como parametro el grafo y el vertice adyacente para que este sea el origen
            }
        }
        marca[o]="negro";//una vez que termina el blucle, marca al vertice como visitado, osea "negro"
        tiempo=tiempo+1;//aumenta el tiempo en +1
        f[o]=tiempo;
    }//Al ser una funcion recursiva, una vez que se llega al ultimo vertice adyacente, se empiezan a marcar uno por uno como visitados
}

