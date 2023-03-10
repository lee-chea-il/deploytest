// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: LobbyInstitutionClassTeacherListReq.proto

package com.classlink.websocket.api.lobby.domain.param.proto;

public final class LobbyInstitutionClassTeacherListReqProto {
  private LobbyInstitutionClassTeacherListReqProto() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  public interface LobbyInstitutionClassTeacherListReqOrBuilder extends
      // @@protoc_insertion_point(interface_extends:Classlink.LobbyInstitutionClassTeacherListReq)
      com.google.protobuf.MessageOrBuilder {

    /**
     * <code>string InsCode = 1;</code>
     * @return The insCode.
     */
    String getInsCode();
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
    String getTarIdentityType();
    /**
     * <code>string TarIdentityType = 2;</code>
     * @return The bytes for tarIdentityType.
     */
    com.google.protobuf.ByteString
        getTarIdentityTypeBytes();
  }
  /**
   * Protobuf type {@code Classlink.LobbyInstitutionClassTeacherListReq}
   */
  public static final class LobbyInstitutionClassTeacherListReq extends
      com.google.protobuf.GeneratedMessageV3 implements
      // @@protoc_insertion_point(message_implements:Classlink.LobbyInstitutionClassTeacherListReq)
      LobbyInstitutionClassTeacherListReqOrBuilder {
  private static final long serialVersionUID = 0L;
    // Use LobbyInstitutionClassTeacherListReq.newBuilder() to construct.
    private LobbyInstitutionClassTeacherListReq(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
      super(builder);
    }
    private LobbyInstitutionClassTeacherListReq() {
      insCode_ = "";
      tarIdentityType_ = "";
    }

    @Override
    @SuppressWarnings({"unused"})
    protected Object newInstance(
        UnusedPrivateParameter unused) {
      return new LobbyInstitutionClassTeacherListReq();
    }

    @Override
    public final com.google.protobuf.UnknownFieldSet
    getUnknownFields() {
      return this.unknownFields;
    }
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return LobbyInstitutionClassTeacherListReqProto.internal_static_Classlink_LobbyInstitutionClassTeacherListReq_descriptor;
    }

    @Override
    protected FieldAccessorTable
        internalGetFieldAccessorTable() {
      return LobbyInstitutionClassTeacherListReqProto.internal_static_Classlink_LobbyInstitutionClassTeacherListReq_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              LobbyInstitutionClassTeacherListReq.class, Builder.class);
    }

    public static final int INSCODE_FIELD_NUMBER = 1;
    private volatile Object insCode_;
    /**
     * <code>string InsCode = 1;</code>
     * @return The insCode.
     */
    @Override
    public String getInsCode() {
      Object ref = insCode_;
      if (ref instanceof String) {
        return (String) ref;
      } else {
        com.google.protobuf.ByteString bs = 
            (com.google.protobuf.ByteString) ref;
        String s = bs.toStringUtf8();
        insCode_ = s;
        return s;
      }
    }
    /**
     * <code>string InsCode = 1;</code>
     * @return The bytes for insCode.
     */
    @Override
    public com.google.protobuf.ByteString
        getInsCodeBytes() {
      Object ref = insCode_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (String) ref);
        insCode_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }

    public static final int TARIDENTITYTYPE_FIELD_NUMBER = 2;
    private volatile Object tarIdentityType_;
    /**
     * <code>string TarIdentityType = 2;</code>
     * @return The tarIdentityType.
     */
    @Override
    public String getTarIdentityType() {
      Object ref = tarIdentityType_;
      if (ref instanceof String) {
        return (String) ref;
      } else {
        com.google.protobuf.ByteString bs = 
            (com.google.protobuf.ByteString) ref;
        String s = bs.toStringUtf8();
        tarIdentityType_ = s;
        return s;
      }
    }
    /**
     * <code>string TarIdentityType = 2;</code>
     * @return The bytes for tarIdentityType.
     */
    @Override
    public com.google.protobuf.ByteString
        getTarIdentityTypeBytes() {
      Object ref = tarIdentityType_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (String) ref);
        tarIdentityType_ = b;
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
      if (!com.google.protobuf.GeneratedMessageV3.isStringEmpty(insCode_)) {
        com.google.protobuf.GeneratedMessageV3.writeString(output, 1, insCode_);
      }
      if (!com.google.protobuf.GeneratedMessageV3.isStringEmpty(tarIdentityType_)) {
        com.google.protobuf.GeneratedMessageV3.writeString(output, 2, tarIdentityType_);
      }
      getUnknownFields().writeTo(output);
    }

    @Override
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

    @Override
    public boolean equals(final Object obj) {
      if (obj == this) {
       return true;
      }
      if (!(obj instanceof LobbyInstitutionClassTeacherListReq)) {
        return super.equals(obj);
      }
      LobbyInstitutionClassTeacherListReq other = (LobbyInstitutionClassTeacherListReq) obj;

      if (!getInsCode()
          .equals(other.getInsCode())) return false;
      if (!getTarIdentityType()
          .equals(other.getTarIdentityType())) return false;
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
      hash = (37 * hash) + INSCODE_FIELD_NUMBER;
      hash = (53 * hash) + getInsCode().hashCode();
      hash = (37 * hash) + TARIDENTITYTYPE_FIELD_NUMBER;
      hash = (53 * hash) + getTarIdentityType().hashCode();
      hash = (29 * hash) + getUnknownFields().hashCode();
      memoizedHashCode = hash;
      return hash;
    }

    public static LobbyInstitutionClassTeacherListReq parseFrom(
        java.nio.ByteBuffer data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static LobbyInstitutionClassTeacherListReq parseFrom(
        java.nio.ByteBuffer data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static LobbyInstitutionClassTeacherListReq parseFrom(
        com.google.protobuf.ByteString data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static LobbyInstitutionClassTeacherListReq parseFrom(
        com.google.protobuf.ByteString data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static LobbyInstitutionClassTeacherListReq parseFrom(byte[] data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static LobbyInstitutionClassTeacherListReq parseFrom(
        byte[] data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static LobbyInstitutionClassTeacherListReq parseFrom(java.io.InputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input);
    }
    public static LobbyInstitutionClassTeacherListReq parseFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input, extensionRegistry);
    }
    public static LobbyInstitutionClassTeacherListReq parseDelimitedFrom(java.io.InputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseDelimitedWithIOException(PARSER, input);
    }
    public static LobbyInstitutionClassTeacherListReq parseDelimitedFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
    }
    public static LobbyInstitutionClassTeacherListReq parseFrom(
        com.google.protobuf.CodedInputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input);
    }
    public static LobbyInstitutionClassTeacherListReq parseFrom(
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
    public static Builder newBuilder(LobbyInstitutionClassTeacherListReq prototype) {
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
     * Protobuf type {@code Classlink.LobbyInstitutionClassTeacherListReq}
     */
    public static final class Builder extends
        com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
        // @@protoc_insertion_point(builder_implements:Classlink.LobbyInstitutionClassTeacherListReq)
        LobbyInstitutionClassTeacherListReqOrBuilder {
      public static final com.google.protobuf.Descriptors.Descriptor
          getDescriptor() {
        return LobbyInstitutionClassTeacherListReqProto.internal_static_Classlink_LobbyInstitutionClassTeacherListReq_descriptor;
      }

      @Override
      protected FieldAccessorTable
          internalGetFieldAccessorTable() {
        return LobbyInstitutionClassTeacherListReqProto.internal_static_Classlink_LobbyInstitutionClassTeacherListReq_fieldAccessorTable
            .ensureFieldAccessorsInitialized(
                LobbyInstitutionClassTeacherListReq.class, Builder.class);
      }

      // Construct using com.classlink.websocket.api.lobby.domain.param.proto.LobbyInstitutionClassTeacherListReqProto.LobbyInstitutionClassTeacherListReq.newBuilder()
      private Builder() {

      }

      private Builder(
          BuilderParent parent) {
        super(parent);

      }
      @Override
      public Builder clear() {
        super.clear();
        insCode_ = "";

        tarIdentityType_ = "";

        return this;
      }

      @Override
      public com.google.protobuf.Descriptors.Descriptor
          getDescriptorForType() {
        return LobbyInstitutionClassTeacherListReqProto.internal_static_Classlink_LobbyInstitutionClassTeacherListReq_descriptor;
      }

      @Override
      public LobbyInstitutionClassTeacherListReq getDefaultInstanceForType() {
        return LobbyInstitutionClassTeacherListReq.getDefaultInstance();
      }

      @Override
      public LobbyInstitutionClassTeacherListReq build() {
        LobbyInstitutionClassTeacherListReq result = buildPartial();
        if (!result.isInitialized()) {
          throw newUninitializedMessageException(result);
        }
        return result;
      }

      @Override
      public LobbyInstitutionClassTeacherListReq buildPartial() {
        LobbyInstitutionClassTeacherListReq result = new LobbyInstitutionClassTeacherListReq(this);
        result.insCode_ = insCode_;
        result.tarIdentityType_ = tarIdentityType_;
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
        if (other instanceof LobbyInstitutionClassTeacherListReq) {
          return mergeFrom((LobbyInstitutionClassTeacherListReq)other);
        } else {
          super.mergeFrom(other);
          return this;
        }
      }

      public Builder mergeFrom(LobbyInstitutionClassTeacherListReq other) {
        if (other == LobbyInstitutionClassTeacherListReq.getDefaultInstance()) return this;
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

      private Object insCode_ = "";
      /**
       * <code>string InsCode = 1;</code>
       * @return The insCode.
       */
      public String getInsCode() {
        Object ref = insCode_;
        if (!(ref instanceof String)) {
          com.google.protobuf.ByteString bs =
              (com.google.protobuf.ByteString) ref;
          String s = bs.toStringUtf8();
          insCode_ = s;
          return s;
        } else {
          return (String) ref;
        }
      }
      /**
       * <code>string InsCode = 1;</code>
       * @return The bytes for insCode.
       */
      public com.google.protobuf.ByteString
          getInsCodeBytes() {
        Object ref = insCode_;
        if (ref instanceof String) {
          com.google.protobuf.ByteString b = 
              com.google.protobuf.ByteString.copyFromUtf8(
                  (String) ref);
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
          String value) {
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

      private Object tarIdentityType_ = "";
      /**
       * <code>string TarIdentityType = 2;</code>
       * @return The tarIdentityType.
       */
      public String getTarIdentityType() {
        Object ref = tarIdentityType_;
        if (!(ref instanceof String)) {
          com.google.protobuf.ByteString bs =
              (com.google.protobuf.ByteString) ref;
          String s = bs.toStringUtf8();
          tarIdentityType_ = s;
          return s;
        } else {
          return (String) ref;
        }
      }
      /**
       * <code>string TarIdentityType = 2;</code>
       * @return The bytes for tarIdentityType.
       */
      public com.google.protobuf.ByteString
          getTarIdentityTypeBytes() {
        Object ref = tarIdentityType_;
        if (ref instanceof String) {
          com.google.protobuf.ByteString b = 
              com.google.protobuf.ByteString.copyFromUtf8(
                  (String) ref);
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
          String value) {
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


      // @@protoc_insertion_point(builder_scope:Classlink.LobbyInstitutionClassTeacherListReq)
    }

    // @@protoc_insertion_point(class_scope:Classlink.LobbyInstitutionClassTeacherListReq)
    private static final LobbyInstitutionClassTeacherListReq DEFAULT_INSTANCE;
    static {
      DEFAULT_INSTANCE = new LobbyInstitutionClassTeacherListReq();
    }

    public static LobbyInstitutionClassTeacherListReq getDefaultInstance() {
      return DEFAULT_INSTANCE;
    }

    private static final com.google.protobuf.Parser<LobbyInstitutionClassTeacherListReq>
        PARSER = new com.google.protobuf.AbstractParser<LobbyInstitutionClassTeacherListReq>() {
      @Override
      public LobbyInstitutionClassTeacherListReq parsePartialFrom(
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

    public static com.google.protobuf.Parser<LobbyInstitutionClassTeacherListReq> parser() {
      return PARSER;
    }

    @Override
    public com.google.protobuf.Parser<LobbyInstitutionClassTeacherListReq> getParserForType() {
      return PARSER;
    }

    @Override
    public LobbyInstitutionClassTeacherListReq getDefaultInstanceForType() {
      return DEFAULT_INSTANCE;
    }

  }

  private static final com.google.protobuf.Descriptors.Descriptor
    internal_static_Classlink_LobbyInstitutionClassTeacherListReq_descriptor;
  private static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_Classlink_LobbyInstitutionClassTeacherListReq_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    String[] descriptorData = {
      "\n)LobbyInstitutionClassTeacherListReq.pr" +
      "oto\022\tClasslink\"O\n#LobbyInstitutionClassT" +
      "eacherListReq\022\017\n\007InsCode\030\001 \001(\t\022\027\n\017TarIde" +
      "ntityType\030\002 \001(\tB`\n4com.classlink.websock" +
      "et.api.lobby.domain.param.protoB(LobbyIn" +
      "stitutionClassTeacherListReqProtob\006proto" +
      "3"
    };
    descriptor = com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        });
    internal_static_Classlink_LobbyInstitutionClassTeacherListReq_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_Classlink_LobbyInstitutionClassTeacherListReq_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_Classlink_LobbyInstitutionClassTeacherListReq_descriptor,
        new String[] { "InsCode", "TarIdentityType", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}
