package CONJUNTO;

public class conjuntoA implements conjuntoTda {
    private int[] a;
    private int cant;

    public void iniciarconjunto(){
        a = new int[100];
        cant = 0;
    }

    public void agregar(int x){
        if (!this.pertenece(x)) {
            a[cant] = x;
            cant++;
        }
    }

    public boolean conjuntovacio(){
        return (cant == 0);
    }

    public int elegir(){
        return a[cant - 1];
    }

    public boolean pertenece(int x){
        int i = 0;
        while (i<cant && a[i] != x)
            i++;
        return (i<cant);
    }

    public void sacar(int x){
        int i = 0;
        while (i < cant && a[i] != x)
            i++;
        if (i < cant) {
            a[i] = a[cant - 1];
            cant--;
        }
    }

    public int cantidad(){
        return cant;
    }
}
