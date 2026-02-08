package com.cxz.set;
public class student {
    private String name;
    private int age;
    public student(String name,int age)
    {
        this.name = name;
        this.age = age;
    }
    public String getName()
    {
        return name;
    }
    public int getAge()
    {
        return age;
    }
    @Override
    public String toString()
    {
        return "name:"+name+" age:"+age;
    }
    //如果希望内容一样的两个对象是相同的需要去重，那么就需要重写equals()和hashCode()方法
    @Override
    public boolean equals(Object obj)
        {
            if(this == obj)
            {
                return true;
            }
            if(obj instanceof student)
            {
                student s = (student)obj;
                return this.name.equals(s.name) && this.age == s.age;
            }
            return false;
        }
        @Override
    public int hashCode()
        {
            return name.hashCode() + age;
        }
}
