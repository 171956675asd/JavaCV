import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.Size;
import org.opencv.highgui.HighGui;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;

public class LianXi13 {
    //四种边缘算法
    public static void main(String[] args) {
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
        Mat src = Imgcodecs.imread("Di.jpg",Imgcodecs.CV_LOAD_IMAGE_GRAYSCALE);
        Mat mat = new Mat();

        //Sobel算法
        Imgproc.Sobel(src,mat,-1,0,1);//-1，1为深度
        HighGui.imshow("Sobel",mat);
        HighGui.waitKey(0);

        //Scharr算法
        Imgproc.Scharr(src,mat,-1,0,1);
        HighGui.imshow("scharr",mat);
        HighGui.waitKey(0);

        //拉普拉斯算法，GaussianBlur（高斯模糊）
        Mat dst = new Mat();
        Imgproc.GaussianBlur(src,dst,new Size(31,5),80,3);
        Imgproc.Laplacian(src,dst,0);
        HighGui.imshow("Laplacian",dst);
        HighGui.waitKey(0);

        //Canny算法
        Imgproc.Canny(src,dst,60,200);
        HighGui.imshow("Canny",dst);
        HighGui.waitKey(0);
    }
}
