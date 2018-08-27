//package com.ks;
//
//import com.ks.dao.InMemoryMessageRepository;
//import com.ks.dao.MessageRepository;
//import com.ks.dto.SbMessage;
//import org.springframework.boot.SpringApplication;
//import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.context.annotation.Bean;
//import org.springframework.core.convert.converter.Converter;
//
///**
// * Title: ${type_name} <br/>
// * <p>
// * Description: <br/>
// *
// * @author jxzhang
// * @DATE 2018年08月27日 15:34
// * @Verdion 1.0 版本
// * ${tags}
// */
//@SpringBootApplication
//public class ThymeleafApplication {
//
//    @Bean
//    public MessageRepository messageRepository() {
//        return new InMemoryMessageRepository();
//    }
//
//    @Bean
//    public Converter<String, SbMessage> messageConverter() {
//        return new Converter<String, SbMessage>() {
//            @Override
//            public SbMessage convert(String id) {
//                return messageRepository().findMessage(Long.valueOf(id));
//            }
//        };
//    }
//
//    public static void main(String[] args) {
//        SpringApplication.run(ThymeleafApplication.class, args);
//    }
//
//}
