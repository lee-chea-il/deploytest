// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: IdentityAvatarChangeReq.proto

package com.classlink.websocket.api.member.domain.param.proto;

public final class IdentityAvatarChangeReqProto {
  private IdentityAvatarChangeReqProto() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  public interface IdentityAvatarChangeReqOrBuilder extends
      // @@protoc_insertion_point(interface_extends:Classlink.IdentityAvatarChangeReq)
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
     * <code>string IdentityType = 2;</code>
     * @return The identityType.
     */
    java.lang.String getIdentityType();
    /**
     * <code>string IdentityType = 2;</code>
     * @return The bytes for identityType.
     */
    com.google.protobuf.ByteString
        getIdentityTypeBytes();

    /**
     * <code>string AvatarId = 3;</code>
     * @return The avatarId.
     */
    java.lang.String getAvatarId();
    /**
     * <code>string AvatarId = 3;</code>
     * @return The bytes for avatarId.
     */
    com.google.protobuf.ByteString
        getAvatarIdBytes();
  }
  /**
   * Protobuf type {@code Classlink.IdentityAvatarChangeReq}
   */
  public static final class IdentityAvatarChangeReq extends
      com.google.protobuf.GeneratedMessageV3 implements
      // @@protoc_insertion_point(message_implements:Classlink.IdentityAvatarChangeReq)
      IdentityAvatarChangeReqOrBuilder {
  private static final long serialVersionUID = 0L;
    // Use IdentityAvatarChangeReq.newBuilder() to construct.
    private IdentityAvatarChangeReq(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
      super(builder);
    }
    private IdentityAvatarChangeReq() {
      insCode_ = "";
      identityType_ = "";
      avatarId_ = "";
    }

    @java.lang.Override
    @SuppressWarnings({"unused"})
    protected java.lang.Object newInstance(
        UnusedPrivateParameter unused) {
      return new IdentityAvatarChangeReq();
    }

    @java.lang.Override
    public final com.google.protobuf.UnknownFieldSet
    getUnknownFields() {
      return this.unknownFields;
    }
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return com.classlink.websocket.api.member.domain.param.proto.IdentityAvatarChangeReqProto.internal_static_Classlink_IdentityAvatarChangeReq_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.classlink.websocket.api.member.domain.param.proto.IdentityAvatarChangeReqProto.internal_static_Classlink_IdentityAvatarChangeReq_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.classlink.websocket.api.member.domain.param.proto.IdentityAvatarChangeReqProto.IdentityAvatarChangeReq.class, com.classlink.websocket.api.member.domain.param.proto.IdentityAvatarChangeReqProto.IdentityAvatarChangeReq.Builder.class);
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

    public static final int IDENTITYTYPE_FIELD_NUMBER = 2;
    private volatile java.lang.Object identityType_;
    /**
     * <code>string IdentityType = 2;</code>
     * @return The identityType.
     */
    @java.lang.Override
    public java.lang.String getIdentityType() {
      java.lang.Object ref = identityType_;
      if (ref instanceof java.lang.String) {
        return (java.lang.String) ref;
      } else {
        com.google.protobuf.ByteString bs = 
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        identityType_ = s;
        return s;
      }
    }
    /**
     * <code>string IdentityType = 2;</code>
     * @return The bytes for identityType.
     */
    @java.lang.Override
    public com.google.protobuf.ByteString
        getIdentityTypeBytes() {
      java.lang.Object ref = identityType_;
      if (ref instanceof java.lang.String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        identityType_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }

    public static final int AVATARID_FIELD_NUMBER = 3;
    private volatile java.lang.Object avatarId_;
    /**
     * <code>string AvatarId = 3;</code>
     * @return The avatarId.
     */
    @java.lang.Override
    public java.lang.String getAvatarId() {
      java.lang.Object ref = avatarId_;
      if (ref instanceof java.lang.String) {
        return (java.lang.String) ref;
      } else {
        com.google.protobuf.ByteString bs = 
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        avatarId_ = s;
        return s;
      }
    }
    /**
     * <code>string AvatarId = 3;</code>
     * @return The bytes for avatarId.
     */
    @java.lang.Override
    public com.google.protobuf.ByteString
        getAvatarIdBytes() {
      java.lang.Object ref = avatarId_;
      if (ref instanceof java.lang.String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        avatarId_ = b;
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
      if (!com.google.protobuf.GeneratedMessageV3.isStringEmpty(identityType_)) {
        com.google.protobuf.GeneratedMessageV3.writeString(output, 2, identityType_);
      }
      if (!com.google.protobuf.GeneratedMessageV3.isStringEmpty(avatarId_)) {
        com.google.protobuf.GeneratedMessageV3.writeString(output, 3, avatarId_);
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
      if (!com.google.protobuf.GeneratedMessageV3.isStringEmpty(identityType_)) {
        size += com.google.protobuf.GeneratedMessageV3.computeStringSize(2, identityType_);
      }
      if (!com.google.protobuf.GeneratedMessageV3.isStringEmpty(avatarId_)) {
        size += com.google.protobuf.GeneratedMessageV3.computeStringSize(3, avatarId_);
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
      if (!(obj instanceof com.classlink.websocket.api.member.domain.param.proto.IdentityAvatarChangeReqProto.IdentityAvatarChangeReq)) {
        return super.equals(obj);
      }
      com.classlink.websocket.api.member.domain.param.proto.IdentityAvatarChangeReqProto.IdentityAvatarChangeReq other = (com.classlink.websocket.api.member.domain.param.proto.IdentityAvatarChangeReqProto.IdentityAvatarChangeReq) obj;

      if (!getInsCode()
          .equals(other.getInsCode())) return false;
      if (!getIdentityType()
          .equals(other.getIdentityType())) return false;
      if (!getAvatarId()
          .equals(other.getAvatarId())) return false;
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
      hash = (37 * hash) + IDENTITYTYPE_FIELD_NUMBER;
      hash = (53 * hash) + getIdentityType().hashCode();
      hash = (37 * hash) + AVATARID_FIELD_NUMBER;
      hash = (53 * hash) + getAvatarId().hashCode();
      hash = (29 * hash) + getUnknownFields().hashCode();
      memoizedHashCode = hash;
      return hash;
    }

    public static com.classlink.websocket.api.member.domain.param.proto.IdentityAvatarChangeReqProto.IdentityAvatarChangeReq parseFrom(
        java.nio.ByteBuffer data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static com.classlink.websocket.api.member.domain.param.proto.IdentityAvatarChangeReqProto.IdentityAvatarChangeReq parseFrom(
        java.nio.ByteBuffer data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static com.classlink.websocket.api.member.domain.param.proto.IdentityAvatarChangeReqProto.IdentityAvatarChangeReq parseFrom(
        com.google.protobuf.ByteString data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static com.classlink.websocket.api.member.domain.param.proto.IdentityAvatarChangeReqProto.IdentityAvatarChangeReq parseFrom(
        com.google.protobuf.ByteString data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static com.classlink.websocket.api.member.domain.param.proto.IdentityAvatarChangeReqProto.IdentityAvatarChangeReq parseFrom(byte[] data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static com.classlink.websocket.api.member.domain.param.proto.IdentityAvatarChangeReqProto.IdentityAvatarChangeReq parseFrom(
        byte[] data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static com.classlink.websocket.api.member.domain.param.proto.IdentityAvatarChangeReqProto.IdentityAvatarChangeReq parseFrom(java.io.InputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input);
    }
    public static com.classlink.websocket.api.member.domain.param.proto.IdentityAvatarChangeReqProto.IdentityAvatarChangeReq parseFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input, extensionRegistry);
    }
    public static com.classlink.websocket.api.member.domain.param.proto.IdentityAvatarChangeReqProto.IdentityAvatarChangeReq parseDelimitedFrom(java.io.InputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseDelimitedWithIOException(PARSER, input);
    }
    public static com.classlink.websocket.api.member.domain.param.proto.IdentityAvatarChangeReqProto.IdentityAvatarChangeReq parseDelimitedFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
    }
    public static com.classlink.websocket.api.member.domain.param.proto.IdentityAvatarChangeReqProto.IdentityAvatarChangeReq parseFrom(
        com.google.protobuf.CodedInputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input);
    }
    public static com.classlink.websocket.api.member.domain.param.proto.IdentityAvatarChangeReqProto.IdentityAvatarChangeReq parseFrom(
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
    public static Builder newBuilder(com.classlink.websocket.api.member.domain.param.proto.IdentityAvatarChangeReqProto.IdentityAvatarChangeReq prototype) {
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
     * Protobuf type {@code Classlink.IdentityAvatarChangeReq}
     */
    public static final class Builder extends
        com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
        // @@protoc_insertion_point(builder_implements:Classlink.IdentityAvatarChangeReq)
        com.classlink.websocket.api.member.domain.param.proto.IdentityAvatarChangeReqProto.IdentityAvatarChangeReqOrBuilder {
      public static final com.google.protobuf.Descriptors.Descriptor
          getDescriptor() {
        return com.classlink.websocket.api.member.domain.param.proto.IdentityAvatarChangeReqProto.internal_static_Classlink_IdentityAvatarChangeReq_descriptor;
      }

      @java.lang.Override
      protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
          internalGetFieldAccessorTable() {
        return com.classlink.websocket.api.member.domain.param.proto.IdentityAvatarChangeReqProto.internal_static_Classlink_IdentityAvatarChangeReq_fieldAccessorTable
            .ensureFieldAccessorsInitialized(
                com.classlink.websocket.api.member.domain.param.proto.IdentityAvatarChangeReqProto.IdentityAvatarChangeReq.class, com.classlink.websocket.api.member.domain.param.proto.IdentityAvatarChangeReqProto.IdentityAvatarChangeReq.Builder.class);
      }

      // Construct using com.classlink.websocket.api.member.domain.param.proto.IdentityAvatarChangeReqProto.IdentityAvatarChangeReq.newBuilder()
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

        identityType_ = "";

        avatarId_ = "";

        return this;
      }

      @java.lang.Override
      public com.google.protobuf.Descriptors.Descriptor
          getDescriptorForType() {
        return com.classlink.websocket.api.member.domain.param.proto.IdentityAvatarChangeReqProto.internal_static_Classlink_IdentityAvatarChangeReq_descriptor;
      }

      @java.lang.Override
      public com.classlink.websocket.api.member.domain.param.proto.IdentityAvatarChangeReqProto.IdentityAvatarChangeReq getDefaultInstanceForType() {
        return com.classlink.websocket.api.member.domain.param.proto.IdentityAvatarChangeReqProto.IdentityAvatarChangeReq.getDefaultInstance();
      }

      @java.lang.Override
      public com.classlink.websocket.api.member.domain.param.proto.IdentityAvatarChangeReqProto.IdentityAvatarChangeReq build() {
        com.classlink.websocket.api.member.domain.param.proto.IdentityAvatarChangeReqProto.IdentityAvatarChangeReq result = buildPartial();
        if (!result.isInitialized()) {
          throw newUninitializedMessageException(result);
        }
        return result;
      }

      @java.lang.Override
      public com.classlink.websocket.api.member.domain.param.proto.IdentityAvatarChangeReqProto.IdentityAvatarChangeReq buildPartial() {
        com.classlink.websocket.api.member.domain.param.proto.IdentityAvatarChangeReqProto.IdentityAvatarChangeReq result = new com.classlink.websocket.api.member.domain.param.proto.IdentityAvatarChangeReqProto.IdentityAvatarChangeReq(this);
        result.insCode_ = insCode_;
        result.identityType_ = identityType_;
        result.avatarId_ = avatarId_;
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
        if (other instanceof com.classlink.websocket.api.member.domain.param.proto.IdentityAvatarChangeReqProto.IdentityAvatarChangeReq) {
          return mergeFrom((com.classlink.websocket.api.member.domain.param.proto.IdentityAvatarChangeReqProto.IdentityAvatarChangeReq)other);
        } else {
          super.mergeFrom(other);
          return this;
        }
      }

      public Builder mergeFrom(com.classlink.websocket.api.member.domain.param.proto.IdentityAvatarChangeReqProto.IdentityAvatarChangeReq other) {
        if (other == com.classlink.websocket.api.member.domain.param.proto.IdentityAvatarChangeReqProto.IdentityAvatarChangeReq.getDefaultInstance()) return this;
        if (!other.getInsCode().isEmpty()) {
          insCode_ = other.insCode_;
          onChanged();
        }
        if (!other.getIdentityType().isEmpty()) {
          identityType_ = other.identityType_;
          onChanged();
        }
        if (!other.getAvatarId().isEmpty()) {
          avatarId_ = other.avatarId_;
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
                identityType_ = input.readStringRequireUtf8();

                break;
              } // case 18
              case 26: {
                avatarId_ = input.readStringRequireUtf8();

                break;
              } // case 26
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

      private java.lang.Object identityType_ = "";
      /**
       * <code>string IdentityType = 2;</code>
       * @return The identityType.
       */
      public java.lang.String getIdentityType() {
        java.lang.Object ref = identityType_;
        if (!(ref instanceof java.lang.String)) {
          com.google.protobuf.ByteString bs =
              (com.google.protobuf.ByteString) ref;
          java.lang.String s = bs.toStringUtf8();
          identityType_ = s;
          return s;
        } else {
          return (java.lang.String) ref;
        }
      }
      /**
       * <code>string IdentityType = 2;</code>
       * @return The bytes for identityType.
       */
      public com.google.protobuf.ByteString
          getIdentityTypeBytes() {
        java.lang.Object ref = identityType_;
        if (ref instanceof String) {
          com.google.protobuf.ByteString b = 
              com.google.protobuf.ByteString.copyFromUtf8(
                  (java.lang.String) ref);
          identityType_ = b;
          return b;
        } else {
          return (com.google.protobuf.ByteString) ref;
        }
      }
      /**
       * <code>string IdentityType = 2;</code>
       * @param value The identityType to set.
       * @return This builder for chaining.
       */
      public Builder setIdentityType(
          java.lang.String value) {
        if (value == null) {
    throw new NullPointerException();
  }
  
        identityType_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>string IdentityType = 2;</code>
       * @return This builder for chaining.
       */
      public Builder clearIdentityType() {
        
        identityType_ = getDefaultInstance().getIdentityType();
        onChanged();
        return this;
      }
      /**
       * <code>string IdentityType = 2;</code>
       * @param value The bytes for identityType to set.
       * @return This builder for chaining.
       */
      public Builder setIdentityTypeBytes(
          com.google.protobuf.ByteString value) {
        if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
        
        identityType_ = value;
        onChanged();
        return this;
      }

      private java.lang.Object avatarId_ = "";
      /**
       * <code>string AvatarId = 3;</code>
       * @return The avatarId.
       */
      public java.lang.String getAvatarId() {
        java.lang.Object ref = avatarId_;
        if (!(ref instanceof java.lang.String)) {
          com.google.protobuf.ByteString bs =
              (com.google.protobuf.ByteString) ref;
          java.lang.String s = bs.toStringUtf8();
          avatarId_ = s;
          return s;
        } else {
          return (java.lang.String) ref;
        }
      }
      /**
       * <code>string AvatarId = 3;</code>
       * @return The bytes for avatarId.
       */
      public com.google.protobuf.ByteString
          getAvatarIdBytes() {
        java.lang.Object ref = avatarId_;
        if (ref instanceof String) {
          com.google.protobuf.ByteString b = 
              com.google.protobuf.ByteString.copyFromUtf8(
                  (java.lang.String) ref);
          avatarId_ = b;
          return b;
        } else {
          return (com.google.protobuf.ByteString) ref;
        }
      }
      /**
       * <code>string AvatarId = 3;</code>
       * @param value The avatarId to set.
       * @return This builder for chaining.
       */
      public Builder setAvatarId(
          java.lang.String value) {
        if (value == null) {
    throw new NullPointerException();
  }
  
        avatarId_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>string AvatarId = 3;</code>
       * @return This builder for chaining.
       */
      public Builder clearAvatarId() {
        
        avatarId_ = getDefaultInstance().getAvatarId();
        onChanged();
        return this;
      }
      /**
       * <code>string AvatarId = 3;</code>
       * @param value The bytes for avatarId to set.
       * @return This builder for chaining.
       */
      public Builder setAvatarIdBytes(
          com.google.protobuf.ByteString value) {
        if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
        
        avatarId_ = value;
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


      // @@protoc_insertion_point(builder_scope:Classlink.IdentityAvatarChangeReq)
    }

    // @@protoc_insertion_point(class_scope:Classlink.IdentityAvatarChangeReq)
    private static final com.classlink.websocket.api.member.domain.param.proto.IdentityAvatarChangeReqProto.IdentityAvatarChangeReq DEFAULT_INSTANCE;
    static {
      DEFAULT_INSTANCE = new com.classlink.websocket.api.member.domain.param.proto.IdentityAvatarChangeReqProto.IdentityAvatarChangeReq();
    }

    public static com.classlink.websocket.api.member.domain.param.proto.IdentityAvatarChangeReqProto.IdentityAvatarChangeReq getDefaultInstance() {
      return DEFAULT_INSTANCE;
    }

    private static final com.google.protobuf.Parser<IdentityAvatarChangeReq>
        PARSER = new com.google.protobuf.AbstractParser<IdentityAvatarChangeReq>() {
      @java.lang.Override
      public IdentityAvatarChangeReq parsePartialFrom(
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

    public static com.google.protobuf.Parser<IdentityAvatarChangeReq> parser() {
      return PARSER;
    }

    @java.lang.Override
    public com.google.protobuf.Parser<IdentityAvatarChangeReq> getParserForType() {
      return PARSER;
    }

    @java.lang.Override
    public com.classlink.websocket.api.member.domain.param.proto.IdentityAvatarChangeReqProto.IdentityAvatarChangeReq getDefaultInstanceForType() {
      return DEFAULT_INSTANCE;
    }

  }

  private static final com.google.protobuf.Descriptors.Descriptor
    internal_static_Classlink_IdentityAvatarChangeReq_descriptor;
  private static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_Classlink_IdentityAvatarChangeReq_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\035IdentityAvatarChangeReq.proto\022\tClassli" +
      "nk\"R\n\027IdentityAvatarChangeReq\022\017\n\007InsCode" +
      "\030\001 \001(\t\022\024\n\014IdentityType\030\002 \001(\t\022\020\n\010AvatarId" +
      "\030\003 \001(\tBU\n5com.classlink.websocket.api.me" +
      "mber.domain.param.protoB\034IdentityAvatarC" +
      "hangeReqProtob\006proto3"
    };
    descriptor = com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        });
    internal_static_Classlink_IdentityAvatarChangeReq_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_Classlink_IdentityAvatarChangeReq_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_Classlink_IdentityAvatarChangeReq_descriptor,
        new java.lang.String[] { "InsCode", "IdentityType", "AvatarId", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}
