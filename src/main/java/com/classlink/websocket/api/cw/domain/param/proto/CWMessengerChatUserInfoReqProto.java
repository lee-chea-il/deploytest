// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: CWMessengerChatUserInfoReq.proto

package com.classlink.websocket.api.cw.domain.param.proto;

public final class CWMessengerChatUserInfoReqProto {
  private CWMessengerChatUserInfoReqProto() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  public interface CWMessengerChatUserInfoReqOrBuilder extends
      // @@protoc_insertion_point(interface_extends:Classlink.CWMessengerChatUserInfoReq)
      com.google.protobuf.MessageOrBuilder {

    /**
     * <code>int32 MemIdx = 1;</code>
     * @return The memIdx.
     */
    int getMemIdx();

    /**
     * <code>string IdentityType = 2;</code>
     * @return The identityType.
     */
    String getIdentityType();
    /**
     * <code>string IdentityType = 2;</code>
     * @return The bytes for identityType.
     */
    com.google.protobuf.ByteString
        getIdentityTypeBytes();
  }
  /**
   * Protobuf type {@code Classlink.CWMessengerChatUserInfoReq}
   */
  public static final class CWMessengerChatUserInfoReq extends
      com.google.protobuf.GeneratedMessageV3 implements
      // @@protoc_insertion_point(message_implements:Classlink.CWMessengerChatUserInfoReq)
      CWMessengerChatUserInfoReqOrBuilder {
  private static final long serialVersionUID = 0L;
    // Use CWMessengerChatUserInfoReq.newBuilder() to construct.
    private CWMessengerChatUserInfoReq(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
      super(builder);
    }
    private CWMessengerChatUserInfoReq() {
      identityType_ = "";
    }

    @Override
    @SuppressWarnings({"unused"})
    protected Object newInstance(
        UnusedPrivateParameter unused) {
      return new CWMessengerChatUserInfoReq();
    }

    @Override
    public final com.google.protobuf.UnknownFieldSet
    getUnknownFields() {
      return this.unknownFields;
    }
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return CWMessengerChatUserInfoReqProto.internal_static_Classlink_CWMessengerChatUserInfoReq_descriptor;
    }

    @Override
    protected FieldAccessorTable
        internalGetFieldAccessorTable() {
      return CWMessengerChatUserInfoReqProto.internal_static_Classlink_CWMessengerChatUserInfoReq_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              CWMessengerChatUserInfoReq.class, Builder.class);
    }

    public static final int MEMIDX_FIELD_NUMBER = 1;
    private int memIdx_;
    /**
     * <code>int32 MemIdx = 1;</code>
     * @return The memIdx.
     */
    @Override
    public int getMemIdx() {
      return memIdx_;
    }

    public static final int IDENTITYTYPE_FIELD_NUMBER = 2;
    private volatile Object identityType_;
    /**
     * <code>string IdentityType = 2;</code>
     * @return The identityType.
     */
    @Override
    public String getIdentityType() {
      Object ref = identityType_;
      if (ref instanceof String) {
        return (String) ref;
      } else {
        com.google.protobuf.ByteString bs = 
            (com.google.protobuf.ByteString) ref;
        String s = bs.toStringUtf8();
        identityType_ = s;
        return s;
      }
    }
    /**
     * <code>string IdentityType = 2;</code>
     * @return The bytes for identityType.
     */
    @Override
    public com.google.protobuf.ByteString
        getIdentityTypeBytes() {
      Object ref = identityType_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (String) ref);
        identityType_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }

    private byte memoizedIsInitialized = -1;
    @Override
    public final boolean isInitialized() {
      byte isInitialized = memoizedIsInitialized;
      if (isInitialized == 1) return true;
      if (isInitialized == 0) return false;

      memoizedIsInitialized = 1;
      return true;
    }

    @Override
    public void writeTo(com.google.protobuf.CodedOutputStream output)
                        throws java.io.IOException {
      if (memIdx_ != 0) {
        output.writeInt32(1, memIdx_);
      }
      if (!com.google.protobuf.GeneratedMessageV3.isStringEmpty(identityType_)) {
        com.google.protobuf.GeneratedMessageV3.writeString(output, 2, identityType_);
      }
      getUnknownFields().writeTo(output);
    }

    @Override
    public int getSerializedSize() {
      int size = memoizedSize;
      if (size != -1) return size;

      size = 0;
      if (memIdx_ != 0) {
        size += com.google.protobuf.CodedOutputStream
          .computeInt32Size(1, memIdx_);
      }
      if (!com.google.protobuf.GeneratedMessageV3.isStringEmpty(identityType_)) {
        size += com.google.protobuf.GeneratedMessageV3.computeStringSize(2, identityType_);
      }
      size += getUnknownFields().getSerializedSize();
      memoizedSize = size;
      return size;
    }

    @Override
    public boolean equals(final Object obj) {
      if (obj == this) {
       return true;
      }
      if (!(obj instanceof CWMessengerChatUserInfoReq)) {
        return super.equals(obj);
      }
      CWMessengerChatUserInfoReq other = (CWMessengerChatUserInfoReq) obj;

      if (getMemIdx()
          != other.getMemIdx()) return false;
      if (!getIdentityType()
          .equals(other.getIdentityType())) return false;
      if (!getUnknownFields().equals(other.getUnknownFields())) return false;
      return true;
    }

    @Override
    public int hashCode() {
      if (memoizedHashCode != 0) {
        return memoizedHashCode;
      }
      int hash = 41;
      hash = (19 * hash) + getDescriptor().hashCode();
      hash = (37 * hash) + MEMIDX_FIELD_NUMBER;
      hash = (53 * hash) + getMemIdx();
      hash = (37 * hash) + IDENTITYTYPE_FIELD_NUMBER;
      hash = (53 * hash) + getIdentityType().hashCode();
      hash = (29 * hash) + getUnknownFields().hashCode();
      memoizedHashCode = hash;
      return hash;
    }

    public static CWMessengerChatUserInfoReq parseFrom(
        java.nio.ByteBuffer data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static CWMessengerChatUserInfoReq parseFrom(
        java.nio.ByteBuffer data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static CWMessengerChatUserInfoReq parseFrom(
        com.google.protobuf.ByteString data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static CWMessengerChatUserInfoReq parseFrom(
        com.google.protobuf.ByteString data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static CWMessengerChatUserInfoReq parseFrom(byte[] data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static CWMessengerChatUserInfoReq parseFrom(
        byte[] data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static CWMessengerChatUserInfoReq parseFrom(java.io.InputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input);
    }
    public static CWMessengerChatUserInfoReq parseFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input, extensionRegistry);
    }
    public static CWMessengerChatUserInfoReq parseDelimitedFrom(java.io.InputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseDelimitedWithIOException(PARSER, input);
    }
    public static CWMessengerChatUserInfoReq parseDelimitedFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
    }
    public static CWMessengerChatUserInfoReq parseFrom(
        com.google.protobuf.CodedInputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input);
    }
    public static CWMessengerChatUserInfoReq parseFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input, extensionRegistry);
    }

    @Override
    public Builder newBuilderForType() { return newBuilder(); }
    public static Builder newBuilder() {
      return DEFAULT_INSTANCE.toBuilder();
    }
    public static Builder newBuilder(CWMessengerChatUserInfoReq prototype) {
      return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
    }
    @Override
    public Builder toBuilder() {
      return this == DEFAULT_INSTANCE
          ? new Builder() : new Builder().mergeFrom(this);
    }

    @Override
    protected Builder newBuilderForType(
        BuilderParent parent) {
      Builder builder = new Builder(parent);
      return builder;
    }
    /**
     * Protobuf type {@code Classlink.CWMessengerChatUserInfoReq}
     */
    public static final class Builder extends
        com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
        // @@protoc_insertion_point(builder_implements:Classlink.CWMessengerChatUserInfoReq)
        CWMessengerChatUserInfoReqOrBuilder {
      public static final com.google.protobuf.Descriptors.Descriptor
          getDescriptor() {
        return CWMessengerChatUserInfoReqProto.internal_static_Classlink_CWMessengerChatUserInfoReq_descriptor;
      }

      @Override
      protected FieldAccessorTable
          internalGetFieldAccessorTable() {
        return CWMessengerChatUserInfoReqProto.internal_static_Classlink_CWMessengerChatUserInfoReq_fieldAccessorTable
            .ensureFieldAccessorsInitialized(
                CWMessengerChatUserInfoReq.class, Builder.class);
      }

      // Construct using com.classlink.websocket.api.cw.domain.param.proto.CWMessengerChatUserInfoReqProto.CWMessengerChatUserInfoReq.newBuilder()
      private Builder() {

      }

      private Builder(
          BuilderParent parent) {
        super(parent);

      }
      @Override
      public Builder clear() {
        super.clear();
        memIdx_ = 0;

        identityType_ = "";

        return this;
      }

      @Override
      public com.google.protobuf.Descriptors.Descriptor
          getDescriptorForType() {
        return CWMessengerChatUserInfoReqProto.internal_static_Classlink_CWMessengerChatUserInfoReq_descriptor;
      }

      @Override
      public CWMessengerChatUserInfoReq getDefaultInstanceForType() {
        return CWMessengerChatUserInfoReq.getDefaultInstance();
      }

      @Override
      public CWMessengerChatUserInfoReq build() {
        CWMessengerChatUserInfoReq result = buildPartial();
        if (!result.isInitialized()) {
          throw newUninitializedMessageException(result);
        }
        return result;
      }

      @Override
      public CWMessengerChatUserInfoReq buildPartial() {
        CWMessengerChatUserInfoReq result = new CWMessengerChatUserInfoReq(this);
        result.memIdx_ = memIdx_;
        result.identityType_ = identityType_;
        onBuilt();
        return result;
      }

      @Override
      public Builder clone() {
        return super.clone();
      }
      @Override
      public Builder setField(
          com.google.protobuf.Descriptors.FieldDescriptor field,
          Object value) {
        return super.setField(field, value);
      }
      @Override
      public Builder clearField(
          com.google.protobuf.Descriptors.FieldDescriptor field) {
        return super.clearField(field);
      }
      @Override
      public Builder clearOneof(
          com.google.protobuf.Descriptors.OneofDescriptor oneof) {
        return super.clearOneof(oneof);
      }
      @Override
      public Builder setRepeatedField(
          com.google.protobuf.Descriptors.FieldDescriptor field,
          int index, Object value) {
        return super.setRepeatedField(field, index, value);
      }
      @Override
      public Builder addRepeatedField(
          com.google.protobuf.Descriptors.FieldDescriptor field,
          Object value) {
        return super.addRepeatedField(field, value);
      }
      @Override
      public Builder mergeFrom(com.google.protobuf.Message other) {
        if (other instanceof CWMessengerChatUserInfoReq) {
          return mergeFrom((CWMessengerChatUserInfoReq)other);
        } else {
          super.mergeFrom(other);
          return this;
        }
      }

      public Builder mergeFrom(CWMessengerChatUserInfoReq other) {
        if (other == CWMessengerChatUserInfoReq.getDefaultInstance()) return this;
        if (other.getMemIdx() != 0) {
          setMemIdx(other.getMemIdx());
        }
        if (!other.getIdentityType().isEmpty()) {
          identityType_ = other.identityType_;
          onChanged();
        }
        this.mergeUnknownFields(other.getUnknownFields());
        onChanged();
        return this;
      }

      @Override
      public final boolean isInitialized() {
        return true;
      }

      @Override
      public Builder mergeFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws java.io.IOException {
        if (extensionRegistry == null) {
          throw new NullPointerException();
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
                memIdx_ = input.readInt32();

                break;
              } // case 8
              case 18: {
                identityType_ = input.readStringRequireUtf8();

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

      private int memIdx_ ;
      /**
       * <code>int32 MemIdx = 1;</code>
       * @return The memIdx.
       */
      @Override
      public int getMemIdx() {
        return memIdx_;
      }
      /**
       * <code>int32 MemIdx = 1;</code>
       * @param value The memIdx to set.
       * @return This builder for chaining.
       */
      public Builder setMemIdx(int value) {
        
        memIdx_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>int32 MemIdx = 1;</code>
       * @return This builder for chaining.
       */
      public Builder clearMemIdx() {
        
        memIdx_ = 0;
        onChanged();
        return this;
      }

      private Object identityType_ = "";
      /**
       * <code>string IdentityType = 2;</code>
       * @return The identityType.
       */
      public String getIdentityType() {
        Object ref = identityType_;
        if (!(ref instanceof String)) {
          com.google.protobuf.ByteString bs =
              (com.google.protobuf.ByteString) ref;
          String s = bs.toStringUtf8();
          identityType_ = s;
          return s;
        } else {
          return (String) ref;
        }
      }
      /**
       * <code>string IdentityType = 2;</code>
       * @return The bytes for identityType.
       */
      public com.google.protobuf.ByteString
          getIdentityTypeBytes() {
        Object ref = identityType_;
        if (ref instanceof String) {
          com.google.protobuf.ByteString b = 
              com.google.protobuf.ByteString.copyFromUtf8(
                  (String) ref);
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
          String value) {
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
      @Override
      public final Builder setUnknownFields(
          final com.google.protobuf.UnknownFieldSet unknownFields) {
        return super.setUnknownFields(unknownFields);
      }

      @Override
      public final Builder mergeUnknownFields(
          final com.google.protobuf.UnknownFieldSet unknownFields) {
        return super.mergeUnknownFields(unknownFields);
      }


      // @@protoc_insertion_point(builder_scope:Classlink.CWMessengerChatUserInfoReq)
    }

    // @@protoc_insertion_point(class_scope:Classlink.CWMessengerChatUserInfoReq)
    private static final CWMessengerChatUserInfoReq DEFAULT_INSTANCE;
    static {
      DEFAULT_INSTANCE = new CWMessengerChatUserInfoReq();
    }

    public static CWMessengerChatUserInfoReq getDefaultInstance() {
      return DEFAULT_INSTANCE;
    }

    private static final com.google.protobuf.Parser<CWMessengerChatUserInfoReq>
        PARSER = new com.google.protobuf.AbstractParser<CWMessengerChatUserInfoReq>() {
      @Override
      public CWMessengerChatUserInfoReq parsePartialFrom(
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

    public static com.google.protobuf.Parser<CWMessengerChatUserInfoReq> parser() {
      return PARSER;
    }

    @Override
    public com.google.protobuf.Parser<CWMessengerChatUserInfoReq> getParserForType() {
      return PARSER;
    }

    @Override
    public CWMessengerChatUserInfoReq getDefaultInstanceForType() {
      return DEFAULT_INSTANCE;
    }

  }

  private static final com.google.protobuf.Descriptors.Descriptor
    internal_static_Classlink_CWMessengerChatUserInfoReq_descriptor;
  private static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_Classlink_CWMessengerChatUserInfoReq_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    String[] descriptorData = {
      "\n CWMessengerChatUserInfoReq.proto\022\tClas" +
      "slink\"B\n\032CWMessengerChatUserInfoReq\022\016\n\006M" +
      "emIdx\030\001 \001(\005\022\024\n\014IdentityType\030\002 \001(\tBT\n1com" +
      ".classlink.websocket.api.cw.domain.param" +
      ".protoB\037CWMessengerChatUserInfoReqProtob" +
      "\006proto3"
    };
    descriptor = com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        });
    internal_static_Classlink_CWMessengerChatUserInfoReq_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_Classlink_CWMessengerChatUserInfoReq_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_Classlink_CWMessengerChatUserInfoReq_descriptor,
        new String[] { "MemIdx", "IdentityType", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}
