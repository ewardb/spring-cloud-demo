package org.wq.demo.springclouddemo.io;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

/**
 * @author wangqiang26
 * @mail wangqiang26@jd.com
 * @Date 19:40 2018/11/20
 */
public enum Calculator {

    Instance;
    private final static ScriptEngine jse = new ScriptEngineManager().getEngineByName("JavaScript");
    public Object cal(String expression) throws ScriptException {
        return jse.eval(expression);
    }



}
