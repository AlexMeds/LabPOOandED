public class App {
    public static void main(String[] args) throws Exception {
        Lista lista = new Lista();

        lista.contarBloco();

        lista.addBlocoInexistente(50, 23);

        lista.adicionarBloco(500,20);

        lista.adicionarBloco(100,1);

        lista.mostrarLista();

        lista.contarBloco();

        lista.removerBloco(1);

        lista.contarBloco();

    }
}

