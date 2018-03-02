package psn.lotus.web.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import psn.lotus.web.support.jsonbean.CustomInnerBean;
import psn.lotus.web.support.jsonbean.ParameterizedBean;

import java.lang.reflect.Type;
import java.util.List;

/**
 * @project lotus
 * @time 2018/1/30 15:02
 */
@Controller
@RequestMapping("/json/compare")
public class JsonCompareController {

    private static final Logger logger = LoggerFactory.getLogger(JumpController.class);

    private static final String json = "{\"name\": \"just name\", \"age\": 10, \"sex\": \"man\", " +
            "\"value\": [{\"name\": \"n1\", \"label\": \"l1\"}, {\"name\": \"n2\", \"label\": \"l2\"}]}";

    private static String bigJsonList;

    {
        int max = 400;
        StringBuilder builder = new StringBuilder();
        builder.append("[");
        for (int i = 0; i < max; i++) {
            builder.append(json);
            if (i != max - 1) {
                builder.append(",");
            }
        }
        builder.append("]");
        bigJsonList = builder.toString();
    }

    private static final Gson gson = new Gson();

    @ResponseBody
    @RequestMapping(value = "/gson", method = RequestMethod.GET)
    public Object gson() {
        Type type = new TypeToken<ParameterizedBean<CustomInnerBean>>() {}.getType();
        return gson.fromJson(json, type);
    }

    @ResponseBody
    @RequestMapping(value = "/gson/list", method = RequestMethod.GET)
    public List<Object> gson4list() {
        Type type = new TypeToken<List<ParameterizedBean<CustomInnerBean>>>() {}.getType();
        return gson.fromJson(bigJsonList, type);
    }

    @ResponseBody
    @RequestMapping(value = "/fastjson", method = RequestMethod.GET)
    public Object fastjson() {
        Type type = new TypeReference<ParameterizedBean<CustomInnerBean>>() {}.getType();
        return JSONObject.parseObject(json, type);
    }

    @ResponseBody
    @RequestMapping(value = "/fastjson/list", method = RequestMethod.GET)
    public List<ParameterizedBean> fastjson4list() {
        return JSONArray.parseArray(bigJsonList, ParameterizedBean.class);
    }

    @ResponseBody
    @RequestMapping(value = "/fastjson/list2", method = RequestMethod.GET)
    public List<Object> fastjson4list2() {
        Type type = new TypeReference<List<ParameterizedBean<CustomInnerBean>>>() {}.getType();
        Type[] types = new Type[]{type};
        return JSONArray.parseArray(bigJsonList, new Type[]{type});
    }

}
