import org.opencv.core.Core;
import org.opencv.core.CvType;
import org.opencv.core.Mat;
import org.opencv.highgui.HighGui;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;

public class LianXi11 {
    //图像金字塔

    public static void main(String[] args) {
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
        Mat src = Imgcodecs.imread("Di.jpg");
        HighGui.imshow("src",src);
        HighGui.waitKey(0);

        Mat dst = new Mat();
        Imgproc.pyrDown(src,dst);//向下采样
        HighGui.imshow("Down",dst);
        HighGui.waitKey(0);

        Imgproc.pyrUp(dst,dst);//向上采样
        HighGui.imshow("Up",dst);
        HighGui.waitKey(0);

        Mat mat = new Mat(src.size(), CvType.CV_64F);
        Core.subtract(dst,src,mat);
        HighGui.imshow("Lap",mat);
        HighGui.waitKey(0);



    }
}
