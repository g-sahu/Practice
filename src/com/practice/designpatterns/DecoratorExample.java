package com.practice.designpatterns;

interface I {
    void doIt();
}

class A implements I {
    public void doIt() {
        System.out.print('A');
    }
}

abstract class D implements I {
    private I core;
    public D(I inner) {
        core = inner;
    }

    public void doIt() {
        core.doIt();
    }
}

class X extends D {
    public X(I inner) {
        super(inner);
    }

    public void doIt() {
        super.doIt();
        doX();
    }

    private void doX() {
        System.out.print('X');
    }
}

class Y extends D {
    public Y(I inner) {
        super(inner);
    }

    public void doIt()  {
        super.doIt();
        doY();
    }

    private void doY() {
        System.out.print('Y');
    }
}

class Z extends D {
    public Z(I inner) {
        super(inner);
    }

    public void doIt()  {
        super.doIt();
        doZ();
    }

    private void doZ() {
        System.out.print('Z');
    }
}

public class DecoratorExample {
    public static void main( String[] args ) {
        I[] array = {
                new X(new A()),
                new Y(new X(new A())),
                new Z(new Y(new X(new A())))
        };

        for (I obj : array) {
            obj.doIt();
            System.out.print("  ");
        }
    }
}
