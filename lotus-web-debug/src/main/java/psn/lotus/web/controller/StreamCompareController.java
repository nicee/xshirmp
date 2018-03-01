package psn.lotus.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @project lotus
 * @time 2018/2/2 16:30
 */
@Controller
@RequestMapping("/collect/compare")
    public class StreamCompareController {

        static final List<String> ints = new ArrayList<>();

    static {
        int total = 10000;
        for (int i = 0; i < total; i++) {
            ints.add("Apple");
            ints.add("Apple2");
            ints.add("Bug");
            ints.add("Bug2");
            ints.add("Couple");
        }
    }

    @ResponseBody
    @RequestMapping(value = "/stream", method = RequestMethod.GET)
    public List<String> doStream() {
        // serial stream
        return ints.stream()
                .filter(i -> i.startsWith("A"))
                .collect(Collectors.toList());
    }

    @ResponseBody
    @RequestMapping(value = "/stream/parallel", method = RequestMethod.GET)
    public List<String> doParallelStream() {
        // parallel stream
        return ints.parallelStream()
                .filter(i -> i.startsWith("A"))
                .collect(Collectors.toList());
    }

    @ResponseBody
    @RequestMapping(value = "/normal", method = RequestMethod.GET)
    public List<String> doNormal() {
        List<String> res2 = new ArrayList<>();
        Iterator<String> iterator = ints.iterator();
        // 普通foreach
        while (iterator.hasNext()) {
            String i = iterator.next();
            if (i.startsWith("A")) {
                res2.add(i);
            }
        }
        return res2;
    }

}
