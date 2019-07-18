import java.io.*;

/**
 * 文件中转(文件字节输入输出流)
 * 流操作步骤:
 * 1.创建源
 * 2.选择流
 * 3.操作
 * 4.释放资源
 * @author fly
 * @date 2019/7/2
 */
public class Test {
    public static void myCopy(String srcPath,String destPath){
        long ts = System.currentTimeMillis();
        //try-with-resourse,声明放在try的括号内
        try(InputStream is = new BufferedInputStream(new FileInputStream(srcPath));
                OutputStream os = new BufferedOutputStream(new FileOutputStream(destPath))) {
            byte[] flush = new byte[1024];  //缓冲容器
            int len = -1;                   //接收长度
            while ((len=is.read(flush)) != -1){
                os.write(flush,0,len);
            }
            os.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
        long te = System.currentTimeMillis();
        System.out.println(te - ts);
    }

    public static void main(String[] args) {
//        myCopy("ccc.mp4","ccc_copy.mp4");
        int a = 2;
        long b = 3;
        a = (int)b;
    }
}
