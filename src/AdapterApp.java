public class AdapterApp {
    public static void main(String[] args){
        VectorGraphics g1 = new VectorAdapterFromRaster();
        g1.drawLine();
        g1.drawSquare();

        VectorGraphics g2 = new VectorAdapterFromRasterComposition(new RasterGraphics());
        g2.drawLine();
        g2.drawSquare();
    }
}

interface VectorGraphics{
    void drawLine();
    void drawSquare();
}

class RasterGraphics{
    void drawRasterLine(){
        System.out.println("Рисуем линию");
    }
    void drawRasterSquare(){
        System.out.println("Рисуем квадрат");
    }
}

class VectorAdapterFromRaster extends RasterGraphics implements VectorGraphics{

    @Override
    public void drawLine() {
        drawRasterLine();
    }

    @Override
    public void drawSquare() {
        drawRasterSquare();
    }
}

class VectorAdapterFromRasterComposition implements VectorGraphics{
    RasterGraphics raster;

    VectorAdapterFromRasterComposition(RasterGraphics raster){
        this.raster = raster;
    }
    @Override
    public void drawLine() {
        raster.drawRasterLine();
    }

    @Override
    public void drawSquare() {
        raster.drawRasterSquare();
    }
}
