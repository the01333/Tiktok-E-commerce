package com.puxinxiaolin.common.enums;

import lombok.Getter;

@Getter
public enum IsDeletedEnum {

    UN_DELETED(0, "未删除"),
    DELETED(1, "已删除"),
    ;

    public int code;

    public String desc;

    IsDeletedEnum(int coed, String desc) {
        this.code = coed;
        this.desc = desc;
    }

    public static IsDeletedEnum getByCode(int code) {
        for (IsDeletedEnum item : IsDeletedEnum.values()) {
            if (item.getCode() == code) {
                return item;
            }
        }
        return null;
    }

}
