import org.opencv.core.Core;
import org.opencv.core.*;
import org.opencv.highgui.HighGui;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;
public class LianXi5 {
    //图像旋转
    public static void main(String[] args) {
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);

        Mat src = Imgcodecs.imread("lena.jpg");
        Mat dst = src.clone();//克隆一张图像
        Point center = new Point(src.width() / 2.0, src.height() / 2.0);//以图像中心为轴心进行旋转
        Mat affineTrans = Imgproc.getRotationMatrix2D/*此为矩阵函数*/(center, 33.0/*旋转度数*/, 1.0);
        Imgproc.warpAffine(src/*图像来源*/, dst/*目标图像*/, affineTrans/*给一个矩阵*/
                , dst.size()/*图像尺寸大小*/, Imgproc.INTER_NEAREST/*常量，默认为0，此单词可替换为0*/);
        HighGui.imshow("mixed", dst);
        HighGui.waitKey(0);
    }
}
