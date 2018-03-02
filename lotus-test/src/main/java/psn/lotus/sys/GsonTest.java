package psn.lotus.sys;

import com.google.gson.Gson;
import org.junit.Test;

import java.util.List;

/**
 * @project lotus
 * @time 2018/1/12 13:40
 */
public class GsonTest {

    @Test
    public void test() {
        String jsonStr = "[{\"names\":\"A\"},{\"names\":\"B\"},{\"names\":\"C\"}]";
        Gson gson = new Gson();
        List<BeanA> beans = gson.fromJson(jsonStr, List.class);
        System.out.println("dsdas");
        System.out.println(jsonStr);
    }

    class BeanA {

        private BeanB inst;

        public BeanB getInst() {
            return inst;
        }

        public void setInst(BeanB inst) {
            this.inst = inst;
        }
    }

    class BeanB {

        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

}
