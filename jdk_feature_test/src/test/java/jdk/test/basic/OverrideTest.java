package jdk.test.basic;

import org.junit.Test;

import static org.assertj.core.api.Java6Assertions.assertThat;

public class OverrideTest {

    class A {
        public int v = 10;

        public int getV() {
            return v;
        }
    }

    class B extends A {
        public int v = 20;

        @Override
        public int getV() {
            return v;
        }
    }

    @Test
    public void testValueV() {
        A a = new A();
        assertThat(a.getV()).isEqualTo(10);
        assertThat(a.v).isEqualTo(10);

        B b = new B();
        assertThat(b.getV()).isEqualTo(20);
        assertThat(b.v).isEqualTo(20);  // <--- get B.v

        A aB = new B();
        assertThat(aB.getV()).isEqualTo(20);
        assertThat(aB.v).isEqualTo(10); // <--- get A.v

    }

}
