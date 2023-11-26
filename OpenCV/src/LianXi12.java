import org.opencv.core.*;
import org.opencv.highgui.HighGui;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;

import java.util.*;

public class LianXi12 {
    public static void main(String[] args) {
        //灰度直方图
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
        Mat src = Imgcodecs.imread("lena.jpg", Imgcodecs.CV_LOAD_IMAGE_GRAYSCALE/*读取成灰度值*/);
        HighGui.imshow("lena", src);
        HighGui.waitKey(0);

        //直方图均衡化
        Mat dst = new Mat();
        Imgproc.equalizeHist(src,dst);
        HighGui.imshow("dst",dst);
        HighGui.waitKey(0);


        //Mat类的列表表示图像
        //初始化一个mat类对象，将src的图像存入mat类对象
        List<Mat> matList = new LinkedList<Mat>();
        matList.add(dst/*src为直方图均衡化之前的直方图*/);

        //定义直方图范围
        float[] range = {0, 256};
        MatOfFloat histRange = new MatOfFloat(range);
        Mat Hist = new Mat();
        //直方图计算函数
        Imgproc.calcHist(matList, new MatOfInt(0)/*0通道*/, new Mat()/*掩模图*/, Hist/*生成的直方图数据*/,
                new MatOfInt(256)/*直方图的区间数*/, histRange/*直方图的范围*/);

        int Wide = 512, High = 400;//直方图尺寸
        Mat histImage = new Mat(High, Wide, CvType.CV_8UC3, new Scalar(0, 0, 0));
        //将直方图数据归一化到[0,400]区间
        Core.normalize(Hist/*输入数据*/, Hist/*输出数据*/, 0/*规划的最小值*/, histImage.rows()/*最大值*/,
                Core.NORM_MINMAX/*类型*/);
        float[] HistData = new float[(int) (Hist.total() * Hist.channels())];
        Hist.get(0, 0, HistData);

        int binW = (int) Math.round((double) Wide / 256);
        for (int i = 1; i < 256; i++) {
            Imgproc.line(histImage, new Point(binW * (i),High),
                    new Point(binW * (i), High - Math.round(HistData[i])),
                    new Scalar(255, 255, 255), 2);
//            Imgproc.line(histImage, new Point(binW * (i - 1), High - Math.round(HistData[i - 1])),
//                    new Point(binW * (i), High - Math.round(HistData[i])),
//                    new Scalar(255, 0, 0), 2);

        }
        HighGui.imshow("lena2",histImage);
        HighGui.waitKey(0);

    }
}
