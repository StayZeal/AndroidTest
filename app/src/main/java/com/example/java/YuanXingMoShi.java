package com.example.java;

/**
 * Created by yangfeng on 2016/6/20.
 */
public class YuanXingMoShi {

    public static void main(String[] args) {
        WordDocument doc = new WordDocument();
        doc.setmText("原型");
        doc.addImage("图片一");
        doc.addImage("图片二");

        doc.showDocument();

        WordDocument doc1 = (WordDocument) doc.clone();
        doc1.showDocument();
        doc1.setmText("复制");
        doc1.addImage("图片哈哈哈");

        doc.showDocument();
        doc1.showDocument();
        WordDocument doc2 = doc;
        doc.setmText("doc3");
        doc.showDocument();



    }

}

