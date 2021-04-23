
package Arvore;

import android.os.Build;

import androidx.annotation.RequiresApi;

import java.util.*;

import Entrada.Decisao;
import Utils.Helper;

public class Arvore {


    //teste
    private No raiz;
    private Map<String, No> mapNos;

    public Arvore(No raiz) {
        this.raiz = raiz;
        mapNos = new HashMap() {{
            put(raiz.getNodeId(), raiz);
        }};
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public No depthFirstSerach(String nodeId) throws Exception {
        Set<No> nosVisitados = new LinkedHashSet<>();
        Stack<No> stack = new Stack<>();
        stack.push(this.raiz);
        No auxNo;
        while (!stack.isEmpty()) {
            auxNo = stack.pop();
            if (auxNo.equals(nodeId)) return auxNo;
            if (!nosVisitados.contains(auxNo)) {
                nosVisitados.add(auxNo);
                for (No no : auxNo.getNosAdjacentes()) {
                    stack.push(no);
                }
            }
        }
        throw new Exception("Estrutura informada inadequada");
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public void preencherNoPelaDecisao(@org.jetbrains.annotations.NotNull No no, Decisao decisao) {
        no.setTextoPrincipal(decisao.getTextoPrincipal());
        no.setTextoAjuda(decisao.getTextoAjuda());
        criarFilhoEsquerdaPeloId(no, decisao.getDirecaoNao());
        criarFilhoDireitaPeloId(no, decisao.getDirecaoSim());
        mapNos.put(decisao.getNodeId(), no);
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    private void criarFilhoEsquerdaPeloId(No principal, String filhoEsquerda) {
        Helper.criarFilhoEsquerda(principal, mapNos.getOrDefault(filhoEsquerda, new No(filhoEsquerda)));
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    private void criarFilhoDireitaPeloId(No principal, String filhoDireita) {
        Helper.criaFilhoDireita(principal, mapNos.getOrDefault(filhoDireita, new No(filhoDireita)));
    }

    public No getRaiz(){
        return this.raiz;
    }

}