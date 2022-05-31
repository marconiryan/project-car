package Car;

public class VidroEletrico {
    private int posicao;
    private boolean aberto;
    public VidroEletrico(){
        this.posicao = 10;
        this.aberto = false;
    }
    public void setPosicao(int posicao) {
        if(this.posicao + posicao >= 0 && this.posicao + posicao <= 10){
            this.posicao += posicao;
        }
        this.aberto = this.posicao < 10;
    }
    public int getPosicao(){
        return this.posicao;
    }
    public boolean getAberto(){
        return this.aberto;
    }
}
