





[TOC]



<!--要掌握函数式编程核心思想！-->

# 参考 🔗

🔗 《Java实战（第2版）》ch2p23

🔗 《Java实战（第2版）》ch3p38

🔗  [Java 8 - 函数编程(lambda表达式)](https://pdai.tech/md/java/java8/java8-stream.html#参考资料)

# Lambda



## 行为参数化

行为参数化：一个方法接收多个不同的行为作为参数，以完成特定动作。行为参数化能够更好地适应不断变化的需求，可以减轻工作量。在Java API中就有很多行为参数化的API，比如排序、线程、GUI。

##  要点

- lambda表达式，无名称，有参数，有方法体，有返回值，有异常列表
- lambda表达式，面向接口编程，写更简洁的代码

## 语法

### 表达式

```java
(parameters) -> expression
```

或

```java
(parameters) -> { statements; }
```

示例：

```java
//布尔表达式 
(List<String> list) -> list.isEmpty() 
  
// 创建对象 
() -> new Apple(10) 
  
//消费一个对象
(Apple a) -> { 
 System.out.println(a.getWeight()); 
} 

//从一个对象中选择/抽取
(String s) -> s.length() 
  
// 组合两个值
(int a, int b) -> a * b 
  
// 比较两个对象
(Apple a1, Apple a2) -> 
a1.getWeight().compareTo(a2.getWeight())
```

### 方法引用**

🔗 《Java实战（第2版）》ch3p57 📝 三种构建方法引用的场景。

```java
类名或对象::方法
```

> 方法引用的形态：

![image-20220722171422561](https://tva1.sinaimg.cn/large/e6c9d24ely1h4ftmicdc6j21bi0u00wf.jpg)

> 如何构建方法引用

- 构建指向静态方法的方法引用，如 `Integer::parseInt`
- 构建指向任意类型实例方法的方法引用，如 `String::length`
- 构建指向现存对象或表达式实例方法的方法引用，如 `expensiveTransaction::getValue`



### 构造函数引用**

```Java
ClassName::new
```



## 用法

在哪用？在函数式接口上使用lambda表达式。比如下面这些：

```java
public interface Comparator<T> {
 int compare(T o1, T o2); 
}// java.util.Comparator 

public interface Runnable { 
 void run(); 
} // java.lang.Runnable

public interface ActionListener extends EventListener {
 void actionPerformed(ActionEvent e); 
} // java.awt.event.ActionListener

public interface Callable<V> { 
 V call() throws Exception; 
} // java.util.concurrent.Callable

public interface PrivilegedAction<T> { 
 T run(); 
}// java.security.PrivilegedAction
```

比如：
![image-20220714220233898](https://tva1.sinaimg.cn/large/e6c9d24ely1h46szwbe1sj21620ok0x8.jpg)

## 原理**

理解lambda的关键在于理解：**它的实际类型是什么**

1. 类型检查机制
2. 类型推断机制
3. 局部变量（在栈中）与实例变量（在堆中）在lambda中的差异


Lambda的类型检查机制：

# 流 | Stream

**流，使用声明式处理数据集合。从”实现什么“到”想要完成什么“的编程思维转变。之前，为实现某个功能，我们需要构思实现的子步骤；现在有了流，我们<u>只需要表明我们想要完成什么</u>，剩下的交给Java Stream API去做即可。**

🔗 《Java 实战（第2版）》#使用流进行函数式数据处理（p73）

📝 使代码简洁、易读、灵活、性能好，完整介绍了流的机制。

流与集合区别：前者“边算边存”，后者“先算后存”：

![image-20211208155750136](https://tva1.sinaimg.cn/large/e6c9d24ely1h3w6zq3tf0j212m0oedj9.jpg)

# 使用示例

🔗 [Java8 stream处理List，Map总结](https://juejin.cn/post/6978759656910880798)

🔗 [使用Java Stream，提取集合中的某一列/按条件过滤集合/求和/最大值/最小值/平均值](https://blog.csdn.net/zwwhnly/article/details/108635898)

🔗 [java 8 利用stream针对List集合根据对象属性去重](https://www.jianshu.com/p/b95d96a07258)

[Java8 stream](https://blog.csdn.net/mu_wind/article/details/109516995)

🔗 [Java 8 Map Filter 过滤示例](https://blog.csdn.net/Hatsune_Miku_/article/details/73435607)

🔗 [使用java8的stream（流）将List集合转成Map集合的方法](https://blog.csdn.net/qq_31332819/article/details/107107280)

🔗 [Java lambda list转换map时，把多个参数拼接作为key](https://blog.csdn.net/feiwuguohai/article/details/80533278)

🔗 [java8 toMap(key重复如何解决)](https://blog.csdn.net/qq_32002237/article/details/78580254)

🔗 [按某个属性给集合再次分组](https://blog.csdn.net/weixin_41835612/article/details/83687088)



> 集合元素同属性累加

```java
        HeavyStatusDTO heavyStatusDTO = singleCarHeavyStatusDTOList.stream().collect(Collectors.toMap(HeavyStatusDTO::getCarNumCol, heavy -> heavy, (header, tail) -> {
            header.setDuration(header.getDuration() + tail.getDuration());
            header.setFrequency(header.getFrequency() + tail.getFrequency());
            header.setMileage(header.getMileage() + tail.getMileage());
            return header;
        })).values().stream().findFirst().get();
```



> 根据对象某个字段过滤出新集合

```

```

> 场景：相同属性的对象聚合成一个，并计算部分属性的总和

```

```

> 场景：两个集合按某属性做集合运算。比如差集，参考[这篇](https://blog.csdn.net/weixin_44871934/article/details/103315657?utm_medium=distribute.pc_relevant.none-task-blog-2%7Edefault%7EBlogCommendFromMachineLearnPai2%7Edefault-1.control&depth_1-utm_source=distribute.pc_relevant.none-task-blog-2%7Edefault%7EBlogCommendFromMachineLearnPai2%7Edefault-1.control)

```
List<A> a=...;//A的列表
List<B> b = ..;//B的列表
List<Long> aIds=a.stream().map(A::getaId).collect(Collectors.toList());//id为两个列表相同属性，取出A的list中的id
List<B> newB=b.stream().filter(B ->!aIds.contains(B.getbId())).collect(Collectors.toList());//B列表去除A列表已有的数据
```

String集合运算，参考[这篇](https://blog.csdn.net/Andya_net/article/details/110120001?utm_medium=distribute.pc_relevant.none-task-blog-2%7Edefault%7EBlogCommendFromMachineLearnPai2%7Edefault-11.control&depth_1-utm_source=distribute.pc_relevant.none-task-blog-2%7Edefault%7EBlogCommendFromMachineLearnPai2%7Edefault-11.control)。

> 场景：按时间分组

```java
Map<String, List<Statistics>> map = msgOpenList.stream().collect(Collectors.groupingBy(item -> new SimpleDateFormat("yyyy-MM-dd").format(new Date(item.getOperationTime()))));
```

>  场景：排序

```java
pageList.stream()
        .sorted(Comparator.comparing(StatisticViolationDTO::getOrganizationId))
        .collect(Collectors.toList()
```



> 使用流将集合按指定字符拼接为字符串

```java
    private static String generateLocationsParam(List<String> locations) {
        StringBuilder sb = new StringBuilder();
        for (String location : locations) {
            // 相等
            if (!location.equals(locations.get(locations.size() - 1))) {
                sb.append(location).append("|");
            } else {
                sb.append(location);
            }
        }
        return sb.toString();
    }
```

**流的方式**

```java
locations.stream().filter(Objects::nonNull).collect(Collectors.joining("|"));
```

## List转Map*



> **==过滤Map==**

```java
        Map<String, ProcessVarDTO> sourcesMapByVaribaleKey = sources.stream().collect(Collectors.toMap(ProcessVarDTO::getVariableKey, Function.identity()));


        Map<String, Object> errorMap = verify.entrySet().stream()
                .filter(map -> !sourcesMapByVaribaleKey.containsKey(map.getKey()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
```

> **==将集合按 K-V形式输出==**

```java

// list<object> → map<object:id,object>
    Map<String, LatestLocationPO> orginal2Map =
        originalLocationPOs.stream()
        .collect(Collectors.toMap(LatestLocationPO::getCarNumColor, original -> original));
```

或

```java
// 重复KEY去重
Map<String, ProcessVarDTO> sourcesMapByVaribaleKey = sources.stream().collect(Collectors.toMap(ProcessVarDTO::getVariableKey, Function.identity(),(key1,key2)->key2));
```

> **==将集合按 K-V形式输出 (使用多个字段作为KEY)==**

```java
        Map<String, AddressResult> addressResultMap = addressResultList.stream().filter(addressResult -> ObjectUtils.isNotEmpty(addressResult.getCoordinate()))
        .filter(addressResult -> ObjectUtils.isNotEmpty(addressResult.getCoordinate().getLongitude()) &&
        ObjectUtils.isNotEmpty(addressResult.getCoordinate().getLatitude()))
        .collect(Collectors.toMap(key -> String.format("%s,%s", key.getCoordinate().getLongitude(), key.getCoordinate().getLatitude()) /*自定义KEY*/
        , Function.identity()
        , (key1, key2) -> key2));/*去重*/
```

> toMap key重复问题

```java
        // KEY= coordinate_orgId_opTypeNo_vioTypeNo_vioLevel, VALUE: vioCarNum;
        Map<String, List<VioHeatMapDTO>> coordinateMapVioCarNums = vioHeatMapDTOS.stream()
        .collect(Collectors.toMap(
        /*自定义KEY*/
        key -> String.format("%s_%s_%s_%s_%s"
        , key.getCoordinate(), key.getOrganizationId(), key.getOperationTypeNo(), key.getViolationTypeNo(), key.getViolationLevel()) /*自定义KEY*/
        /*收集违章车辆集*/
        , element -> Lists.newArrayList(element)
        /*新旧集合替换*/
        , (List<VioHeatMapDTO> oldList, List<VioHeatMapDTO> newList) -> {
        oldList.addAll(newList);
        return oldList;
        }
        ));
```





# 流的问题

## 使用.parallelStream

🔗 《Java 实战（第2版）》#并行数据处理与能力（page152）

📝 并行流，最大化发挥多核处理器的作用，让这些核助力高效完成作业。其底层使用的是`ForkJoinPool`，默认使用的线程数=CPU核数。

```java
// 获取CPU核数
Runtime.getRuntime().availableProcessors();
```

<b style="color:red">如何正确使用并行流？</b>

避免“多个线程”混乱读写共享变量，比如说：

```java

```

<b style="color:red">如何高效使用并行流？</b>

以下几点应该多加注意，避免在这些场景里使用并行流：

- 自动装箱和拆箱操作，应考虑使用原始类型流（如 IntStream）
- `.limit()`、`findFirst()`等有次序特点的，不适合用并行流。
- 处理的数据量特别小的时候，不适合用并行流。
- 有些集合结构不适合用并行流，如 LinkedList。

想要高效使用并行流，建议在使用过程中多进行JMH进行基准测试，直观看出使用与否前后的性能是否有较大提升，尔后再做取舍。

<b style="color:red">如何测验并行流的性能？</b>

使用**==Java 微基准套件（Java microbenchmark harness，JMH）==**进行测试，非常建议学习一下这个套件，有助于代码性能的分析。



## 无法使用局部变量

<b style="color:red">为什么流中不能使用局部变量？</b>

![image-20220308153020996](https://tva1.sinaimg.cn/large/e6c9d24ely1h3w6v2eqgmj21m80aqq5o.jpg)

## 更好的实现方式

<b style="color:red">有没有更好的方式实现下列代码段？</b>

![image-20220311141808753](https://tva1.sinaimg.cn/large/e6c9d24ely1h3w6v5ymk0j216s0cwwhd.jpg)

