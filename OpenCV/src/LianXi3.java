import org.opencv.core.Core;
import org.opencv.core.*;
import org.opencv.highgui.HighGui;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;
public class LianXi3 {
    //打印矩阵
    public static void main(String[] args) {
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);

        Mat mat = Mat.eye(3,3, CvType.CV_8UC1);//生成3*3矩阵，通道1（灰度图）
//        Mat mat = Mat.ones(3,3, CvType.CV_8UC1);//生成3*3矩阵，通道1（灰度图）
//        Mat mat = Mat.eye(3,3, CvType.CV_8UC3);//生成3*3矩阵，通道3（彩图）
        System.out.println(mat.dump());
    }
}