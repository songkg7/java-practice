package com.example.javapractice.designpattern.singleton;

/**
 * NOTE: Best Practice!
 * Thread-safety 와 Serialization 이 보장된다.
 * Reflection 을 통한 공격에도 안전하다.
 */
public enum SettingV4 {

    SETTING;

    public static SettingV4 getInstance() {
        return SETTING;
    }

}
