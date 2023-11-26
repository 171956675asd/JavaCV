import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.Point;
import org.opencv.core.Scalar;
import org.opencv.highgui.HighGui;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;

public class LianXi15 {
    //模板匹配
    public static void main(String[] args) {
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
        Mat src = Imgcodecs.imread("lena.jpg");
        HighGui.imshow("lena", src);
        HighGui.waitKey(0);
        Mat template = Imgcodecs.imread("face.jpg");
        HighGui.imshow("template", template);
        HighGui.waitKey(0);

        Mat result = new Mat();
        Imgproc.matchTemplate(src, template, result, Imgproc.TM_CCOEFF);//结果在result中
        Core.MinMaxLocResult mmr = Core.minMaxLoc(result);//结果包括最大最小值和位置
        Point Loc = mmr.maxLoc;//取出最大值的位置（TM_CCOEFF模式用最大值）
        //在src上画出匹配位置
        Imgproc.rectangle(src, Loc,
                new Point(Loc.x + template.cols(), Loc.y + template.rows()),
                new Scalar(255, 0, 0));
        HighGui.imshow("match",src);
        HighGui.waitKey(0);
    }
}
