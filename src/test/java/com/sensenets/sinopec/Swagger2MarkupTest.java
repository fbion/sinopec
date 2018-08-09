/*
 *
 *  Copyright 2015 the original author or authors.
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 *
 *
 */
package com.sensenets.sinopec;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.io.BufferedWriter;
import java.io.File;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.asciidoctor.Asciidoctor;
import org.asciidoctor.Attributes;
import org.asciidoctor.OptionsBuilder;
import org.asciidoctor.Placement;
import org.asciidoctor.SafeMode;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.sensenets.sinopec.config.SwaggerConfig;


@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@AutoConfigureRestDocs(outputDir = "build/asciidoc/snippets")
@SpringBootTest(classes = {SinopecApplication.class, SwaggerConfig.class})
@AutoConfigureMockMvc
public class Swagger2MarkupTest {

    private static MockMvc mockMvc;
    
    @Autowired
    private WebApplicationContext wac;
    
    @Before
    public void init(){
        mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
    }

    @Test
    public void createSpringfoxSwaggerJson() throws Exception {
        String outputDir = System.getProperty("io.springfox.staticdocs.outputDir");
        MockHttpServletRequestBuilder  builder =  get("/v2/api-docs").accept(MediaType.APPLICATION_JSON);
        MvcResult mvcResult = mockMvc.perform(builder)
                .andExpect(status().isOk())
                .andReturn();

        MockHttpServletResponse response = mvcResult.getResponse();
        String swaggerJson = response.getContentAsString();
        Files.createDirectories(Paths.get(outputDir));
        try (BufferedWriter writer = Files.newBufferedWriter(Paths.get(outputDir, "swagger.json"), StandardCharsets.UTF_8)){
            writer.write(swaggerJson);
        }
        
        Asciidoctor asciidoctor = Asciidoctor.Factory.create();
        Attributes attributes = new Attributes();
        attributes.setCopyCss(true);
        attributes.setLinkCss(false);
        attributes.setSectNumLevels(3);
        attributes.setAnchors(true);
        attributes.setSectionNumbers(true);
        attributes.setHardbreaks(true);
        attributes.setTableOfContents(Placement.LEFT);
        attributes.setAttribute("generated", "generated");
        OptionsBuilder optionsBuilder = OptionsBuilder.options()
                .backend("html5")
                .docType("book")
                .eruby("")
                .inPlace(true)      
                .safe(SafeMode.UNSAFE)
                .attributes(attributes);
        String asciiInputFile = System.getProperty("asciidoctor.input.directory");
        asciidoctor.convertFile(
                new File(asciiInputFile),
                optionsBuilder.get());

    }
    
//    @Test
//    public void addTest() throws Exception {
//        RestDocumentationResultHandler resultHandler = document("add", preprocessResponse(prettyPrint()));
//        mockMvc.perform(post("/test/add").content(createTest())
//                .contentType(MediaType.APPLICATION_JSON))
//                .andDo(resultHandler)
//                .andExpect(status().isOk());
//    }
//
//
//    private String createTest() throws JsonProcessingException {
//        com.sensenets.sinopec.buiness.model.Test test = new com.sensenets.sinopec.buiness.model.Test();
//        test.setId(1L);
//        test.setName("张三");
//        return new Gson().toJson(test);
//    }
    
}
