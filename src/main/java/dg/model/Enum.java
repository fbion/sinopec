// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: enum.proto

package dg.model;

public final class Enum {
  private Enum() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  /**
   * Protobuf enum {@code dg.model.TaskStatus}
   */
  public enum TaskStatus
      implements com.google.protobuf.ProtocolMessageEnum {
    /**
     * <code>Task_Status_Unknown = 0;</code>
     */
    Task_Status_Unknown(0),
    /**
     * <code>Task_Status_Created = 1;</code>
     */
    Task_Status_Created(1),
    /**
     * <code>Task_Status_Processing = 2;</code>
     */
    Task_Status_Processing(2),
    /**
     * <code>Task_Status_Finished = 3;</code>
     */
    Task_Status_Finished(3),
    /**
     * <code>Task_Status_Deleted = 4;</code>
     */
    Task_Status_Deleted(4),
    /**
     * <code>Task_Status_Outdate = 5;</code>
     */
    Task_Status_Outdate(5),
    /**
     * <code>Task_Status_Paused = 6;</code>
     */
    Task_Status_Paused(6),
    /**
     * <code>Task_Status_Stopped = 7;</code>
     */
    Task_Status_Stopped(7),
    UNRECOGNIZED(-1),
    ;

    /**
     * <code>Task_Status_Unknown = 0;</code>
     */
    public static final int Task_Status_Unknown_VALUE = 0;
    /**
     * <code>Task_Status_Created = 1;</code>
     */
    public static final int Task_Status_Created_VALUE = 1;
    /**
     * <code>Task_Status_Processing = 2;</code>
     */
    public static final int Task_Status_Processing_VALUE = 2;
    /**
     * <code>Task_Status_Finished = 3;</code>
     */
    public static final int Task_Status_Finished_VALUE = 3;
    /**
     * <code>Task_Status_Deleted = 4;</code>
     */
    public static final int Task_Status_Deleted_VALUE = 4;
    /**
     * <code>Task_Status_Outdate = 5;</code>
     */
    public static final int Task_Status_Outdate_VALUE = 5;
    /**
     * <code>Task_Status_Paused = 6;</code>
     */
    public static final int Task_Status_Paused_VALUE = 6;
    /**
     * <code>Task_Status_Stopped = 7;</code>
     */
    public static final int Task_Status_Stopped_VALUE = 7;


    public final int getNumber() {
      if (this == UNRECOGNIZED) {
        throw new java.lang.IllegalArgumentException(
            "Can't get the number of an unknown enum value.");
      }
      return value;
    }

    /**
     * @deprecated Use {@link #forNumber(int)} instead.
     */
    @java.lang.Deprecated
    public static TaskStatus valueOf(int value) {
      return forNumber(value);
    }

    public static TaskStatus forNumber(int value) {
      switch (value) {
        case 0: return Task_Status_Unknown;
        case 1: return Task_Status_Created;
        case 2: return Task_Status_Processing;
        case 3: return Task_Status_Finished;
        case 4: return Task_Status_Deleted;
        case 5: return Task_Status_Outdate;
        case 6: return Task_Status_Paused;
        case 7: return Task_Status_Stopped;
        default: return null;
      }
    }

    public static com.google.protobuf.Internal.EnumLiteMap<TaskStatus>
        internalGetValueMap() {
      return internalValueMap;
    }
    private static final com.google.protobuf.Internal.EnumLiteMap<
        TaskStatus> internalValueMap =
          new com.google.protobuf.Internal.EnumLiteMap<TaskStatus>() {
            public TaskStatus findValueByNumber(int number) {
              return TaskStatus.forNumber(number);
            }
          };

    public final com.google.protobuf.Descriptors.EnumValueDescriptor
        getValueDescriptor() {
      return getDescriptor().getValues().get(ordinal());
    }
    public final com.google.protobuf.Descriptors.EnumDescriptor
        getDescriptorForType() {
      return getDescriptor();
    }
    public static final com.google.protobuf.Descriptors.EnumDescriptor
        getDescriptor() {
      return dg.model.Enum.getDescriptor().getEnumTypes().get(0);
    }

    private static final TaskStatus[] VALUES = values();

    public static TaskStatus valueOf(
        com.google.protobuf.Descriptors.EnumValueDescriptor desc) {
      if (desc.getType() != getDescriptor()) {
        throw new java.lang.IllegalArgumentException(
          "EnumValueDescriptor is not for this type.");
      }
      if (desc.getIndex() == -1) {
        return UNRECOGNIZED;
      }
      return VALUES[desc.getIndex()];
    }

    private final int value;

    private TaskStatus(int value) {
      this.value = value;
    }

    // @@protoc_insertion_point(enum_scope:dg.model.TaskStatus)
  }

  /**
   * Protobuf enum {@code dg.model.SwitcherStatus}
   */
  public enum SwitcherStatus
      implements com.google.protobuf.ProtocolMessageEnum {
    /**
     * <code>Switcher_Status_Unknown = 0;</code>
     */
    Switcher_Status_Unknown(0),
    /**
     * <code>Switcher_Status_Started = 1;</code>
     */
    Switcher_Status_Started(1),
    /**
     * <code>Switcher_Status_Stopped = 2;</code>
     */
    Switcher_Status_Stopped(2),
    /**
     * <code>Switcher_Status_Paused = 3;</code>
     */
    Switcher_Status_Paused(3),
    UNRECOGNIZED(-1),
    ;

    /**
     * <code>Switcher_Status_Unknown = 0;</code>
     */
    public static final int Switcher_Status_Unknown_VALUE = 0;
    /**
     * <code>Switcher_Status_Started = 1;</code>
     */
    public static final int Switcher_Status_Started_VALUE = 1;
    /**
     * <code>Switcher_Status_Stopped = 2;</code>
     */
    public static final int Switcher_Status_Stopped_VALUE = 2;
    /**
     * <code>Switcher_Status_Paused = 3;</code>
     */
    public static final int Switcher_Status_Paused_VALUE = 3;


    public final int getNumber() {
      if (this == UNRECOGNIZED) {
        throw new java.lang.IllegalArgumentException(
            "Can't get the number of an unknown enum value.");
      }
      return value;
    }

    /**
     * @deprecated Use {@link #forNumber(int)} instead.
     */
    @java.lang.Deprecated
    public static SwitcherStatus valueOf(int value) {
      return forNumber(value);
    }

    public static SwitcherStatus forNumber(int value) {
      switch (value) {
        case 0: return Switcher_Status_Unknown;
        case 1: return Switcher_Status_Started;
        case 2: return Switcher_Status_Stopped;
        case 3: return Switcher_Status_Paused;
        default: return null;
      }
    }

    public static com.google.protobuf.Internal.EnumLiteMap<SwitcherStatus>
        internalGetValueMap() {
      return internalValueMap;
    }
    private static final com.google.protobuf.Internal.EnumLiteMap<
        SwitcherStatus> internalValueMap =
          new com.google.protobuf.Internal.EnumLiteMap<SwitcherStatus>() {
            public SwitcherStatus findValueByNumber(int number) {
              return SwitcherStatus.forNumber(number);
            }
          };

    public final com.google.protobuf.Descriptors.EnumValueDescriptor
        getValueDescriptor() {
      return getDescriptor().getValues().get(ordinal());
    }
    public final com.google.protobuf.Descriptors.EnumDescriptor
        getDescriptorForType() {
      return getDescriptor();
    }
    public static final com.google.protobuf.Descriptors.EnumDescriptor
        getDescriptor() {
      return dg.model.Enum.getDescriptor().getEnumTypes().get(1);
    }

    private static final SwitcherStatus[] VALUES = values();

    public static SwitcherStatus valueOf(
        com.google.protobuf.Descriptors.EnumValueDescriptor desc) {
      if (desc.getType() != getDescriptor()) {
        throw new java.lang.IllegalArgumentException(
          "EnumValueDescriptor is not for this type.");
      }
      if (desc.getIndex() == -1) {
        return UNRECOGNIZED;
      }
      return VALUES[desc.getIndex()];
    }

    private final int value;

    private SwitcherStatus(int value) {
      this.value = value;
    }

    // @@protoc_insertion_point(enum_scope:dg.model.SwitcherStatus)
  }

  /**
   * Protobuf enum {@code dg.model.CutboardType}
   */
  public enum CutboardType
      implements com.google.protobuf.ProtocolMessageEnum {
    /**
     * <code>CUTBOARD_TYPE_UNKNOWN = 0;</code>
     */
    CUTBOARD_TYPE_UNKNOWN(0),
    /**
     * <code>CUTBOARD_TYPE_VEHICLE = 1;</code>
     */
    CUTBOARD_TYPE_VEHICLE(1),
    /**
     * <code>CUTBOARD_TYPE_SYMBOL = 2;</code>
     */
    CUTBOARD_TYPE_SYMBOL(2),
    /**
     * <code>CUTBOARD_TYPE_PLATE = 3;</code>
     */
    CUTBOARD_TYPE_PLATE(3),
    UNRECOGNIZED(-1),
    ;

    /**
     * <code>CUTBOARD_TYPE_UNKNOWN = 0;</code>
     */
    public static final int CUTBOARD_TYPE_UNKNOWN_VALUE = 0;
    /**
     * <code>CUTBOARD_TYPE_VEHICLE = 1;</code>
     */
    public static final int CUTBOARD_TYPE_VEHICLE_VALUE = 1;
    /**
     * <code>CUTBOARD_TYPE_SYMBOL = 2;</code>
     */
    public static final int CUTBOARD_TYPE_SYMBOL_VALUE = 2;
    /**
     * <code>CUTBOARD_TYPE_PLATE = 3;</code>
     */
    public static final int CUTBOARD_TYPE_PLATE_VALUE = 3;


    public final int getNumber() {
      if (this == UNRECOGNIZED) {
        throw new java.lang.IllegalArgumentException(
            "Can't get the number of an unknown enum value.");
      }
      return value;
    }

    /**
     * @deprecated Use {@link #forNumber(int)} instead.
     */
    @java.lang.Deprecated
    public static CutboardType valueOf(int value) {
      return forNumber(value);
    }

    public static CutboardType forNumber(int value) {
      switch (value) {
        case 0: return CUTBOARD_TYPE_UNKNOWN;
        case 1: return CUTBOARD_TYPE_VEHICLE;
        case 2: return CUTBOARD_TYPE_SYMBOL;
        case 3: return CUTBOARD_TYPE_PLATE;
        default: return null;
      }
    }

    public static com.google.protobuf.Internal.EnumLiteMap<CutboardType>
        internalGetValueMap() {
      return internalValueMap;
    }
    private static final com.google.protobuf.Internal.EnumLiteMap<
        CutboardType> internalValueMap =
          new com.google.protobuf.Internal.EnumLiteMap<CutboardType>() {
            public CutboardType findValueByNumber(int number) {
              return CutboardType.forNumber(number);
            }
          };

    public final com.google.protobuf.Descriptors.EnumValueDescriptor
        getValueDescriptor() {
      return getDescriptor().getValues().get(ordinal());
    }
    public final com.google.protobuf.Descriptors.EnumDescriptor
        getDescriptorForType() {
      return getDescriptor();
    }
    public static final com.google.protobuf.Descriptors.EnumDescriptor
        getDescriptor() {
      return dg.model.Enum.getDescriptor().getEnumTypes().get(2);
    }

    private static final CutboardType[] VALUES = values();

    public static CutboardType valueOf(
        com.google.protobuf.Descriptors.EnumValueDescriptor desc) {
      if (desc.getType() != getDescriptor()) {
        throw new java.lang.IllegalArgumentException(
          "EnumValueDescriptor is not for this type.");
      }
      if (desc.getIndex() == -1) {
        return UNRECOGNIZED;
      }
      return VALUES[desc.getIndex()];
    }

    private final int value;

    private CutboardType(int value) {
      this.value = value;
    }

    // @@protoc_insertion_point(enum_scope:dg.model.CutboardType)
  }

  /**
   * Protobuf enum {@code dg.model.TaskSourceType}
   */
  public enum TaskSourceType
      implements com.google.protobuf.ProtocolMessageEnum {
    /**
     * <code>TASK_TYPE_UNKNOWN = 0;</code>
     */
    TASK_TYPE_UNKNOWN(0),
    /**
     * <pre>
     * 静态图片任务
     * </pre>
     *
     * <code>TASK_TYPE_IMAGE = 1;</code>
     */
    TASK_TYPE_IMAGE(1),
    /**
     * <pre>
     * 视频文件任务
     * </pre>
     *
     * <code>TASK_TYPE_VIDEO = 2;</code>
     */
    TASK_TYPE_VIDEO(2),
    /**
     * <pre>
     * 视频流任务
     * </pre>
     *
     * <code>TASK_TYPE_STREAM = 3;</code>
     */
    TASK_TYPE_STREAM(3),
    /**
     * <pre>
     * 动态图片任务
     * </pre>
     *
     * <code>TASK_TYPE_CAPTURE = 4;</code>
     */
    TASK_TYPE_CAPTURE(4),
    /**
     * <pre>
     * 平台视频流
     * </pre>
     *
     * <code>TASK_TYPE_PLATFORM_STREAM = 5;</code>
     */
    TASK_TYPE_PLATFORM_STREAM(5),
    UNRECOGNIZED(-1),
    ;

    /**
     * <code>TASK_TYPE_UNKNOWN = 0;</code>
     */
    public static final int TASK_TYPE_UNKNOWN_VALUE = 0;
    /**
     * <pre>
     * 静态图片任务
     * </pre>
     *
     * <code>TASK_TYPE_IMAGE = 1;</code>
     */
    public static final int TASK_TYPE_IMAGE_VALUE = 1;
    /**
     * <pre>
     * 视频文件任务
     * </pre>
     *
     * <code>TASK_TYPE_VIDEO = 2;</code>
     */
    public static final int TASK_TYPE_VIDEO_VALUE = 2;
    /**
     * <pre>
     * 视频流任务
     * </pre>
     *
     * <code>TASK_TYPE_STREAM = 3;</code>
     */
    public static final int TASK_TYPE_STREAM_VALUE = 3;
    /**
     * <pre>
     * 动态图片任务
     * </pre>
     *
     * <code>TASK_TYPE_CAPTURE = 4;</code>
     */
    public static final int TASK_TYPE_CAPTURE_VALUE = 4;
    /**
     * <pre>
     * 平台视频流
     * </pre>
     *
     * <code>TASK_TYPE_PLATFORM_STREAM = 5;</code>
     */
    public static final int TASK_TYPE_PLATFORM_STREAM_VALUE = 5;


    public final int getNumber() {
      if (this == UNRECOGNIZED) {
        throw new java.lang.IllegalArgumentException(
            "Can't get the number of an unknown enum value.");
      }
      return value;
    }

    /**
     * @deprecated Use {@link #forNumber(int)} instead.
     */
    @java.lang.Deprecated
    public static TaskSourceType valueOf(int value) {
      return forNumber(value);
    }

    public static TaskSourceType forNumber(int value) {
      switch (value) {
        case 0: return TASK_TYPE_UNKNOWN;
        case 1: return TASK_TYPE_IMAGE;
        case 2: return TASK_TYPE_VIDEO;
        case 3: return TASK_TYPE_STREAM;
        case 4: return TASK_TYPE_CAPTURE;
        case 5: return TASK_TYPE_PLATFORM_STREAM;
        default: return null;
      }
    }

    public static com.google.protobuf.Internal.EnumLiteMap<TaskSourceType>
        internalGetValueMap() {
      return internalValueMap;
    }
    private static final com.google.protobuf.Internal.EnumLiteMap<
        TaskSourceType> internalValueMap =
          new com.google.protobuf.Internal.EnumLiteMap<TaskSourceType>() {
            public TaskSourceType findValueByNumber(int number) {
              return TaskSourceType.forNumber(number);
            }
          };

    public final com.google.protobuf.Descriptors.EnumValueDescriptor
        getValueDescriptor() {
      return getDescriptor().getValues().get(ordinal());
    }
    public final com.google.protobuf.Descriptors.EnumDescriptor
        getDescriptorForType() {
      return getDescriptor();
    }
    public static final com.google.protobuf.Descriptors.EnumDescriptor
        getDescriptor() {
      return dg.model.Enum.getDescriptor().getEnumTypes().get(3);
    }

    private static final TaskSourceType[] VALUES = values();

    public static TaskSourceType valueOf(
        com.google.protobuf.Descriptors.EnumValueDescriptor desc) {
      if (desc.getType() != getDescriptor()) {
        throw new java.lang.IllegalArgumentException(
          "EnumValueDescriptor is not for this type.");
      }
      if (desc.getIndex() == -1) {
        return UNRECOGNIZED;
      }
      return VALUES[desc.getIndex()];
    }

    private final int value;

    private TaskSourceType(int value) {
      this.value = value;
    }

    // @@protoc_insertion_point(enum_scope:dg.model.TaskSourceType)
  }

  /**
   * <pre>
   * 图片类型
   * </pre>
   *
   * Protobuf enum {@code dg.model.ImageType}
   */
  public enum ImageType
      implements com.google.protobuf.ProtocolMessageEnum {
    /**
     * <code>ImageTypeUnknown = 0;</code>
     */
    ImageTypeUnknown(0),
    /**
     * <pre>
     * 身份证图片
     * </pre>
     *
     * <code>ImageTypeId = 1;</code>
     */
    ImageTypeId(1),
    /**
     * <pre>
     * 抓拍图片
     * </pre>
     *
     * <code>ImageTypeCapture = 2;</code>
     */
    ImageTypeCapture(2),
    /**
     * <pre>
     * 用户上传图片 
     * </pre>
     *
     * <code>ImageTypeUpload = 3;</code>
     */
    ImageTypeUpload(3),
    /**
     * <pre>
     * 全景图
     * </pre>
     *
     * <code>ImageTypePanorama = 100;</code>
     */
    ImageTypePanorama(100),
    /**
     * <pre>
     * 人脸大图
     * </pre>
     *
     * <code>ImageTypeLargerFace = 101;</code>
     */
    ImageTypeLargerFace(101),
    /**
     * <pre>
     * 人脸小图
     * </pre>
     *
     * <code>ImageTypeSmallerFace = 102;</code>
     */
    ImageTypeSmallerFace(102),
    /**
     * <pre>
     * 车/人/非大图
     * </pre>
     *
     * <code>ImageTypeLargerVehicle = 103;</code>
     */
    ImageTypeLargerVehicle(103),
    /**
     * <pre>
     * 车/人/非小图
     * </pre>
     *
     * <code>ImageTypeSmallerVehicle = 104;</code>
     */
    ImageTypeSmallerVehicle(104),
    UNRECOGNIZED(-1),
    ;

    /**
     * <code>ImageTypeUnknown = 0;</code>
     */
    public static final int ImageTypeUnknown_VALUE = 0;
    /**
     * <pre>
     * 身份证图片
     * </pre>
     *
     * <code>ImageTypeId = 1;</code>
     */
    public static final int ImageTypeId_VALUE = 1;
    /**
     * <pre>
     * 抓拍图片
     * </pre>
     *
     * <code>ImageTypeCapture = 2;</code>
     */
    public static final int ImageTypeCapture_VALUE = 2;
    /**
     * <pre>
     * 用户上传图片 
     * </pre>
     *
     * <code>ImageTypeUpload = 3;</code>
     */
    public static final int ImageTypeUpload_VALUE = 3;
    /**
     * <pre>
     * 全景图
     * </pre>
     *
     * <code>ImageTypePanorama = 100;</code>
     */
    public static final int ImageTypePanorama_VALUE = 100;
    /**
     * <pre>
     * 人脸大图
     * </pre>
     *
     * <code>ImageTypeLargerFace = 101;</code>
     */
    public static final int ImageTypeLargerFace_VALUE = 101;
    /**
     * <pre>
     * 人脸小图
     * </pre>
     *
     * <code>ImageTypeSmallerFace = 102;</code>
     */
    public static final int ImageTypeSmallerFace_VALUE = 102;
    /**
     * <pre>
     * 车/人/非大图
     * </pre>
     *
     * <code>ImageTypeLargerVehicle = 103;</code>
     */
    public static final int ImageTypeLargerVehicle_VALUE = 103;
    /**
     * <pre>
     * 车/人/非小图
     * </pre>
     *
     * <code>ImageTypeSmallerVehicle = 104;</code>
     */
    public static final int ImageTypeSmallerVehicle_VALUE = 104;


    public final int getNumber() {
      if (this == UNRECOGNIZED) {
        throw new java.lang.IllegalArgumentException(
            "Can't get the number of an unknown enum value.");
      }
      return value;
    }

    /**
     * @deprecated Use {@link #forNumber(int)} instead.
     */
    @java.lang.Deprecated
    public static ImageType valueOf(int value) {
      return forNumber(value);
    }

    public static ImageType forNumber(int value) {
      switch (value) {
        case 0: return ImageTypeUnknown;
        case 1: return ImageTypeId;
        case 2: return ImageTypeCapture;
        case 3: return ImageTypeUpload;
        case 100: return ImageTypePanorama;
        case 101: return ImageTypeLargerFace;
        case 102: return ImageTypeSmallerFace;
        case 103: return ImageTypeLargerVehicle;
        case 104: return ImageTypeSmallerVehicle;
        default: return null;
      }
    }

    public static com.google.protobuf.Internal.EnumLiteMap<ImageType>
        internalGetValueMap() {
      return internalValueMap;
    }
    private static final com.google.protobuf.Internal.EnumLiteMap<
        ImageType> internalValueMap =
          new com.google.protobuf.Internal.EnumLiteMap<ImageType>() {
            public ImageType findValueByNumber(int number) {
              return ImageType.forNumber(number);
            }
          };

    public final com.google.protobuf.Descriptors.EnumValueDescriptor
        getValueDescriptor() {
      return getDescriptor().getValues().get(ordinal());
    }
    public final com.google.protobuf.Descriptors.EnumDescriptor
        getDescriptorForType() {
      return getDescriptor();
    }
    public static final com.google.protobuf.Descriptors.EnumDescriptor
        getDescriptor() {
      return dg.model.Enum.getDescriptor().getEnumTypes().get(4);
    }

    private static final ImageType[] VALUES = values();

    public static ImageType valueOf(
        com.google.protobuf.Descriptors.EnumValueDescriptor desc) {
      if (desc.getType() != getDescriptor()) {
        throw new java.lang.IllegalArgumentException(
          "EnumValueDescriptor is not for this type.");
      }
      if (desc.getIndex() == -1) {
        return UNRECOGNIZED;
      }
      return VALUES[desc.getIndex()];
    }

    private final int value;

    private ImageType(int value) {
      this.value = value;
    }

    // @@protoc_insertion_point(enum_scope:dg.model.ImageType)
  }

  /**
   * <pre>
   * 交通事件类型
   * </pre>
   *
   * Protobuf enum {@code dg.model.TrafficRuleType}
   */
  public enum TrafficRuleType
      implements com.google.protobuf.ProtocolMessageEnum {
    /**
     * <code>TrafficRuleTypeUnknown = 0;</code>
     */
    TrafficRuleTypeUnknown(0),
    /**
     * <pre>
     * 违停
     * </pre>
     *
     * <code>TrafficRuleTypeIllegalParking = 1;</code>
     */
    TrafficRuleTypeIllegalParking(1),
    /**
     * <pre>
     * 逆行
     * </pre>
     *
     * <code>TrafficRuleTypeRetRograde = 2;</code>
     */
    TrafficRuleTypeRetRograde(2),
    /**
     * <pre>
     * 行人
     * </pre>
     *
     * <code>TrafficRuleTypePedestrian = 3;</code>
     */
    TrafficRuleTypePedestrian(3),
    /**
     * <pre>
     * 压线
     * </pre>
     *
     * <code>TrafficRuleTypeOccupyLane = 4;</code>
     */
    TrafficRuleTypeOccupyLane(4),
    /**
     * <pre>
     * 变道
     * </pre>
     *
     * <code>TrafficRuleTypeChangeLane = 5;</code>
     */
    TrafficRuleTypeChangeLane(5),
    /**
     * <pre>
     * 机占非
     * </pre>
     *
     * <code>TrafficRuleTypeMotorOccupyNonmotor = 6;</code>
     */
    TrafficRuleTypeMotorOccupyNonmotor(6),
    /**
     * <pre>
     * 非占机
     * </pre>
     *
     * <code>TrafficRuleTypeNonmotorOccupyMotor = 7;</code>
     */
    TrafficRuleTypeNonmotorOccupyMotor(7),
    /**
     * <pre>
     * 占专用车道
     * </pre>
     *
     * <code>TrafficRuleTypeOccupyDedicateLane = 8;</code>
     */
    TrafficRuleTypeOccupyDedicateLane(8),
    UNRECOGNIZED(-1),
    ;

    /**
     * <code>TrafficRuleTypeUnknown = 0;</code>
     */
    public static final int TrafficRuleTypeUnknown_VALUE = 0;
    /**
     * <pre>
     * 违停
     * </pre>
     *
     * <code>TrafficRuleTypeIllegalParking = 1;</code>
     */
    public static final int TrafficRuleTypeIllegalParking_VALUE = 1;
    /**
     * <pre>
     * 逆行
     * </pre>
     *
     * <code>TrafficRuleTypeRetRograde = 2;</code>
     */
    public static final int TrafficRuleTypeRetRograde_VALUE = 2;
    /**
     * <pre>
     * 行人
     * </pre>
     *
     * <code>TrafficRuleTypePedestrian = 3;</code>
     */
    public static final int TrafficRuleTypePedestrian_VALUE = 3;
    /**
     * <pre>
     * 压线
     * </pre>
     *
     * <code>TrafficRuleTypeOccupyLane = 4;</code>
     */
    public static final int TrafficRuleTypeOccupyLane_VALUE = 4;
    /**
     * <pre>
     * 变道
     * </pre>
     *
     * <code>TrafficRuleTypeChangeLane = 5;</code>
     */
    public static final int TrafficRuleTypeChangeLane_VALUE = 5;
    /**
     * <pre>
     * 机占非
     * </pre>
     *
     * <code>TrafficRuleTypeMotorOccupyNonmotor = 6;</code>
     */
    public static final int TrafficRuleTypeMotorOccupyNonmotor_VALUE = 6;
    /**
     * <pre>
     * 非占机
     * </pre>
     *
     * <code>TrafficRuleTypeNonmotorOccupyMotor = 7;</code>
     */
    public static final int TrafficRuleTypeNonmotorOccupyMotor_VALUE = 7;
    /**
     * <pre>
     * 占专用车道
     * </pre>
     *
     * <code>TrafficRuleTypeOccupyDedicateLane = 8;</code>
     */
    public static final int TrafficRuleTypeOccupyDedicateLane_VALUE = 8;


    public final int getNumber() {
      if (this == UNRECOGNIZED) {
        throw new java.lang.IllegalArgumentException(
            "Can't get the number of an unknown enum value.");
      }
      return value;
    }

    /**
     * @deprecated Use {@link #forNumber(int)} instead.
     */
    @java.lang.Deprecated
    public static TrafficRuleType valueOf(int value) {
      return forNumber(value);
    }

    public static TrafficRuleType forNumber(int value) {
      switch (value) {
        case 0: return TrafficRuleTypeUnknown;
        case 1: return TrafficRuleTypeIllegalParking;
        case 2: return TrafficRuleTypeRetRograde;
        case 3: return TrafficRuleTypePedestrian;
        case 4: return TrafficRuleTypeOccupyLane;
        case 5: return TrafficRuleTypeChangeLane;
        case 6: return TrafficRuleTypeMotorOccupyNonmotor;
        case 7: return TrafficRuleTypeNonmotorOccupyMotor;
        case 8: return TrafficRuleTypeOccupyDedicateLane;
        default: return null;
      }
    }

    public static com.google.protobuf.Internal.EnumLiteMap<TrafficRuleType>
        internalGetValueMap() {
      return internalValueMap;
    }
    private static final com.google.protobuf.Internal.EnumLiteMap<
        TrafficRuleType> internalValueMap =
          new com.google.protobuf.Internal.EnumLiteMap<TrafficRuleType>() {
            public TrafficRuleType findValueByNumber(int number) {
              return TrafficRuleType.forNumber(number);
            }
          };

    public final com.google.protobuf.Descriptors.EnumValueDescriptor
        getValueDescriptor() {
      return getDescriptor().getValues().get(ordinal());
    }
    public final com.google.protobuf.Descriptors.EnumDescriptor
        getDescriptorForType() {
      return getDescriptor();
    }
    public static final com.google.protobuf.Descriptors.EnumDescriptor
        getDescriptor() {
      return dg.model.Enum.getDescriptor().getEnumTypes().get(5);
    }

    private static final TrafficRuleType[] VALUES = values();

    public static TrafficRuleType valueOf(
        com.google.protobuf.Descriptors.EnumValueDescriptor desc) {
      if (desc.getType() != getDescriptor()) {
        throw new java.lang.IllegalArgumentException(
          "EnumValueDescriptor is not for this type.");
      }
      if (desc.getIndex() == -1) {
        return UNRECOGNIZED;
      }
      return VALUES[desc.getIndex()];
    }

    private final int value;

    private TrafficRuleType(int value) {
      this.value = value;
    }

    // @@protoc_insertion_point(enum_scope:dg.model.TrafficRuleType)
  }

  /**
   * <pre>
   * 星期类型
   * </pre>
   *
   * Protobuf enum {@code dg.model.WeekDayType}
   */
  public enum WeekDayType
      implements com.google.protobuf.ProtocolMessageEnum {
    /**
     * <pre>
     * 周日
     * </pre>
     *
     * <code>WeekDayTypeSunday = 0;</code>
     */
    WeekDayTypeSunday(0),
    /**
     * <pre>
     * 周一
     * </pre>
     *
     * <code>WeekDayTypeMonday = 1;</code>
     */
    WeekDayTypeMonday(1),
    /**
     * <pre>
     * 周二
     * </pre>
     *
     * <code>WeekDayTypeTuesday = 2;</code>
     */
    WeekDayTypeTuesday(2),
    /**
     * <pre>
     * 周三
     * </pre>
     *
     * <code>WeekDayTypeWednesday = 3;</code>
     */
    WeekDayTypeWednesday(3),
    /**
     * <pre>
     * 周四
     * </pre>
     *
     * <code>WeekDayTypeThursday = 4;</code>
     */
    WeekDayTypeThursday(4),
    /**
     * <pre>
     * 周五
     * </pre>
     *
     * <code>WeekDayTypeFriday = 5;</code>
     */
    WeekDayTypeFriday(5),
    /**
     * <pre>
     * 周六
     * </pre>
     *
     * <code>WeekDayTypeSaturday = 6;</code>
     */
    WeekDayTypeSaturday(6),
    UNRECOGNIZED(-1),
    ;

    /**
     * <pre>
     * 周日
     * </pre>
     *
     * <code>WeekDayTypeSunday = 0;</code>
     */
    public static final int WeekDayTypeSunday_VALUE = 0;
    /**
     * <pre>
     * 周一
     * </pre>
     *
     * <code>WeekDayTypeMonday = 1;</code>
     */
    public static final int WeekDayTypeMonday_VALUE = 1;
    /**
     * <pre>
     * 周二
     * </pre>
     *
     * <code>WeekDayTypeTuesday = 2;</code>
     */
    public static final int WeekDayTypeTuesday_VALUE = 2;
    /**
     * <pre>
     * 周三
     * </pre>
     *
     * <code>WeekDayTypeWednesday = 3;</code>
     */
    public static final int WeekDayTypeWednesday_VALUE = 3;
    /**
     * <pre>
     * 周四
     * </pre>
     *
     * <code>WeekDayTypeThursday = 4;</code>
     */
    public static final int WeekDayTypeThursday_VALUE = 4;
    /**
     * <pre>
     * 周五
     * </pre>
     *
     * <code>WeekDayTypeFriday = 5;</code>
     */
    public static final int WeekDayTypeFriday_VALUE = 5;
    /**
     * <pre>
     * 周六
     * </pre>
     *
     * <code>WeekDayTypeSaturday = 6;</code>
     */
    public static final int WeekDayTypeSaturday_VALUE = 6;


    public final int getNumber() {
      if (this == UNRECOGNIZED) {
        throw new java.lang.IllegalArgumentException(
            "Can't get the number of an unknown enum value.");
      }
      return value;
    }

    /**
     * @deprecated Use {@link #forNumber(int)} instead.
     */
    @java.lang.Deprecated
    public static WeekDayType valueOf(int value) {
      return forNumber(value);
    }

    public static WeekDayType forNumber(int value) {
      switch (value) {
        case 0: return WeekDayTypeSunday;
        case 1: return WeekDayTypeMonday;
        case 2: return WeekDayTypeTuesday;
        case 3: return WeekDayTypeWednesday;
        case 4: return WeekDayTypeThursday;
        case 5: return WeekDayTypeFriday;
        case 6: return WeekDayTypeSaturday;
        default: return null;
      }
    }

    public static com.google.protobuf.Internal.EnumLiteMap<WeekDayType>
        internalGetValueMap() {
      return internalValueMap;
    }
    private static final com.google.protobuf.Internal.EnumLiteMap<
        WeekDayType> internalValueMap =
          new com.google.protobuf.Internal.EnumLiteMap<WeekDayType>() {
            public WeekDayType findValueByNumber(int number) {
              return WeekDayType.forNumber(number);
            }
          };

    public final com.google.protobuf.Descriptors.EnumValueDescriptor
        getValueDescriptor() {
      return getDescriptor().getValues().get(ordinal());
    }
    public final com.google.protobuf.Descriptors.EnumDescriptor
        getDescriptorForType() {
      return getDescriptor();
    }
    public static final com.google.protobuf.Descriptors.EnumDescriptor
        getDescriptor() {
      return dg.model.Enum.getDescriptor().getEnumTypes().get(6);
    }

    private static final WeekDayType[] VALUES = values();

    public static WeekDayType valueOf(
        com.google.protobuf.Descriptors.EnumValueDescriptor desc) {
      if (desc.getType() != getDescriptor()) {
        throw new java.lang.IllegalArgumentException(
          "EnumValueDescriptor is not for this type.");
      }
      if (desc.getIndex() == -1) {
        return UNRECOGNIZED;
      }
      return VALUES[desc.getIndex()];
    }

    private final int value;

    private WeekDayType(int value) {
      this.value = value;
    }

    // @@protoc_insertion_point(enum_scope:dg.model.WeekDayType)
  }


  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\nenum.proto\022\010dg.model*\327\001\n\nTaskStatus\022\027\n" +
      "\023Task_Status_Unknown\020\000\022\027\n\023Task_Status_Cr" +
      "eated\020\001\022\032\n\026Task_Status_Processing\020\002\022\030\n\024T" +
      "ask_Status_Finished\020\003\022\027\n\023Task_Status_Del" +
      "eted\020\004\022\027\n\023Task_Status_Outdate\020\005\022\026\n\022Task_" +
      "Status_Paused\020\006\022\027\n\023Task_Status_Stopped\020\007" +
      "*\203\001\n\016SwitcherStatus\022\033\n\027Switcher_Status_U" +
      "nknown\020\000\022\033\n\027Switcher_Status_Started\020\001\022\033\n" +
      "\027Switcher_Status_Stopped\020\002\022\032\n\026Switcher_S" +
      "tatus_Paused\020\003*w\n\014CutboardType\022\031\n\025CUTBOA" +
      "RD_TYPE_UNKNOWN\020\000\022\031\n\025CUTBOARD_TYPE_VEHIC" +
      "LE\020\001\022\030\n\024CUTBOARD_TYPE_SYMBOL\020\002\022\027\n\023CUTBOA" +
      "RD_TYPE_PLATE\020\003*\235\001\n\016TaskSourceType\022\025\n\021TA" +
      "SK_TYPE_UNKNOWN\020\000\022\023\n\017TASK_TYPE_IMAGE\020\001\022\023" +
      "\n\017TASK_TYPE_VIDEO\020\002\022\024\n\020TASK_TYPE_STREAM\020" +
      "\003\022\025\n\021TASK_TYPE_CAPTURE\020\004\022\035\n\031TASK_TYPE_PL" +
      "ATFORM_STREAM\020\005*\340\001\n\tImageType\022\024\n\020ImageTy" +
      "peUnknown\020\000\022\017\n\013ImageTypeId\020\001\022\024\n\020ImageTyp" +
      "eCapture\020\002\022\023\n\017ImageTypeUpload\020\003\022\025\n\021Image" +
      "TypePanorama\020d\022\027\n\023ImageTypeLargerFace\020e\022" +
      "\030\n\024ImageTypeSmallerFace\020f\022\032\n\026ImageTypeLa" +
      "rgerVehicle\020g\022\033\n\027ImageTypeSmallerVehicle" +
      "\020h*\303\002\n\017TrafficRuleType\022\032\n\026TrafficRuleTyp" +
      "eUnknown\020\000\022!\n\035TrafficRuleTypeIllegalPark" +
      "ing\020\001\022\035\n\031TrafficRuleTypeRetRograde\020\002\022\035\n\031" +
      "TrafficRuleTypePedestrian\020\003\022\035\n\031TrafficRu" +
      "leTypeOccupyLane\020\004\022\035\n\031TrafficRuleTypeCha" +
      "ngeLane\020\005\022&\n\"TrafficRuleTypeMotorOccupyN" +
      "onmotor\020\006\022&\n\"TrafficRuleTypeNonmotorOccu" +
      "pyMotor\020\007\022%\n!TrafficRuleTypeOccupyDedica" +
      "teLane\020\010*\266\001\n\013WeekDayType\022\025\n\021WeekDayTypeS" +
      "unday\020\000\022\025\n\021WeekDayTypeMonday\020\001\022\026\n\022WeekDa" +
      "yTypeTuesday\020\002\022\030\n\024WeekDayTypeWednesday\020\003" +
      "\022\027\n\023WeekDayTypeThursday\020\004\022\025\n\021WeekDayType" +
      "Friday\020\005\022\027\n\023WeekDayTypeSaturday\020\006b\006proto" +
      "3"
    };
    com.google.protobuf.Descriptors.FileDescriptor.InternalDescriptorAssigner assigner =
        new com.google.protobuf.Descriptors.FileDescriptor.    InternalDescriptorAssigner() {
          public com.google.protobuf.ExtensionRegistry assignDescriptors(
              com.google.protobuf.Descriptors.FileDescriptor root) {
            descriptor = root;
            return null;
          }
        };
    com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        }, assigner);
  }

  // @@protoc_insertion_point(outer_class_scope)
}
