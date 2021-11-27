package com.scx.servicebase.exceptionhandler;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @auther scx
 * @date 2021/7/25 - 8:02
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ScxException extends RuntimeException {
    private Integer code;
    private String msg;
}
