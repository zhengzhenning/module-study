package com.yibu.modulestudy.juc;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 *
 **/
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class LocationDTO implements Serializable {
    private static final long serialVersionUID = -1692704584755761460L;
    private String _id;
    private String carNumColor;
    private String sim;
    /**
     * 车牌号冗余字段，该冗余字段用于满足 SELECT DISTINCT(field)，聚合统计不可用tag做条件
     * 参考 http://zhangqijun.com/influxdb%E6%9F%A5%E8%AF%A2%E5%8E%BB%E9%87%8D/
     */
    private String carNumColField;
    private String vehicleId;
    private String cameraNumber;
    private String tenantId;
    private String organizationId;
    private String organizationName;
    private String companyId;
    private String companyName;
    private String operationType;
    private Integer operationTypeNo;
    @Builder.Default
    private String dataSource = "0";
    @Builder.Default
    private String dataSourceName = "运营商";
    private String gpsDate;
    private Long gpsDateMs;
    private String receiveDate;
    private Integer recorderSpeed;
    private String longitude;
    private String latitude;
    private Double longitudeF;
    private Double latitudeF;
    private Integer height;
    @Builder.Default
    private Integer speed = 0;
    private Integer direction;
    private Integer mileage;
    private Long devAlarm;
    private List<String> devAlarmIllstrates;
    private List<String> devStatusIllstrates;
    private Long devStatus;
    private String devType;
    private String adcode;
    private String adname;
    private String ownerAdcode;
    private String gmtCreate;
    private Integer vehicleStatusPriority;
    private String opType;
    private List<String> terminalTypes;
    private Integer accStatus;
    private Integer emptyHeavyStatus;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date recentlySpeedGt0Time;

    /**
     * 定位归属省份
     */
    private String provinceAdcode;
    /**
     * 网格编号
     */
    @Builder.Default
    private String reseauId = "0";


    /**
     * 是否为补传点
     */
    private Boolean isFill;

    /**
     * 限速值，若为0则表示速度未获取，或获取限速值失败
     */
    private Double speedLimit;
    /**
     * 限速值，来源
     */
    private String speedLimitSource;

    /**
     * 异常类型（空字符表示非异常点）
     */
    private String abnormalType;


}
