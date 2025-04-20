package 非常规代码题;

/**
 * @author 李华宪
 * @Description
 * @create 2025-03-17 17:41
 */
abstract class Template {
    void run() {
        step1();
        step2();
    }

    void step1() {
        System.out.println("通用步骤1");
    }

    abstract void step2();
}

class Concrete extends Template {
    void step2() {
        System.out.println("具体步骤2");
    }
}
// Template t = new Concrete();
// t.run();
