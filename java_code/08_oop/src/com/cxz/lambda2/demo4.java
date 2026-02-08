package com.cxz.lambda2;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
public class demo4 {
    public static void main(String[] args) {
        carfactory factory = new carfactory() {
            @Override
            public car getCar(String name) {
                return new car(name);
            }
        };
        carfactory factory1 = name -> new car(name);
        carfactory factory2 = car::new;
        car c1 = factory.getCar("BMW");
        System.out.println(c1.getName());
    }
}
@Data
@AllArgsConstructor
@NoArgsConstructor
class car{
    private String name;
}
interface carfactory{
    car getCar(String name);
}