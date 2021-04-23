package Utils;

import Arvore.No;

public abstract class Helper {

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
            no.setEsquerda(new No(filhoEsquerda));
        }
    }

    public static void criaFilhoDireita(No no, final String filhoDireita) {
        if (!TEXTO_FINAL.equalsIgnoreCase(filhoDireita.trim())) {
            no.seteNoFinal(false);
            no.setDireita(new No(filhoDireita));
        }
    }

    public static void criarFilhoEsquerda(No no, final No filhoEsquerda) {
        if (!TEXTO_FINAL.equalsIgnoreCase(filhoEsquerda.getNodeId().trim())) {
            no.seteNoFinal(false);
            no.setEsquerda(filhoEsquerda);
        }
    }

    public static void criaFilhoDireita(No no, final No filhoDireita) {
        if (!TEXTO_FINAL.equalsIgnoreCase(filhoDireita.getNodeId().trim())) {
            no.seteNoFinal(false);
            no.setDireita(filhoDireita);
        }
    }

}