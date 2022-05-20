package com.example.test.ais;

import java.util.regex.Pattern;

public class AisParser {

    // \s:rORBCOMM000,q:u,c:1643673601*3A\!AIVDM,1,1,,A,1:U7@f?P00trW=5jr4Ta>gwl2@R4,0*10
    private static final Pattern pattern =
            Pattern.compile("!AIVDM,[1-9],[1-9],(\\d?),[0-3A-B],([\\d:;<=>?@A-W`a-w]+),[0-5]\\*[A-F\\d]{2}");

}
