import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Task1 {
    public static void main(String[] args) {
        List<String> strings = List.of("I", "am", "a", "list", "of", "Strings");
        //使用List.of()方法来初始化一个包含指定元素的不可变列表。

        Stream<String> stream = strings.stream();
        //调用流API的方法，例如我们希望最多有4个元素
        Stream<String> limit = stream.limit(4);
        //最后我们打印
        System.out.println("limit = " + limit);
        //结果:limit = java.util.stream.SliceOps$1@6d311334
        //limit 是Stream对象的一个引用，不能直接打印引用本身，需要通过某种方法获取到里面的数据
        limit.forEach(System.out::println);
        //通过终端方法forEach输出，::表示引用了System.out的println方法，接收一个参数并打印，调用该
        //方法时由底层的迭代器负责提供流中的每个元素给println方法。

        List<Integer> numbers = Arrays.asList(1,2,5,4,8);
        List<Integer> squaresList = numbers.stream()//创建一个流
                .map(i -> i * i)	//将原来列表中每个元素映射成它的平方，保存到一个新的流里面
                .sorted((x, y) -> y - x)	//降序排序
                .collect(Collectors.toList());//终端操作，将流收集到一个新的列表squaresList中
        for(Integer i : squaresList) {
            System.out.print(i+" ");
        }
    }
}
