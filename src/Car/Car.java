package Car;

import javax.imageio.ImageIO;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Objects;

public class Car {
    private int posicao;
    VidroEletrico Vidro;
    Gasolina gasolina;
    BufferedImage ImageCar;
    String ImageName;
    Keyboard keyboard;

    public Car(Keyboard keyboard) {
        this.Vidro = new VidroEletrico();
        this.gasolina = new Gasolina();
        this.keyboard = keyboard;
        this.ImageName = "/Sprites/car_vidro_10.jpeg";
        this.posicao = 300;

    }
    public void setPosicao(int posicao){
        this.posicao += posicao;
    }
    public void draw(Graphics2D graphics2D) {
        try {
            this.ImageCar = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream(this.ImageName)));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        graphics2D.drawImage(this.ImageCar, posicao, 410, 150, 150, null);
    }

    public void update() {
        switch (Vidro.getPosicao()) {
            case 1 -> this.ImageName = "";
            case 2 -> this.ImageName = "";
            case 3 -> this.ImageName = "";
            case 4 -> this.ImageName = "";
            case 5 -> this.ImageName = "";
            case 6 -> this.ImageName = "";
            case 7 -> this.ImageName = "";
            case 8 -> this.ImageName = "";
            case 9 -> this.ImageName = "";
            default -> this.ImageName = "/Sprites/car_vidro_10.jpeg";
        }
        if(this.keyboard.Key_Right && gasolina.isNotVazio()){
            setPosicao(1);
            this.gasolina.setGasolina(-0.5);
        }if(this.keyboard.Key_Left && gasolina.isNotVazio()){
            setPosicao(-1);
            this.gasolina.setGasolina(-0.5);
        }
        if(this.keyboard.Key_UP){
            this.Vidro.setPosicao(1);
        }
        if(this.keyboard.Key_Down){
            this.Vidro.setPosicao(-1);
        }
        if(this.keyboard.Key_Space){
            this.gasolina.setGasolina(10);
        }
        

    }
}
