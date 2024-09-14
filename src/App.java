public class App {
    public static void main(String[] args) throws Exception {
        Lista lista = new Lista();

        for(int i = 0; i <= 10; i++){
            lista.adicionarBlocoInicio(i);
        }

        lista.mostrarLista();

        System.out.println("\n");

        System.out.println("Simulação de FILA:");
        lista.removerBlocoInicio();
        lista.mostrarLista();

        System.out.println("\n");

        System.out.println("Simulação de PILHA:");
        lista.removerBlocoFim();
        lista.mostrarLista();
    }
}

