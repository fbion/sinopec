
package com.sensenets.sinopec;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;


@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = {SinopecApplication.class})
public class SinopecTest {

    private static MockMvc mockMvc;
    
    @Autowired
    private WebApplicationContext wac;
    
 
    
    @Before
    public void init(){
        mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
    }
    
    

}
