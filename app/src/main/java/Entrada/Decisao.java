package Entrada;

public class Decisao {
    private String nodeId;
    private String direcaoSim;
    private String direcaoNao;
    private String textoPrincipal;
    private String textoAjuda;

    public Decisao() {

    }

    public String getTextoAjuda() {
        return textoAjuda;
    }

    public void setTextoAjuda(String textoAjuda) {
        this.textoAjuda = textoAjuda;
    }

    public String getNodeId() {
        return nodeId;
    }

    public void setNodeId(String nodeId) {
        this.nodeId = nodeId;
    }

    public String getDirecaoSim() {
        return direcaoSim;
    }

    public void setDirecaoSim(String direcaoSim) {
        this.direcaoSim = direcaoSim;
    }

    public String getDirecaoNao() {
        return direcaoNao;
    }

    public void setDirecaoNao(String direcaoNao) {
        this.direcaoNao = direcaoNao;
    }

    public String getTextoPrincipal() {
        return textoPrincipal;
    }

    public void setTextoPrincipal(String textoPrincipal) {
        this.textoPrincipal = textoPrincipal;
    }
};