
package Arvore;

import android.os.Build;

import androidx.annotation.RequiresApi;

import java.util.*;

import Entrada.Decisao;
import Utils.Helper;

public class Arvore {

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
        No esquerda = buscarNoMapeado(filhoEsquerda);
        mapNos.putIfAbsent(esquerda.getNodeId(), esquerda);
        Helper.criarFilhoEsquerda(principal, esquerda);
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    private void criarFilhoDireitaPeloId(No principal, String filhoDireita) {
        No direita = buscarNoMapeado(filhoDireita);
        mapNos.putIfAbsent(direita.getNodeId(), direita);
        Helper.criaFilhoDireita(principal, direita);
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    private No buscarNoMapeado(String filho){
        return Objects.isNull(mapNos.get(filho)) ? new No(filho) : mapNos.get(filho);
    }

    public No getRaiz(){
        return this.raiz;
    }

}