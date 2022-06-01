package Main;
import Car.Car;
import Others.Keyboard;
import Car.Gasolina;
import Car.VidroEletrico;
import Others.Information;
import Others.TelaInicial;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Objects;

public class Game extends JPanel implements Runnable {
    Keyboard keyboard = new Keyboard();
    Thread gameThread;
    BufferedImage background;
    VidroEletrico vidroEletrico = new VidroEletrico();
    Gasolina gasolina = new Gasolina();
    Car carro = new Car(keyboard, vidroEletrico, gasolina);
    Information information = new Information(gasolina,vidroEletrico);
    TelaInicial telaInicial = new TelaInicial();
    final double FPS = 60;

    public Game() {
        this.addKeyListener(keyboard);
        this.setBackground(Color.BLACK);
        this.setDoubleBuffered(true);
        this.setPreferredSize(new Dimension(800,600));
        this.setFocusable(true);
        try {
            background = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Sprites/background.png")));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void startGameThread() {
        gameThread = new Thread(this);
        gameThread.start();

    }

    public void paintComponent(Graphics graph) {
        super.paintComponent(graph);
        Graphics2D graphics2D = (Graphics2D) graph;
        graphics2D.drawImage(background,carro.getPosicaoCar()-500,0,1600,600,null);
        carro.draw(graphics2D);
        information.draw(graphics2D);
        if(telaInicial.isAlive()){
            telaInicial.draw(graphics2D);
        }
        graphics2D.dispose();
    }

    public void update() {
        carro.update();
        information.update();
        telaInicial.update(keyboard);

    }

    @Override
    public void run() {
        double drawInterval = 1000000000 / FPS;
        double delta = 0;
        long lastTime = System.nanoTime();
        long currentTime;
        while (gameThread != null) {
            currentTime = System.nanoTime();
            delta += (currentTime - lastTime) / drawInterval;
            lastTime = currentTime;
            if (delta >= 1) {
                update();
                repaint();
                delta--;
            }
        }
    }
}
