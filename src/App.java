public class App {
    public static void main(String[] args) throws Exception {
        Lista lista = new Lista();
        for(int i = 0; i <= 20; i++){
            lista.adicionarBloco(i);
        }


        lista.adicionarBloco(100, 2);

        lista.removerBloco(2);

        lista.localizarBloco(2);

    }
}

