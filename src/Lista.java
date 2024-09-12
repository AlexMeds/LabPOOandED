public class Lista {
    
    Bloco inicio;

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

    public Bloco addBlocoInexistente (int valor, int posicao){ // Bloco em uma posicao que nao existe
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

    public void mostrarLista(){
        Bloco blocoAux = inicio;
        while(blocoAux != null){
            System.out.println(blocoAux.valor);
            blocoAux = blocoAux.prox;
        }
    }

    public void mostrarBloco (int posicao){
        Bloco blocoAux = inicio;
        int contador = 0;
        while(blocoAux != null && contador < posicao){
            blocoAux = blocoAux.prox;
            contador++;
        }
        System.out.println(blocoAux.valor);
    }

    public void contarBloco(){
        if(inicio == null){
            System.out.println("Lista vazia");
        }else{
            Bloco blocoAux = inicio;
            int contador = 0;
            while(blocoAux != null){
                blocoAux = blocoAux.prox;
                contador ++;
            }
            System.out.format("A lista possui %d blocos\n", contador);
        }
    }
}