package Arvore;

import android.os.Build;

import androidx.annotation.RequiresApi;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class No {

    private String nodeId;
    private String textoPrincipal;
    private String textoAjuda;
    private boolean eNoFinal;
    private No esquerda;
    private No direita;

    public No(String nodeId) {
        this.nodeId = nodeId;
        this.textoPrincipal = null;
        this.textoAjuda = null;
        this.eNoFinal = true;
        this.esquerda = null;
        this.direita = null;
    }

    public No(String nodeId, String textoPrincipal, String textoAjuda) {
        this.nodeId = nodeId;
        this.textoPrincipal = textoPrincipal;
        this.textoAjuda = textoAjuda;
        this.eNoFinal = true;
        this.esquerda = null;
        this.direita = null;
    }

    public No(String nodeId, String textoPrincipal, String textoAjuda, boolean eNoFinal, No esquerda, No direita) {
        this.nodeId = nodeId;
        this.textoPrincipal = textoPrincipal;
        this.textoAjuda = textoAjuda;
        this.eNoFinal = eNoFinal;
        this.esquerda = esquerda;
        this.direita = direita;
    }

    public String getNodeId() {
        return nodeId;
    }

    public void setNodeId(String nodeId) {
        this.nodeId = nodeId;
    }

    public String getTextoPrincipal() {
        return textoPrincipal;
    }

    public void setTextoPrincipal(String textoPrincipal) {
        this.textoPrincipal = textoPrincipal;
    }

    public String getTextoAjuda() {
        return textoAjuda;
    }

    public void setTextoAjuda(String textoAjuda) {
        this.textoAjuda = textoAjuda;
    }

    public boolean iseNoFinal() {
        return eNoFinal;
    }

    public void seteNoFinal(boolean eNoFinal) {
        this.eNoFinal = eNoFinal;
    }

    public No getEsquerda() {
        return esquerda;
    }

    public void setEsquerda(No esquerda) {
        this.esquerda = esquerda;
    }

    public No getDireita() {
        return direita;
    }

    public void setDireita(No direita) {
        this.direita = direita;
    }

    public boolean equals(String nodeId) {
        return this.nodeId.equalsIgnoreCase(nodeId);
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public List<No> getNosAdjacentes() {
        List<No> nosAdjacentes = new ArrayList<>();
        if (!java.util.Objects.isNull(this.esquerda)) {
            nosAdjacentes.add(this.esquerda);
        }
        if (!Objects.isNull(this.direita)) {
            nosAdjacentes.add(this.direita);
        }
        return nosAdjacentes;
    }


}