package web.framework.service.base.provider;

import web.framework.java.base.BaseService;

public class BaseServiceImpl implements BaseService {

    @Override
    public String demo(String name) {
        return "Hello " + name;
    }

}
