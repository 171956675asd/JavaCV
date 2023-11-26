
import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.highgui.HighGui;
import org.opencv.imgcodecs.Imgcodecs;

public class Main {

    private boolean flag = true;

    static {
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
        System.out.println("opencv\t" + Core.VERSION);
    }

    public static void main(String[] args) {
        new Main().test();
    }

    public static void test() {
        Mat src = Imgcodecs.imread("preview.jpg");
        HighGui gui = new HighGui();
        gui.imshow("哈妮", src);
        gui.waitKey(1000);
    }


}