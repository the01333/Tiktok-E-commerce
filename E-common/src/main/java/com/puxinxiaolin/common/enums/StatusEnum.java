package com.puxinxiaolin.common.enums;

import lombok.Getter;

@Getter
public enum StatusEnum {

    OPEN(0, "启用"),
    CLOSE(1, "禁用"),
    ;

    public int code;

    public String desc;

    StatusEnum(int coed, String desc) {
        this.code = coed;
        this.desc = desc;
    }

    public static StatusEnum getByCode(int code) {
        for (StatusEnum item : StatusEnum.values()) {
            if (item.getCode() == code) {
                return item;
            }
        }
        return null;
    }

}
