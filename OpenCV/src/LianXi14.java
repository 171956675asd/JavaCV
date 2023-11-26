import org.opencv.core.*;
import org.opencv.highgui.HighGui;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;

import java.util.ArrayList;
import java.util.List;

public class LianXi14 {
    public static void main(String[] args) {
        //轮廓提取

        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
        Mat src = Imgcodecs.imread("Di.jpg", Imgcodecs.CV_LOAD_IMAGE_GRAYSCALE);
        Mat gray = new Mat();
        //将结果保存到一个新的Mat对象。Canny()方法是使用了Canny边缘检测算法，60和200是两个阈值参数。
        Imgproc.Canny(src, gray, 60, 200);

        HighGui.imshow("source", gray);
        HighGui.waitKey(0);

        //查找和存储图像中的轮廓。
        List<MatOfPoint> contours = new ArrayList<MatOfPoint>();
        Imgproc.findContours(gray,contours,new Mat(),Imgproc.RETR_LIST,Imgproc.CHAIN_APPROX_SIMPLE);

        Mat target = new Mat(gray.height(),gray.width(), CvType.CV_8UC3,new Scalar(255,255,255));

        for (int i = 0; i < contours.size()/*具体数值也可以*/; i++) {
            Imgproc.drawContours(target,contours,i,new Scalar(0,0,0),3);
        }

        HighGui.imshow("Contours",target);
        HighGui.waitKey(0);

    }
}
