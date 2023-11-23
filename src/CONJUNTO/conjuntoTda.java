package CONJUNTO;

public interface conjuntoTda {
    void iniciarconjunto();
    void agregar(int x);
    int elegir();
    boolean conjuntovacio();
    void sacar(int x);
    boolean pertenece(int x);

    int cantidad();
}
