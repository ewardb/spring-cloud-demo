package org.wq.demo.ser;

import lombok.Data;

import java.io.Serializable;
import java.util.Hashtable;

/**
 * @author wangqiang26
 * @mail wangqiang26@jd.com
 * @Date 10:59 2019/5/24
 */
@Data
public class Rectangle implements Serializable {


    private static final long serialVersionUID = 8670175495402248039L;
    private Integer width;
    private Integer height;
    private transient Integer area;
    private Hashtable<String, String> hashtable = new Hashtable<>();



    public Rectangle (Integer width, Integer height){
        this.width = width;
        this.height = height;
        this.area = width * height;
    }

    public void setArea(){
        this.area = this.width * this.height;
    }


    private void writeObject(java.io.ObjectOutputStream stream) throws Exception{
        height <<= 2;
        stream.defaultWriteObject();
    }

    private void readObject(java.io.ObjectInputStream stream) throws Exception{
        stream.defaultReadObject();
        height >>=2;
    }



//    @Override
//    public String toString(){
//        StringBuffer sb = new StringBuffer(40);
//        sb.append("width : ");
//        sb.append(this.width);
//        sb.append("\nheight : ");
//        sb.append(this.height);
//        sb.append("\narea : ");
//        sb.append(this.area);
//        return sb.toString();
//    }
}
