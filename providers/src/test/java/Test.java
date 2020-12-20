import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import java.text.SimpleDateFormat;
import java.time.Clock;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @Author: zhaoxiaofeng
 * @Description:
 * @Date: 2020/5/6 17:59
 */
public class Test {
    public static void main(String[] args) {
        //Test.test1();
        //Test.test2();
        //getCurrentTime();
        filterSex();
        //testMap();
        //testFlatMap();
        //testCollect();
    }
    public static List<PersonModel> getData(){
        PersonModel wu = new PersonModel("wu qi", 18, "男");
        PersonModel zhang = new PersonModel("zhang san", 19, "男");
        PersonModel wang = new PersonModel("wang si", 20, "女");
        PersonModel zhao = new PersonModel("zhao wu", 20, "男");
        PersonModel chen = new PersonModel("chen liu", 21, "男");
        return Arrays.asList(wu, zhang, wang, zhao, chen);
    }

    /**
     * Collect
     * collect在流中生成列表，map，等常用的数据结构
     * toList()
     * toSet()
     * toMap()
     * 自定义
     */
    public static void testCollect(){
        List<PersonModel> data =getData();
        // toList
        List<String> toList = data.stream().map(PersonModel::getName).collect(Collectors.toList());
        System.out.println("toList: " + toList);
        // toSet
        Set<String> toSet = data.stream().map(PersonModel::getName).collect(Collectors.toSet());
        System.out.println("toSet: " + toSet);
        // toMap
        /**第一个参数：PersonModel::getName 表示选择PersonModel的getName() 作为key
         * 第二个参数：PersonModel::getAge  表示选择PersonModel的getAge()作为value
         * 第三个参数：(v1, v2) -> v2)      表示在key相同时选择 v2 作为 key 的value
         **/
        Map<String, Integer> toMap1 = data.stream().collect(
                        Collectors.toMap(PersonModel::getName, PersonModel::getAge, (v1, v2) -> v2)
                );
        System.out.println("toMap1: " + toMap1);
        Map<String, PersonModel> toMap2 = data.stream().collect(Collectors.toMap(personModel->personModel.getName(), value->value, (v1, v2) -> v2));
        System.out.println("toMap2: " + toMap2);

        // 指定类型(暂定)
//        TreeSet<PersonModel> treeSet = data.stream().collect(Collectors.toCollection(TreeSet::new));
//        System.out.println("TreeSet: " + treeSet);
        // 分组
        Map<Boolean, List<PersonModel>> group = data.stream()
                .collect(Collectors.groupingBy(per -> "男".equals(per.getSex())));
        System.out.println("分组： " + group);
        // 分割
        String collect = data.stream().map(personModel -> personModel.getName())
                .collect(Collectors.joining(",", "{", "}"));
        System.out.println("分割： " + collect);
        // 自定义
        List<String> d = Stream.of("1", "2", "3").collect(
                Collectors.reducing(new ArrayList<String>(), x -> Arrays.asList(x), (y, z) -> {
                    y.addAll(z);
                    return y;
                }));
        System.out.println("自定义" + d);

    }

    /**
     * 测试stream 中的flatMap
     */
    public static void testFlatMap(){
        List<PersonModel> data =getData();
        // 方法一
        List<String> list1 = data.stream()
                .flatMap(personModel -> Arrays.stream(personModel.getName().split(",")))
                .collect(Collectors.toList());
        System.out.println("flatMap方法一： " + list1);
        // 方法二
        List<Stream<String>> list2 = data.stream()
                .map(personModel -> Arrays.stream(personModel.getName().split(",")))
                .collect(Collectors.toList());
        System.out.println("flatMap方法二： " + list2);

        //用map实现
        List<String> list3 = data.stream()
                .map(personModel -> personModel.getName().split(" "))
                .flatMap(Arrays::stream).collect(Collectors.toList());
        System.out.println("list3: " + list3);
        //另一种方式
        List<String> list4 = data.stream()
                .map(personModel -> personModel.getName().split(" "))
                .flatMap(arr -> Arrays.asList(arr).stream()).collect(Collectors.toList());
        System.out.println("list4: " + list4);
    }

    /**
     * 测试stream 中的 map
     */
    public static void testMap(){
        List<PersonModel> data =getData();
        // 方法一
        List<String> list1 = data.stream().map(personModel -> personModel.getName()).collect(Collectors.toList());
        System.out.println("map获取名字方法一： " + list1);
        // 方法二
        List<String> list2 = data.stream().map(PersonModel::getName).collect(Collectors.toList());
        System.out.println("map获取名字方法二： " + list2);
        // 方法三
        List<String> list3 = data.stream().map(personModel -> {
            return personModel.getName();
        }).collect(Collectors.toList());
        System.out.println("map获取名字方法三： " + list3);
    }

    /**
     * 过滤filter
     */
    public static void filterSex(){
        List<PersonModel> data =getData();
        //old
        List<PersonModel> temp=new ArrayList<>();
        for (PersonModel person:data) {
            if ("男".equals(person.getSex())){
                temp.add(person);
            }
        }
        System.out.println("temp: " + temp);
        //new
        List<PersonModel> collect = data
                .stream()
                .filter(person -> {
                    if("男".equals(person.getSex()) && person.getAge() < 20){
                        return false;
                    }
                    return true;
                })
                .collect(Collectors.toList());
        System.out.println("collect" + collect);
    }

    /**
     * Lambda 表达式
     */
    public static void test1(){
        List<Object> idList = Arrays.asList(new String[]{"1","2","3","4"});
        List<String> stringList = new ArrayList<>();
        System.out.println(idList);
        StringBuffer sql = new StringBuffer();
        for (int i = 0;i < idList.size();i++){
            stringList.add("?");
        }
        sql.append(String.join(",",stringList));
        System.out.println(sql);
    }
    public static void test2(){
        String separator = ",";
        List<String> list = new ArrayList<String>();
        list.add("a");
        list.add("b");
        list.add("c");
        String[] arr = new String[]{"d", "f", "f"};
        // System.out.println("join:" + String.join("-", list));
        list.forEach( e -> {
            System.out.println(e);
        } );
    }

    /**
     * java 8 LocalDateTime
     */
    public static void getCurrentTime(){

        // 获取当前时间:LocalDateTime
        String localDateTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        System.out.println("localDateTime：" +localDateTime);

        // 获取当前时间：SimpleDateFormat
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date();
        System.out.println("sdf:" + sdf.format(date).toString());

        // 获取当前时间：Clock
        Clock clock = Clock.systemUTC();
        System.out.println("clock:" + clock.instant());
    }

}
