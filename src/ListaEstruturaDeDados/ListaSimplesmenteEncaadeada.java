package ListaEstruturaDeDados;

public class ListaSimplesmenteEncaadeada {

    Header cabecalho = new Header();
    Bloco inicio = cabecalho.inicio;

    public Bloco adicionarInicio (int valor){
        Bloco novo = new Bloco();
        novo.valor = valor;
        this.cabecalho.tamanho++;
        if(this.inicio== null){
            this.inicio = novo;
            this.cabecalho.fim = novo;
        }else{
            novo.prox = this.inicio;
            this.inicio = novo;
        }
        return novo;
    }

    public Bloco adicionarFim (int valor){
        Bloco novo = new Bloco();
        novo.valor = valor;
        this.cabecalho.tamanho ++;
        if(this.inicio == null){
            this.inicio = novo;
            this.cabecalho.fim = novo;
        }else{
            this.cabecalho.fim.prox = novo;
            this.cabecalho.fim = novo;
        }
        return novo;
    }

    public Bloco adicionarBlocoInicio (int valor){
        Bloco novo = new Bloco();
        novo.valor = valor;
        novo.prox = inicio;
        inicio = novo;
        return novo;
    }

    public Bloco adicionarBlocoFinal (int valor){
        Bloco novo = new Bloco();
        novo.valor = valor;
        if(inicio == null){
            inicio = novo;
        }else{
            Bloco blocoAux = inicio;
            while(blocoAux.prox != null){
                blocoAux = blocoAux.prox;
            }
            blocoAux.prox = novo;
        }
        return novo;
    }

    public Bloco addBlocoInexistente (int valor, int posicao){ // ListaEstruturaDeDados.Bloco em uma posicao que nao existe
        Bloco blocoNovo = localizarBloco(posicao);
        if(blocoNovo == null){
            adicionarBlocoFinal(1);
            addBlocoInexistente(valor, posicao);
        }else{
            blocoNovo.valor = valor;
        }
        return blocoNovo;
    }

    public Bloco adicionarBloco (int valor, int posicao){
        Bloco blocoAlvo = localizarBloco(posicao);
        Bloco blocoAnterior = localizarBloco(posicao - 1);
        Bloco novo = null;
        if(blocoAlvo != null){
            novo = new Bloco();
            novo.valor = valor;
            novo.prox = blocoAlvo;

            if(blocoAlvo == inicio){
                inicio = novo;
            }else{
                blocoAnterior.prox = novo;
            }
        }
        return novo;
    }

    public Bloco localizarBloco (int posicao){
        Bloco blocoAux = inicio;
        int contador = 0;
        while (blocoAux != null && contador < posicao - 1) {
            blocoAux = blocoAux.prox;
            contador++;
        }
        return blocoAux;
    }

    public Bloco localizarBlocoRecursivo(int posicao){
        return localizarBlocoRecursivo(posicao, 0, inicio);
    }

    private Bloco localizarBlocoRecursivo (int posicao, int posicaoAtual, Bloco blocoAux){
        if(blocoAux != null){
            if(posicao == posicaoAtual){
                return blocoAux;
            }else{
                return localizarBlocoRecursivo(posicao, posicaoAtual + 1, blocoAux.prox);
            }
        }
        return blocoAux;
    }

    public Bloco removerBloco (int posicao){
        if(inicio == null || posicao < 0){
            return null;
        }

        Bloco blocoAlvo = localizarBloco(posicao);
        if(blocoAlvo == inicio){
            inicio = inicio.prox;
        }else{
            Bloco blocoAnterior = localizarBloco(posicao - 1);
            blocoAnterior.prox = blocoAlvo.prox;
        }
        blocoAlvo.prox = null;
        return blocoAlvo;
    }

    public Bloco removerBlocoInicio(){
        if(inicio == null){
            return null;
        }else{
            Bloco blocoRemovido = inicio;
            inicio = inicio.prox;
            return blocoRemovido;
        }
    }

    public Bloco removerBlocoFim(){
        int tamanho = contarBloco();
        Bloco blocoRemovido = null;
        if(tamanho == 0){
            return blocoRemovido;
        }else if(tamanho == 1){
            blocoRemovido = inicio;
            inicio = null;
            return blocoRemovido;
        }else{
            Bloco blocoAnterior = localizarBloco(contarBloco() - 1);
            blocoRemovido = blocoAnterior.prox;
            blocoAnterior.prox = null;
            return blocoRemovido;
        }
    }

    public void mostrarLista() {
        Bloco blocoAux = inicio;
        while (blocoAux != null) {
            System.out.println(blocoAux.valor);
            blocoAux = blocoAux.prox;
        }
        int tamanho = contarBloco();
        if (tamanho == 0) {
            System.out.format("Lista vazia!\n");
        } else {
            System.out.format("A lista possui %d Blocos\n", tamanho);
        }
    }

    public void mostrarBloco (int posicao){
        Bloco blocoAux = inicio;
        int contador = 0;
        while(blocoAux != null && contador < posicao - 1){
            blocoAux = blocoAux.prox;
            contador++;
        }
        System.out.println(blocoAux.valor);
    }

    public int contarBloco(){
        int contador = 0;
        if(inicio == null){
            return 0;
        }else{
            Bloco blocoAux = inicio;
            while(blocoAux != null) {
                blocoAux = blocoAux.prox;
                contador++;
            }
        }
        return contador;
    }
}