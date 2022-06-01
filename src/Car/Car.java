package Car;

import Others.Keyboard;

import javax.imageio.ImageIO;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Objects;

public class Car {
    private final int posCarDefault = 300;
    private int posicaoCar;
    VidroEletrico Vidro;
    Gasolina gasolina;
    BufferedImage ImageCar;
    String ImageNameCar;
    Keyboard keyboard;

    public Car(Keyboard keyboard, VidroEletrico vidro, Gasolina gasolina) {
        this.Vidro = vidro;
        this.gasolina = gasolina;
        this.keyboard = keyboard;
        this.ImageNameCar = "/Sprites/car_vidro_10.png";
        this.posicaoCar = this.posCarDefault;

    }
    public void setPosicaoCar(int posicaoCar){
        this.posicaoCar += posicaoCar;
    }
    public void draw(Graphics2D graphics2D) {
        try {
            this.ImageCar = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream(this.ImageNameCar)));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        graphics2D.drawImage(this.ImageCar, posicaoCar, 410, 250, 150, null);
    }
    public int getPosicaoCar(){
        return posCarDefault - posicaoCar;
    }
    public void update() {
        switch (Vidro.getPosicao()) {
            case 0 -> this.ImageNameCar = "/Sprites/car_vidro_0.png";
            case 1 -> this.ImageNameCar = "/Sprites/car_vidro_1.png";
            case 2 -> this.ImageNameCar = "/Sprites/car_vidro_2.png";
            case 3 -> this.ImageNameCar = "/Sprites/car_vidro_3.png";
            case 4 -> this.ImageNameCar = "/Sprites/car_vidro_4.png";
            case 5 -> this.ImageNameCar = "/Sprites/car_vidro_5.png";
            case 6 -> this.ImageNameCar = "/Sprites/car_vidro_6.png";
            case 7 -> this.ImageNameCar = "/Sprites/car_vidro_7.png";
            case 8 -> this.ImageNameCar = "/Sprites/car_vidro_8.png";
            case 9 -> this.ImageNameCar = "/Sprites/car_vidro_9.png";
            default -> this.ImageNameCar = "/Sprites/car_vidro_10.png";
        }
        if(this.keyboard.Key_Right && gasolina.isNotVazio()){
            setPosicaoCar(1);
            this.gasolina.setGasolina(-0.5);
        }if(this.keyboard.Key_Left && gasolina.isNotVazio()){
            setPosicaoCar(-1);
            this.gasolina.setGasolina(-0.5);
        }
        if(this.keyboard.Key_UP){
            this.Vidro.setPosicao(1);
        }
        if(this.keyboard.Key_Down){
            this.Vidro.setPosicao(-1);
        }
        if(this.keyboard.Key_Space){
            this.gasolina.setGasolina(0.5);
        }
        

    }
}
