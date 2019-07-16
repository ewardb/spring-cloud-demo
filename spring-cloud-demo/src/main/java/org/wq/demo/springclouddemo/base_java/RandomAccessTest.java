package org.wq.demo.springclouddemo.base_java;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.RandomAccess;
import java.util.List;


/**
 * @author wangqiang26
 * @mail wangqiang26@jd.com
 * @Date 14:45 2019/7/5
 */
public class RandomAccessTest {


    public static void traverse(List list){

        if (list instanceof RandomAccess){
            System.out.println("实现了RandomAccess接口，不使用迭代器");

            for (int i = 0;i < list.size();i++){
                System.out.println(list.get(i));
            }

        }else{
            System.out.println("没实现RandomAccess接口，使用迭代器");

            Iterator it = list.iterator();
            while(it.hasNext()){
                System.out.println(it.next());
            }

        }
    }
    public static void main(String[] args) {
        List<String> arrayList = new ArrayList<>();
        arrayList.add("a");
        arrayList.add("b");
        traverse(arrayList);

        List<String> linkedList = new LinkedList<>();
        linkedList.add("c");
        linkedList.add("d");
        traverse(linkedList);
    }
}
