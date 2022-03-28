package client1.controller;

import cn.gotten.common.core.util.DateUtil;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Client1Controller {

    @RequestMapping("/")
    public String index() {
        return String.join(" - ", "client1", "index", DateUtil.getNowTime("yyyy-MM-dd HH:mm:ss"));
    }

    @RequestMapping("/detail")
    public String detail() {
        return String.join(" - ", "client1", "detail", DateUtil.getNowTime("yyyy-MM-dd HH:mm:ss"));
    }
}
