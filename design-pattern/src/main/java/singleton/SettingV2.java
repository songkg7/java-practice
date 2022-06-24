package singleton;

public class SettingV2 {

    private static SettingV2 setting = new SettingV2();

    private SettingV2() {}

    public SettingV2 getInstance() {
        return setting;
    }

}
