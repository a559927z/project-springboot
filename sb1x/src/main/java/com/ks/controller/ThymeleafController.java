package com.ks.controller;

import com.ks.dao.MessageRepository;
import com.ks.dto.SbMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Title: ${type_name} <br/>
 * <p>
 * Description: <br/>
 *
 * @author jxzhang
 * @DATE 2018年08月24日 17:06
 * @Verdion 1.0 版本
 * ${tags}
 */
@RequestMapping("/thymeleaf")
@Controller
public class ThymeleafController {

//    @Autowired
//    private MessageRepository messageRepository;
//
//    //    @GetMapping(params = "/form")
//    @GetMapping("/form")
//    public String createForm(@ModelAttribute SbMessage message) {
//        return "messages/form";
//    }
//
//
//    /**
//     * localhost:8080/sb1x/thymeleaf/create
//     *
//     * @param message
//     * @param result
//     * @param redirect
//     * @return
//     */
//    @PostMapping("/create")
//    public ModelAndView create(@Valid SbMessage message, BindingResult result,
//                               RedirectAttributes redirect) {
//        if (result.hasErrors()) {
//            return new ModelAndView("messages/form", "formErrors", result.getAllErrors());
//        }
//        message = this.messageRepository.save(message);
//        redirect.addFlashAttribute("globalMessage", "Successfully created a new message");
//        return new ModelAndView("redirect:/{message.id}", "message.id", message.getId());
//    }


    @RequestMapping("/hi")
    public String hello(Locale locale, Model model) {
        model.addAttribute("greeting", "Hello!");

        Date date = new Date();
        DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
        String formattedDate = dateFormat.format(date);
        model.addAttribute("currentTime", formattedDate);

        return "hello";
    }
}

