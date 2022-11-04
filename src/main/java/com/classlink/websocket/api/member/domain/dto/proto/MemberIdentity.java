// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: memberIdentity.proto

package com.classlink.websocket.api.member.domain.dto.proto;

public final class MemberIdentity {
  private MemberIdentity() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  public interface MemberIdentityDataOrBuilder extends
      // @@protoc_insertion_point(interface_extends:tutorial.MemberIdentityData)
      com.google.protobuf.MessageOrBuilder {

    /**
     * <code>int32 MdtIdx = 1;</code>
     * @return The mdtIdx.
     */
    int getMdtIdx();

    /**
     * <code>int32 IdtCode = 2;</code>
     * @return The idtCode.
     */
    int getIdtCode();

    /**
     * <code>int32 MemIdx = 3;</code>
     * @return The memIdx.
     */
    int getMemIdx();

    /**
     * <code>string DeleteYn = 4;</code>
     * @return The deleteYn.
     */
    java.lang.String getDeleteYn();
    /**
     * <code>string DeleteYn = 4;</code>
     * @return The bytes for deleteYn.
     */
    com.google.protobuf.ByteString
        getDeleteYnBytes();
  }
  /**
   * Protobuf type {@code tutorial.MemberIdentityData}
   */
  public static final class MemberIdentityData extends
      com.google.protobuf.GeneratedMessageV3 implements
      // @@protoc_insertion_point(message_implements:tutorial.MemberIdentityData)
      MemberIdentityDataOrBuilder {
  private static final long serialVersionUID = 0L;
    // Use MemberIdentityData.newBuilder() to construct.
    private MemberIdentityData(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
      super(builder);
    }
    private MemberIdentityData() {
      deleteYn_ = "";
    }

    @java.lang.Override
    @SuppressWarnings({"unused"})
    protected java.lang.Object newInstance(
        UnusedPrivateParameter unused) {
      return new MemberIdentityData();
    }

    @java.lang.Override
    public final com.google.protobuf.UnknownFieldSet
    getUnknownFields() {
      return this.unknownFields;
    }
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return com.classlink.websocket.api.member.domain.dto.proto.MemberIdentity.internal_static_tutorial_MemberIdentityData_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.classlink.websocket.api.member.domain.dto.proto.MemberIdentity.internal_static_tutorial_MemberIdentityData_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.classlink.websocket.api.member.domain.dto.proto.MemberIdentity.MemberIdentityData.class, com.classlink.websocket.api.member.domain.dto.proto.MemberIdentity.MemberIdentityData.Builder.class);
    }

    public static final int MDTIDX_FIELD_NUMBER = 1;
    private int mdtIdx_;
    /**
     * <code>int32 MdtIdx = 1;</code>
     * @return The mdtIdx.
     */
    @java.lang.Override
    public int getMdtIdx() {
      return mdtIdx_;
    }

    public static final int IDTCODE_FIELD_NUMBER = 2;
    private int idtCode_;
    /**
     * <code>int32 IdtCode = 2;</code>
     * @return The idtCode.
     */
    @java.lang.Override
    public int getIdtCode() {
      return idtCode_;
    }

    public static final int MEMIDX_FIELD_NUMBER = 3;
    private int memIdx_;
    /**
     * <code>int32 MemIdx = 3;</code>
     * @return The memIdx.
     */
    @java.lang.Override
    public int getMemIdx() {
      return memIdx_;
    }

    public static final int DELETEYN_FIELD_NUMBER = 4;
    private volatile java.lang.Object deleteYn_;
    /**
     * <code>string DeleteYn = 4;</code>
     * @return The deleteYn.
     */
    @java.lang.Override
    public java.lang.String getDeleteYn() {
      java.lang.Object ref = deleteYn_;
      if (ref instanceof java.lang.String) {
        return (java.lang.String) ref;
      } else {
        com.google.protobuf.ByteString bs = 
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        deleteYn_ = s;
        return s;
      }
    }
    /**
     * <code>string DeleteYn = 4;</code>
     * @return The bytes for deleteYn.
     */
    @java.lang.Override
    public com.google.protobuf.ByteString
        getDeleteYnBytes() {
      java.lang.Object ref = deleteYn_;
      if (ref instanceof java.lang.String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        deleteYn_ = b;
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
      if (mdtIdx_ != 0) {
        output.writeInt32(1, mdtIdx_);
      }
      if (idtCode_ != 0) {
        output.writeInt32(2, idtCode_);
      }
      if (memIdx_ != 0) {
        output.writeInt32(3, memIdx_);
      }
      if (!com.google.protobuf.GeneratedMessageV3.isStringEmpty(deleteYn_)) {
        com.google.protobuf.GeneratedMessageV3.writeString(output, 4, deleteYn_);
      }
      getUnknownFields().writeTo(output);
    }

    @java.lang.Override
    public int getSerializedSize() {
      int size = memoizedSize;
      if (size != -1) return size;

      size = 0;
      if (mdtIdx_ != 0) {
        size += com.google.protobuf.CodedOutputStream
          .computeInt32Size(1, mdtIdx_);
      }
      if (idtCode_ != 0) {
        size += com.google.protobuf.CodedOutputStream
          .computeInt32Size(2, idtCode_);
      }
      if (memIdx_ != 0) {
        size += com.google.protobuf.CodedOutputStream
          .computeInt32Size(3, memIdx_);
      }
      if (!com.google.protobuf.GeneratedMessageV3.isStringEmpty(deleteYn_)) {
        size += com.google.protobuf.GeneratedMessageV3.computeStringSize(4, deleteYn_);
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
      if (!(obj instanceof com.classlink.websocket.api.member.domain.dto.proto.MemberIdentity.MemberIdentityData)) {
        return super.equals(obj);
      }
      com.classlink.websocket.api.member.domain.dto.proto.MemberIdentity.MemberIdentityData other = (com.classlink.websocket.api.member.domain.dto.proto.MemberIdentity.MemberIdentityData) obj;

      if (getMdtIdx()
          != other.getMdtIdx()) return false;
      if (getIdtCode()
          != other.getIdtCode()) return false;
      if (getMemIdx()
          != other.getMemIdx()) return false;
      if (!getDeleteYn()
          .equals(other.getDeleteYn())) return false;
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
      hash = (37 * hash) + MDTIDX_FIELD_NUMBER;
      hash = (53 * hash) + getMdtIdx();
      hash = (37 * hash) + IDTCODE_FIELD_NUMBER;
      hash = (53 * hash) + getIdtCode();
      hash = (37 * hash) + MEMIDX_FIELD_NUMBER;
      hash = (53 * hash) + getMemIdx();
      hash = (37 * hash) + DELETEYN_FIELD_NUMBER;
      hash = (53 * hash) + getDeleteYn().hashCode();
      hash = (29 * hash) + getUnknownFields().hashCode();
      memoizedHashCode = hash;
      return hash;
    }

    public static com.classlink.websocket.api.member.domain.dto.proto.MemberIdentity.MemberIdentityData parseFrom(
        java.nio.ByteBuffer data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static com.classlink.websocket.api.member.domain.dto.proto.MemberIdentity.MemberIdentityData parseFrom(
        java.nio.ByteBuffer data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static com.classlink.websocket.api.member.domain.dto.proto.MemberIdentity.MemberIdentityData parseFrom(
        com.google.protobuf.ByteString data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static com.classlink.websocket.api.member.domain.dto.proto.MemberIdentity.MemberIdentityData parseFrom(
        com.google.protobuf.ByteString data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static com.classlink.websocket.api.member.domain.dto.proto.MemberIdentity.MemberIdentityData parseFrom(byte[] data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static com.classlink.websocket.api.member.domain.dto.proto.MemberIdentity.MemberIdentityData parseFrom(
        byte[] data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static com.classlink.websocket.api.member.domain.dto.proto.MemberIdentity.MemberIdentityData parseFrom(java.io.InputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input);
    }
    public static com.classlink.websocket.api.member.domain.dto.proto.MemberIdentity.MemberIdentityData parseFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input, extensionRegistry);
    }
    public static com.classlink.websocket.api.member.domain.dto.proto.MemberIdentity.MemberIdentityData parseDelimitedFrom(java.io.InputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseDelimitedWithIOException(PARSER, input);
    }
    public static com.classlink.websocket.api.member.domain.dto.proto.MemberIdentity.MemberIdentityData parseDelimitedFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
    }
    public static com.classlink.websocket.api.member.domain.dto.proto.MemberIdentity.MemberIdentityData parseFrom(
        com.google.protobuf.CodedInputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input);
    }
    public static com.classlink.websocket.api.member.domain.dto.proto.MemberIdentity.MemberIdentityData parseFrom(
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
    public static Builder newBuilder(com.classlink.websocket.api.member.domain.dto.proto.MemberIdentity.MemberIdentityData prototype) {
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
     * Protobuf type {@code tutorial.MemberIdentityData}
     */
    public static final class Builder extends
        com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
        // @@protoc_insertion_point(builder_implements:tutorial.MemberIdentityData)
        com.classlink.websocket.api.member.domain.dto.proto.MemberIdentity.MemberIdentityDataOrBuilder {
      public static final com.google.protobuf.Descriptors.Descriptor
          getDescriptor() {
        return com.classlink.websocket.api.member.domain.dto.proto.MemberIdentity.internal_static_tutorial_MemberIdentityData_descriptor;
      }

      @java.lang.Override
      protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
          internalGetFieldAccessorTable() {
        return com.classlink.websocket.api.member.domain.dto.proto.MemberIdentity.internal_static_tutorial_MemberIdentityData_fieldAccessorTable
            .ensureFieldAccessorsInitialized(
                com.classlink.websocket.api.member.domain.dto.proto.MemberIdentity.MemberIdentityData.class, com.classlink.websocket.api.member.domain.dto.proto.MemberIdentity.MemberIdentityData.Builder.class);
      }

      // Construct using com.classlink.websocket.api.member.domain.protobuf.MemberIdentity.MemberIdentityData.newBuilder()
      private Builder() {

      }

      private Builder(
          com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
        super(parent);

      }
      @java.lang.Override
      public Builder clear() {
        super.clear();
        mdtIdx_ = 0;

        idtCode_ = 0;

        memIdx_ = 0;

        deleteYn_ = "";

        return this;
      }

      @java.lang.Override
      public com.google.protobuf.Descriptors.Descriptor
          getDescriptorForType() {
        return com.classlink.websocket.api.member.domain.dto.proto.MemberIdentity.internal_static_tutorial_MemberIdentityData_descriptor;
      }

      @java.lang.Override
      public com.classlink.websocket.api.member.domain.dto.proto.MemberIdentity.MemberIdentityData getDefaultInstanceForType() {
        return com.classlink.websocket.api.member.domain.dto.proto.MemberIdentity.MemberIdentityData.getDefaultInstance();
      }

      @java.lang.Override
      public com.classlink.websocket.api.member.domain.dto.proto.MemberIdentity.MemberIdentityData build() {
        com.classlink.websocket.api.member.domain.dto.proto.MemberIdentity.MemberIdentityData result = buildPartial();
        if (!result.isInitialized()) {
          throw newUninitializedMessageException(result);
        }
        return result;
      }

      @java.lang.Override
      public com.classlink.websocket.api.member.domain.dto.proto.MemberIdentity.MemberIdentityData buildPartial() {
        com.classlink.websocket.api.member.domain.dto.proto.MemberIdentity.MemberIdentityData result = new com.classlink.websocket.api.member.domain.dto.proto.MemberIdentity.MemberIdentityData(this);
        result.mdtIdx_ = mdtIdx_;
        result.idtCode_ = idtCode_;
        result.memIdx_ = memIdx_;
        result.deleteYn_ = deleteYn_;
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
        if (other instanceof com.classlink.websocket.api.member.domain.dto.proto.MemberIdentity.MemberIdentityData) {
          return mergeFrom((com.classlink.websocket.api.member.domain.dto.proto.MemberIdentity.MemberIdentityData)other);
        } else {
          super.mergeFrom(other);
          return this;
        }
      }

      public Builder mergeFrom(com.classlink.websocket.api.member.domain.dto.proto.MemberIdentity.MemberIdentityData other) {
        if (other == com.classlink.websocket.api.member.domain.dto.proto.MemberIdentity.MemberIdentityData.getDefaultInstance()) return this;
        if (other.getMdtIdx() != 0) {
          setMdtIdx(other.getMdtIdx());
        }
        if (other.getIdtCode() != 0) {
          setIdtCode(other.getIdtCode());
        }
        if (other.getMemIdx() != 0) {
          setMemIdx(other.getMemIdx());
        }
        if (!other.getDeleteYn().isEmpty()) {
          deleteYn_ = other.deleteYn_;
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
              case 8: {
                mdtIdx_ = input.readInt32();

                break;
              } // case 8
              case 16: {
                idtCode_ = input.readInt32();

                break;
              } // case 16
              case 24: {
                memIdx_ = input.readInt32();

                break;
              } // case 24
              case 34: {
                deleteYn_ = input.readStringRequireUtf8();

                break;
              } // case 34
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

      private int mdtIdx_ ;
      /**
       * <code>int32 MdtIdx = 1;</code>
       * @return The mdtIdx.
       */
      @java.lang.Override
      public int getMdtIdx() {
        return mdtIdx_;
      }
      /**
       * <code>int32 MdtIdx = 1;</code>
       * @param value The mdtIdx to set.
       * @return This builder for chaining.
       */
      public Builder setMdtIdx(int value) {
        
        mdtIdx_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>int32 MdtIdx = 1;</code>
       * @return This builder for chaining.
       */
      public Builder clearMdtIdx() {
        
        mdtIdx_ = 0;
        onChanged();
        return this;
      }

      private int idtCode_ ;
      /**
       * <code>int32 IdtCode = 2;</code>
       * @return The idtCode.
       */
      @java.lang.Override
      public int getIdtCode() {
        return idtCode_;
      }
      /**
       * <code>int32 IdtCode = 2;</code>
       * @param value The idtCode to set.
       * @return This builder for chaining.
       */
      public Builder setIdtCode(int value) {
        
        idtCode_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>int32 IdtCode = 2;</code>
       * @return This builder for chaining.
       */
      public Builder clearIdtCode() {
        
        idtCode_ = 0;
        onChanged();
        return this;
      }

      private int memIdx_ ;
      /**
       * <code>int32 MemIdx = 3;</code>
       * @return The memIdx.
       */
      @java.lang.Override
      public int getMemIdx() {
        return memIdx_;
      }
      /**
       * <code>int32 MemIdx = 3;</code>
       * @param value The memIdx to set.
       * @return This builder for chaining.
       */
      public Builder setMemIdx(int value) {
        
        memIdx_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>int32 MemIdx = 3;</code>
       * @return This builder for chaining.
       */
      public Builder clearMemIdx() {
        
        memIdx_ = 0;
        onChanged();
        return this;
      }

      private java.lang.Object deleteYn_ = "";
      /**
       * <code>string DeleteYn = 4;</code>
       * @return The deleteYn.
       */
      public java.lang.String getDeleteYn() {
        java.lang.Object ref = deleteYn_;
        if (!(ref instanceof java.lang.String)) {
          com.google.protobuf.ByteString bs =
              (com.google.protobuf.ByteString) ref;
          java.lang.String s = bs.toStringUtf8();
          deleteYn_ = s;
          return s;
        } else {
          return (java.lang.String) ref;
        }
      }
      /**
       * <code>string DeleteYn = 4;</code>
       * @return The bytes for deleteYn.
       */
      public com.google.protobuf.ByteString
          getDeleteYnBytes() {
        java.lang.Object ref = deleteYn_;
        if (ref instanceof String) {
          com.google.protobuf.ByteString b = 
              com.google.protobuf.ByteString.copyFromUtf8(
                  (java.lang.String) ref);
          deleteYn_ = b;
          return b;
        } else {
          return (com.google.protobuf.ByteString) ref;
        }
      }
      /**
       * <code>string DeleteYn = 4;</code>
       * @param value The deleteYn to set.
       * @return This builder for chaining.
       */
      public Builder setDeleteYn(
          java.lang.String value) {
        if (value == null) {
    throw new NullPointerException();
  }
  
        deleteYn_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>string DeleteYn = 4;</code>
       * @return This builder for chaining.
       */
      public Builder clearDeleteYn() {
        
        deleteYn_ = getDefaultInstance().getDeleteYn();
        onChanged();
        return this;
      }
      /**
       * <code>string DeleteYn = 4;</code>
       * @param value The bytes for deleteYn to set.
       * @return This builder for chaining.
       */
      public Builder setDeleteYnBytes(
          com.google.protobuf.ByteString value) {
        if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
        
        deleteYn_ = value;
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


      // @@protoc_insertion_point(builder_scope:tutorial.MemberIdentityData)
    }

    // @@protoc_insertion_point(class_scope:tutorial.MemberIdentityData)
    private static final com.classlink.websocket.api.member.domain.dto.proto.MemberIdentity.MemberIdentityData DEFAULT_INSTANCE;
    static {
      DEFAULT_INSTANCE = new com.classlink.websocket.api.member.domain.dto.proto.MemberIdentity.MemberIdentityData();
    }

    public static com.classlink.websocket.api.member.domain.dto.proto.MemberIdentity.MemberIdentityData getDefaultInstance() {
      return DEFAULT_INSTANCE;
    }

    private static final com.google.protobuf.Parser<MemberIdentityData>
        PARSER = new com.google.protobuf.AbstractParser<MemberIdentityData>() {
      @java.lang.Override
      public MemberIdentityData parsePartialFrom(
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

    public static com.google.protobuf.Parser<MemberIdentityData> parser() {
      return PARSER;
    }

    @java.lang.Override
    public com.google.protobuf.Parser<MemberIdentityData> getParserForType() {
      return PARSER;
    }

    @java.lang.Override
    public com.classlink.websocket.api.member.domain.dto.proto.MemberIdentity.MemberIdentityData getDefaultInstanceForType() {
      return DEFAULT_INSTANCE;
    }

  }

  private static final com.google.protobuf.Descriptors.Descriptor
    internal_static_tutorial_MemberIdentityData_descriptor;
  private static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_tutorial_MemberIdentityData_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\024memberIdentity.proto\022\010tutorial\"W\n\022Memb" +
      "erIdentityData\022\016\n\006MdtIdx\030\001 \001(\005\022\017\n\007IdtCod" +
      "e\030\002 \001(\005\022\016\n\006MemIdx\030\003 \001(\005\022\020\n\010DeleteYn\030\004 \001(" +
      "\tBD\n2com.classlink.websocket.api.member." +
      "domain.protobufB\016MemberIdentityb\006proto3"
    };
    descriptor = com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        });
    internal_static_tutorial_MemberIdentityData_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_tutorial_MemberIdentityData_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_tutorial_MemberIdentityData_descriptor,
        new java.lang.String[] { "MdtIdx", "IdtCode", "MemIdx", "DeleteYn", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}
