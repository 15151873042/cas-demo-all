package client2.controller;

import cn.gotten.common.core.util.DateUtil;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Client2Controller {

    @RequestMapping("/")
    public String index() {
        return String.join(" - ", "client2", "index", DateUtil.getNowTime("yyyy-MM-dd HH:mm:ss"));
    }

    @RequestMapping("/detail")
    public String detail() {
        return String.join(" - ", "client2", "detail", DateUtil.getNowTime("yyyy-MM-dd HH:mm:ss"));
    }
}
