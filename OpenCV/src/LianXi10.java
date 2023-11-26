import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.Point;
import org.opencv.highgui.HighGui;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;

public class LianXi10 {
    //腐蚀膨胀算法
    public static void main(String[] args) {
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
        Mat src = Imgcodecs.imread("letter.jpg");
        HighGui.imshow("lena", src);
        HighGui.waitKey(0);
        Mat dst = new Mat();

        //腐蚀图像
//        Imgproc.erode(src, dst, new Mat());
//        HighGui.imshow("dilats", dst);
//        HighGui.waitKey(0);
//
//        //膨胀图像
//        Imgproc.dilate(src, dst, new Mat());
//        HighGui.imshow("dilate", dst);
//        HighGui.waitKey(0);

        //open——开运算，先腐蚀后膨胀，-1，-1为锚点，默认为0，0。迭代次数3次
//        Imgproc.morphologyEx(src, dst, Imgproc.MORPH_OPEN, new Mat(),
//                new Point(-1, -1), 6);

        //形态学梯度，膨胀与腐蚀的差，可用于获取图像轮廓
        Imgproc.morphologyEx(src, dst, Imgproc.MORPH_GRADIENT, new Mat());

        HighGui.imshow("dilate2", dst);
        HighGui.waitKey(0);

    }
}
