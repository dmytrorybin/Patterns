package ua.epam;

/**
 * Created by Дмитрий on 25.09.2016.
 */
public class Adapter {
    public static void main(String[] args) {
        VectorGraphicsInterface a = new VectorAdapterFromRaster();
        a.drawLine();
        a.drawSquare();
    }
}

    interface VectorGraphicsInterface {
        void drawLine();
        void drawSquare();
    }

     class RasterGraphics {
        void drawRasterLine() {
            System.out.println("raster line");
        }
        void drawRasterSquare() {
            System.out.println("raster square");
        }
    }

     class VectorAdapterFromRaster extends RasterGraphics implements VectorGraphicsInterface {
        public void drawLine() {
            drawRasterLine();
        }
        public void drawSquare() {
            drawRasterSquare();
        }
    }

