package com.example.javapractice.designpattern.singleton;

public class SettingV1 {

    private static SettingV1 setting;

    private SettingV1() {}

    public SettingV1 getInstance() {
        if (setting == null) {
            return new SettingV1();
        }
        return setting;
    }

}
