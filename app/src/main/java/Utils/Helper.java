package Utils;

import Arvore.No;

public abstract class Helper {

    public static boolean TELA_INICIAL = true;
    private static final String TEXTO_FINAL = "FINAL";

    public static No criarNoRaiz(String nodeId, String textoPrincipal, String textoAjuda, String filhoEsquerda, String filhoDireita) {
        No novoNo = new No(nodeId, textoPrincipal, textoAjuda);
        criaFilhos(novoNo, filhoEsquerda, filhoDireita);
        return novoNo;
    }

    public static void criaFilhos(No no, final String filhoEsquerda, final String filhoDireita) {
        criarFilhoEsquerda(no, filhoEsquerda);
        criaFilhoDireita(no, filhoDireita);
    }

    public static void criarFilhoEsquerda(No no, final String filhoEsquerda) {
        if (!TEXTO_FINAL.equalsIgnoreCase(filhoEsquerda.trim())) {
            no.seteNoFinal(false);
            No filho = new No(filhoEsquerda);
            no.setEsquerda(filho);
        }
    }

    public static void criaFilhoDireita(No no, final String filhoDireita) {
        if (!TEXTO_FINAL.equalsIgnoreCase(filhoDireita.trim())) {
            no.seteNoFinal(false);
            No filho = new No(filhoDireita);
            no.setDireita(filho);
        }
    }

    public static void criarFilhoEsquerda(No no, No filhoEsquerda) {
        if (!TEXTO_FINAL.equalsIgnoreCase(filhoEsquerda.getNodeId().trim())) {
            no.seteNoFinal(false);
            no.setEsquerda(filhoEsquerda);
        }
    }

    public static void criaFilhoDireita(No no, No filhoDireita) {
        if (!TEXTO_FINAL.equalsIgnoreCase(filhoDireita.getNodeId().trim())) {
            no.seteNoFinal(false);
            no.setDireita(filhoDireita);
        }
    }

}