package com.cxz.singlestance;

public class b {
    private static b instance;
    private b()
    {
    }
    public static b getInstance()
    {
        if(instance == null)
        {
            instance = new b();
        }
        return instance;
    }
}
