import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.Size;
import org.opencv.highgui.HighGui;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;

public class LianXi9 {
    //图像平滑，三种滤波
    public static void main(String[] args) {
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
        Mat src = Imgcodecs.imread("lena.jpg");
        HighGui.imshow("lena",src);
        HighGui.waitKey(0);

        //均值滤波
//        Mat dst = new Mat();
//        Imgproc.blur(src,dst,new Size(3,3));//Size(卷积核）数值越大越模糊
//        HighGui.imshow("lena",dst);
//        HighGui.waitKey(0);

        //高斯滤波
//        Mat dst = new Mat();
//        Imgproc.GaussianBlur(src,dst,new Size(13,13),10,10);//Size(卷积核）数值越大越模糊
//        HighGui.imshow("lena",dst);
//        HighGui.waitKey(0);

        Mat mat = Imgcodecs.imread("lena.jpg");
        HighGui.imshow("lena",mat);
        HighGui.waitKey(0);
        Mat dst = new Mat();
        Imgproc.medianBlur(mat,dst,5);
        HighGui.imshow("lena",dst);
        HighGui.waitKey(0);

    }
}

