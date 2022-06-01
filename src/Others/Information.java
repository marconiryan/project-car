package Others;

import Car.Gasolina;
import Car.VidroEletrico;

import java.awt.*;

public class Information {
    Gasolina gasolina;
    VidroEletrico vidro;
    private String vidroAberto;

    public Information(Gasolina gasolina, VidroEletrico vidro){
        this.gasolina = gasolina;
        this.vidro = vidro;
    }

    private void showVidroAberto(){
        if(vidro.getAberto()){
            this.vidroAberto = "Aberto";
        }
        else{
            this.vidroAberto = "Fechado";
        }
    }
    public void draw(Graphics2D graphics2D){
        int barra = (int) gasolina.getGasolina() ;
        graphics2D.setColor(Color.ORANGE);
        graphics2D.fillRect(30,30,barra,50);
        graphics2D.setColor(Color.black);
        graphics2D.drawRect(30,30,100,50);
        graphics2D.drawString("Vidro:"+this.vidroAberto,700,50);
    }
    public void update(){
        showVidroAberto();
    }
}
