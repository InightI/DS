class ParentException extends Exception {}
class ChildException extends ParentException {}

class Parent {
    public void method() throws ParentException {
    }
}

class Child extends Parent {
    @Override
    public void method() throws ParentException {
        throw new ChildException();
    }
}

public class OverrideDemo {
    public static void main(String[] args) throws ParentException {
        Parent p = new Child();
        p.method();
    }
}

interface A {
    default void method() {
    }
}
