package com.yibu.modulestudy.tools;

import cn.hutool.core.util.IdcardUtil;
import com.yibu.modulestudy.ModuleStudyApplication;
import org.assertj.core.api.Assertions;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

@SpringBootTest(classes = {ModuleStudyApplication.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class HuToolTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    /**
     * TODO 可以结合 http://www.ip33.com/shenfenzheng.html 进行双向比对
     */
    @Test
    public  void 测试身份证校验_01(){
        String idCardNum="14052219841209008X";
        boolean validCard = IdcardUtil.isValidCard(idCardNum);
        Assertions.assertThat(validCard).isTrue();
    }


    @Test
    public void 测试身份证校验() {

        // 15位
        String idCardNumIs15="350424870506202";
        boolean numsIs15 = IdcardUtil.isValidCard(idCardNumIs15);
        Assertions.assertThat(numsIs15).isTrue();

        // 错误的位数
        String idCardErrorNums="35030119961303003089";
        boolean errorNums = IdcardUtil.isValidCard(idCardErrorNums);
        Assertions.assertThat(errorNums).isFalse();

        // 错误生日的
        String idCardErrorBirth="350301199613030030";
        boolean errorBirth = IdcardUtil.isValidCard(idCardErrorBirth);
        Assertions.assertThat(errorBirth).isFalse();

        // 正确的
        String idCard="350301199606030030";
        boolean yes = IdcardUtil.isValidCard(idCard);
        Assertions.assertThat(yes).isTrue();
    }
}