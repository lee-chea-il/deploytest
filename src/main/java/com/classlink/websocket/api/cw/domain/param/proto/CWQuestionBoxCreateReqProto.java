// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: CWQuestionBoxCreateReq.proto

package com.classlink.websocket.api.cw.domain.param.proto;

public final class CWQuestionBoxCreateReqProto {
  private CWQuestionBoxCreateReqProto() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  public interface CWQuestionBoxCreateReqOrBuilder extends
      // @@protoc_insertion_point(interface_extends:Classlink.CWQuestionBoxCreateReq)
      com.google.protobuf.MessageOrBuilder {

    /**
     * <code>string Title = 1;</code>
     * @return The title.
     */
    String getTitle();
    /**
     * <code>string Title = 1;</code>
     * @return The bytes for title.
     */
    com.google.protobuf.ByteString
        getTitleBytes();

    /**
     * <code>string Question = 2;</code>
     * @return The question.
     */
    String getQuestion();
    /**
     * <code>string Question = 2;</code>
     * @return The bytes for question.
     */
    com.google.protobuf.ByteString
        getQuestionBytes();

    /**
     * <pre>
     *repeated FileMetaInfo FileMetaInfoList = 4;
     * </pre>
     *
     * <code>int32 TeacherIdx = 3;</code>
     * @return The teacherIdx.
     */
    int getTeacherIdx();
  }
  /**
   * Protobuf type {@code Classlink.CWQuestionBoxCreateReq}
   */
  public static final class CWQuestionBoxCreateReq extends
      com.google.protobuf.GeneratedMessageV3 implements
      // @@protoc_insertion_point(message_implements:Classlink.CWQuestionBoxCreateReq)
      CWQuestionBoxCreateReqOrBuilder {
  private static final long serialVersionUID = 0L;
    // Use CWQuestionBoxCreateReq.newBuilder() to construct.
    private CWQuestionBoxCreateReq(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
      super(builder);
    }
    private CWQuestionBoxCreateReq() {
      title_ = "";
      question_ = "";
    }

    @Override
    @SuppressWarnings({"unused"})
    protected Object newInstance(
        UnusedPrivateParameter unused) {
      return new CWQuestionBoxCreateReq();
    }

    @Override
    public final com.google.protobuf.UnknownFieldSet
    getUnknownFields() {
      return this.unknownFields;
    }
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return CWQuestionBoxCreateReqProto.internal_static_Classlink_CWQuestionBoxCreateReq_descriptor;
    }

    @Override
    protected FieldAccessorTable
        internalGetFieldAccessorTable() {
      return CWQuestionBoxCreateReqProto.internal_static_Classlink_CWQuestionBoxCreateReq_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              CWQuestionBoxCreateReq.class, Builder.class);
    }

    public static final int TITLE_FIELD_NUMBER = 1;
    private volatile Object title_;
    /**
     * <code>string Title = 1;</code>
     * @return The title.
     */
    @Override
    public String getTitle() {
      Object ref = title_;
      if (ref instanceof String) {
        return (String) ref;
      } else {
        com.google.protobuf.ByteString bs = 
            (com.google.protobuf.ByteString) ref;
        String s = bs.toStringUtf8();
        title_ = s;
        return s;
      }
    }
    /**
     * <code>string Title = 1;</code>
     * @return The bytes for title.
     */
    @Override
    public com.google.protobuf.ByteString
        getTitleBytes() {
      Object ref = title_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (String) ref);
        title_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }

    public static final int QUESTION_FIELD_NUMBER = 2;
    private volatile Object question_;
    /**
     * <code>string Question = 2;</code>
     * @return The question.
     */
    @Override
    public String getQuestion() {
      Object ref = question_;
      if (ref instanceof String) {
        return (String) ref;
      } else {
        com.google.protobuf.ByteString bs = 
            (com.google.protobuf.ByteString) ref;
        String s = bs.toStringUtf8();
        question_ = s;
        return s;
      }
    }
    /**
     * <code>string Question = 2;</code>
     * @return The bytes for question.
     */
    @Override
    public com.google.protobuf.ByteString
        getQuestionBytes() {
      Object ref = question_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (String) ref);
        question_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }

    public static final int TEACHERIDX_FIELD_NUMBER = 3;
    private int teacherIdx_;
    /**
     * <pre>
     *repeated FileMetaInfo FileMetaInfoList = 4;
     * </pre>
     *
     * <code>int32 TeacherIdx = 3;</code>
     * @return The teacherIdx.
     */
    @Override
    public int getTeacherIdx() {
      return teacherIdx_;
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
      if (!com.google.protobuf.GeneratedMessageV3.isStringEmpty(title_)) {
        com.google.protobuf.GeneratedMessageV3.writeString(output, 1, title_);
      }
      if (!com.google.protobuf.GeneratedMessageV3.isStringEmpty(question_)) {
        com.google.protobuf.GeneratedMessageV3.writeString(output, 2, question_);
      }
      if (teacherIdx_ != 0) {
        output.writeInt32(3, teacherIdx_);
      }
      getUnknownFields().writeTo(output);
    }

    @Override
    public int getSerializedSize() {
      int size = memoizedSize;
      if (size != -1) return size;

      size = 0;
      if (!com.google.protobuf.GeneratedMessageV3.isStringEmpty(title_)) {
        size += com.google.protobuf.GeneratedMessageV3.computeStringSize(1, title_);
      }
      if (!com.google.protobuf.GeneratedMessageV3.isStringEmpty(question_)) {
        size += com.google.protobuf.GeneratedMessageV3.computeStringSize(2, question_);
      }
      if (teacherIdx_ != 0) {
        size += com.google.protobuf.CodedOutputStream
          .computeInt32Size(3, teacherIdx_);
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
      if (!(obj instanceof CWQuestionBoxCreateReq)) {
        return super.equals(obj);
      }
      CWQuestionBoxCreateReq other = (CWQuestionBoxCreateReq) obj;

      if (!getTitle()
          .equals(other.getTitle())) return false;
      if (!getQuestion()
          .equals(other.getQuestion())) return false;
      if (getTeacherIdx()
          != other.getTeacherIdx()) return false;
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
      hash = (37 * hash) + TITLE_FIELD_NUMBER;
      hash = (53 * hash) + getTitle().hashCode();
      hash = (37 * hash) + QUESTION_FIELD_NUMBER;
      hash = (53 * hash) + getQuestion().hashCode();
      hash = (37 * hash) + TEACHERIDX_FIELD_NUMBER;
      hash = (53 * hash) + getTeacherIdx();
      hash = (29 * hash) + getUnknownFields().hashCode();
      memoizedHashCode = hash;
      return hash;
    }

    public static CWQuestionBoxCreateReq parseFrom(
        java.nio.ByteBuffer data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static CWQuestionBoxCreateReq parseFrom(
        java.nio.ByteBuffer data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static CWQuestionBoxCreateReq parseFrom(
        com.google.protobuf.ByteString data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static CWQuestionBoxCreateReq parseFrom(
        com.google.protobuf.ByteString data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static CWQuestionBoxCreateReq parseFrom(byte[] data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static CWQuestionBoxCreateReq parseFrom(
        byte[] data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static CWQuestionBoxCreateReq parseFrom(java.io.InputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input);
    }
    public static CWQuestionBoxCreateReq parseFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input, extensionRegistry);
    }
    public static CWQuestionBoxCreateReq parseDelimitedFrom(java.io.InputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseDelimitedWithIOException(PARSER, input);
    }
    public static CWQuestionBoxCreateReq parseDelimitedFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
    }
    public static CWQuestionBoxCreateReq parseFrom(
        com.google.protobuf.CodedInputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input);
    }
    public static CWQuestionBoxCreateReq parseFrom(
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
    public static Builder newBuilder(CWQuestionBoxCreateReq prototype) {
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
     * Protobuf type {@code Classlink.CWQuestionBoxCreateReq}
     */
    public static final class Builder extends
        com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
        // @@protoc_insertion_point(builder_implements:Classlink.CWQuestionBoxCreateReq)
        CWQuestionBoxCreateReqOrBuilder {
      public static final com.google.protobuf.Descriptors.Descriptor
          getDescriptor() {
        return CWQuestionBoxCreateReqProto.internal_static_Classlink_CWQuestionBoxCreateReq_descriptor;
      }

      @Override
      protected FieldAccessorTable
          internalGetFieldAccessorTable() {
        return CWQuestionBoxCreateReqProto.internal_static_Classlink_CWQuestionBoxCreateReq_fieldAccessorTable
            .ensureFieldAccessorsInitialized(
                CWQuestionBoxCreateReq.class, Builder.class);
      }

      // Construct using com.classlink.websocket.api.cw.domain.param.proto.CWQuestionBoxCreateReqProto.CWQuestionBoxCreateReq.newBuilder()
      private Builder() {

      }

      private Builder(
          BuilderParent parent) {
        super(parent);

      }
      @Override
      public Builder clear() {
        super.clear();
        title_ = "";

        question_ = "";

        teacherIdx_ = 0;

        return this;
      }

      @Override
      public com.google.protobuf.Descriptors.Descriptor
          getDescriptorForType() {
        return CWQuestionBoxCreateReqProto.internal_static_Classlink_CWQuestionBoxCreateReq_descriptor;
      }

      @Override
      public CWQuestionBoxCreateReq getDefaultInstanceForType() {
        return CWQuestionBoxCreateReq.getDefaultInstance();
      }

      @Override
      public CWQuestionBoxCreateReq build() {
        CWQuestionBoxCreateReq result = buildPartial();
        if (!result.isInitialized()) {
          throw newUninitializedMessageException(result);
        }
        return result;
      }

      @Override
      public CWQuestionBoxCreateReq buildPartial() {
        CWQuestionBoxCreateReq result = new CWQuestionBoxCreateReq(this);
        result.title_ = title_;
        result.question_ = question_;
        result.teacherIdx_ = teacherIdx_;
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
        if (other instanceof CWQuestionBoxCreateReq) {
          return mergeFrom((CWQuestionBoxCreateReq)other);
        } else {
          super.mergeFrom(other);
          return this;
        }
      }

      public Builder mergeFrom(CWQuestionBoxCreateReq other) {
        if (other == CWQuestionBoxCreateReq.getDefaultInstance()) return this;
        if (!other.getTitle().isEmpty()) {
          title_ = other.title_;
          onChanged();
        }
        if (!other.getQuestion().isEmpty()) {
          question_ = other.question_;
          onChanged();
        }
        if (other.getTeacherIdx() != 0) {
          setTeacherIdx(other.getTeacherIdx());
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
                title_ = input.readStringRequireUtf8();

                break;
              } // case 10
              case 18: {
                question_ = input.readStringRequireUtf8();

                break;
              } // case 18
              case 24: {
                teacherIdx_ = input.readInt32();

                break;
              } // case 24
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

      private Object title_ = "";
      /**
       * <code>string Title = 1;</code>
       * @return The title.
       */
      public String getTitle() {
        Object ref = title_;
        if (!(ref instanceof String)) {
          com.google.protobuf.ByteString bs =
              (com.google.protobuf.ByteString) ref;
          String s = bs.toStringUtf8();
          title_ = s;
          return s;
        } else {
          return (String) ref;
        }
      }
      /**
       * <code>string Title = 1;</code>
       * @return The bytes for title.
       */
      public com.google.protobuf.ByteString
          getTitleBytes() {
        Object ref = title_;
        if (ref instanceof String) {
          com.google.protobuf.ByteString b = 
              com.google.protobuf.ByteString.copyFromUtf8(
                  (String) ref);
          title_ = b;
          return b;
        } else {
          return (com.google.protobuf.ByteString) ref;
        }
      }
      /**
       * <code>string Title = 1;</code>
       * @param value The title to set.
       * @return This builder for chaining.
       */
      public Builder setTitle(
          String value) {
        if (value == null) {
    throw new NullPointerException();
  }
  
        title_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>string Title = 1;</code>
       * @return This builder for chaining.
       */
      public Builder clearTitle() {
        
        title_ = getDefaultInstance().getTitle();
        onChanged();
        return this;
      }
      /**
       * <code>string Title = 1;</code>
       * @param value The bytes for title to set.
       * @return This builder for chaining.
       */
      public Builder setTitleBytes(
          com.google.protobuf.ByteString value) {
        if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
        
        title_ = value;
        onChanged();
        return this;
      }

      private Object question_ = "";
      /**
       * <code>string Question = 2;</code>
       * @return The question.
       */
      public String getQuestion() {
        Object ref = question_;
        if (!(ref instanceof String)) {
          com.google.protobuf.ByteString bs =
              (com.google.protobuf.ByteString) ref;
          String s = bs.toStringUtf8();
          question_ = s;
          return s;
        } else {
          return (String) ref;
        }
      }
      /**
       * <code>string Question = 2;</code>
       * @return The bytes for question.
       */
      public com.google.protobuf.ByteString
          getQuestionBytes() {
        Object ref = question_;
        if (ref instanceof String) {
          com.google.protobuf.ByteString b = 
              com.google.protobuf.ByteString.copyFromUtf8(
                  (String) ref);
          question_ = b;
          return b;
        } else {
          return (com.google.protobuf.ByteString) ref;
        }
      }
      /**
       * <code>string Question = 2;</code>
       * @param value The question to set.
       * @return This builder for chaining.
       */
      public Builder setQuestion(
          String value) {
        if (value == null) {
    throw new NullPointerException();
  }
  
        question_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>string Question = 2;</code>
       * @return This builder for chaining.
       */
      public Builder clearQuestion() {
        
        question_ = getDefaultInstance().getQuestion();
        onChanged();
        return this;
      }
      /**
       * <code>string Question = 2;</code>
       * @param value The bytes for question to set.
       * @return This builder for chaining.
       */
      public Builder setQuestionBytes(
          com.google.protobuf.ByteString value) {
        if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
        
        question_ = value;
        onChanged();
        return this;
      }

      private int teacherIdx_ ;
      /**
       * <pre>
       *repeated FileMetaInfo FileMetaInfoList = 4;
       * </pre>
       *
       * <code>int32 TeacherIdx = 3;</code>
       * @return The teacherIdx.
       */
      @Override
      public int getTeacherIdx() {
        return teacherIdx_;
      }
      /**
       * <pre>
       *repeated FileMetaInfo FileMetaInfoList = 4;
       * </pre>
       *
       * <code>int32 TeacherIdx = 3;</code>
       * @param value The teacherIdx to set.
       * @return This builder for chaining.
       */
      public Builder setTeacherIdx(int value) {
        
        teacherIdx_ = value;
        onChanged();
        return this;
      }
      /**
       * <pre>
       *repeated FileMetaInfo FileMetaInfoList = 4;
       * </pre>
       *
       * <code>int32 TeacherIdx = 3;</code>
       * @return This builder for chaining.
       */
      public Builder clearTeacherIdx() {
        
        teacherIdx_ = 0;
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


      // @@protoc_insertion_point(builder_scope:Classlink.CWQuestionBoxCreateReq)
    }

    // @@protoc_insertion_point(class_scope:Classlink.CWQuestionBoxCreateReq)
    private static final CWQuestionBoxCreateReq DEFAULT_INSTANCE;
    static {
      DEFAULT_INSTANCE = new CWQuestionBoxCreateReq();
    }

    public static CWQuestionBoxCreateReq getDefaultInstance() {
      return DEFAULT_INSTANCE;
    }

    private static final com.google.protobuf.Parser<CWQuestionBoxCreateReq>
        PARSER = new com.google.protobuf.AbstractParser<CWQuestionBoxCreateReq>() {
      @Override
      public CWQuestionBoxCreateReq parsePartialFrom(
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

    public static com.google.protobuf.Parser<CWQuestionBoxCreateReq> parser() {
      return PARSER;
    }

    @Override
    public com.google.protobuf.Parser<CWQuestionBoxCreateReq> getParserForType() {
      return PARSER;
    }

    @Override
    public CWQuestionBoxCreateReq getDefaultInstanceForType() {
      return DEFAULT_INSTANCE;
    }

  }

  private static final com.google.protobuf.Descriptors.Descriptor
    internal_static_Classlink_CWQuestionBoxCreateReq_descriptor;
  private static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_Classlink_CWQuestionBoxCreateReq_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    String[] descriptorData = {
      "\n\034CWQuestionBoxCreateReq.proto\022\tClasslin" +
      "k\"M\n\026CWQuestionBoxCreateReq\022\r\n\005Title\030\001 \001" +
      "(\t\022\020\n\010Question\030\002 \001(\t\022\022\n\nTeacherIdx\030\003 \001(\005" +
      "BP\n1com.classlink.websocket.api.cw.domai" +
      "n.param.protoB\033CWQuestionBoxCreateReqPro" +
      "tob\006proto3"
    };
    descriptor = com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        });
    internal_static_Classlink_CWQuestionBoxCreateReq_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_Classlink_CWQuestionBoxCreateReq_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_Classlink_CWQuestionBoxCreateReq_descriptor,
        new String[] { "Title", "Question", "TeacherIdx", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}
