import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.Point;
import org.opencv.core.Scalar;
import org.opencv.highgui.HighGui;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;

public class LianXI17 {
    //霍夫梯度法圆检测
    public static void main(String[] args) {
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);

        Mat src = Imgcodecs.imread("QiPan2.jpg");
        HighGui.imshow("1",src);
        HighGui.waitKey(0);

        Mat gray = new Mat();
        Imgproc.cvtColor(src,gray,Imgproc.COLOR_BGR2GRAY);
        Imgproc.medianBlur(gray,gray,5);

        Mat circies = new Mat();
        Imgproc.HoughCircles(gray,circies,Imgproc.HOUGH_GRADIENT,1.0,
                (double) gray.rows()/16,100.0,30.0,1,30);

        for (int x = 0; x < circies.cols(); x++) {
            double[] c = circies.get(0,x);
            Point center = new Point(Math.round(c[0]),Math.round(c[1]));
            int radius = (int) Math.round(c[2]);
            Imgproc.circle(src,center,radius,new Scalar(255,0,255),3,8,0);
        }

        HighGui.imshow("Circles",src);
        HighGui.waitKey();
        System.exit(0);
    }
}
