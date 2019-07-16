package org.wq.demo.springclouddemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
public class SpringCloudDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudDemoApplication.class, args);
    }


    public static List<Integer> getList(){
        List<Integer> initList = new ArrayList<>();
        initList.addAll(Arrays.asList(99,98,97));
        for (int itemi = 96 ;itemi > 0;itemi--){
            Map<Integer,Integer> map = new HashMap<>();
            for (int itemj = 0 ;itemj < initList.size();itemj++){
                for (int itemm = itemj+1;itemm < initList.size();itemm++){
                    int total = initList.get(itemj) + initList.get(itemm);
                    map.put(total,1);
                }
            }
            int hopeSize = ((initList.size())*(initList.size())-(initList.size()))/2;
            if (map.size() != hopeSize){
                throw new RuntimeException("Error");
            }
            boolean flag = true;
            for (int n = 0 ;n < initList.size();n++){
                int total = initList.get(n)+itemi;
                Integer integer = map.get(total);
                if (integer == null || integer == 0){
                    map.put(total,1);
                }else {
                    flag = false;
                    break;
                }
            }
            hopeSize = ((initList.size()+1)*(initList.size()+1)-(initList.size()+1))/2;
            if (map.size() == hopeSize && flag){
                initList.add(itemi);
            }
        }
        return initList;
    }
}
