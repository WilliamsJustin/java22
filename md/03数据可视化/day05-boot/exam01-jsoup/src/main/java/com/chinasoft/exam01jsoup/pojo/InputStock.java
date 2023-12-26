package com.chinasoft.exam01jsoup.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InputStock implements Serializable {
    String strDate;
    Double open;
    Double close;
    Double high;
    Double low;
    Double vol;
}
