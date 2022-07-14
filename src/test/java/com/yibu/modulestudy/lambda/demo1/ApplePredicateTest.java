package com.yibu.modulestudy.lambda.demo1;

import com.google.common.collect.Lists;
import com.yibu.modulestudy.ModuleStudyApplication;
import com.yibu.modulestudy.lambda.demo2.Car;
import com.yibu.modulestudy.lambda.demo2.Predicate;
import org.assertj.core.api.Assertions;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.net.CacheRequest;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest(classes = {ModuleStudyApplication.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class ApplePredicateTest {

    private final static Logger log = LoggerFactory.getLogger(ApplePredicateTest.class);

    @Test
    public void test04() {
        List<Car> filterCars = this.filterT(mockCars(), (Car car) -> car.getWeight() > 50);
        Assertions.assertThat(filterCars).hasSize(1);
    }

    @Test
    public void test03() {
        List<Apple> filterWeight = this.filter(mockApples(), (Apple apple) -> apple.getWeight() > 100);
//        Assertions.assertThat(filterWeight).hasSize(5);
        Assertions.assertThat(filterWeight).hasSize(4);
    }

    /**
     * 使用匿名内部类的方式自定义行为
     */
    @Test
    public void test02() {
        List<Apple> apples = mockApples();
        List<Apple> filterWeightGt600 = this.filter(apples, new ApplePredicate() {
            @Override
            public boolean test(Apple apple) {
                return apple.getWeight() > 600;
            }
        });
        // 不符预期
//        Assertions.assertThat(filterWeightGt600).hasSize(2);
        // 符合预期
        Assertions.assertThat(filterWeightGt600).hasSize(1);
    }

    @Test
    public void test01() {

        // 获取假数据
        List<Apple> apples = mockApples();

        // 4个绿苹果
        List<Apple> filterGreen = this.filter(apples, new AppleGreenColorPredicate());
        Assertions.assertThat(filterGreen).hasSize(4);

        // 3个重量大于150的苹果
        List<Apple> filterHeavy = this.filter(apples, new AppleHeavyWeightPredicate());
        Assertions.assertThat(filterHeavy).hasSize(3);

    }

    private List<Apple> mockApples() {
        Apple apple3 = Apple.builder().color("绿色").weight(29).build();
        Apple apple = Apple.builder().color("绿色").weight(78).build();
        Apple apple1 = Apple.builder().color("绿色").weight(98).build();
        Apple apple6 = Apple.builder().color("红色").weight(128).build();
        Apple apple2 = Apple.builder().color("绿色").weight(156).build();
        Apple apple7 = Apple.builder().color("红色").weight(156).build();
        Apple apple4 = Apple.builder().color("红色").weight(689).build();
        ArrayList<Apple> apples = Lists.newArrayList(apple, apple1, apple2, apple3, apple4, apple6, apple7);
        return apples;
    }

    private List<Car> mockCars() {
        Car 奔驰 = Car.builder().name("奔驰").weight(50).build();
        Car 宝马 = Car.builder().name("宝马").weight(35).build();
        Car 大众 = Car.builder().name("大众").weight(45).build();
        Car 五菱宏光 = Car.builder().name("五菱宏光").weight(80).build();
        Car 别克 = Car.builder().name("别克").weight(70).build();
        Car 丰田 = Car.builder().name("丰田").weight(40).build();
        List<Car> cars = Lists.newArrayList(奔驰, 宝马, 大众, 五菱宏光, 别克, 丰田);
        return cars;
    }

    private List<Apple> filter(List<Apple> apples, ApplePredicate applePredicate) {
        List<@Nullable Apple> result = Lists.newArrayList();
        for (Apple apple : apples) {
            if (applePredicate.test(apple)) {
                result.add(apple);
            }
        }
        return result;
    }


    /**
     * 一般化处理
     *
     * @param t
     * @param predicate
     * @param <T>
     * @return
     */
    private <T> List<T> filterT(List<T> t, Predicate<T> predicate) {
        ArrayList<@Nullable T> result = Lists.newArrayList();
        for (T t1 : t) {
            if (predicate.test(t1)) {
                result.add(t1);
            }
        }
        return result;
    }

}