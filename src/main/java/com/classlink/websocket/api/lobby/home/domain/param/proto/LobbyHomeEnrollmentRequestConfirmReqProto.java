// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: LobbyHomeEnrollmentRequestConfirmReq.proto

package com.classlink.websocket.api.lobby.home.domain.param.proto;

public final class LobbyHomeEnrollmentRequestConfirmReqProto {
  private LobbyHomeEnrollmentRequestConfirmReqProto() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  public interface LobbyHomeEnrollmentRequestConfirmReqOrBuilder extends
      // @@protoc_insertion_point(interface_extends:Classlink.LobbyHomeEnrollmentRequestConfirmReq)
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
     * <code>string MemId = 2;</code>
     * @return The memId.
     */
    java.lang.String getMemId();
    /**
     * <code>string MemId = 2;</code>
     * @return The bytes for memId.
     */
    com.google.protobuf.ByteString
        getMemIdBytes();
  }
  /**
   * Protobuf type {@code Classlink.LobbyHomeEnrollmentRequestConfirmReq}
   */
  public static final class LobbyHomeEnrollmentRequestConfirmReq extends
      com.google.protobuf.GeneratedMessageV3 implements
      // @@protoc_insertion_point(message_implements:Classlink.LobbyHomeEnrollmentRequestConfirmReq)
      LobbyHomeEnrollmentRequestConfirmReqOrBuilder {
  private static final long serialVersionUID = 0L;
    // Use LobbyHomeEnrollmentRequestConfirmReq.newBuilder() to construct.
    private LobbyHomeEnrollmentRequestConfirmReq(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
      super(builder);
    }
    private LobbyHomeEnrollmentRequestConfirmReq() {
      insCode_ = "";
      memId_ = "";
    }

    @java.lang.Override
    @SuppressWarnings({"unused"})
    protected java.lang.Object newInstance(
        UnusedPrivateParameter unused) {
      return new LobbyHomeEnrollmentRequestConfirmReq();
    }

    @java.lang.Override
    public final com.google.protobuf.UnknownFieldSet
    getUnknownFields() {
      return this.unknownFields;
    }
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return com.classlink.websocket.api.lobby.home.domain.param.proto.LobbyHomeEnrollmentRequestConfirmReqProto.internal_static_Classlink_LobbyHomeEnrollmentRequestConfirmReq_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.classlink.websocket.api.lobby.home.domain.param.proto.LobbyHomeEnrollmentRequestConfirmReqProto.internal_static_Classlink_LobbyHomeEnrollmentRequestConfirmReq_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.classlink.websocket.api.lobby.home.domain.param.proto.LobbyHomeEnrollmentRequestConfirmReqProto.LobbyHomeEnrollmentRequestConfirmReq.class, com.classlink.websocket.api.lobby.home.domain.param.proto.LobbyHomeEnrollmentRequestConfirmReqProto.LobbyHomeEnrollmentRequestConfirmReq.Builder.class);
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

    public static final int MEMID_FIELD_NUMBER = 2;
    private volatile java.lang.Object memId_;
    /**
     * <code>string MemId = 2;</code>
     * @return The memId.
     */
    @java.lang.Override
    public java.lang.String getMemId() {
      java.lang.Object ref = memId_;
      if (ref instanceof java.lang.String) {
        return (java.lang.String) ref;
      } else {
        com.google.protobuf.ByteString bs = 
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        memId_ = s;
        return s;
      }
    }
    /**
     * <code>string MemId = 2;</code>
     * @return The bytes for memId.
     */
    @java.lang.Override
    public com.google.protobuf.ByteString
        getMemIdBytes() {
      java.lang.Object ref = memId_;
      if (ref instanceof java.lang.String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        memId_ = b;
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
      if (!com.google.protobuf.GeneratedMessageV3.isStringEmpty(memId_)) {
        com.google.protobuf.GeneratedMessageV3.writeString(output, 2, memId_);
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
      if (!com.google.protobuf.GeneratedMessageV3.isStringEmpty(memId_)) {
        size += com.google.protobuf.GeneratedMessageV3.computeStringSize(2, memId_);
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
      if (!(obj instanceof com.classlink.websocket.api.lobby.home.domain.param.proto.LobbyHomeEnrollmentRequestConfirmReqProto.LobbyHomeEnrollmentRequestConfirmReq)) {
        return super.equals(obj);
      }
      com.classlink.websocket.api.lobby.home.domain.param.proto.LobbyHomeEnrollmentRequestConfirmReqProto.LobbyHomeEnrollmentRequestConfirmReq other = (com.classlink.websocket.api.lobby.home.domain.param.proto.LobbyHomeEnrollmentRequestConfirmReqProto.LobbyHomeEnrollmentRequestConfirmReq) obj;

      if (!getInsCode()
          .equals(other.getInsCode())) return false;
      if (!getMemId()
          .equals(other.getMemId())) return false;
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
      hash = (37 * hash) + MEMID_FIELD_NUMBER;
      hash = (53 * hash) + getMemId().hashCode();
      hash = (29 * hash) + getUnknownFields().hashCode();
      memoizedHashCode = hash;
      return hash;
    }

    public static com.classlink.websocket.api.lobby.home.domain.param.proto.LobbyHomeEnrollmentRequestConfirmReqProto.LobbyHomeEnrollmentRequestConfirmReq parseFrom(
        java.nio.ByteBuffer data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static com.classlink.websocket.api.lobby.home.domain.param.proto.LobbyHomeEnrollmentRequestConfirmReqProto.LobbyHomeEnrollmentRequestConfirmReq parseFrom(
        java.nio.ByteBuffer data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static com.classlink.websocket.api.lobby.home.domain.param.proto.LobbyHomeEnrollmentRequestConfirmReqProto.LobbyHomeEnrollmentRequestConfirmReq parseFrom(
        com.google.protobuf.ByteString data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static com.classlink.websocket.api.lobby.home.domain.param.proto.LobbyHomeEnrollmentRequestConfirmReqProto.LobbyHomeEnrollmentRequestConfirmReq parseFrom(
        com.google.protobuf.ByteString data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static com.classlink.websocket.api.lobby.home.domain.param.proto.LobbyHomeEnrollmentRequestConfirmReqProto.LobbyHomeEnrollmentRequestConfirmReq parseFrom(byte[] data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static com.classlink.websocket.api.lobby.home.domain.param.proto.LobbyHomeEnrollmentRequestConfirmReqProto.LobbyHomeEnrollmentRequestConfirmReq parseFrom(
        byte[] data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static com.classlink.websocket.api.lobby.home.domain.param.proto.LobbyHomeEnrollmentRequestConfirmReqProto.LobbyHomeEnrollmentRequestConfirmReq parseFrom(java.io.InputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input);
    }
    public static com.classlink.websocket.api.lobby.home.domain.param.proto.LobbyHomeEnrollmentRequestConfirmReqProto.LobbyHomeEnrollmentRequestConfirmReq parseFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input, extensionRegistry);
    }
    public static com.classlink.websocket.api.lobby.home.domain.param.proto.LobbyHomeEnrollmentRequestConfirmReqProto.LobbyHomeEnrollmentRequestConfirmReq parseDelimitedFrom(java.io.InputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseDelimitedWithIOException(PARSER, input);
    }
    public static com.classlink.websocket.api.lobby.home.domain.param.proto.LobbyHomeEnrollmentRequestConfirmReqProto.LobbyHomeEnrollmentRequestConfirmReq parseDelimitedFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
    }
    public static com.classlink.websocket.api.lobby.home.domain.param.proto.LobbyHomeEnrollmentRequestConfirmReqProto.LobbyHomeEnrollmentRequestConfirmReq parseFrom(
        com.google.protobuf.CodedInputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input);
    }
    public static com.classlink.websocket.api.lobby.home.domain.param.proto.LobbyHomeEnrollmentRequestConfirmReqProto.LobbyHomeEnrollmentRequestConfirmReq parseFrom(
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
    public static Builder newBuilder(com.classlink.websocket.api.lobby.home.domain.param.proto.LobbyHomeEnrollmentRequestConfirmReqProto.LobbyHomeEnrollmentRequestConfirmReq prototype) {
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
     * Protobuf type {@code Classlink.LobbyHomeEnrollmentRequestConfirmReq}
     */
    public static final class Builder extends
        com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
        // @@protoc_insertion_point(builder_implements:Classlink.LobbyHomeEnrollmentRequestConfirmReq)
        com.classlink.websocket.api.lobby.home.domain.param.proto.LobbyHomeEnrollmentRequestConfirmReqProto.LobbyHomeEnrollmentRequestConfirmReqOrBuilder {
      public static final com.google.protobuf.Descriptors.Descriptor
          getDescriptor() {
        return com.classlink.websocket.api.lobby.home.domain.param.proto.LobbyHomeEnrollmentRequestConfirmReqProto.internal_static_Classlink_LobbyHomeEnrollmentRequestConfirmReq_descriptor;
      }

      @java.lang.Override
      protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
          internalGetFieldAccessorTable() {
        return com.classlink.websocket.api.lobby.home.domain.param.proto.LobbyHomeEnrollmentRequestConfirmReqProto.internal_static_Classlink_LobbyHomeEnrollmentRequestConfirmReq_fieldAccessorTable
            .ensureFieldAccessorsInitialized(
                com.classlink.websocket.api.lobby.home.domain.param.proto.LobbyHomeEnrollmentRequestConfirmReqProto.LobbyHomeEnrollmentRequestConfirmReq.class, com.classlink.websocket.api.lobby.home.domain.param.proto.LobbyHomeEnrollmentRequestConfirmReqProto.LobbyHomeEnrollmentRequestConfirmReq.Builder.class);
      }

      // Construct using com.classlink.websocket.api.lobby.home.domain.param.proto.LobbyHomeEnrollmentRequestConfirmReqProto.LobbyHomeEnrollmentRequestConfirmReq.newBuilder()
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

        memId_ = "";

        return this;
      }

      @java.lang.Override
      public com.google.protobuf.Descriptors.Descriptor
          getDescriptorForType() {
        return com.classlink.websocket.api.lobby.home.domain.param.proto.LobbyHomeEnrollmentRequestConfirmReqProto.internal_static_Classlink_LobbyHomeEnrollmentRequestConfirmReq_descriptor;
      }

      @java.lang.Override
      public com.classlink.websocket.api.lobby.home.domain.param.proto.LobbyHomeEnrollmentRequestConfirmReqProto.LobbyHomeEnrollmentRequestConfirmReq getDefaultInstanceForType() {
        return com.classlink.websocket.api.lobby.home.domain.param.proto.LobbyHomeEnrollmentRequestConfirmReqProto.LobbyHomeEnrollmentRequestConfirmReq.getDefaultInstance();
      }

      @java.lang.Override
      public com.classlink.websocket.api.lobby.home.domain.param.proto.LobbyHomeEnrollmentRequestConfirmReqProto.LobbyHomeEnrollmentRequestConfirmReq build() {
        com.classlink.websocket.api.lobby.home.domain.param.proto.LobbyHomeEnrollmentRequestConfirmReqProto.LobbyHomeEnrollmentRequestConfirmReq result = buildPartial();
        if (!result.isInitialized()) {
          throw newUninitializedMessageException(result);
        }
        return result;
      }

      @java.lang.Override
      public com.classlink.websocket.api.lobby.home.domain.param.proto.LobbyHomeEnrollmentRequestConfirmReqProto.LobbyHomeEnrollmentRequestConfirmReq buildPartial() {
        com.classlink.websocket.api.lobby.home.domain.param.proto.LobbyHomeEnrollmentRequestConfirmReqProto.LobbyHomeEnrollmentRequestConfirmReq result = new com.classlink.websocket.api.lobby.home.domain.param.proto.LobbyHomeEnrollmentRequestConfirmReqProto.LobbyHomeEnrollmentRequestConfirmReq(this);
        result.insCode_ = insCode_;
        result.memId_ = memId_;
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
        if (other instanceof com.classlink.websocket.api.lobby.home.domain.param.proto.LobbyHomeEnrollmentRequestConfirmReqProto.LobbyHomeEnrollmentRequestConfirmReq) {
          return mergeFrom((com.classlink.websocket.api.lobby.home.domain.param.proto.LobbyHomeEnrollmentRequestConfirmReqProto.LobbyHomeEnrollmentRequestConfirmReq)other);
        } else {
          super.mergeFrom(other);
          return this;
        }
      }

      public Builder mergeFrom(com.classlink.websocket.api.lobby.home.domain.param.proto.LobbyHomeEnrollmentRequestConfirmReqProto.LobbyHomeEnrollmentRequestConfirmReq other) {
        if (other == com.classlink.websocket.api.lobby.home.domain.param.proto.LobbyHomeEnrollmentRequestConfirmReqProto.LobbyHomeEnrollmentRequestConfirmReq.getDefaultInstance()) return this;
        if (!other.getInsCode().isEmpty()) {
          insCode_ = other.insCode_;
          onChanged();
        }
        if (!other.getMemId().isEmpty()) {
          memId_ = other.memId_;
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
                memId_ = input.readStringRequireUtf8();

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

      private java.lang.Object memId_ = "";
      /**
       * <code>string MemId = 2;</code>
       * @return The memId.
       */
      public java.lang.String getMemId() {
        java.lang.Object ref = memId_;
        if (!(ref instanceof java.lang.String)) {
          com.google.protobuf.ByteString bs =
              (com.google.protobuf.ByteString) ref;
          java.lang.String s = bs.toStringUtf8();
          memId_ = s;
          return s;
        } else {
          return (java.lang.String) ref;
        }
      }
      /**
       * <code>string MemId = 2;</code>
       * @return The bytes for memId.
       */
      public com.google.protobuf.ByteString
          getMemIdBytes() {
        java.lang.Object ref = memId_;
        if (ref instanceof String) {
          com.google.protobuf.ByteString b = 
              com.google.protobuf.ByteString.copyFromUtf8(
                  (java.lang.String) ref);
          memId_ = b;
          return b;
        } else {
          return (com.google.protobuf.ByteString) ref;
        }
      }
      /**
       * <code>string MemId = 2;</code>
       * @param value The memId to set.
       * @return This builder for chaining.
       */
      public Builder setMemId(
          java.lang.String value) {
        if (value == null) {
    throw new NullPointerException();
  }
  
        memId_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>string MemId = 2;</code>
       * @return This builder for chaining.
       */
      public Builder clearMemId() {
        
        memId_ = getDefaultInstance().getMemId();
        onChanged();
        return this;
      }
      /**
       * <code>string MemId = 2;</code>
       * @param value The bytes for memId to set.
       * @return This builder for chaining.
       */
      public Builder setMemIdBytes(
          com.google.protobuf.ByteString value) {
        if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
        
        memId_ = value;
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


      // @@protoc_insertion_point(builder_scope:Classlink.LobbyHomeEnrollmentRequestConfirmReq)
    }

    // @@protoc_insertion_point(class_scope:Classlink.LobbyHomeEnrollmentRequestConfirmReq)
    private static final com.classlink.websocket.api.lobby.home.domain.param.proto.LobbyHomeEnrollmentRequestConfirmReqProto.LobbyHomeEnrollmentRequestConfirmReq DEFAULT_INSTANCE;
    static {
      DEFAULT_INSTANCE = new com.classlink.websocket.api.lobby.home.domain.param.proto.LobbyHomeEnrollmentRequestConfirmReqProto.LobbyHomeEnrollmentRequestConfirmReq();
    }

    public static com.classlink.websocket.api.lobby.home.domain.param.proto.LobbyHomeEnrollmentRequestConfirmReqProto.LobbyHomeEnrollmentRequestConfirmReq getDefaultInstance() {
      return DEFAULT_INSTANCE;
    }

    private static final com.google.protobuf.Parser<LobbyHomeEnrollmentRequestConfirmReq>
        PARSER = new com.google.protobuf.AbstractParser<LobbyHomeEnrollmentRequestConfirmReq>() {
      @java.lang.Override
      public LobbyHomeEnrollmentRequestConfirmReq parsePartialFrom(
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

    public static com.google.protobuf.Parser<LobbyHomeEnrollmentRequestConfirmReq> parser() {
      return PARSER;
    }

    @java.lang.Override
    public com.google.protobuf.Parser<LobbyHomeEnrollmentRequestConfirmReq> getParserForType() {
      return PARSER;
    }

    @java.lang.Override
    public com.classlink.websocket.api.lobby.home.domain.param.proto.LobbyHomeEnrollmentRequestConfirmReqProto.LobbyHomeEnrollmentRequestConfirmReq getDefaultInstanceForType() {
      return DEFAULT_INSTANCE;
    }

  }

  private static final com.google.protobuf.Descriptors.Descriptor
    internal_static_Classlink_LobbyHomeEnrollmentRequestConfirmReq_descriptor;
  private static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_Classlink_LobbyHomeEnrollmentRequestConfirmReq_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n*LobbyHomeEnrollmentRequestConfirmReq.p" +
      "roto\022\tClasslink\"F\n$LobbyHomeEnrollmentRe" +
      "questConfirmReq\022\017\n\007InsCode\030\001 \001(\t\022\r\n\005MemI" +
      "d\030\002 \001(\tBf\n9com.classlink.websocket.api.l" +
      "obby.home.domain.param.protoB)LobbyHomeE" +
      "nrollmentRequestConfirmReqProtob\006proto3"
    };
    descriptor = com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        });
    internal_static_Classlink_LobbyHomeEnrollmentRequestConfirmReq_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_Classlink_LobbyHomeEnrollmentRequestConfirmReq_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_Classlink_LobbyHomeEnrollmentRequestConfirmReq_descriptor,
        new java.lang.String[] { "InsCode", "MemId", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}
