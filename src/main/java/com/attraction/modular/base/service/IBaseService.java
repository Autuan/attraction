package com.attraction.modular.base.service;

import com.attraction.common.exception.CheckException;
import org.apache.commons.lang3.StringUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public interface IBaseService {
    default void checkStrParamNotBlank(String... strs) {
        for(String str :strs) {
            if(StringUtils.isBlank(str)) {
                throw new CheckException("必要参数为空");
            }
        }
    }

    default void checkParamNotNull(Object... objs) {
        for(Object obj :objs) {
            if(null == obj) {
                throw new CheckException("必要参数为空");
            }
        }
    }

    default boolean isHttpStr(String str){
        boolean isurl = false;
        String regex = "(https?|ftp|file)://[-A-Za-z0-9+&@#/%?=~_|!:,.;]+[-A-Za-z0-9+&@#/%=~_|]";
        Pattern pat = Pattern.compile(regex.trim());//比对
        Matcher mat = pat.matcher(str.trim());
        isurl = mat.matches();//判断是否匹配
        if (isurl) {
            isurl = true;
        }
        return isurl;
    }
}
