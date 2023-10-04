
import javafx.application.Platform;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.scene.image.Image;
import javafx.scene.image.PixelReader;
import javafx.scene.image.PixelWriter;
import javafx.scene.image.WritableImage;
import javafx.scene.paint.Color;

public class ImageDiscoverer implements Runnable{
    private WritableImage destImage;
    private Image srcImage;
    private DoubleProperty progress = new SimpleDoubleProperty();

    private int width;
    private int height;
    private PixelWriter pixelWriter;

    public DoubleProperty progressProperty() {
        return progress;
    }

    private PixelReader pixelReader;

    public ImageDiscoverer(Image srcImage) {
        this.srcImage = srcImage;
        this.width = (int) srcImage.getWidth();
        this.height = (int) srcImage.getHeight();
        this.destImage = new WritableImage(width, height);
        this.pixelWriter = destImage.getPixelWriter();
        this.pixelReader = destImage.getPixelReader();
    }

    public Image getDestImage() {
        initializeDestImage();
        return this.destImage;
    }

    public void initializeDestImage()  {
        for (int y = 0; y < destImage.getHeight(); y++) {
            for (int x = 0; x < destImage.getWidth(); x++) {
                int red = (int) (Math.random() * 255);
                int green = (int) (Math.random() * 255);
                int blue = (int) (Math.random() * 255);
                pixelWriter.setColor(x, y, Color.rgb(red, green, blue));
            }
        }
    }
    public void reveal() {
        for (int y = 0; y < destImage.getHeight(); y++) {
            final int row = y;
            Platform.runLater(()->{
            for (int x = 0; x < destImage.getWidth(); x++) {
                Color pixel = pixelReader.getColor(x,row);
                pixelWriter.setColor(x,row,pixel);
            }
            });
           for (int x = 0; x < destImage.getWidth(); x++) {
               Color pixel = pixelReader.getColor(x,y);
               pixelWriter.setColor(x,y,pixel);
           }
            // end critical section
            try {
                Thread.sleep(20);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void reveal2(){
        boolean[][] revealedPixels = new boolean[width][height];
        for (int y = 0; y < destImage.getHeight(); y++) {
            progress.setValue(y/destImage.getHeight());
            Platform.runLater(()->{
                for (int x = 0; x < destImage.getWidth(); x++) {
                    for (int i = 0; i < 100; i++) {
                        int randomX = (int) (Math.random() * width);
                        int randomY = (int) (Math.random() * height);
                        if(revealedPixels[randomX][randomY]) {
                            i--;
                            continue;
                        }
                        Color pixel = pixelReader.getColor(randomX, randomY);
                        pixelWriter.setColor(randomX, randomY, pixel);

                        revealedPixels[randomX][randomY] = true;
                    }
                }
            });
            try {
                Thread.sleep(20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            // todo: setProgressWithConsumer(setProgress, y);
        }
    }

    public void reveal3(){

    }


    @Override
    public void run() {
        reveal();
    }
}