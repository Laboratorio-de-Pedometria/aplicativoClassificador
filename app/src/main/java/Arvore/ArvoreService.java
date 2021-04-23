package Arvore;

public class ArvoreService {

    private final Arvore arvore;
    private No noAtual;

    public ArvoreService(final Arvore arvore) {
        this.arvore = arvore;
        this.noAtual = arvore.getRaiz();
    }

    public void esquerda() {
        this.noAtual = this.noAtual.getEsquerda();
    }

    public void direita() {
        this.noAtual = this.noAtual.getDireita();
    }

    public No getNoAtual() {
        return this.noAtual;
    }

}