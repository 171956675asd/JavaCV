import org.opencv.core.*;
import org.opencv.highgui.HighGui;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;

public class LianXi6 {
    //图像角点变换
    public static void main(String[] args) {
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);

        Mat src = Imgcodecs.imread("JiaoTu.jpg");
        Mat dst = new Mat();

        //定义图像角点
        Point[] pt1 = new Point[3];
        pt1[0] = new Point(0,0);
        pt1[1] = new Point(400,0);
        pt1[2] = new Point(0,400);

        //输出图像角点
        Point[] pt2 = new Point[3];
        pt2[0] = new Point(0,0);
        pt2[1] = new Point(400,0);
        pt2[2] = new Point(200,400);

        //将形参转化为矩阵mop*
        MatOfPoint2f mop1 = new MatOfPoint2f(pt1);
        MatOfPoint2f mop2 = new MatOfPoint2f(pt2);

        Mat mat = Imgproc.getAffineTransform/*计算仿射变换2*3矩阵*/(mop1,mop2);
        Imgproc.warpAffine(src,dst,mat,src.size());
        HighGui.imshow("lena",dst);
        HighGui.waitKey(0);

    }
}
