package com.cxz.proxy;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Star implements StarService{
    private String name;
    @Override
    public void sing(String singname) {
        System.out.println(name + "正在唱歌，唱的是"+ singname);
    }
    @Override
    public String dance() {
        System.out.println(name+"正在跳舞...");
        return "跳完了哈哈哈哈";
    }
}
