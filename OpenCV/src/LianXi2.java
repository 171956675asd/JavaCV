import org.opencv.core.Core;
import org.opencv.core.*;
import org.opencv.highgui.HighGui;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;
public class LianXi2 {
    //图像阅读以及变换二值图
    public static void main(String[] args) {
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);

        Mat mat = Imgcodecs.imread("preview.jpg", Imgcodecs.CV_LOAD_IMAGE_GRAYSCALE);
        Imgcodecs.imwrite("preview.jpg", mat);
        Mat src = Imgcodecs.imread("lena.jpg",Imgcodecs.CV_LOAD_IMAGE_GRAYSCALE);
        HighGui.imshow("lena",src);
        HighGui.waitKey(0);
    }
}