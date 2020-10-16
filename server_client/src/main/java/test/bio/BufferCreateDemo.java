package test.bio;

import java.nio.Buffer;
import java.nio.ByteBuffer;

public class BufferCreateDemo {
    public static void main(String[] args) {
        //方式1：allocate方式直接分配，内部将隐含的创建一个数组
        ByteBuffer allocate = ByteBuffer.allocate(10);
        //方式2：通过wrap根据一个已有的数组创建
        byte[] bytes=new byte[10];
        ByteBuffer wrap = ByteBuffer.wrap(bytes);
        //方式3：通过wrap根据一个已有的数组指定区间创建
        ByteBuffer wrapoffset = ByteBuffer.wrap(bytes,2,5);

        //打印出刚刚创建的缓冲区的相关信息

        System.out.println("----put");
        print(wrapoffset);

        wrapoffset.put("a".getBytes()); //position=3
        print(wrapoffset);
        wrapoffset.put("b".getBytes()); //position=4
        wrapoffset.put("c".getBytes()); //position=5
        wrapoffset.put("d".getBytes()); //position=6
        wrapoffset.put("e".getBytes()); //position=7  <--- limit
        print(wrapoffset);
        try {
            wrapoffset.put("f".getBytes());  //position=8 <-- over limit

        } catch (java.nio.BufferOverflowException e) {
            System.out.println("java.nio.BufferOverflowException");
        }

        print(wrapoffset);
        System.out.println("----get");
        System.out.println(wrapoffset.get(0));
        System.out.println(wrapoffset.get(1));
        System.out.println(wrapoffset.get(2));
        System.out.println(wrapoffset.get(3));
        System.out.println(wrapoffset.get(6));
        try {
            System.out.println(wrapoffset.get(7)); // get index > limit
        } catch (java.lang.IndexOutOfBoundsException e) {
            System.out.println("java.lang.IndexOutOfBoundsException");
        }

        System.out.println("----flip");
        print(allocate);
        allocate.put("hello".getBytes());
        print(allocate);
        System.out.println("before flip");
        allocate.flip();
        System.out.println("after flip");
        print(allocate);
        byte[] readBytes = new byte[allocate.limit()];
        for (int i = 0; allocate.hasRemaining() ; i++) {
            readBytes[i] = allocate.get();
        }
        System.out.println("readBytes = "+new String(readBytes));
        byte[] readBytes2 = new byte[allocate.limit()];
        print(allocate);
        allocate.position(0);
        allocate.get(readBytes2);
        System.out.println("readBytes2 = "+new String(readBytes2));

        System.out.println("----clear");
        print(allocate);
        allocate.clear();
        System.out.println("after clear");
        print(allocate);
        allocate.flip();
        print(allocate);


        ByteBuffer.allocateDirect(10);
    }

    private static void print(Buffer... buffers) {
        for (Buffer buffer : buffers) {
            System.out.println("capacity="+buffer.capacity()
                    +",limit="+buffer.limit()
                    +",position="+buffer.position()
                    +",hasRemaining:"+buffer.hasArray()
                    +",remaining="+buffer.remaining()
                    +",hasArray="+buffer.hasArray()
                    +",isReadOnly="+buffer.isReadOnly()
                    +",arrayOffset="+buffer.arrayOffset());
        }
    }

}
