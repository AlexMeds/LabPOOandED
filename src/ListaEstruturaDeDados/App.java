package ListaEstruturaDeDados;

public class App {
    public static void main(String[] args) throws Exception {
        ListaSimplesmenteEncaadeada lista = new ListaSimplesmenteEncaadeada();
        ListaDuplamenteEncadeada lista2 = new ListaDuplamenteEncadeada();

        lista2.addBloco(2);
        lista2.addBloco(3);
        lista2.addBloco(4);
        lista2.addBloco(2);
        lista2.addBloco(2);
        lista2.addBloco(5);

        ListaDuplamenteEncadeada l = lista2.localizarValor(2);

        l.mostrarLista();

        System.out.println("\n");

        lista2.removerBloco(6);

        lista2.mostrarLista();

    }
}

