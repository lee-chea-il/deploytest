// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: CWCurriculumChangeRes.proto

package com.classlink.websocket.api.cw.domain.dto.proto;

public final class CWCurriculumChangeResProto {
  private CWCurriculumChangeResProto() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  public interface CWCurriculumChangeResOrBuilder extends
      // @@protoc_insertion_point(interface_extends:Classlink.CWCurriculumChangeRes)
      com.google.protobuf.MessageOrBuilder {
  }
  /**
   * Protobuf type {@code Classlink.CWCurriculumChangeRes}
   */
  public static final class CWCurriculumChangeRes extends
      com.google.protobuf.GeneratedMessageV3 implements
      // @@protoc_insertion_point(message_implements:Classlink.CWCurriculumChangeRes)
      CWCurriculumChangeResOrBuilder {
  private static final long serialVersionUID = 0L;
    // Use CWCurriculumChangeRes.newBuilder() to construct.
    private CWCurriculumChangeRes(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
      super(builder);
    }
    private CWCurriculumChangeRes() {
    }

    @java.lang.Override
    @SuppressWarnings({"unused"})
    protected java.lang.Object newInstance(
        UnusedPrivateParameter unused) {
      return new CWCurriculumChangeRes();
    }

    @java.lang.Override
    public final com.google.protobuf.UnknownFieldSet
    getUnknownFields() {
      return this.unknownFields;
    }
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return com.classlink.websocket.api.cw.domain.dto.proto.CWCurriculumChangeResProto.internal_static_Classlink_CWCurriculumChangeRes_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.classlink.websocket.api.cw.domain.dto.proto.CWCurriculumChangeResProto.internal_static_Classlink_CWCurriculumChangeRes_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.classlink.websocket.api.cw.domain.dto.proto.CWCurriculumChangeResProto.CWCurriculumChangeRes.class, com.classlink.websocket.api.cw.domain.dto.proto.CWCurriculumChangeResProto.CWCurriculumChangeRes.Builder.class);
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
      getUnknownFields().writeTo(output);
    }

    @java.lang.Override
    public int getSerializedSize() {
      int size = memoizedSize;
      if (size != -1) return size;

      size = 0;
      size += getUnknownFields().getSerializedSize();
      memoizedSize = size;
      return size;
    }

    @java.lang.Override
    public boolean equals(final java.lang.Object obj) {
      if (obj == this) {
       return true;
      }
      if (!(obj instanceof com.classlink.websocket.api.cw.domain.dto.proto.CWCurriculumChangeResProto.CWCurriculumChangeRes)) {
        return super.equals(obj);
      }
      com.classlink.websocket.api.cw.domain.dto.proto.CWCurriculumChangeResProto.CWCurriculumChangeRes other = (com.classlink.websocket.api.cw.domain.dto.proto.CWCurriculumChangeResProto.CWCurriculumChangeRes) obj;

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
      hash = (29 * hash) + getUnknownFields().hashCode();
      memoizedHashCode = hash;
      return hash;
    }

    public static com.classlink.websocket.api.cw.domain.dto.proto.CWCurriculumChangeResProto.CWCurriculumChangeRes parseFrom(
        java.nio.ByteBuffer data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static com.classlink.websocket.api.cw.domain.dto.proto.CWCurriculumChangeResProto.CWCurriculumChangeRes parseFrom(
        java.nio.ByteBuffer data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static com.classlink.websocket.api.cw.domain.dto.proto.CWCurriculumChangeResProto.CWCurriculumChangeRes parseFrom(
        com.google.protobuf.ByteString data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static com.classlink.websocket.api.cw.domain.dto.proto.CWCurriculumChangeResProto.CWCurriculumChangeRes parseFrom(
        com.google.protobuf.ByteString data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static com.classlink.websocket.api.cw.domain.dto.proto.CWCurriculumChangeResProto.CWCurriculumChangeRes parseFrom(byte[] data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static com.classlink.websocket.api.cw.domain.dto.proto.CWCurriculumChangeResProto.CWCurriculumChangeRes parseFrom(
        byte[] data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static com.classlink.websocket.api.cw.domain.dto.proto.CWCurriculumChangeResProto.CWCurriculumChangeRes parseFrom(java.io.InputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input);
    }
    public static com.classlink.websocket.api.cw.domain.dto.proto.CWCurriculumChangeResProto.CWCurriculumChangeRes parseFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input, extensionRegistry);
    }
    public static com.classlink.websocket.api.cw.domain.dto.proto.CWCurriculumChangeResProto.CWCurriculumChangeRes parseDelimitedFrom(java.io.InputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseDelimitedWithIOException(PARSER, input);
    }
    public static com.classlink.websocket.api.cw.domain.dto.proto.CWCurriculumChangeResProto.CWCurriculumChangeRes parseDelimitedFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
    }
    public static com.classlink.websocket.api.cw.domain.dto.proto.CWCurriculumChangeResProto.CWCurriculumChangeRes parseFrom(
        com.google.protobuf.CodedInputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input);
    }
    public static com.classlink.websocket.api.cw.domain.dto.proto.CWCurriculumChangeResProto.CWCurriculumChangeRes parseFrom(
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
    public static Builder newBuilder(com.classlink.websocket.api.cw.domain.dto.proto.CWCurriculumChangeResProto.CWCurriculumChangeRes prototype) {
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
     * Protobuf type {@code Classlink.CWCurriculumChangeRes}
     */
    public static final class Builder extends
        com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
        // @@protoc_insertion_point(builder_implements:Classlink.CWCurriculumChangeRes)
        com.classlink.websocket.api.cw.domain.dto.proto.CWCurriculumChangeResProto.CWCurriculumChangeResOrBuilder {
      public static final com.google.protobuf.Descriptors.Descriptor
          getDescriptor() {
        return com.classlink.websocket.api.cw.domain.dto.proto.CWCurriculumChangeResProto.internal_static_Classlink_CWCurriculumChangeRes_descriptor;
      }

      @java.lang.Override
      protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
          internalGetFieldAccessorTable() {
        return com.classlink.websocket.api.cw.domain.dto.proto.CWCurriculumChangeResProto.internal_static_Classlink_CWCurriculumChangeRes_fieldAccessorTable
            .ensureFieldAccessorsInitialized(
                com.classlink.websocket.api.cw.domain.dto.proto.CWCurriculumChangeResProto.CWCurriculumChangeRes.class, com.classlink.websocket.api.cw.domain.dto.proto.CWCurriculumChangeResProto.CWCurriculumChangeRes.Builder.class);
      }

      // Construct using com.classlink.websocket.api.cw.domain.dto.proto.CWCurriculumChangeResProto.CWCurriculumChangeRes.newBuilder()
      private Builder() {

      }

      private Builder(
          com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
        super(parent);

      }
      @java.lang.Override
      public Builder clear() {
        super.clear();
        return this;
      }

      @java.lang.Override
      public com.google.protobuf.Descriptors.Descriptor
          getDescriptorForType() {
        return com.classlink.websocket.api.cw.domain.dto.proto.CWCurriculumChangeResProto.internal_static_Classlink_CWCurriculumChangeRes_descriptor;
      }

      @java.lang.Override
      public com.classlink.websocket.api.cw.domain.dto.proto.CWCurriculumChangeResProto.CWCurriculumChangeRes getDefaultInstanceForType() {
        return com.classlink.websocket.api.cw.domain.dto.proto.CWCurriculumChangeResProto.CWCurriculumChangeRes.getDefaultInstance();
      }

      @java.lang.Override
      public com.classlink.websocket.api.cw.domain.dto.proto.CWCurriculumChangeResProto.CWCurriculumChangeRes build() {
        com.classlink.websocket.api.cw.domain.dto.proto.CWCurriculumChangeResProto.CWCurriculumChangeRes result = buildPartial();
        if (!result.isInitialized()) {
          throw newUninitializedMessageException(result);
        }
        return result;
      }

      @java.lang.Override
      public com.classlink.websocket.api.cw.domain.dto.proto.CWCurriculumChangeResProto.CWCurriculumChangeRes buildPartial() {
        com.classlink.websocket.api.cw.domain.dto.proto.CWCurriculumChangeResProto.CWCurriculumChangeRes result = new com.classlink.websocket.api.cw.domain.dto.proto.CWCurriculumChangeResProto.CWCurriculumChangeRes(this);
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
        if (other instanceof com.classlink.websocket.api.cw.domain.dto.proto.CWCurriculumChangeResProto.CWCurriculumChangeRes) {
          return mergeFrom((com.classlink.websocket.api.cw.domain.dto.proto.CWCurriculumChangeResProto.CWCurriculumChangeRes)other);
        } else {
          super.mergeFrom(other);
          return this;
        }
      }

      public Builder mergeFrom(com.classlink.websocket.api.cw.domain.dto.proto.CWCurriculumChangeResProto.CWCurriculumChangeRes other) {
        if (other == com.classlink.websocket.api.cw.domain.dto.proto.CWCurriculumChangeResProto.CWCurriculumChangeRes.getDefaultInstance()) return this;
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


      // @@protoc_insertion_point(builder_scope:Classlink.CWCurriculumChangeRes)
    }

    // @@protoc_insertion_point(class_scope:Classlink.CWCurriculumChangeRes)
    private static final com.classlink.websocket.api.cw.domain.dto.proto.CWCurriculumChangeResProto.CWCurriculumChangeRes DEFAULT_INSTANCE;
    static {
      DEFAULT_INSTANCE = new com.classlink.websocket.api.cw.domain.dto.proto.CWCurriculumChangeResProto.CWCurriculumChangeRes();
    }

    public static com.classlink.websocket.api.cw.domain.dto.proto.CWCurriculumChangeResProto.CWCurriculumChangeRes getDefaultInstance() {
      return DEFAULT_INSTANCE;
    }

    private static final com.google.protobuf.Parser<CWCurriculumChangeRes>
        PARSER = new com.google.protobuf.AbstractParser<CWCurriculumChangeRes>() {
      @java.lang.Override
      public CWCurriculumChangeRes parsePartialFrom(
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

    public static com.google.protobuf.Parser<CWCurriculumChangeRes> parser() {
      return PARSER;
    }

    @java.lang.Override
    public com.google.protobuf.Parser<CWCurriculumChangeRes> getParserForType() {
      return PARSER;
    }

    @java.lang.Override
    public com.classlink.websocket.api.cw.domain.dto.proto.CWCurriculumChangeResProto.CWCurriculumChangeRes getDefaultInstanceForType() {
      return DEFAULT_INSTANCE;
    }

  }

  private static final com.google.protobuf.Descriptors.Descriptor
    internal_static_Classlink_CWCurriculumChangeRes_descriptor;
  private static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_Classlink_CWCurriculumChangeRes_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\033CWCurriculumChangeRes.proto\022\tClasslink" +
      "\"\027\n\025CWCurriculumChangeResBM\n/com.classli" +
      "nk.websocket.api.cw.domain.dto.protoB\032CW" +
      "CurriculumChangeResProtob\006proto3"
    };
    descriptor = com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        });
    internal_static_Classlink_CWCurriculumChangeRes_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_Classlink_CWCurriculumChangeRes_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_Classlink_CWCurriculumChangeRes_descriptor,
        new java.lang.String[] { });
  }

  // @@protoc_insertion_point(outer_class_scope)
}
