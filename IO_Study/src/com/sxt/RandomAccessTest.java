package com.sxt;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.List;

/**
 * @author fly
 * @date 2019/7/17
 */
public class RandomAccessTest {
    private File srcFile;
    private String destDir;
    private List<String>destPaths;
    private int blockSize;
    private int blockAmount;

    public RandomAccessTest(String srcPath, String destDir, int blockSize) {
        this.srcFile = new File(srcPath);
        this.destDir = destDir;
        this.destPaths = new ArrayList<>();
        this.blockSize = blockSize;
    }

    //初始化
    private void init(){
//        System.out.println("len = " + len);
        //块数量
//        this.blockAmount = (int)Math.ceil(len*1.0/blockSize);
        System.out.println("blockAmount = " + blockAmount);
        for (int i = 0; i < this.blockAmount; i++) {
            this.destPaths.add("this.destDir\\"+this.srcFile.getName()+i);
        }
    }

    public void split() {
        //总长度
        long len = this.srcFile.length();
        //起始位置
        int beginPos = 0;
        //实际读取大小
        int actualSize = (int)(blockSize>len?len:blockSize);
        System.out.println("beginPos = " + beginPos);
        for (int i = 0; i < blockAmount; i++) {
            beginPos = i*blockSize;
            if (i == blockAmount-1){//最后一块
                actualSize = (int) len;
            }else {//非最后一块
                actualSize =blockSize;
                len -= actualSize;
            }
            System.out.println("i="+i+"-->beginPos="+beginPos+"-->actualSize="+actualSize);
//            splitDetail(i,beginPos,actualSize);
        }
    }

    private void splitDetail(int i,int beginPos,int totalSize) throws IOException {
        RandomAccessFile raf = new RandomAccessFile(this.srcFile,"r");
        RandomAccessFile raf2 = new RandomAccessFile(this.destPaths.get(i),"rw");
        //随机读取
        raf.seek(beginPos);
        byte[] flush = new byte[1024];
        int len = -1;
        while ((len=raf.read(flush)) != -1){
////            if (actualSize)
//                raf2.write(flush,0,len);
//            }else {
//                System.out.println("**************************"+(i++));
//                int finalSize = totalSize-blockSize*(blockAmount-1);
//                System.out.println(new String(flush,0,totalSize-blockSize*(blockAmount-1)));
//                raf2.write(flush,0,finalSize);
            }
        }
//        raf2.close();
//        raf.close();
    }
//}


