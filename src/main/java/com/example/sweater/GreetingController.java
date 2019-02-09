package com.example.sweater;

import com.example.sweater.domain.Message;
import com.example.sweater.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

@Controller
public class GreetingController {

    @Autowired
    private MessageRepository messageRepository;

    @GetMapping("/greeting")
    public String greeting(
            @RequestParam(name = "name", required = false, defaultValue = "World") String name, Model model) {
        model.addAttribute("name", name);
        return "greeting";
    }

    @GetMapping("/helloing")
    public String helloing(@RequestParam(name = "name", required = false, defaultValue = "Spring")
                                       String name, Map<String, Object> model) {
        model.put("name", name);

        return "helloing";
    }

    @GetMapping("/jpa")
    public String jpa(Map<String, Object> model) {
        Iterable<Message> messages = messageRepository.findAll();
        model.put("messages", messages);

        return "jpa";
    }

    @PostMapping("/jpa")
    public String addMessage(@RequestParam String text, @RequestParam String tags, Map<String, Object> model) {
        Message message = new Message(text, tags);

        messageRepository.save(message);

        Iterable<Message> messages = messageRepository.findAll();

        model.put("messages", messages);

        return "jpa";
    }

    @PostMapping("filter")
    public String filter(@RequestParam String filter, Map<String, Object> model) {
        Iterable<Message> messages;

        if (filter != null && !filter.isEmpty()) {
            messages = messageRepository.findByTags(filter);
        } else {
            messages = messageRepository.findAll();
        }

        model.put("messages", messages);

        return "jpa";
    }
}