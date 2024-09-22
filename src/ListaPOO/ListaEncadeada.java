package ListaPOO;

import ListaPOO.Lista;

public class ListaEncadeada extends Lista {

    @Override
    public Bloco addBloco(int valor, int posicao) {
        Bloco blocoAlvo = localizarBloco(posicao);
        Bloco blocoAnterior = localizarBloco(posicao - 1);
        Bloco blocoNovo = null;
        if(blocoAlvo != null){
            blocoNovo.valor = valor;
            blocoNovo.prox = blocoAlvo;
            if(blocoAlvo == this.cabecalho.inicio){
                this.cabecalho.inicio = blocoNovo;
            }else{
                blocoAnterior.prox = blocoNovo;
            }
        }
        return blocoNovo;
    }

    @Override
    public Bloco removeBloco(int posicao) {
        if(this.cabecalho.inicio == null){
            return null;
        }
        if(posicao < 0){
            return null;
        }
        Bloco blocoAlvo = localizarBloco(posicao);
        if(blocoAlvo == this.cabecalho.inicio){
            this.cabecalho.inicio = this.cabecalho.inicio.prox;
        }else{
            Bloco blocoAnterior = localizarBloco(posicao - 1);
            blocoAnterior.prox = blocoAlvo.prox;
        }
        return blocoAlvo;
    }

    @Override
    public Bloco localizarBloco(int posicao) {
        return localizarBloco(posicao, 0, cabecalho.inicio);
    }

    private Bloco localizarBloco(int posicao, int posicaoAtual, Bloco blocoAux){
        if(blocoAux != null){
            if(posicao == posicaoAtual){
                return blocoAux;
            }else{
                return localizarBloco(posicao, posicaoAtual + 1, blocoAux.prox);
            }
        }
        return blocoAux;
    }
}
