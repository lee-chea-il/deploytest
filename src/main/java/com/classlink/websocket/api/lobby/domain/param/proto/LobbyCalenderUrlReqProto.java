// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: LobbyCalenderUrlReq.proto

package com.classlink.websocket.api.lobby.domain.param.proto;

public final class LobbyCalenderUrlReqProto {
  private LobbyCalenderUrlReqProto() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  public interface LobbyCalenderUrlReqOrBuilder extends
      // @@protoc_insertion_point(interface_extends:Classlink.LobbyCalenderUrlReq)
      com.google.protobuf.MessageOrBuilder {

    /**
     * <code>string InsCode = 1;</code>
     * @return The insCode.
     */
    java.lang.String getInsCode();
    /**
     * <code>string InsCode = 1;</code>
     * @return The bytes for insCode.
     */
    com.google.protobuf.ByteString
        getInsCodeBytes();

    /**
     * <code>string TarIdentityType = 2;</code>
     * @return The tarIdentityType.
     */
    java.lang.String getTarIdentityType();
    /**
     * <code>string TarIdentityType = 2;</code>
     * @return The bytes for tarIdentityType.
     */
    com.google.protobuf.ByteString
        getTarIdentityTypeBytes();
  }
  /**
   * Protobuf type {@code Classlink.LobbyCalenderUrlReq}
   */
  public static final class LobbyCalenderUrlReq extends
      com.google.protobuf.GeneratedMessageV3 implements
      // @@protoc_insertion_point(message_implements:Classlink.LobbyCalenderUrlReq)
      LobbyCalenderUrlReqOrBuilder {
  private static final long serialVersionUID = 0L;
    // Use LobbyCalenderUrlReq.newBuilder() to construct.
    private LobbyCalenderUrlReq(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
      super(builder);
    }
    private LobbyCalenderUrlReq() {
      insCode_ = "";
      tarIdentityType_ = "";
    }

    @java.lang.Override
    @SuppressWarnings({"unused"})
    protected java.lang.Object newInstance(
        UnusedPrivateParameter unused) {
      return new LobbyCalenderUrlReq();
    }

    @java.lang.Override
    public final com.google.protobuf.UnknownFieldSet
    getUnknownFields() {
      return this.unknownFields;
    }
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return com.classlink.websocket.api.lobby.domain.param.proto.LobbyCalenderUrlReqProto.internal_static_Classlink_LobbyCalenderUrlReq_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.classlink.websocket.api.lobby.domain.param.proto.LobbyCalenderUrlReqProto.internal_static_Classlink_LobbyCalenderUrlReq_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.classlink.websocket.api.lobby.domain.param.proto.LobbyCalenderUrlReqProto.LobbyCalenderUrlReq.class, com.classlink.websocket.api.lobby.domain.param.proto.LobbyCalenderUrlReqProto.LobbyCalenderUrlReq.Builder.class);
    }

    public static final int INSCODE_FIELD_NUMBER = 1;
    private volatile java.lang.Object insCode_;
    /**
     * <code>string InsCode = 1;</code>
     * @return The insCode.
     */
    @java.lang.Override
    public java.lang.String getInsCode() {
      java.lang.Object ref = insCode_;
      if (ref instanceof java.lang.String) {
        return (java.lang.String) ref;
      } else {
        com.google.protobuf.ByteString bs = 
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        insCode_ = s;
        return s;
      }
    }
    /**
     * <code>string InsCode = 1;</code>
     * @return The bytes for insCode.
     */
    @java.lang.Override
    public com.google.protobuf.ByteString
        getInsCodeBytes() {
      java.lang.Object ref = insCode_;
      if (ref instanceof java.lang.String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        insCode_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }

    public static final int TARIDENTITYTYPE_FIELD_NUMBER = 2;
    private volatile java.lang.Object tarIdentityType_;
    /**
     * <code>string TarIdentityType = 2;</code>
     * @return The tarIdentityType.
     */
    @java.lang.Override
    public java.lang.String getTarIdentityType() {
      java.lang.Object ref = tarIdentityType_;
      if (ref instanceof java.lang.String) {
        return (java.lang.String) ref;
      } else {
        com.google.protobuf.ByteString bs = 
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        tarIdentityType_ = s;
        return s;
      }
    }
    /**
     * <code>string TarIdentityType = 2;</code>
     * @return The bytes for tarIdentityType.
     */
    @java.lang.Override
    public com.google.protobuf.ByteString
        getTarIdentityTypeBytes() {
      java.lang.Object ref = tarIdentityType_;
      if (ref instanceof java.lang.String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        tarIdentityType_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
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
      if (!com.google.protobuf.GeneratedMessageV3.isStringEmpty(insCode_)) {
        com.google.protobuf.GeneratedMessageV3.writeString(output, 1, insCode_);
      }
      if (!com.google.protobuf.GeneratedMessageV3.isStringEmpty(tarIdentityType_)) {
        com.google.protobuf.GeneratedMessageV3.writeString(output, 2, tarIdentityType_);
      }
      getUnknownFields().writeTo(output);
    }

    @java.lang.Override
    public int getSerializedSize() {
      int size = memoizedSize;
      if (size != -1) return size;

      size = 0;
      if (!com.google.protobuf.GeneratedMessageV3.isStringEmpty(insCode_)) {
        size += com.google.protobuf.GeneratedMessageV3.computeStringSize(1, insCode_);
      }
      if (!com.google.protobuf.GeneratedMessageV3.isStringEmpty(tarIdentityType_)) {
        size += com.google.protobuf.GeneratedMessageV3.computeStringSize(2, tarIdentityType_);
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
      if (!(obj instanceof com.classlink.websocket.api.lobby.domain.param.proto.LobbyCalenderUrlReqProto.LobbyCalenderUrlReq)) {
        return super.equals(obj);
      }
      com.classlink.websocket.api.lobby.domain.param.proto.LobbyCalenderUrlReqProto.LobbyCalenderUrlReq other = (com.classlink.websocket.api.lobby.domain.param.proto.LobbyCalenderUrlReqProto.LobbyCalenderUrlReq) obj;

      if (!getInsCode()
          .equals(other.getInsCode())) return false;
      if (!getTarIdentityType()
          .equals(other.getTarIdentityType())) return false;
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
      hash = (37 * hash) + INSCODE_FIELD_NUMBER;
      hash = (53 * hash) + getInsCode().hashCode();
      hash = (37 * hash) + TARIDENTITYTYPE_FIELD_NUMBER;
      hash = (53 * hash) + getTarIdentityType().hashCode();
      hash = (29 * hash) + getUnknownFields().hashCode();
      memoizedHashCode = hash;
      return hash;
    }

    public static com.classlink.websocket.api.lobby.domain.param.proto.LobbyCalenderUrlReqProto.LobbyCalenderUrlReq parseFrom(
        java.nio.ByteBuffer data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static com.classlink.websocket.api.lobby.domain.param.proto.LobbyCalenderUrlReqProto.LobbyCalenderUrlReq parseFrom(
        java.nio.ByteBuffer data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static com.classlink.websocket.api.lobby.domain.param.proto.LobbyCalenderUrlReqProto.LobbyCalenderUrlReq parseFrom(
        com.google.protobuf.ByteString data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static com.classlink.websocket.api.lobby.domain.param.proto.LobbyCalenderUrlReqProto.LobbyCalenderUrlReq parseFrom(
        com.google.protobuf.ByteString data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static com.classlink.websocket.api.lobby.domain.param.proto.LobbyCalenderUrlReqProto.LobbyCalenderUrlReq parseFrom(byte[] data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static com.classlink.websocket.api.lobby.domain.param.proto.LobbyCalenderUrlReqProto.LobbyCalenderUrlReq parseFrom(
        byte[] data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static com.classlink.websocket.api.lobby.domain.param.proto.LobbyCalenderUrlReqProto.LobbyCalenderUrlReq parseFrom(java.io.InputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input);
    }
    public static com.classlink.websocket.api.lobby.domain.param.proto.LobbyCalenderUrlReqProto.LobbyCalenderUrlReq parseFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input, extensionRegistry);
    }
    public static com.classlink.websocket.api.lobby.domain.param.proto.LobbyCalenderUrlReqProto.LobbyCalenderUrlReq parseDelimitedFrom(java.io.InputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseDelimitedWithIOException(PARSER, input);
    }
    public static com.classlink.websocket.api.lobby.domain.param.proto.LobbyCalenderUrlReqProto.LobbyCalenderUrlReq parseDelimitedFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
    }
    public static com.classlink.websocket.api.lobby.domain.param.proto.LobbyCalenderUrlReqProto.LobbyCalenderUrlReq parseFrom(
        com.google.protobuf.CodedInputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input);
    }
    public static com.classlink.websocket.api.lobby.domain.param.proto.LobbyCalenderUrlReqProto.LobbyCalenderUrlReq parseFrom(
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
    public static Builder newBuilder(com.classlink.websocket.api.lobby.domain.param.proto.LobbyCalenderUrlReqProto.LobbyCalenderUrlReq prototype) {
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
     * Protobuf type {@code Classlink.LobbyCalenderUrlReq}
     */
    public static final class Builder extends
        com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
        // @@protoc_insertion_point(builder_implements:Classlink.LobbyCalenderUrlReq)
        com.classlink.websocket.api.lobby.domain.param.proto.LobbyCalenderUrlReqProto.LobbyCalenderUrlReqOrBuilder {
      public static final com.google.protobuf.Descriptors.Descriptor
          getDescriptor() {
        return com.classlink.websocket.api.lobby.domain.param.proto.LobbyCalenderUrlReqProto.internal_static_Classlink_LobbyCalenderUrlReq_descriptor;
      }

      @java.lang.Override
      protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
          internalGetFieldAccessorTable() {
        return com.classlink.websocket.api.lobby.domain.param.proto.LobbyCalenderUrlReqProto.internal_static_Classlink_LobbyCalenderUrlReq_fieldAccessorTable
            .ensureFieldAccessorsInitialized(
                com.classlink.websocket.api.lobby.domain.param.proto.LobbyCalenderUrlReqProto.LobbyCalenderUrlReq.class, com.classlink.websocket.api.lobby.domain.param.proto.LobbyCalenderUrlReqProto.LobbyCalenderUrlReq.Builder.class);
      }

      // Construct using com.classlink.websocket.api.lobby.domain.param.proto.LobbyCalenderUrlReqProto.LobbyCalenderUrlReq.newBuilder()
      private Builder() {

      }

      private Builder(
          com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
        super(parent);

      }
      @java.lang.Override
      public Builder clear() {
        super.clear();
        insCode_ = "";

        tarIdentityType_ = "";

        return this;
      }

      @java.lang.Override
      public com.google.protobuf.Descriptors.Descriptor
          getDescriptorForType() {
        return com.classlink.websocket.api.lobby.domain.param.proto.LobbyCalenderUrlReqProto.internal_static_Classlink_LobbyCalenderUrlReq_descriptor;
      }

      @java.lang.Override
      public com.classlink.websocket.api.lobby.domain.param.proto.LobbyCalenderUrlReqProto.LobbyCalenderUrlReq getDefaultInstanceForType() {
        return com.classlink.websocket.api.lobby.domain.param.proto.LobbyCalenderUrlReqProto.LobbyCalenderUrlReq.getDefaultInstance();
      }

      @java.lang.Override
      public com.classlink.websocket.api.lobby.domain.param.proto.LobbyCalenderUrlReqProto.LobbyCalenderUrlReq build() {
        com.classlink.websocket.api.lobby.domain.param.proto.LobbyCalenderUrlReqProto.LobbyCalenderUrlReq result = buildPartial();
        if (!result.isInitialized()) {
          throw newUninitializedMessageException(result);
        }
        return result;
      }

      @java.lang.Override
      public com.classlink.websocket.api.lobby.domain.param.proto.LobbyCalenderUrlReqProto.LobbyCalenderUrlReq buildPartial() {
        com.classlink.websocket.api.lobby.domain.param.proto.LobbyCalenderUrlReqProto.LobbyCalenderUrlReq result = new com.classlink.websocket.api.lobby.domain.param.proto.LobbyCalenderUrlReqProto.LobbyCalenderUrlReq(this);
        result.insCode_ = insCode_;
        result.tarIdentityType_ = tarIdentityType_;
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
        if (other instanceof com.classlink.websocket.api.lobby.domain.param.proto.LobbyCalenderUrlReqProto.LobbyCalenderUrlReq) {
          return mergeFrom((com.classlink.websocket.api.lobby.domain.param.proto.LobbyCalenderUrlReqProto.LobbyCalenderUrlReq)other);
        } else {
          super.mergeFrom(other);
          return this;
        }
      }

      public Builder mergeFrom(com.classlink.websocket.api.lobby.domain.param.proto.LobbyCalenderUrlReqProto.LobbyCalenderUrlReq other) {
        if (other == com.classlink.websocket.api.lobby.domain.param.proto.LobbyCalenderUrlReqProto.LobbyCalenderUrlReq.getDefaultInstance()) return this;
        if (!other.getInsCode().isEmpty()) {
          insCode_ = other.insCode_;
          onChanged();
        }
        if (!other.getTarIdentityType().isEmpty()) {
          tarIdentityType_ = other.tarIdentityType_;
          onChanged();
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
              case 10: {
                insCode_ = input.readStringRequireUtf8();

                break;
              } // case 10
              case 18: {
                tarIdentityType_ = input.readStringRequireUtf8();

                break;
              } // case 18
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

      private java.lang.Object insCode_ = "";
      /**
       * <code>string InsCode = 1;</code>
       * @return The insCode.
       */
      public java.lang.String getInsCode() {
        java.lang.Object ref = insCode_;
        if (!(ref instanceof java.lang.String)) {
          com.google.protobuf.ByteString bs =
              (com.google.protobuf.ByteString) ref;
          java.lang.String s = bs.toStringUtf8();
          insCode_ = s;
          return s;
        } else {
          return (java.lang.String) ref;
        }
      }
      /**
       * <code>string InsCode = 1;</code>
       * @return The bytes for insCode.
       */
      public com.google.protobuf.ByteString
          getInsCodeBytes() {
        java.lang.Object ref = insCode_;
        if (ref instanceof String) {
          com.google.protobuf.ByteString b = 
              com.google.protobuf.ByteString.copyFromUtf8(
                  (java.lang.String) ref);
          insCode_ = b;
          return b;
        } else {
          return (com.google.protobuf.ByteString) ref;
        }
      }
      /**
       * <code>string InsCode = 1;</code>
       * @param value The insCode to set.
       * @return This builder for chaining.
       */
      public Builder setInsCode(
          java.lang.String value) {
        if (value == null) {
    throw new NullPointerException();
  }
  
        insCode_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>string InsCode = 1;</code>
       * @return This builder for chaining.
       */
      public Builder clearInsCode() {
        
        insCode_ = getDefaultInstance().getInsCode();
        onChanged();
        return this;
      }
      /**
       * <code>string InsCode = 1;</code>
       * @param value The bytes for insCode to set.
       * @return This builder for chaining.
       */
      public Builder setInsCodeBytes(
          com.google.protobuf.ByteString value) {
        if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
        
        insCode_ = value;
        onChanged();
        return this;
      }

      private java.lang.Object tarIdentityType_ = "";
      /**
       * <code>string TarIdentityType = 2;</code>
       * @return The tarIdentityType.
       */
      public java.lang.String getTarIdentityType() {
        java.lang.Object ref = tarIdentityType_;
        if (!(ref instanceof java.lang.String)) {
          com.google.protobuf.ByteString bs =
              (com.google.protobuf.ByteString) ref;
          java.lang.String s = bs.toStringUtf8();
          tarIdentityType_ = s;
          return s;
        } else {
          return (java.lang.String) ref;
        }
      }
      /**
       * <code>string TarIdentityType = 2;</code>
       * @return The bytes for tarIdentityType.
       */
      public com.google.protobuf.ByteString
          getTarIdentityTypeBytes() {
        java.lang.Object ref = tarIdentityType_;
        if (ref instanceof String) {
          com.google.protobuf.ByteString b = 
              com.google.protobuf.ByteString.copyFromUtf8(
                  (java.lang.String) ref);
          tarIdentityType_ = b;
          return b;
        } else {
          return (com.google.protobuf.ByteString) ref;
        }
      }
      /**
       * <code>string TarIdentityType = 2;</code>
       * @param value The tarIdentityType to set.
       * @return This builder for chaining.
       */
      public Builder setTarIdentityType(
          java.lang.String value) {
        if (value == null) {
    throw new NullPointerException();
  }
  
        tarIdentityType_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>string TarIdentityType = 2;</code>
       * @return This builder for chaining.
       */
      public Builder clearTarIdentityType() {
        
        tarIdentityType_ = getDefaultInstance().getTarIdentityType();
        onChanged();
        return this;
      }
      /**
       * <code>string TarIdentityType = 2;</code>
       * @param value The bytes for tarIdentityType to set.
       * @return This builder for chaining.
       */
      public Builder setTarIdentityTypeBytes(
          com.google.protobuf.ByteString value) {
        if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
        
        tarIdentityType_ = value;
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


      // @@protoc_insertion_point(builder_scope:Classlink.LobbyCalenderUrlReq)
    }

    // @@protoc_insertion_point(class_scope:Classlink.LobbyCalenderUrlReq)
    private static final com.classlink.websocket.api.lobby.domain.param.proto.LobbyCalenderUrlReqProto.LobbyCalenderUrlReq DEFAULT_INSTANCE;
    static {
      DEFAULT_INSTANCE = new com.classlink.websocket.api.lobby.domain.param.proto.LobbyCalenderUrlReqProto.LobbyCalenderUrlReq();
    }

    public static com.classlink.websocket.api.lobby.domain.param.proto.LobbyCalenderUrlReqProto.LobbyCalenderUrlReq getDefaultInstance() {
      return DEFAULT_INSTANCE;
    }

    private static final com.google.protobuf.Parser<LobbyCalenderUrlReq>
        PARSER = new com.google.protobuf.AbstractParser<LobbyCalenderUrlReq>() {
      @java.lang.Override
      public LobbyCalenderUrlReq parsePartialFrom(
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

    public static com.google.protobuf.Parser<LobbyCalenderUrlReq> parser() {
      return PARSER;
    }

    @java.lang.Override
    public com.google.protobuf.Parser<LobbyCalenderUrlReq> getParserForType() {
      return PARSER;
    }

    @java.lang.Override
    public com.classlink.websocket.api.lobby.domain.param.proto.LobbyCalenderUrlReqProto.LobbyCalenderUrlReq getDefaultInstanceForType() {
      return DEFAULT_INSTANCE;
    }

  }

  private static final com.google.protobuf.Descriptors.Descriptor
    internal_static_Classlink_LobbyCalenderUrlReq_descriptor;
  private static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_Classlink_LobbyCalenderUrlReq_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\031LobbyCalenderUrlReq.proto\022\tClasslink\"?" +
      "\n\023LobbyCalenderUrlReq\022\017\n\007InsCode\030\001 \001(\t\022\027" +
      "\n\017TarIdentityType\030\002 \001(\tBP\n4com.classlink" +
      ".websocket.api.lobby.domain.param.protoB" +
      "\030LobbyCalenderUrlReqProtob\006proto3"
    };
    descriptor = com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        });
    internal_static_Classlink_LobbyCalenderUrlReq_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_Classlink_LobbyCalenderUrlReq_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_Classlink_LobbyCalenderUrlReq_descriptor,
        new java.lang.String[] { "InsCode", "TarIdentityType", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}