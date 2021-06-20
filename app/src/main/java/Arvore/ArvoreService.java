package Arvore;

import java.util.Stack;

public class ArvoreService {

    private final Arvore arvore;
    private No noAtual;
    private No noAnterior;
    private Stack<No> nosVisitados;

    public ArvoreService(final Arvore arvore) {
        this.arvore = arvore;
        this.noAtual = arvore.getRaiz();
        this.noAnterior = null;
        this.nosVisitados = new Stack<>();
    }

    public void esquerda() {
        this.nosVisitados.push(this.noAtual);
        this.noAnterior = this.noAtual;
        this.noAtual = this.noAtual.getEsquerda();
    }

    public void direita() {
        this.nosVisitados.push(this.noAtual);
        this.noAnterior = this.noAtual;
        this.noAtual = this.noAtual.getDireita();
    }

    public void voltar(){
        this.noAtual = this.noAnterior;
        this.noAnterior = !this.nosVisitados.empty() ? this.nosVisitados.pop() : null;
    }

    public No getNoAtual() {
        return this.noAtual;
    }

}