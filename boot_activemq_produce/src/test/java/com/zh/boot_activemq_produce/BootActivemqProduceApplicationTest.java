package com.zh.boot_activemq_produce;

import com.zh.boot_activemq_produce.produce.produceQueue;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;


@SpringBootTest(classes = BootActivemqProduceApplication.class)
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
class BootActivemqProduceApplicationTest {
    @Autowired
    private produceQueue queue;

    @Test
    public void sendMsgTest(){
        queue.produceMsg();
    }
}