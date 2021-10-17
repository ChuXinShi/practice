package com.scx.demo.excel;

import com.alibaba.excel.EasyExcelFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * @auther scx
 * @date 2021/10/17 - 19:18
 */
public class TestEasyExcel {

    public static void main(String[] args) {
//        String filename = "D:\\study\\project\\testeasyexcel\\write.xlsx";
//        EasyExcelFactory.write(filename,DemoData.class).sheet("学生列表").doWrite(getData());

        //实现excel读的操作
        EasyExcelFactory.read("D:\\study\\project\\testeasyexcel\\write.xlsx",DemoData.class,new ExcelListener()).sheet().doRead();
    }

    //创建方法返回list集合
    private static List<DemoData> getData(){
        List<DemoData> list = new ArrayList<>();
        for(int i = 0;i<10;i++){
            DemoData data = new DemoData();
            data.setSno(i);
            data.setSname("lucy" + i);
            list.add(data);
        }
        return list;
    }


}
