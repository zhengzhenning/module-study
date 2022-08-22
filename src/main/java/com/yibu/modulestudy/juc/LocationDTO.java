package com.wk.infrastructure.terminaldata.domain.location.dto;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.wk.infrastructure.commonutil.baseutil.domain.VehicleSimpleInfo;
import com.wk.infrastructure.commonutil.baseutil.enums.service.protocol.VehicleProtocolTypeEnum;
import com.wk.infrastructure.commonutil.baseutil.enums.service.vehicle.VehicleNetStatusEnum;
import com.wk.infrastructure.commonutil.baseutil.util.licence.LicencePlateUtil;
import com.wk.infrastructure.commonutil.baseutil.util.licence.LicensePlateNumberUtil;
import com.wk.infrastructure.commonutil.baseutil.util.math.MathUtil;
import com.wk.infrastructure.commonutil.baseutil.util.time.DateUtil;
import com.wk.infrastructure.terminaldata.domain.coordinate.Coordinate;
import com.wk.infrastructure.terminaldata.domain.location.enums.SpeedLimitSourceEnum;
import com.wk.infrastructure.terminaldata.util.enums.AlarmConvertUtils;
import com.wk.infrastructure.terminaldata.util.taxi.TaxiStateUtils;
import com.wk.infrastructure.terminaldata.util.time.MyDateUtils;
import com.wk.infrastructure.terminaldata.util.vehicle.VehicleUtil;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.compress.utils.Lists;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 *
 **/
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@ApiModel("定位DTO")
public class LocationDTO implements Serializable {
    private static final long serialVersionUID = -1692704584755761460L;
    private String _id;
    @ApiModelProperty("车牌号_颜色")
    private String carNumColor;
    @ApiModelProperty("设备卡号（手机sim卡）")
    private String sim;
    /**
     * 车牌号冗余字段，该冗余字段用于满足 SELECT DISTINCT(field)，聚合统计不可用tag做条件
     * 参考 http://zhangqijun.com/influxdb%E6%9F%A5%E8%AF%A2%E5%8E%BB%E9%87%8D/
     */
    @ApiModelProperty("车牌号_颜色（influx聚合不可使用tag,故添加该冗余字段）")
    private String carNumColField;
    @ApiModelProperty("车辆ID")
    private String vehicleId;
    @ApiModelProperty("摄像头数")
    private String cameraNumber;
    @ApiModelProperty("租户ID")
    private String tenantId;
    @ApiModelProperty("地区编号")
    private String organizationId;
    @ApiModelProperty("地区名称")
    private String organizationName;
    @ApiModelProperty("企业编号")
    private String companyId;
    @ApiModelProperty("企业名称")
    private String companyName;
    @ApiModelProperty("运营类型")
    private String operationType;
    @ApiModelProperty("运营类型码值")
    private Integer operationTypeNo;
    @ApiModelProperty("数据来源编号，及所属运营商编号")
    @Builder.Default
    private String dataSource = "0";
    @ApiModelProperty("运营商名称，及所属运营商")
    @Builder.Default
    private String dataSourceName = "运营商";
    @ApiModelProperty("GPS定位时间，格式为:yyyy-MM-dd HH:mm:ss")
    private String gpsDate;
    @ApiModelProperty("GPS定位时间:毫秒级")
    private Long gpsDateMs;
    @ApiModelProperty("设备接收时间，格式为:yyyy-MM-dd HH:mm:ss")
    private String receiveDate;
    @ApiModelProperty("仪表盘速度")
    private Integer recorderSpeed;
    @ApiModelProperty("经度")
    private String longitude;
    @ApiModelProperty("维度")
    private String latitude;
    @ApiModelProperty("冗余字段：经度（float）")
    private Double longitudeF;
    @ApiModelProperty("冗余字段：纬度（float）")
    private Double latitudeF;
    @ApiModelProperty("海拔")
    private Integer height;
    @ApiModelProperty("速度：km/h")
    @Builder.Default
    private Integer speed = 0;
    @ApiModelProperty("行驶方向角度")
    private Integer direction;
    @ApiModelProperty("里程，单位km")
    private Integer mileage;
    @ApiModelProperty("设备报警标识")
    private Long devAlarm;
    @ApiModelProperty("设备报警类型标识集合")
    private List<String> devAlarmIllstrates;
    @ApiModelProperty("车辆报警状态标识集合")
    private List<String> devStatusIllstrates;
    @ApiModelProperty("车辆状态标识")
    private Long devStatus;
    @ApiModelProperty("设备类型")
    private String devType;
    @ApiModelProperty("地区编码")
    private String adcode;
    @ApiModelProperty("地区名称")
    private String adname;
    @ApiModelProperty("车辆归属地（车是挂靠在企业上，所以以企业adcode为准）")
    private String ownerAdcode;
    @ApiModelProperty("平台接收时间，格式为:yyyy-MM-dd HH:mm:ss")
    private String gmtCreate;
    @ApiModelProperty("在线状态，RUNNING：运行，STOPPING：停车，OFFLINE：离线")
    private VehicleNetStatusEnum vehicleStatus;
    @ApiModelProperty("车辆状态优先级（1：运行 2：停车；3离线；4：未入网）")
    private Integer vehicleStatusPriority;
    @ApiModelProperty("车辆运营类型，枚举说明与车辆基本信息一致")
    private String opType;
    @ApiModelProperty("终端设备绑定的类型")
    private List<String> terminalTypes;
    @ApiModelProperty("ACC状态： 0-关 1-开")
    private Integer accStatus;
    @ApiModelProperty("空重状态： 0-重转空 1-空转重")
    private Integer emptyHeavyStatus;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @ApiModelProperty("最近一次速度大于0的定位点")
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
     * 网格坐标点
     */
    private Coordinate reseauCoordinate;

    /**
     * 定位协议
     */
    private VehicleProtocolTypeEnum protocol;

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


    /**
     * 808定位数据封装
     *
     * @param dataJsonObject 卡夫卡消息的JSON格式
     * @param vehicle808     808协议的车辆基本信息
     * @return
     */
    public static LocationDTO generate808Loc(JSONObject dataJsonObject, VehicleSimpleInfo vehicle808) {
        if (dataJsonObject == null || vehicle808 == null) {
            return null;
        }
        JSONObject location808Data = dataJsonObject;
        // 【预处理】日期时间：秒→ yyyy-MM-dd HH:mm:ss
        String gpsDateStr_808 = MyDateUtils.getDate("yyyyMMdd", location808Data.getInteger("gpsDate"), location808Data.getInteger("gpsTime"));
        String receDateStr_808 = MyDateUtils.getDate("yyyyMMdd", location808Data.getInteger("recvDate"), location808Data.getInteger("recvTime"));
        // 【预处理】appendInfoList -> 里程、仪表盘速度
        int mileage = 0;
        int recorderSpeed = 0;
        JSONArray appendInfoList = location808Data.getJSONArray("appendInfoList");
        if (ObjectUtils.isNotEmpty(appendInfoList)) {
            for (int i = 0; i < appendInfoList.size(); i++) {
                JSONObject jsonObject = appendInfoList.getJSONObject(i);
                if (StringUtils.isBlank(jsonObject.getString("strValue"))) {
                    continue;
                }
                // mileage 里程
                if (Integer.valueOf(0x01).equals(jsonObject.getInteger("type"))) {
                    mileage = Integer.parseInt(jsonObject.getString("strValue"), 16);
                }
                // recorder speed 仪表盘速度
                if (Integer.valueOf(0x03).equals(jsonObject.getInteger("type"))) {
                    recorderSpeed = Integer.parseInt(jsonObject.getString("strValue"), 16);
                }
            }
        }
        // 【封装】* 该阶段只封装从PaaS平台来的数据
        LocationDTO location808DTO = LocationDTO.builder()
                .isFill(Boolean.FALSE)
                // 设备卡号
                .sim(location808Data.getString("sim"))
                // 车牌颜色
                .carNumColor(vehicle808.getLicenceNumber() + "_" + vehicle808.getLicenceColor()).carNumColField(vehicle808.getLicenceNumber() + "_" + vehicle808.getLicenceColor())
                // 定位协议
                .protocol(vehicle808.getProtocolType())
                // gps卫星时间
                .gpsDate(gpsDateStr_808)
                .gpsDateMs(DateUtil.getDate(gpsDateStr_808, DateUtil.simple).getTime())
                // 系统接收时间
                .receiveDate(receDateStr_808)
                // 定位实例创建时间
                .gmtCreate(DateUtil.getDate(new Date(), DateUtil.simple))
                // 经纬度
                .latitude(String.valueOf(location808Data.getInteger("latitude")))
                .longitude(String.valueOf(location808Data.getInteger("longitude")))
                .longitudeF(MathUtil.divide(Float.valueOf(location808Data.getString("latitude")), 1, 6))
                .latitudeF(MathUtil.divide(Float.valueOf(location808Data.getString("longitude")), 1, 6))
                // 高度
                .height(location808Data.getInteger("height"))
                // 设备报警
                .devAlarm(location808Data.getLong("devAlarm"))
                // 设备状态
                .devStatus(location808Data.getLong("devStatus"))
                // 速度
                .speed(location808Data.getInteger("speed") * 1 / 10)
                // 角度
                .direction(location808Data.getInteger("direction"))
                // 里程
                .mileage(mileage)
                // 仪表盘速度
                .recorderSpeed(recorderSpeed)
                .build();
        return location808DTO;
    }

    /**
     * 809 定位数据
     *
     * @param dataJsonObject 卡夫卡消息JSON格式
     * @param vehicleDTO     809车辆基本
     * @return
     */
    public static LocationDTO generate809Loc(JSONObject dataJsonObject, VehicleSimpleInfo vehicleDTO) {
        // 处理日期时间：秒→ yyyy-MM-dd HH:mm:ss
        JSONObject gnssData = dataJsonObject.getJSONObject("gnssData");
        String gpsDateStr_809 = MyDateUtils.getDate("yyyyMMdd", gnssData.getInteger("gpsDate"), gnssData.getInteger("gpsTime"));
        String receDateStr_809 = MyDateUtils.getDate("yyyyMMdd", dataJsonObject.getInteger("recvDate"), dataJsonObject.getInteger("recvTime"));
        if (StringUtils.isBlank(gpsDateStr_809) || !LicensePlateNumberUtil.checkPlateNumberFormat(dataJsonObject.getString("licensePlate"))) {
            return null;
        }
        LocationDTO locationDTO_809 = LocationDTO.builder()
                .isFill(Boolean.FALSE)
                // 车辆协议
                .protocol(vehicleDTO.getProtocolType())
                .carNumColor(dataJsonObject.getString("licensePlate") +
                        "_" + LicencePlateUtil.convert2PlateColor(dataJsonObject.getInteger("plateColor")))
                // 该冗余字段用于满足 SELECT DISTINCT(field)，聚合统计不可用tag做条件
                .carNumColField(dataJsonObject.getString("licensePlate") +
                        "_" + LicencePlateUtil.convert2PlateColor(dataJsonObject.getInteger("plateColor")))
                .dataSource(dataJsonObject.getString("gnssCenterId"))
                .gpsDate(gpsDateStr_809)
                .gpsDateMs(DateUtil.getDate(gpsDateStr_809, DateUtil.simple).getTime())
                .receiveDate(receDateStr_809)
                .recorderSpeed(gnssData.getInteger("recorderSpeed"))
                .longitude(gnssData.getString("lon"))
                .latitude(gnssData.getString("lat"))
                .longitudeF(MathUtil.divide(Float.valueOf(gnssData.getString("lon")), 1, 6))
                .latitudeF(MathUtil.divide(Float.valueOf(gnssData.getString("lat")), 1, 6))
                .height(gnssData.getInteger("altitude"))
                .speed(gnssData.getInteger("gpsSpeed"))
                .direction(gnssData.getInteger("direction"))
                .mileage(gnssData.getInteger("mileage"))
                .devAlarm(gnssData.getLong("alarm"))
                .devStatus(gnssData.getLong("state"))
                .gmtCreate(DateUtil.getSimpleDate(new Date()))
                .build();
        return locationDTO_809;
    }


    public List<String> getDevAlarmIllstrates() {
        return devAlarmIllstrates;
    }

    public void setDevAlarmIllstrates(Long num) {
        this.devAlarmIllstrates = AlarmConvertUtils.convertAlarmType(num);
    }

    public List<String> getDevStatusIllstrates() {
        return devStatusIllstrates;
    }

    public void setDevStatusIllstrates(Long num) {
        VehicleSimpleInfo vehicleFromCache = VehicleUtil.getVehicleFromCache(this.getCarNumColor());
        if (ObjectUtils.isNotEmpty(vehicleFromCache)) {
            if (VehicleProtocolTypeEnum.P_905.equals(vehicleFromCache.getProtocolType())) {
                this.devStatusIllstrates = TaxiStateUtils.getDescs(num.intValue());
            } else {
                this.devStatusIllstrates = AlarmConvertUtils.convertAlarmStatus(num);
            }
        } else {
            this.devStatusIllstrates = AlarmConvertUtils.convertAlarmStatus(num);
        }
    }

    /**
     * 定位时间需要在前7天以内，或者未来10分钟以内
     */
    public boolean legalCheckTime() {
        if (StringUtils.isBlank(this.gpsDate)) {
            return false;
        }
        Date gmtDate = DateUtil.getDate(this.gpsDate);
        long diffMin = DateUtil.diffMin(gmtDate, new Date());
        return diffMin >= -7 * 24 * 60 && diffMin <= 24 * 60;
    }

    /**
     * 校验定位点是否合法
     *
     * @return
     */
    public boolean validateCoordinate() {
        try {
            Coordinate coordinate = Coordinate.builder().latitude(Double.parseDouble(this.latitude))
                    .longitude(Double.parseDouble(this.longitude)).build();
            return coordinate.validate() && !coordinate.outOfChina();
        } catch (NumberFormatException e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * @param locs 定位集
     * @return
     * @implSpec 过滤掉有定位，但报警状态位为0的定位
     * 报警状态为：0：未定位；1：定位
     * 过滤掉数值为0的定位（二进制）
     */
    public static List<LocationDTO> filterLocNotZero(List<LocationDTO> locs) {
        if (CollectionUtils.isEmpty(locs)) {
            return null;
        }
        // 从0开始，第1位：标识是否有定位
        List<LocationDTO> illegalLocations = locs.stream().filter(loc -> !VehicleProtocolTypeEnum.P_905.equals(loc.getProtocol()))
                .filter(loc -> Integer.valueOf(0).equals(AlarmConvertUtils.getAlarmStatusBin(loc.getDevStatus(), 1)))
                .collect(Collectors.toList());
        // 移除非905的未定位数据
        locs.removeAll(illegalLocations);

        return Optional.ofNullable(locs).orElse(Lists.newArrayList());
    }


}
