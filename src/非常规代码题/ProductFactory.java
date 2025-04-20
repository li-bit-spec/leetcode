package 非常规代码题;

// 规定所有实现它的类得有个use()方法。
interface Product {
    void use();
}

/**
 * @author 李华宪
 * @Description 工厂模式
 * @create 2025-03-17 17:10
 */
//工厂类，负责造Product对象
public class ProductFactory {
    public static Product create(String type) {
        if ("A".equals(type)) {
            return new ProductA();
        } else if ("B".equals(type)) {
            return new ProductB();
        } else {
            throw new IllegalArgumentException("Invalid product type: " + type);
        }
    }

    public static void main(String[] args) {
        Product p1 = ProductFactory.create("A"); // 造ProductA
        p1.use(); // 输出: Using Product A
        Product p2 = ProductFactory.create("B"); // 造ProductB
        p2.use(); // 输出: 用B
    }
}

class ProductA implements Product {
    @Override
    public void use() {
        System.out.println("Using Product A");
    }
}

class ProductB implements Product {
    public void use() {
        System.out.println("Using Product B");
    }
}

