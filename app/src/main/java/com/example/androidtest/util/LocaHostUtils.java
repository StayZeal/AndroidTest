package com.example.androidtest.util;


import android.util.Log;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * 创建人: ${俞力枫}
 * 联系方式: yulifeng@mingxun.cc
 * 创建时间: 2017/3/23
 */
public class LocaHostUtils {

    //获取当前的时间
    public static String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss", Locale.getDefault()).format(new Date());


    //这个路径是 当前路径/OPE/
    public static String savepath = "/sdcard/WCS摸排信息/";

    //这个是保存的文本信息
    public static void sacieFileData(String strcontent, String bundName) {

        //这个路径是 信息
        String fileNamee = ".txt";


        File file = new File(savepath);

        if (!file.exists()) {

            file.mkdirs();    //创建文件夹

        }

        File file1 = new File(savepath + timeStamp + File.separator);//bundName + timeStamp + fileNamee
        if (!file1.exists()) {
            file1.mkdirs();  //创建文件
        }

        File file2 = new File(file1, bundName + timeStamp + fileNamee);
        if (!file2.exists()) {
            try {
                file2.createNewFile();  //创建文件
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        //一行一行的读
        FileWriter fw = null;
        BufferedWriter bw = null;   //
        String datetime = "";
        try {
            fw = new FileWriter(file2, true);   //对这个进行扫描
            bw = new BufferedWriter(fw);   //缓冲区对图片的写入

            String myreadline = datetime + "" + strcontent;

            bw.write(myreadline + "\n");       //往进写的东西
            bw.flush(); //刷新
            bw.close();
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    //这个是将数据库里面的路径寻找到
    public static void getJson(Object path) {
        String pathstring = path.toString();
        String arrpath = pathstring.substring(1, pathstring.length() - 1);
        String[] split = arrpath.split(",");


        for (int i = 0; i < split.length; i++) {
            char c = (char) (Math.random() * 26 + 97);    //随机数
            Log.i("------------", split[i]);
            copyFile(split[i], savepath + c + ".jpeg");

        }
    }

    public static void copyFile(String src, String target) {
        Log.d("----------", src + "----dizhi----" + target);
//        FileOutputStream out = null;
//        InputStream in = null;
//        File fileSrc = new File(src);
//        if (fileSrc.exists()) {
//            try {
//                out = new FileOutputStream(target);
//                try {
//                    in = new FileInputStream(src);
//                    out = new FileOutputStream(target);
//                    byte[] bytes = new byte[1024 * 3];
//                    int len = 0;
//                    while ((len = in.read(bytes)) > 0) {
//
//                        out.write(bytes, 0, len);
//                    }
//                    Log.d("-----1----", "文件复制成功");
//                    out.flush();
//
//                } catch (FileNotFoundException e) {
//                    e.printStackTrace();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                } finally {
//                    try {
//                        if (in != null)
//                            in.close();
//                    } catch (IOException e) {
//                        e.printStackTrace();
//                    }
//                    try {
//                        if (out != null)
//                            out.close();
//                    } catch (IOException e) {
//                        e.printStackTrace();
//                    }
//                }
//            } catch (FileNotFoundException e) {
//                e.printStackTrace();
//            }

            int bytesum = 0;
            int byteread = 0;
        try {
            File oldfile = new File(src);
            if (oldfile.exists()) {          //文件存在时


                InputStream inStream = new FileInputStream(src);      //读入原文件
                FileOutputStream fs = new FileOutputStream(target);
                byte[] buffer = new byte[1444];
                while ((byteread = inStream.read(buffer)) != -1) {
                    bytesum += byteread;            //字节数 文件大小
                    System.out.println(bytesum);
                    fs.write(buffer, 0, byteread);
                }
                inStream.close();
            }
        } catch (Exception e) {
            System.out.println("复制单个文件操作出错");
            e.printStackTrace();
        }

    }
    }

    //这个是寻找到图片、然后将其转化为bitmap图片
//    public static Bitmap getBitmap(String path) {
//        BitmapFactory.Options opts = new BitmapFactory.Options();
//        // 设置为ture只获取图片大小
//        opts.inPreferredConfig = Bitmap.Config.ALPHA_8;
//        opts.inSampleSize = 2;
//        // 返回为空
//        return BitmapFactory.decodeFile(path);
//    }


//    //这个是保存图片的
//    public static void saveImgToDisk(String imgName, Bitmap bitmap) {
//        //这个路径是 信息
//        String fileNamee = ".jpeg";
//
//        File file = new File(path + timeStamp + File.separator, imgName + fileNamee);
//        try {
//            FileOutputStream out = new FileOutputStream(file);
//            bitmap.compress(Bitmap.CompressFormat.PNG, 80, out);
//            out.flush();
//            out.close();
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }




