// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: IdentityEnrollmentReplyReq.proto

package com.classlink.websocket.api.member.domain.param.proto;

public final class IdentityEnrollmentReplyReqProto {
  private IdentityEnrollmentReplyReqProto() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  public interface IdentityEnrollmentReplyReqOrBuilder extends
      // @@protoc_insertion_point(interface_extends:Classlink.IdentityEnrollmentReplyReq)
      com.google.protobuf.MessageOrBuilder {

    /**
     * <code>int32 ItmIdx = 1;</code>
     * @return The itmIdx.
     */
    int getItmIdx();

    /**
     * <code>bool IsPermission = 2;</code>
     * @return The isPermission.
     */
    boolean getIsPermission();
  }
  /**
   * Protobuf type {@code Classlink.IdentityEnrollmentReplyReq}
   */
  public static final class IdentityEnrollmentReplyReq extends
      com.google.protobuf.GeneratedMessageV3 implements
      // @@protoc_insertion_point(message_implements:Classlink.IdentityEnrollmentReplyReq)
      IdentityEnrollmentReplyReqOrBuilder {
  private static final long serialVersionUID = 0L;
    // Use IdentityEnrollmentReplyReq.newBuilder() to construct.
    private IdentityEnrollmentReplyReq(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
      super(builder);
    }
    private IdentityEnrollmentReplyReq() {
    }

    @java.lang.Override
    @SuppressWarnings({"unused"})
    protected java.lang.Object newInstance(
        UnusedPrivateParameter unused) {
      return new IdentityEnrollmentReplyReq();
    }

    @java.lang.Override
    public final com.google.protobuf.UnknownFieldSet
    getUnknownFields() {
      return this.unknownFields;
    }
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return com.classlink.websocket.api.member.domain.param.proto.IdentityEnrollmentReplyReqProto.internal_static_Classlink_IdentityEnrollmentReplyReq_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.classlink.websocket.api.member.domain.param.proto.IdentityEnrollmentReplyReqProto.internal_static_Classlink_IdentityEnrollmentReplyReq_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.classlink.websocket.api.member.domain.param.proto.IdentityEnrollmentReplyReqProto.IdentityEnrollmentReplyReq.class, com.classlink.websocket.api.member.domain.param.proto.IdentityEnrollmentReplyReqProto.IdentityEnrollmentReplyReq.Builder.class);
    }

    public static final int ITMIDX_FIELD_NUMBER = 1;
    private int itmIdx_;
    /**
     * <code>int32 ItmIdx = 1;</code>
     * @return The itmIdx.
     */
    @java.lang.Override
    public int getItmIdx() {
      return itmIdx_;
    }

    public static final int ISPERMISSION_FIELD_NUMBER = 2;
    private boolean isPermission_;
    /**
     * <code>bool IsPermission = 2;</code>
     * @return The isPermission.
     */
    @java.lang.Override
    public boolean getIsPermission() {
      return isPermission_;
    }

    private byte memoizedIsInitialized = -1;
    @java.lang.Override
    public final boolean isInitialized() {
      byte isInitialized = memoizedIsInitialized;
      if (isInitialized == 1) return true;
      if (isInitialized == 0) return false;

      memoizedIsInitialized = 1;
      return true;
    }

    @java.lang.Override
    public void writeTo(com.google.protobuf.CodedOutputStream output)
                        throws java.io.IOException {
      if (itmIdx_ != 0) {
        output.writeInt32(1, itmIdx_);
      }
      if (isPermission_ != false) {
        output.writeBool(2, isPermission_);
      }
      getUnknownFields().writeTo(output);
    }

    @java.lang.Override
    public int getSerializedSize() {
      int size = memoizedSize;
      if (size != -1) return size;

      size = 0;
      if (itmIdx_ != 0) {
        size += com.google.protobuf.CodedOutputStream
          .computeInt32Size(1, itmIdx_);
      }
      if (isPermission_ != false) {
        size += com.google.protobuf.CodedOutputStream
          .computeBoolSize(2, isPermission_);
      }
      size += getUnknownFields().getSerializedSize();
      memoizedSize = size;
      return size;
    }

    @java.lang.Override
    public boolean equals(final java.lang.Object obj) {
      if (obj == this) {
       return true;
      }
      if (!(obj instanceof com.classlink.websocket.api.member.domain.param.proto.IdentityEnrollmentReplyReqProto.IdentityEnrollmentReplyReq)) {
        return super.equals(obj);
      }
      com.classlink.websocket.api.member.domain.param.proto.IdentityEnrollmentReplyReqProto.IdentityEnrollmentReplyReq other = (com.classlink.websocket.api.member.domain.param.proto.IdentityEnrollmentReplyReqProto.IdentityEnrollmentReplyReq) obj;

      if (getItmIdx()
          != other.getItmIdx()) return false;
      if (getIsPermission()
          != other.getIsPermission()) return false;
      if (!getUnknownFields().equals(other.getUnknownFields())) return false;
      return true;
    }

    @java.lang.Override
    public int hashCode() {
      if (memoizedHashCode != 0) {
        return memoizedHashCode;
      }
      int hash = 41;
      hash = (19 * hash) + getDescriptor().hashCode();
      hash = (37 * hash) + ITMIDX_FIELD_NUMBER;
      hash = (53 * hash) + getItmIdx();
      hash = (37 * hash) + ISPERMISSION_FIELD_NUMBER;
      hash = (53 * hash) + com.google.protobuf.Internal.hashBoolean(
          getIsPermission());
      hash = (29 * hash) + getUnknownFields().hashCode();
      memoizedHashCode = hash;
      return hash;
    }

    public static com.classlink.websocket.api.member.domain.param.proto.IdentityEnrollmentReplyReqProto.IdentityEnrollmentReplyReq parseFrom(
        java.nio.ByteBuffer data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static com.classlink.websocket.api.member.domain.param.proto.IdentityEnrollmentReplyReqProto.IdentityEnrollmentReplyReq parseFrom(
        java.nio.ByteBuffer data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static com.classlink.websocket.api.member.domain.param.proto.IdentityEnrollmentReplyReqProto.IdentityEnrollmentReplyReq parseFrom(
        com.google.protobuf.ByteString data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static com.classlink.websocket.api.member.domain.param.proto.IdentityEnrollmentReplyReqProto.IdentityEnrollmentReplyReq parseFrom(
        com.google.protobuf.ByteString data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static com.classlink.websocket.api.member.domain.param.proto.IdentityEnrollmentReplyReqProto.IdentityEnrollmentReplyReq parseFrom(byte[] data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static com.classlink.websocket.api.member.domain.param.proto.IdentityEnrollmentReplyReqProto.IdentityEnrollmentReplyReq parseFrom(
        byte[] data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static com.classlink.websocket.api.member.domain.param.proto.IdentityEnrollmentReplyReqProto.IdentityEnrollmentReplyReq parseFrom(java.io.InputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input);
    }
    public static com.classlink.websocket.api.member.domain.param.proto.IdentityEnrollmentReplyReqProto.IdentityEnrollmentReplyReq parseFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input, extensionRegistry);
    }
    public static com.classlink.websocket.api.member.domain.param.proto.IdentityEnrollmentReplyReqProto.IdentityEnrollmentReplyReq parseDelimitedFrom(java.io.InputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseDelimitedWithIOException(PARSER, input);
    }
    public static com.classlink.websocket.api.member.domain.param.proto.IdentityEnrollmentReplyReqProto.IdentityEnrollmentReplyReq parseDelimitedFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
    }
    public static com.classlink.websocket.api.member.domain.param.proto.IdentityEnrollmentReplyReqProto.IdentityEnrollmentReplyReq parseFrom(
        com.google.protobuf.CodedInputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input);
    }
    public static com.classlink.websocket.api.member.domain.param.proto.IdentityEnrollmentReplyReqProto.IdentityEnrollmentReplyReq parseFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input, extensionRegistry);
    }

    @java.lang.Override
    public Builder newBuilderForType() { return newBuilder(); }
    public static Builder newBuilder() {
      return DEFAULT_INSTANCE.toBuilder();
    }
    public static Builder newBuilder(com.classlink.websocket.api.member.domain.param.proto.IdentityEnrollmentReplyReqProto.IdentityEnrollmentReplyReq prototype) {
      return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
    }
    @java.lang.Override
    public Builder toBuilder() {
      return this == DEFAULT_INSTANCE
          ? new Builder() : new Builder().mergeFrom(this);
    }

    @java.lang.Override
    protected Builder newBuilderForType(
        com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
      Builder builder = new Builder(parent);
      return builder;
    }
    /**
     * Protobuf type {@code Classlink.IdentityEnrollmentReplyReq}
     */
    public static final class Builder extends
        com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
        // @@protoc_insertion_point(builder_implements:Classlink.IdentityEnrollmentReplyReq)
        com.classlink.websocket.api.member.domain.param.proto.IdentityEnrollmentReplyReqProto.IdentityEnrollmentReplyReqOrBuilder {
      public static final com.google.protobuf.Descriptors.Descriptor
          getDescriptor() {
        return com.classlink.websocket.api.member.domain.param.proto.IdentityEnrollmentReplyReqProto.internal_static_Classlink_IdentityEnrollmentReplyReq_descriptor;
      }

      @java.lang.Override
      protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
          internalGetFieldAccessorTable() {
        return com.classlink.websocket.api.member.domain.param.proto.IdentityEnrollmentReplyReqProto.internal_static_Classlink_IdentityEnrollmentReplyReq_fieldAccessorTable
            .ensureFieldAccessorsInitialized(
                com.classlink.websocket.api.member.domain.param.proto.IdentityEnrollmentReplyReqProto.IdentityEnrollmentReplyReq.class, com.classlink.websocket.api.member.domain.param.proto.IdentityEnrollmentReplyReqProto.IdentityEnrollmentReplyReq.Builder.class);
      }

      // Construct using com.classlink.websocket.api.member.domain.param.proto.IdentityEnrollmentReplyReqProto.IdentityEnrollmentReplyReq.newBuilder()
      private Builder() {

      }

      private Builder(
          com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
        super(parent);

      }
      @java.lang.Override
      public Builder clear() {
        super.clear();
        itmIdx_ = 0;

        isPermission_ = false;

        return this;
      }

      @java.lang.Override
      public com.google.protobuf.Descriptors.Descriptor
          getDescriptorForType() {
        return com.classlink.websocket.api.member.domain.param.proto.IdentityEnrollmentReplyReqProto.internal_static_Classlink_IdentityEnrollmentReplyReq_descriptor;
      }

      @java.lang.Override
      public com.classlink.websocket.api.member.domain.param.proto.IdentityEnrollmentReplyReqProto.IdentityEnrollmentReplyReq getDefaultInstanceForType() {
        return com.classlink.websocket.api.member.domain.param.proto.IdentityEnrollmentReplyReqProto.IdentityEnrollmentReplyReq.getDefaultInstance();
      }

      @java.lang.Override
      public com.classlink.websocket.api.member.domain.param.proto.IdentityEnrollmentReplyReqProto.IdentityEnrollmentReplyReq build() {
        com.classlink.websocket.api.member.domain.param.proto.IdentityEnrollmentReplyReqProto.IdentityEnrollmentReplyReq result = buildPartial();
        if (!result.isInitialized()) {
          throw newUninitializedMessageException(result);
        }
        return result;
      }

      @java.lang.Override
      public com.classlink.websocket.api.member.domain.param.proto.IdentityEnrollmentReplyReqProto.IdentityEnrollmentReplyReq buildPartial() {
        com.classlink.websocket.api.member.domain.param.proto.IdentityEnrollmentReplyReqProto.IdentityEnrollmentReplyReq result = new com.classlink.websocket.api.member.domain.param.proto.IdentityEnrollmentReplyReqProto.IdentityEnrollmentReplyReq(this);
        result.itmIdx_ = itmIdx_;
        result.isPermission_ = isPermission_;
        onBuilt();
        return result;
      }

      @java.lang.Override
      public Builder clone() {
        return super.clone();
      }
      @java.lang.Override
      public Builder setField(
          com.google.protobuf.Descriptors.FieldDescriptor field,
          java.lang.Object value) {
        return super.setField(field, value);
      }
      @java.lang.Override
      public Builder clearField(
          com.google.protobuf.Descriptors.FieldDescriptor field) {
        return super.clearField(field);
      }
      @java.lang.Override
      public Builder clearOneof(
          com.google.protobuf.Descriptors.OneofDescriptor oneof) {
        return super.clearOneof(oneof);
      }
      @java.lang.Override
      public Builder setRepeatedField(
          com.google.protobuf.Descriptors.FieldDescriptor field,
          int index, java.lang.Object value) {
        return super.setRepeatedField(field, index, value);
      }
      @java.lang.Override
      public Builder addRepeatedField(
          com.google.protobuf.Descriptors.FieldDescriptor field,
          java.lang.Object value) {
        return super.addRepeatedField(field, value);
      }
      @java.lang.Override
      public Builder mergeFrom(com.google.protobuf.Message other) {
        if (other instanceof com.classlink.websocket.api.member.domain.param.proto.IdentityEnrollmentReplyReqProto.IdentityEnrollmentReplyReq) {
          return mergeFrom((com.classlink.websocket.api.member.domain.param.proto.IdentityEnrollmentReplyReqProto.IdentityEnrollmentReplyReq)other);
        } else {
          super.mergeFrom(other);
          return this;
        }
      }

      public Builder mergeFrom(com.classlink.websocket.api.member.domain.param.proto.IdentityEnrollmentReplyReqProto.IdentityEnrollmentReplyReq other) {
        if (other == com.classlink.websocket.api.member.domain.param.proto.IdentityEnrollmentReplyReqProto.IdentityEnrollmentReplyReq.getDefaultInstance()) return this;
        if (other.getItmIdx() != 0) {
          setItmIdx(other.getItmIdx());
        }
        if (other.getIsPermission() != false) {
          setIsPermission(other.getIsPermission());
        }
        this.mergeUnknownFields(other.getUnknownFields());
        onChanged();
        return this;
      }

      @java.lang.Override
      public final boolean isInitialized() {
        return true;
      }

      @java.lang.Override
      public Builder mergeFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws java.io.IOException {
        if (extensionRegistry == null) {
          throw new java.lang.NullPointerException();
        }
        try {
          boolean done = false;
          while (!done) {
            int tag = input.readTag();
            switch (tag) {
              case 0:
                done = true;
                break;
              case 8: {
                itmIdx_ = input.readInt32();

                break;
              } // case 8
              case 16: {
                isPermission_ = input.readBool();

                break;
              } // case 16
              default: {
                if (!super.parseUnknownField(input, extensionRegistry, tag)) {
                  done = true; // was an endgroup tag
                }
                break;
              } // default:
            } // switch (tag)
          } // while (!done)
        } catch (com.google.protobuf.InvalidProtocolBufferException e) {
          throw e.unwrapIOException();
        } finally {
          onChanged();
        } // finally
        return this;
      }

      private int itmIdx_ ;
      /**
       * <code>int32 ItmIdx = 1;</code>
       * @return The itmIdx.
       */
      @java.lang.Override
      public int getItmIdx() {
        return itmIdx_;
      }
      /**
       * <code>int32 ItmIdx = 1;</code>
       * @param value The itmIdx to set.
       * @return This builder for chaining.
       */
      public Builder setItmIdx(int value) {
        
        itmIdx_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>int32 ItmIdx = 1;</code>
       * @return This builder for chaining.
       */
      public Builder clearItmIdx() {
        
        itmIdx_ = 0;
        onChanged();
        return this;
      }

      private boolean isPermission_ ;
      /**
       * <code>bool IsPermission = 2;</code>
       * @return The isPermission.
       */
      @java.lang.Override
      public boolean getIsPermission() {
        return isPermission_;
      }
      /**
       * <code>bool IsPermission = 2;</code>
       * @param value The isPermission to set.
       * @return This builder for chaining.
       */
      public Builder setIsPermission(boolean value) {
        
        isPermission_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>bool IsPermission = 2;</code>
       * @return This builder for chaining.
       */
      public Builder clearIsPermission() {
        
        isPermission_ = false;
        onChanged();
        return this;
      }
      @java.lang.Override
      public final Builder setUnknownFields(
          final com.google.protobuf.UnknownFieldSet unknownFields) {
        return super.setUnknownFields(unknownFields);
      }

      @java.lang.Override
      public final Builder mergeUnknownFields(
          final com.google.protobuf.UnknownFieldSet unknownFields) {
        return super.mergeUnknownFields(unknownFields);
      }


      // @@protoc_insertion_point(builder_scope:Classlink.IdentityEnrollmentReplyReq)
    }

    // @@protoc_insertion_point(class_scope:Classlink.IdentityEnrollmentReplyReq)
    private static final com.classlink.websocket.api.member.domain.param.proto.IdentityEnrollmentReplyReqProto.IdentityEnrollmentReplyReq DEFAULT_INSTANCE;
    static {
      DEFAULT_INSTANCE = new com.classlink.websocket.api.member.domain.param.proto.IdentityEnrollmentReplyReqProto.IdentityEnrollmentReplyReq();
    }

    public static com.classlink.websocket.api.member.domain.param.proto.IdentityEnrollmentReplyReqProto.IdentityEnrollmentReplyReq getDefaultInstance() {
      return DEFAULT_INSTANCE;
    }

    private static final com.google.protobuf.Parser<IdentityEnrollmentReplyReq>
        PARSER = new com.google.protobuf.AbstractParser<IdentityEnrollmentReplyReq>() {
      @java.lang.Override
      public IdentityEnrollmentReplyReq parsePartialFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws com.google.protobuf.InvalidProtocolBufferException {
        Builder builder = newBuilder();
        try {
          builder.mergeFrom(input, extensionRegistry);
        } catch (com.google.protobuf.InvalidProtocolBufferException e) {
          throw e.setUnfinishedMessage(builder.buildPartial());
        } catch (com.google.protobuf.UninitializedMessageException e) {
          throw e.asInvalidProtocolBufferException().setUnfinishedMessage(builder.buildPartial());
        } catch (java.io.IOException e) {
          throw new com.google.protobuf.InvalidProtocolBufferException(e)
              .setUnfinishedMessage(builder.buildPartial());
        }
        return builder.buildPartial();
      }
    };

    public static com.google.protobuf.Parser<IdentityEnrollmentReplyReq> parser() {
      return PARSER;
    }

    @java.lang.Override
    public com.google.protobuf.Parser<IdentityEnrollmentReplyReq> getParserForType() {
      return PARSER;
    }

    @java.lang.Override
    public com.classlink.websocket.api.member.domain.param.proto.IdentityEnrollmentReplyReqProto.IdentityEnrollmentReplyReq getDefaultInstanceForType() {
      return DEFAULT_INSTANCE;
    }

  }

  private static final com.google.protobuf.Descriptors.Descriptor
    internal_static_Classlink_IdentityEnrollmentReplyReq_descriptor;
  private static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_Classlink_IdentityEnrollmentReplyReq_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n IdentityEnrollmentReplyReq.proto\022\tClas" +
      "slink\"B\n\032IdentityEnrollmentReplyReq\022\016\n\006I" +
      "tmIdx\030\001 \001(\005\022\024\n\014IsPermission\030\002 \001(\010BX\n5com" +
      ".classlink.websocket.api.member.domain.p" +
      "aram.protoB\037IdentityEnrollmentReplyReqPr" +
      "otob\006proto3"
    };
    descriptor = com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        });
    internal_static_Classlink_IdentityEnrollmentReplyReq_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_Classlink_IdentityEnrollmentReplyReq_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_Classlink_IdentityEnrollmentReplyReq_descriptor,
        new java.lang.String[] { "ItmIdx", "IsPermission", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}
