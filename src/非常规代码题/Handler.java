package 非常规代码题;

/**
 * @author 李华宪
 * @Description
 * @create 2025-03-17 17:38
 */
abstract class Handler {
    protected Handler next;

    public void setNext(Handler next) {
        this.next = next;
    }

    abstract void handle(int request);
}

class HandlerA extends Handler {
    void handle(int request) {
        if (request < 10)
            System.out.println("A处理");
        else
            next.handle(request);
    }
}

class HandlerB extends Handler {
    void handle(int request) {
        if (request < 20)
            System.out.println("B处理");
        else
            next.handle(request);
    }
}
// Handler a = new HandlerA();
// Handler b = new HandlerB();
// a.setNext(b);
// a.handle(15);
