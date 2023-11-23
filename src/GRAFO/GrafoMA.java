package GRAFO;

import CONJUNTO.conjuntoA;

public class GrafoMA implements TDAG {
    static int n = 100;
    int [][] MAdy;
    int [] Etiqs;
    int cantNodos;

    @Override
    public void InicializarGrafo() {
        MAdy = new int [n][n];
        Etiqs = new int[n];
        cantNodos = 0;
    }

    @Override
    public void AgregarVertice(int v) {
        //Costo lineal
        Etiqs[cantNodos] = v;
        for (int i = 0; i <= cantNodos; i++){
            MAdy[cantNodos][i] = 0;
            MAdy[i][cantNodos] = 0;
        }
        cantNodos ++;
    }

    private int Vert2Indice(int v){
        //Costo lineal
        int i = cantNodos -1;
        while (1 > 0 && Etiqs[i] != v){
            i--;
        }
        return i;
    }

    @Override
    public void EliminarVertice(int v) {
        //Costo lineal
        int ind = Vert2Indice(v);
        for (int i=0; i < cantNodos; i++){
            MAdy[i][ind] = MAdy [i][cantNodos-1];
        }
        for (int i=0; i < cantNodos; i++){
            MAdy[ind][i] = MAdy [cantNodos-1][i];
        }
        Etiqs[ind] = Etiqs[cantNodos-1];
        cantNodos--;
    }

    @Override
    public void AgregarArista(int v1, int v2, int p) {
        //Costo lineal
        int o = Vert2Indice(v1);
        int d = Vert2Indice(v2);
        MAdy[o][d] = p;
    }

    public void EliminarArista(int v1, int v2){
        //Costo lineal
        int o = Vert2Indice(v1);
        int d = Vert2Indice(v2);
        MAdy[o][d] = 0;
    }

    @Override
    public int PesoArista(int v1, int v2) {
        //Costo lineal
        int o = Vert2Indice(v1);
        int d = Vert2Indice(v2);
        return MAdy[o][d];
    }

    @Override
    public conjuntoA Vertices() {
        //Costo cuadratico
        conjuntoA Vert = new conjuntoA();
        Vert.iniciarconjunto();
        for (int i=0; i<cantNodos; i++){
            Vert.agregar(Etiqs[i]);
        }
        return Vert;
    }

    @Override
    public boolean ExisteArista(int v1, int v2) {
        //Costo lineal
        int o = Vert2Indice(v1);
        int d = Vert2Indice(v2);
        return (MAdy[o][d] != 0);
    }
    public conjuntoA Adyacentes(int v) {
        //Costo lineal
        int o = Vert2Indice(v);
        conjuntoA ady = new conjuntoA();
        ady.iniciarconjunto();
        for (int d=0; d<cantNodos; d++){
            if (MAdy[o][d] != 0){
                ady.agregar(Etiqs[d]);
            }
        }
        return ady;
    }


}
