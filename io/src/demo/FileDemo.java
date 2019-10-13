package demo;

import org.junit.Test;

import java.io.*;
import java.net.URI;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @Author zjl
 * @Date 2019/10/8 16:25
 */
public class FileDemo {
    @Test
    public void test() throws IOException {
        File file = new File("C:\\Users\\zjl\\Desktop\\Java\\scanlog.txt");
        System.out.println("canread:"+file.canRead()) ;
        System.out.println("canwrite:"+file.canWrite()) ;
        System.out.println("compareto:"+file.compareTo(new File("C:\\Users\\zjl\\Desktop\\Java\\scanlog.txt"))) ;
        System.out.println("createNewFile:"+file.createNewFile()) ;
        System.out.println("exists:"+file.exists()) ;
        System.out.println("absolutePath:"+file.getAbsolutePath()) ;
        System.out.println("canonicalPath:"+file.getCanonicalPath()) ;
        System.out.println("freespace:"+file.getFreeSpace()/1024/1024/1024) ;
        System.out.println("name:"+file.getName()) ;
        System.out.println("parent:"+file.getParent()) ;
        System.out.println("path:"+file.getPath()) ;
        System.out.println("parentPath:"+file.getParentFile().getPath()) ;
        System.out.println("totalSpace:"+file.getTotalSpace()/1024/1024/1024) ;
        System.out.println("usableSpace:"+file.getUsableSpace()/1024/1024/1024) ;
        System.out.println("isAbsolute:"+file.isAbsolute()) ;
    }
    @Test
    public void test2() throws IOException {
        InputStream inputStream = new FileInputStream("D:\\360Downloads\\305229.jpg");
        OutputStream outputStream = new FileOutputStream("a.jpg");
        byte [] bytes = new byte[1024];
        int length = 0;
        while ( (length=inputStream.read(bytes))!=-1 ){
            outputStream.write(bytes,0,length);
        }
        inputStream.close();
        outputStream.close();

    }
    @Test
    public void test3() throws IOException, ClassNotFoundException {
//        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("q.txt"));
//        Person person = new Person( );
//        person.setName("ym");
//        objectOutputStream.writeObject(person);
//        objectOutputStream.close();
        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("q.txt"));
        Person o = ( Person ) objectInputStream.readObject( );
        System.out.println(o.getName()) ;
        objectInputStream.close();
    }
    @Test
    public void test4() throws IOException {
        FileReader fileReader = new FileReader("a.txt");
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        char[] chars = new char[1024];
        int length = 0;
        String message=null;
        while ((message = bufferedReader.readLine())!=null){
            System.out.println(message) ;
        }
        bufferedReader.close();
        fileReader.close();
    }
    @Test
    public void test5() throws IOException{
        DataOutputStream dataOutputStream = new DataOutputStream(new FileOutputStream("c.txt",true));
        dataOutputStream.writeInt(2323);
        dataOutputStream.writeUTF("hello");
        DataInputStream dataInputStream = new DataInputStream(new FileInputStream("c.txt"));
        int i = dataInputStream.readInt( );
        System.out.println(i) ;
        String s = dataInputStream.readUTF();
        System.out.println(s) ;
        int a = 0;
        while ( (a=dataInputStream.read())!=-1){
            System.out.println(dataInputStream.readUTF()) ;
        }
        dataInputStream.close();
        dataOutputStream.close();
    }
    @Test
    public void test6() throws IOException, ClassNotFoundException {
        PrintStream printStream = new PrintStream( new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream("v.txt"))));
        Person person = new Person( );
        person.setName("Df");
        printStream.print(person);
        printStream.flush();
        printStream.close();
        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("v.txt"));
        Person o = ( Person ) objectInputStream.readObject( );
        System.out.println(o) ;
        objectInputStream.close();

    }
    @Test
    public void test7() throws IOException{
        FileOutputStream fileOutputStream = new FileOutputStream("nio.txt");
        FileChannel channel = fileOutputStream.getChannel( );
        ByteBuffer allocate = ByteBuffer.allocate(1024);
        allocate.put("hello,nio".getBytes());
        allocate.flip();
        channel.write(allocate);
        int read = channel.read(allocate);
        byte[] array = allocate.array( );
        System.out.println(new String(array)) ;
        fileOutputStream.close();
    }
    @Test
    public void test8() throws Exception{
        FileInputStream inputStream = new FileInputStream("nio.txt");
        FileOutputStream fileOutputStream = new FileOutputStream("nio1.txt");
        FileChannel channel1 = inputStream.getChannel( );
        FileChannel channel2 = fileOutputStream.getChannel( );
        channel1.transferTo(0,channel1.size(),channel2);
        inputStream.close();
        fileOutputStream.close();

    }
    @Test
    public void test9() throws IOException {
        FileChannel inChannel = FileChannel.open(Paths.get("a.jpg"),StandardOpenOption.READ);
        FileChannel outChannel = FileChannel.open(Paths.get("b1.jpg"),StandardOpenOption.WRITE,StandardOpenOption.READ, StandardOpenOption.CREATE);
        MappedByteBuffer map = inChannel.map(FileChannel.MapMode.READ_ONLY, 0, inChannel.size( ));
        MappedByteBuffer map1 = outChannel.map(FileChannel.MapMode.READ_WRITE, 0, inChannel.size( ));
        byte[] by = new byte[(map.limit())];
        map.get(by);
        map1.put(by);
        inChannel.close();
        outChannel.close();


    }
    @Test
    public void test10() throws IOException {
        FileChannel inChannel = FileChannel.open(Paths.get("a.jpg"), StandardOpenOption.READ);
        FileChannel outChannel = FileChannel.open(Paths.get("c1.jpg"),StandardOpenOption.WRITE,StandardOpenOption.READ,StandardOpenOption.CREATE);
        MappedByteBuffer inMap = inChannel.map(FileChannel.MapMode.READ_ONLY, 0, inChannel.size( ));
        MappedByteBuffer outMap = outChannel.map(FileChannel.MapMode.READ_WRITE, 0, inChannel.size( ));
        byte[] bytes = new byte[inMap.limit()];
        inMap.get(bytes);
        outMap.put(bytes);
        inChannel.close();
        outChannel.close();

    }
    @Test
    public void test11() throws IOException{
        RandomAccessFile in_randomAccessFile = new RandomAccessFile("c1.jpg", "rw");
        RandomAccessFile out_randomAccessFile = new RandomAccessFile("c11.jpg", "rw");
        FileChannel in_channel = in_randomAccessFile.getChannel( );
        FileChannel out_channel = out_randomAccessFile.getChannel( );
        ByteBuffer byteBuffer1 = ByteBuffer.allocate((int ) in_channel.size());
        ByteBuffer byteBuffer2 = ByteBuffer.allocate((int ) in_channel.size());
        in_channel.read(new ByteBuffer[]{byteBuffer1,byteBuffer2});
        byteBuffer1.flip();
        byteBuffer2.flip();
        out_channel.write(new ByteBuffer[]{byteBuffer1,byteBuffer2});
        in_channel.close();
        out_channel.close();
        in_randomAccessFile.close();
        out_randomAccessFile.close();
    }
}
