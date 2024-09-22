package ListaPOO;

abstract public class Lista {

    public Header cabecalho;
    abstract public Bloco addBloco(int valor, int posicao);
    abstract public Bloco removeBloco(int posicao);
    abstract public Bloco localizarBloco (int posicao);

}
