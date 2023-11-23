import CONJUNTO.conjuntoA;
import GRAFO.GrafoMA;

import java.util.LinkedList;
import java.util.Queue;

public class Bfs {
    String[] marca;
    int[]p;
    double[] d;
    double infinito = Double.MAX_VALUE;

    public void inicializarDfs(int n){
        //Se instancian los atributos de la clase necesarios para realizar el recorrido
        marca = new String[n];//Aca se guardan el estado del nodo, blanco para no visitado, gris para descubierto, negro para visitado, cada uno en el indice correspondiente al nodo
        p = new int[n];// los predecesores de cada nodo
        d = new double[n];
    }
    public String[] bfsForest(GrafoMA grafo){ // Funcion forest para asegurarse de que se visiten todos los nodos
        conjuntoA conv = grafo.Vertices(); // crea un conjunto de los vertices del grafo llamando a la funcion Vertices()
        while (!conv.conjuntovacio()){ // entra en un bucle que se ejecuta siempre que el conjunto creado no este vacio
            int v = conv.elegir();// se elige un vertice del conjunto
            conv.sacar(v); // se saca el vertice del conjunto para que el bucle no sea infinito
            marca[v]="blanco"; // se marca en la lista de visitados en el indice que corresponde al vertice como blanco, osea no visitado
            d[v]=infinito; //Asigna a la infinito a la distancia de cada vertice en la lista d
        }// este while asegura que todos los nodos esten en no visitados
        conjuntoA conv2 = grafo.Vertices();
        while (!conv2.conjuntovacio()) {
            int v = conv2.elegir();
            conv2.sacar(v);
            if (marca[v] == "blanco") { // evalua si el vertice no esta visitado, osea si en la lista esta en blanco
                bfs(grafo, v); // si es asi, llama a la funcion dfs pasandole el grafo y el vertice como origen
            }
        } // este while se encarda de que todos los nodos sean visitados, incluyendo a los nodos que estan aislados
        return marca; // retorna la lista de los estados de los elementos para asegurarnos de que visito a todos
    }

    public void bfs(GrafoMA g, int o){
        Queue<Integer> fila = new LinkedList<>(); //Crea una cola
        marca[o] = "negro"; //Marca al origen como visitado("negro") en la lista marca
        fila.add(o);//Agrega al origen a la cola
        d[o]=0;
        while (!fila.isEmpty()){//Entre en un bucle que se ejecuta siempre que la cola no este vacia
            int u = fila.peek();//Obtiene el primer elemento de la cola
            conjuntoA conv = g.Adyacentes(u);//Obtiene los vertices adyacentes de u que seria el primer elemento de la cola que este seria el origen
            while (!conv.conjuntovacio()){//Entra en un bucle que recorre los vertices adyacentes
                int v = conv.elegir();//Elige un vertice del conjunto
                conv.sacar(v);//Elimina el vertice del conjunto
                if(marca[v]=="blanco"){//Si el vertice no esta visitado osea es "blanco" en la lista marca en el indice correspondiente al vertice
                    marca[v]="gris";//Lo marca como descubierto "gris"
                    p[v]=u;//Le asiga u como predecesor en la lista p al vertice
                    d[v]=d[u]+1;//asigna el valor de u +1 de la lista d, al vertice en la misma lista
                    fila.add(v);//Agrega el vertice a la fila
                }
            }
            fila.remove();//Remueve u de la fila
            marca[u]="negro";//Lo marca como visitado "negro"
        }
    }
}
