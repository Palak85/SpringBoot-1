package com.palak.demo;

class P{
    void m1(){

    }

    void m2(){

    }
}
class c1 extends P{
    void m3(){

    }
}
public class Test {
    c1 c = new c1();
//    c1 a = new P(); // we cannot do this because we cannot store the object of parent class into the child reference
}
