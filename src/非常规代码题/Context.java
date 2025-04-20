package 非常规代码题;

interface Strategy {
    void execute();
}

/**
 * @author 李华宪
 * @Description
 * @create 2025-03-17 17:32
 */
public class Context {

    private Strategy strategy;

    public Context(Strategy strategy) {
        this.strategy = strategy;
    }

    public void run() {
        strategy.execute();
    }
}

class StrategyA implements Strategy {
    @Override
    public void execute() {
        System.out.println("This is Strategy A");
    }
}

class StrategyB implements Strategy {
    @Override
    public void execute() {
        System.out.println("This is Strategy B");
    }
}
//Context c = new Context();
//c.setStrategy(new StrategyA());
//c.run();
