import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.highgui.HighGui;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;

public class LianXi8 {
    public static void main(String[] args) {
        //转换二值图
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
        Mat src = Imgcodecs.imread("lena.jpg");
        HighGui.imshow("lena",src);
        HighGui.waitKey(0);
        Mat dst = new Mat();

        /*变换颜色函数*/
        Imgproc.cvtColor(src,dst,Imgproc.COLOR_RGB2GRAY);//将src1赋值给dst再转变成二值图

        Mat mat = new Mat();
        //115为阈值，255为最大值（115以上的转变数），低于115则为0（黑色）
        Imgproc.threshold(dst,mat,115,255,Imgproc.THRESH_BINARY/*可换为0*/);
        HighGui.imshow("lena2",mat);
        HighGui.waitKey(0);

    }
}
