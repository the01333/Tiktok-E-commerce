package com.puxinxiaolin.common.enums;

import lombok.Getter;

@Getter
public enum ResultCodeEnum {

    SUCCESS(200, "成功"),
    FAIL(500, "失败");

    public final int code;
    public final String desc;

    ResultCodeEnum(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public static ResultCodeEnum getByCode(int code) {
        for (ResultCodeEnum value : ResultCodeEnum.values()) {
            if (value.code == code) {
                return value;
            }
        }
        return null;
    }

}
