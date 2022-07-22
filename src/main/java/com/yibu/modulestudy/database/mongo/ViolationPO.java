package com.yibu.modulestudy.database.mongo;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.Set;


@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Document("violation")
public class ViolationPO {

    private static Logger LOGGER = LoggerFactory.getLogger(ViolationPO.class);


    /**
     * 自主维护id 保持父子类id一致
     */
    @Id
    private String id;

    // --- 数据隔离必要字段 ---
    private String tenantId;

    private String tenantType;

    //@Indexed
    private String organizationId;

    private String organizationName;

    //@Indexed
    private String companyId;

    private String companyName;

    private String enterpriseType;
    // --- 违章类型基础字段 ---

    private String tradeType;

    private Long handlerTime;

    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private Date startHandler;

    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private Date endHandler;

    private String region;

    private String operationType;

    private Integer operationTypeNo;

    //@Indexed
    private String carNumCol;

    private String accessPlatform;

    private String accessPlatformId;

    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private Date receiveTime;

    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    //@Indexed(direction = IndexDirection.DESCENDING)
    private Date startTime;

    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private Date endTime;

    private Integer duration;

    private String startLocation;

    private String endLocation;

    private Integer overdue;

    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private Date overdueTime;

    private String violationStatus;

    //@Indexed(direction = IndexDirection.ASCENDING)
    private Integer violationStatusPriority;

    private String violationType;

    private Integer violationTypeNo;

    private String violationIllustrate;

    private String workOrderId;

    private String historyWorkOrderId;

    private String workOrderStatus;

    private String workOrderType;

    private Long processTime;

//    private GovernancePattern governancePattern;

    private String snapshootRejectId;

    private String type;

//    private List<AlarmPoint> alarmPointList;

//    private List<ParkPoint> parkPoints;

    /**
     * 违章视频集
     */
//    private List<ViolationVideo> violationVideos;

    /**
     * 标记状态
     */
    private String flagStatus;

    @Field
    @Builder.Default
    private Integer violationLevel = 1;

    private Set<String> calcFactoryIDs;

    private String vioCreator;

    private String vioAccessoryUrl;

    private String vioAccessoryName;

    private String vioExplain;

    private String vioSource;

    @Field("limitRate")
    private Integer limitRate;

    /**
     * 【类型：疲劳驾驶】第一个满足报警的定位时间
     */
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date firstAlarmPointTime;

    /**
     * 【类型：疲劳驾驶】行车时间
     */
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date drivingTime;

    /**
     * 【类型：疲劳驾驶】休息车速
     */
    private Integer restSpeed;

    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;


}
