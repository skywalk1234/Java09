package KTV;

import java.io.*;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Songs songs = new Songs();
        List<Song> song = songs.getSongs();
        //song.stream().forEach(System.out::println);
        //打印所有Rock流派的歌曲
        List<Song> Filtering = song.stream()
                                .filter((Song s)->(s.getGenre()=="Rock"))
                                 //过滤出只包含Rock流派的歌曲
                                .collect(Collectors.toList());
                                // 收集成一个列表
        System.out.println("所有Rock流派的歌曲");
        for (Song s : Filtering) {
            System.out.println(s.getInfo());
        }

        //集合Set不能出现重复元素，所以可以用集合保存流派达到去重的效果
        Set<String> genre = song.stream()
                .map((Song s)->(s.getGenre()))
                //将每一个Song对象映射为它的流派，即创建一个新的流，保存每首歌的流派
                .collect(Collectors.toSet());
        //打印所有流派
        System.out.println("---------------歌单包含的流派-------------");
        for (String s : genre) {
            System.out.println(s);
        }
        //序列化与反序列化
        //将歌曲写入文件
        int n = song.size();
        for(int i=0;i<n;i++){
            Song s = song.get(i);
            ObjectOutputStream oos = null;
            try {
                System.out.println("正在写入："+i+".ser");
                oos = new ObjectOutputStream(new FileOutputStream("./src/KTV/SongFile/"+i+".ser"));
                oos.writeObject(s);
            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("写入文件失败");
            }finally{
                try {
                    oos.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        //读取文件
        System.out.println("通过反序列化读取.ser文件");
        for(int i=0;i<n;i++){
            ObjectInputStream ois = null;
            try {
                ois = new ObjectInputStream(new FileInputStream("./src/KTV/SongFile/"+i+".ser"));
                Song s2 = (Song) ois.readObject();
                System.out.println(s2.getInfo());
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("读取文件失败");
            }finally{
                try {
                    ois.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        //将歌曲写入到文本文件
        for (int i = 0; i < n; i++) {
            Song s = song.get(i);
            FileWriter fw = null;
            try {
                fw = new FileWriter("./src/KTV/SongFile/"+i+".txt");
                fw.write(s.WriteIn());
                System.out.println("....正在写入："+i+".txt");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }finally {
                try {
                    fw.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }

        }
        //读取文件
        System.out.println("通过BufferedReader读取文本文件");
        String c1[] = new String[5];
        c1[0] = "歌曲";
        c1[1] = "创作者";
        c1[2] = "流派";
        c1[3] = "发行时间";
        c1[4] = "时长";
        int k=0;
        for(int i=0;i<n;i++){
            System.out.println("--------------------------------");
            BufferedReader br = null;
            String line = null;
            k=0;
            try {
                br = new BufferedReader(new FileReader("./src/KTV/SongFile/"+i+".txt"));
                while((line=br.readLine())!=null){
                    System.out.println(c1[k]+":"+line);
                    k++;
                }
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }

    }
}
