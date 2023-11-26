import org.opencv.core.*;
import org.opencv.highgui.HighGui;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;

public class LianXi7 {
    public static void main(String[] args) {
        //透视变换
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);

        Mat src = Imgcodecs.imread("JiaoTu.jpg");
        HighGui.imshow("jiao",src);
        HighGui.waitKey(0);
        Mat dst = new Mat();

        Point[] pt1 = new Point[4];
        pt1[0] = new Point(50,26);
        pt1[1] = new Point(524,68);
        pt1[2] = new Point(10,567);
        pt1[3] = new Point(479,549);

        Point[] pt2 = new Point[4];
        pt2[0] = new Point(0,0);
        pt2[1] = new Point(532,0);
        pt2[2] = new Point(0,575);
        pt2[3] = new Point(532,575);

        MatOfPoint2f mop1 = new MatOfPoint2f(pt1);
        MatOfPoint2f mop2 = new MatOfPoint2f(pt2);

        Mat perspectiveTransform = Imgproc.getPerspectiveTransform(mop1,mop2);
        Imgproc.warpPerspective(src,dst,perspectiveTransform,new Size());
        HighGui.imshow("jiaotu",dst);
        HighGui.waitKey(0);
    }
}
