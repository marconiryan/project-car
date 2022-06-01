package Others;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Objects;

public class TelaInicial {
    public boolean telaInicial;
    BufferedImage Img;
    public TelaInicial(){
        this.telaInicial = true;
    }
    public boolean isAlive(){
        return this.telaInicial;
    }
    public void draw(Graphics2D graphics2D){
            try {
                Img = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Sprites/tela_inicial.png")));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        graphics2D.drawImage(Img,0,0,800,600,null);
    }
    public void update(Keyboard keyboard){
        if(this.telaInicial && keyboard.Key_Enter){
            this.telaInicial = false;
        }
    }
}
