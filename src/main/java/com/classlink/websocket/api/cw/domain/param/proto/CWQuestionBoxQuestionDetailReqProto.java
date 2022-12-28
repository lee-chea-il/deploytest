// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: CWQuestionBoxQuestionDetailReq.proto

package com.classlink.websocket.api.cw.domain.param.proto;

public final class CWQuestionBoxQuestionDetailReqProto {
  private CWQuestionBoxQuestionDetailReqProto() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  public interface CWQuestionBoxQuestionDetailReqOrBuilder extends
      // @@protoc_insertion_point(interface_extends:Classlink.CWQuestionBoxQuestionDetailReq)
      com.google.protobuf.MessageOrBuilder {

    /**
     * <code>int32 QuestionIdx = 1;</code>
     * @return The questionIdx.
     */
    int getQuestionIdx();
  }
  /**
   * Protobuf type {@code Classlink.CWQuestionBoxQuestionDetailReq}
   */
  public static final class CWQuestionBoxQuestionDetailReq extends
      com.google.protobuf.GeneratedMessageV3 implements
      // @@protoc_insertion_point(message_implements:Classlink.CWQuestionBoxQuestionDetailReq)
      CWQuestionBoxQuestionDetailReqOrBuilder {
  private static final long serialVersionUID = 0L;
    // Use CWQuestionBoxQuestionDetailReq.newBuilder() to construct.
    private CWQuestionBoxQuestionDetailReq(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
      super(builder);
    }
    private CWQuestionBoxQuestionDetailReq() {
    }

    @Override
    @SuppressWarnings({"unused"})
    protected Object newInstance(
        UnusedPrivateParameter unused) {
      return new CWQuestionBoxQuestionDetailReq();
    }

    @Override
    public final com.google.protobuf.UnknownFieldSet
    getUnknownFields() {
      return this.unknownFields;
    }
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return CWQuestionBoxQuestionDetailReqProto.internal_static_Classlink_CWQuestionBoxQuestionDetailReq_descriptor;
    }

    @Override
    protected FieldAccessorTable
        internalGetFieldAccessorTable() {
      return CWQuestionBoxQuestionDetailReqProto.internal_static_Classlink_CWQuestionBoxQuestionDetailReq_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              CWQuestionBoxQuestionDetailReq.class, Builder.class);
    }

    public static final int QUESTIONIDX_FIELD_NUMBER = 1;
    private int questionIdx_;
    /**
     * <code>int32 QuestionIdx = 1;</code>
     * @return The questionIdx.
     */
    @Override
    public int getQuestionIdx() {
      return questionIdx_;
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
      if (questionIdx_ != 0) {
        output.writeInt32(1, questionIdx_);
      }
      getUnknownFields().writeTo(output);
    }

    @Override
    public int getSerializedSize() {
      int size = memoizedSize;
      if (size != -1) return size;

      size = 0;
      if (questionIdx_ != 0) {
        size += com.google.protobuf.CodedOutputStream
          .computeInt32Size(1, questionIdx_);
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
      if (!(obj instanceof CWQuestionBoxQuestionDetailReq)) {
        return super.equals(obj);
      }
      CWQuestionBoxQuestionDetailReq other = (CWQuestionBoxQuestionDetailReq) obj;

      if (getQuestionIdx()
          != other.getQuestionIdx()) return false;
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
      hash = (37 * hash) + QUESTIONIDX_FIELD_NUMBER;
      hash = (53 * hash) + getQuestionIdx();
      hash = (29 * hash) + getUnknownFields().hashCode();
      memoizedHashCode = hash;
      return hash;
    }

    public static CWQuestionBoxQuestionDetailReq parseFrom(
        java.nio.ByteBuffer data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static CWQuestionBoxQuestionDetailReq parseFrom(
        java.nio.ByteBuffer data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static CWQuestionBoxQuestionDetailReq parseFrom(
        com.google.protobuf.ByteString data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static CWQuestionBoxQuestionDetailReq parseFrom(
        com.google.protobuf.ByteString data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static CWQuestionBoxQuestionDetailReq parseFrom(byte[] data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static CWQuestionBoxQuestionDetailReq parseFrom(
        byte[] data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static CWQuestionBoxQuestionDetailReq parseFrom(java.io.InputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input);
    }
    public static CWQuestionBoxQuestionDetailReq parseFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input, extensionRegistry);
    }
    public static CWQuestionBoxQuestionDetailReq parseDelimitedFrom(java.io.InputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseDelimitedWithIOException(PARSER, input);
    }
    public static CWQuestionBoxQuestionDetailReq parseDelimitedFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
    }
    public static CWQuestionBoxQuestionDetailReq parseFrom(
        com.google.protobuf.CodedInputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input);
    }
    public static CWQuestionBoxQuestionDetailReq parseFrom(
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
    public static Builder newBuilder(CWQuestionBoxQuestionDetailReq prototype) {
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
     * Protobuf type {@code Classlink.CWQuestionBoxQuestionDetailReq}
     */
    public static final class Builder extends
        com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
        // @@protoc_insertion_point(builder_implements:Classlink.CWQuestionBoxQuestionDetailReq)
        CWQuestionBoxQuestionDetailReqOrBuilder {
      public static final com.google.protobuf.Descriptors.Descriptor
          getDescriptor() {
        return CWQuestionBoxQuestionDetailReqProto.internal_static_Classlink_CWQuestionBoxQuestionDetailReq_descriptor;
      }

      @Override
      protected FieldAccessorTable
          internalGetFieldAccessorTable() {
        return CWQuestionBoxQuestionDetailReqProto.internal_static_Classlink_CWQuestionBoxQuestionDetailReq_fieldAccessorTable
            .ensureFieldAccessorsInitialized(
                CWQuestionBoxQuestionDetailReq.class, Builder.class);
      }

      // Construct using com.classlink.websocket.api.cw.domain.param.proto.CWQuestionBoxQuestionDetailReqProto.CWQuestionBoxQuestionDetailReq.newBuilder()
      private Builder() {

      }

      private Builder(
          BuilderParent parent) {
        super(parent);

      }
      @Override
      public Builder clear() {
        super.clear();
        questionIdx_ = 0;

        return this;
      }

      @Override
      public com.google.protobuf.Descriptors.Descriptor
          getDescriptorForType() {
        return CWQuestionBoxQuestionDetailReqProto.internal_static_Classlink_CWQuestionBoxQuestionDetailReq_descriptor;
      }

      @Override
      public CWQuestionBoxQuestionDetailReq getDefaultInstanceForType() {
        return CWQuestionBoxQuestionDetailReq.getDefaultInstance();
      }

      @Override
      public CWQuestionBoxQuestionDetailReq build() {
        CWQuestionBoxQuestionDetailReq result = buildPartial();
        if (!result.isInitialized()) {
          throw newUninitializedMessageException(result);
        }
        return result;
      }

      @Override
      public CWQuestionBoxQuestionDetailReq buildPartial() {
        CWQuestionBoxQuestionDetailReq result = new CWQuestionBoxQuestionDetailReq(this);
        result.questionIdx_ = questionIdx_;
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
        if (other instanceof CWQuestionBoxQuestionDetailReq) {
          return mergeFrom((CWQuestionBoxQuestionDetailReq)other);
        } else {
          super.mergeFrom(other);
          return this;
        }
      }

      public Builder mergeFrom(CWQuestionBoxQuestionDetailReq other) {
        if (other == CWQuestionBoxQuestionDetailReq.getDefaultInstance()) return this;
        if (other.getQuestionIdx() != 0) {
          setQuestionIdx(other.getQuestionIdx());
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
                questionIdx_ = input.readInt32();

                break;
              } // case 8
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

      private int questionIdx_ ;
      /**
       * <code>int32 QuestionIdx = 1;</code>
       * @return The questionIdx.
       */
      @Override
      public int getQuestionIdx() {
        return questionIdx_;
      }
      /**
       * <code>int32 QuestionIdx = 1;</code>
       * @param value The questionIdx to set.
       * @return This builder for chaining.
       */
      public Builder setQuestionIdx(int value) {
        
        questionIdx_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>int32 QuestionIdx = 1;</code>
       * @return This builder for chaining.
       */
      public Builder clearQuestionIdx() {
        
        questionIdx_ = 0;
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


      // @@protoc_insertion_point(builder_scope:Classlink.CWQuestionBoxQuestionDetailReq)
    }

    // @@protoc_insertion_point(class_scope:Classlink.CWQuestionBoxQuestionDetailReq)
    private static final CWQuestionBoxQuestionDetailReq DEFAULT_INSTANCE;
    static {
      DEFAULT_INSTANCE = new CWQuestionBoxQuestionDetailReq();
    }

    public static CWQuestionBoxQuestionDetailReq getDefaultInstance() {
      return DEFAULT_INSTANCE;
    }

    private static final com.google.protobuf.Parser<CWQuestionBoxQuestionDetailReq>
        PARSER = new com.google.protobuf.AbstractParser<CWQuestionBoxQuestionDetailReq>() {
      @Override
      public CWQuestionBoxQuestionDetailReq parsePartialFrom(
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

    public static com.google.protobuf.Parser<CWQuestionBoxQuestionDetailReq> parser() {
      return PARSER;
    }

    @Override
    public com.google.protobuf.Parser<CWQuestionBoxQuestionDetailReq> getParserForType() {
      return PARSER;
    }

    @Override
    public CWQuestionBoxQuestionDetailReq getDefaultInstanceForType() {
      return DEFAULT_INSTANCE;
    }

  }

  private static final com.google.protobuf.Descriptors.Descriptor
    internal_static_Classlink_CWQuestionBoxQuestionDetailReq_descriptor;
  private static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_Classlink_CWQuestionBoxQuestionDetailReq_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    String[] descriptorData = {
      "\n$CWQuestionBoxQuestionDetailReq.proto\022\t" +
      "Classlink\"5\n\036CWQuestionBoxQuestionDetail" +
      "Req\022\023\n\013QuestionIdx\030\001 \001(\005BX\n1com.classlin" +
      "k.websocket.api.cw.domain.param.protoB#C" +
      "WQuestionBoxQuestionDetailReqProtob\006prot" +
      "o3"
    };
    descriptor = com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        });
    internal_static_Classlink_CWQuestionBoxQuestionDetailReq_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_Classlink_CWQuestionBoxQuestionDetailReq_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_Classlink_CWQuestionBoxQuestionDetailReq_descriptor,
        new String[] { "QuestionIdx", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}