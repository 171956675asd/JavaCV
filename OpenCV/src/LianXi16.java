import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.Point;
import org.opencv.core.Scalar;
import org.opencv.highgui.HighGui;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;

public class LianXi16 {
    //霍夫直线检测
    public static void main(String[] args) {
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
        Mat dst = new Mat(), cdst = new Mat();
        Mat src = Imgcodecs.imread("QiPan.jpg", Imgcodecs.IMREAD_GRAYSCALE);

        Imgproc.Canny(src, dst, 50, 200, 3, false);
        Imgproc.cvtColor(dst, cdst, Imgproc.COLOR_GRAY2BGR);
        Mat lines = new Mat();
        Imgproc.HoughLines(dst, lines, 1, Math.PI / 180, 150);
        for (int x = 0; x < lines.rows(); x++) {
            double rho = lines.get(x, 0)[0], theta = lines.get(x, 0)[1];
            double a = Math.cos(theta), b = Math.sin(theta);
            double x0 = a * rho, y0 = b * rho;
            Point pt1 = new Point(Math.round(x0 + 1000 * (-b)), Math.round(y0 + 1000 * (a)));
            Point pt2 = new Point(Math.round(x0 - 1000 * (-b)), Math.round(y0 - 1000 * (a)));
            Imgproc.line(cdst,pt1,pt2,new Scalar(0,0,255),3);
        }

        HighGui.imshow("Source",src);
        HighGui.waitKey(0);
        HighGui.imshow("Detected Lines",cdst);
        HighGui.waitKey(0);
        System.exit(0);
    }
}
